package risk;

import risk.GamePhase.GamePhase;
import risk.UIElements.DiceTray;
import risk.UIElements.Icon;
import risk.tile.Tile;
import javafx.scene.layout.Region;

import java.util.*;

import static risk.GamePhase.GamePhase.MOVING;
import static risk.tile.TerrainType.*;

public class Controller {
    private Vieuw vieuw;
    private Model model;

    public Controller() {
        this.model = new Model();
        this.vieuw = new Vieuw(model);
        this.setVieuw();
        this.setDice();
        this.nextButton();
        this.setHandIn();
    }

    public Region getVieuw(){
        return vieuw.getVieuw();
    }

    private void setVieuw() {
        setTiles();
    }

    private void setHandIn(){
        vieuw.getInfoBar().getHand_in_icon().setOnMouseClicked(event ->{
        int conquestPoints = this.model.getConquestPoints();
        int savedUpArmies = 0;
        if (conquestPoints == 1) {
            savedUpArmies = 1;
        } else if (conquestPoints == 2) {
            savedUpArmies = 3;
        } else if (conquestPoints == 3) {
            savedUpArmies = 5;
        } else if (conquestPoints == 4) {
            savedUpArmies = 8;
        } else if (conquestPoints == 5) {
            savedUpArmies = 12;
        } else if (conquestPoints == 6) {
            savedUpArmies = 16;
        }
            this.model.setReinforcements(this.model.getReinforcements().intValue()+savedUpArmies);
            this.model.setConquestPoints(0);
            this.model.getPlayer().setConquestPoints(0);
        });
    }

    private void setTiles(){
        for (Tile clickedTile : model.getGamemap()) {
            clickedTile.setOnMouseClicked(event -> {
                Tile tile = (Tile) event.getSource();
                GamePhase gamePhase = model.getGamePhase();
                switch (gamePhase) {
                    case INCREMENT:
                        if (tile.getTerrainType() != WATER) {
                            tile.setCount(tile.getCount() + 1);
                        }
                        break;
                    case DECREMENT:
                        if (tile.getTerrainType() != WATER) {
                            tile.setCount(tile.getCount() - 1);
                        }
                        break;
                    case SET_P1:
                        tile.setTerrainType(P1);
                        break;
                    case SET_P2:
                        tile.setTerrainType(P2);
                        break;
                    case SET_P3:
                        tile.setTerrainType(P3);
                        break;
                    case SET_P4:
                        tile.setTerrainType(P4);
                        break;
                    case REINFORCING:
                        hasConqueredThisTurn = false;
                        hasEliminatedThisTurn = false;

                        for (Tile tile2 : model.getGamemap()) {
                            tile2.setSelected(false);
                            tile2.setSelected2(false);
                        }
                        if (model.getSelected() == null && model.getPlayer().getColour() == tile.getTerrainType().colour) {
                            tile.setSelected(true);
                            model.setSelected(tile);
                            break;
                        } else if ((model.getSelected() != null &&
                                model.getPlayer().getColour() == tile.getTerrainType().colour &&
                                tile == model.getSelected() &&
                                model.getReinforcements().intValue() > 0)) {
                            model.setReinforcements(model.getReinforcements().intValue() - 1);
                            tile.setCount(tile.getCount() + 1);
                            break;
                        } else {
                            model.setSelected(null);
                            break;
                        }
                    case SET_WATER:
                        tile.setTerrainType(WATER);
                        break;
                    case SET_SHALLOW:
                        tile.setTerrainType(SHALLOW);
                        break;
                    case SELECT:
                        for (Tile tile2 : model.getGamemap()) {
                            tile2.setSelected(false);
                            tile2.setSelected2(false);
                        }
                        if (model.getSelected() == null) {
                            tile.setSelected(true);
                            model.setSelected(tile);
                            break;
                        } else {
                            model.setSelected(null);
                        }
                    case SELECTTWO:
                        if (model.getSelected() == null) {
                            for (Tile tile2 : model.getGamemap()) {
                                tile2.setSelected(false);
                            }
                            tile.setSelected(true);
                            model.setSelected(tile);
                            break;
                        } else if (model.getSelected2() == null) {
                            for (Tile tile2 : model.getGamemap()) {
                                tile2.setSelected2(false);
                            }
                            tile.setSelected2(true);
                            model.setSelected2(tile);
                            break;
                        } else {
                            for (Tile tile2 : model.getGamemap()) {
                                tile2.setSelected2(false);
                                tile2.setSelected(false);
                            }
                            model.setSelected2(null);
                            model.setSelected(null);
                        }
                    case ATTACKING:
                        if (model.getSelected() == null) { // set selected and targets if possible
                            log += "no prior selection detected.\n";
                            for (Tile tile2 : model.getGamemap()) {
                                tile2.setSelected(false);
                            }

                            if (tile.isTerritory() && model.getPlayer().getColour() == tile.getTerrainType().colour) {
                                if (getPotentialTargets(tile) != null && tile.getCount() > 1) {
                                    log += "A valid selection was made at [" + tile.getPosition().row() + ", " + tile.getPosition().column() + "].\n";
                                    tile.setSelected(true);
                                    model.setSelected(tile);
                                    getAttackTargets(tile);
                                    if (attackTargets != null) {
                                        for (Tile tile2 : attackTargets) {
                                            tile2.setSelected2(true);
                                        }
                                        log += "all targets were highlighted.\n";
                                    }
                                    break;
                                }
                            } else {
                                log += "No valid selection could be made as too few armies where present or a sea or a shallows at [" + tile.getPosition().row() + ", " + tile.getPosition().column() + "] was clicked upon.\n";
                                break;
                            }
                        } else if (model.getSelected() == tile) { // cancel selection by clicking it again.
                                log += "the selected tile was clicked upon, thus cancelling the selection (handy if no viable targets exist).\n";
                                for (Tile tile2 : model.getGamemap()) {
                                    tile2.setSelected2(false);
                                }
                                model.setSelected(null);
                                tile.setSelected(false);
                                attackTargets.clear();
                                break;
                            }
                        else if (tile.isSelected2() && (model.getSelected().getCount() > 1 && model.getSelected().getTerrainType() != tile.getTerrainType())) {
                            log += "Prior selections were detected, and either was clicked upon, thus battle was waged.\n";
                            int[] outcomeBattle = attack(model.getSelected().getCount(), tile.getCount());

                            model.getSelected().setCount(outcomeBattle[0]);
                            tile.setCount(outcomeBattle[1]);

                            if (tile.getCount() == 0) {
                                log += "the territory was conquered, the player had " + model.getPlayer().getConquestPoints() + " conquest points.\n";
                                eliminationCheck.clear();
                                for (Tile tile2 : model.getGamemap()) {
                                    if (tile2.getTerrainType() == tile.getTerrainType()) {
                                        eliminationCheck.add(tile2);

                                    }
                                }
                                tile.setTerrainType(model.getSelected().getTerrainType());
                                int armiesToMoveToConqueredTer = 1;
                                if (model.getSelected().getCount() > 2) {
                                    armiesToMoveToConqueredTer = 2;
                                }
                                if (model.getSelected().getCount() > 3) {
                                    armiesToMoveToConqueredTer = 3;
                                }
                                model.getSelected().setCount(model.getSelected().getCount() - armiesToMoveToConqueredTer);
                                tile.setCount(tile.getCount() + armiesToMoveToConqueredTer);

                                if (!hasConqueredThisTurn && model.getPlayer().getConquestPoints() < 5) {
                                    model.getPlayer().setConquestPoints(model.getPlayer().getConquestPoints() + 1);
                                    this.model.setConquestPoints(this.model.getConquestPoints() +1);
                                    model.getPlayer().setSavedUpArmies(determineSavedUpArmies(model.getPlayer().getConquestPoints()));
                                    log += "since player already conquered this turn was set to: " + hasConqueredThisTurn + ", a conquest point was added due to conquest, the player now has " + model.getPlayer().getConquestPoints() + " saved up.\n";
                                    hasConqueredThisTurn = true;
                                    log += "player already conquered this turn was now set to: " + hasConqueredThisTurn;
                                }
                                else {
                                    log += "no conq point was added. player already conquered this turn was set to: " + hasConqueredThisTurn;
                                }
                                if (!hasEliminatedThisTurn && (eliminationCheck.size() == 1 && model.getPlayer().getConquestPoints() < 6)) {
                                    model.getPlayer().setConquestPoints(model.getPlayer().getConquestPoints() + 1);
                                    this.model.setConquestPoints(this.model.getConquestPoints() +1);
                                    model.getPlayer().setSavedUpArmies(determineSavedUpArmies(model.getPlayer().getConquestPoints()));
                                    hasEliminatedThisTurn = true;
                                    log += "a conquest point was added due to elimination, the player now has " + model.getPlayer().getConquestPoints() + " saved up.\n";
                                }
                            }
                            break;
                        }
                        else if (tile.isSelected2() && (model.getSelected().getCount() > 1 && model.getSelected().getTerrainType() == tile.getTerrainType())) {
                            log += "An army was moved to the newly conquered territory.\n";
                            model.getSelected().setCount(model.getSelected().getCount() - 1);
                            tile.setCount(tile.getCount() + 1);
                        }
                        else {
                            log += "A selection and a selection2 was detected, but neither was clicked upon, thus selections were reset.\n";
                            for (Tile tile2 : model.getGamemap()) {
                                tile2.setSelected2(false);
                                tile2.setSelected(false);
                            }
                            model.setSelected(null);
                            attackTargets.clear();
                            break;
                        }
                    case MOVING:
                        log += moveLimit + " moves remain.\n";
                        moveLimit = model.getAvailableMoves();
                        log += "model: de available moves zijn " + model.getAvailableMoves() + ".\n";
                        if (moveLimit == 0) {
                            for (Tile tile2 : model.getGamemap()) {
                                tile2.setSelected2(false);
                            }
                            model.setSelected(null);
                            tile.setSelected(false);
                            moveTargets.clear();
                            break;
                        }
                        else if (model.getSelected()==null) {
                            log += "no prior selection detected.\n";
                            for (Tile tile2 : model.getGamemap()) {
                                tile2.setSelected(false);
                            }
                            if (tile.getCount() > 1) {
                                if (tile.isTerritory() && model.getPlayer().getColour() == tile.getTerrainType().colour) {
                                    if (getPotentialTargets(tile) != null) {
                                        log += "A valid selection was made at [" + tile.getPosition().row() + ", " + tile.getPosition().column() + "].\n";
                                        tile.setSelected(true);
                                        model.setSelected(tile);
                                        getMoveTargets(tile);
                                        if (moveTargets != null) {
                                            for (Tile tile2 : moveTargets) {
                                                tile2.setSelected2(true);
                                            }
                                            log += "all targets were highlighted.\n";
                                        }
                                        break;
                                    }
                                }
                            }
                            else {
                                log += "No valid selection could be made as a sea or a shallows at [" + tile.getPosition().row() + ", " + tile.getPosition().column() + "] was clicked upon, or the territory has too few armies to move any away.\n";
                                break;
                            }
                        }
                        else if (model.getSelected() == tile) {
                            log += "the selected tile was clicked upon, thus cancelling the selection (handy if no viable targets exist).\n";
                            for (Tile tile2 : model.getGamemap()) {
                                tile2.setSelected2(false);
                            }
                            model.setSelected(null);
                            tile.setSelected(false);
                            moveTargets.clear();
                            break;
                        }
                        else if (tile.isSelected2() && gamePhase == MOVING) {
                            if (model.getSelected().getCount() > 1) {
                                moveLimit -= 1;
                                this.model.setMovable(this.model.getMovable() -1); // beinvloed de teller.
                                this.model.setAvailableMoves(this.model.getAvailableMoves() -1);
                                log += "Prior selections were detected, and either was clicked upon, thus an army was moved.\n";
                                log += "Now " + moveLimit + " moves remain.\n";

                                model.getSelected().setCount(model.getSelected().getCount() - 1);
                                tile.setCount(tile.getCount() + 1);
                            }
                            else {
                                for (Tile tile2 : model.getGamemap()) {
                                    tile2.setSelected2(false);
                                    tile2.setSelected(false);
                                }
                                model.setSelected(null);
                                log += "The territory can move away no more armies.\n";
                            }
                            break;
                        }
                        else if (gamePhase == MOVING)
                        {
                            log += "A selection and a selection2 was detected, but neither was clicked upon, thus selections were reset.\n";
                            for (Tile tile2 : model.getGamemap()) {
                                tile2.setSelected2(false);
                                tile2.setSelected(false);
                            }
                            model.setSelected(null);
                            break;
                        }
                    default:
                        break;
                }
                if (printLog) {
                    System.out.println(log);
                }
                log = "Starting new log:\n";
            });
        }
    }

    ArrayList<Tile> potentialTargets = new ArrayList<>();
    ArrayList<Tile> attackTargets = new ArrayList<>();
    ArrayList<Tile> moveTargets = new ArrayList<>();
    ArrayList<Tile> eliminationCheck = new ArrayList<>();
    String log = "Starting log:\n";
    int availableMoves = 7;
    int moveLimit = availableMoves;
    boolean hasConqueredThisTurn = false;
    boolean hasEliminatedThisTurn = false;

    // some temporary telltales.
    boolean printLog = true; // set to false to disengage log entries.
    int telltaleTempIncrementer = 0; // set to 0 to avoid telltale increments on adjacent tiles.

    private int determineSavedUpArmies(int conquestPoints) {
        int savedUpArmies = 0;
        if (conquestPoints == 1) {
            savedUpArmies = 1;
        } else if (conquestPoints == 2) {
            savedUpArmies = 3;
        } else if (conquestPoints == 3) {
            savedUpArmies = 5;
        } else if (conquestPoints == 4) {
            savedUpArmies = 8;
        } else if (conquestPoints == 5) {
            savedUpArmies = 12;
        } else if (conquestPoints == 6) {
            savedUpArmies = 16;
        }
        return savedUpArmies;
    }

    private void getMoveTargets(Tile tile) {
        moveTargets.clear();
        for (Tile tile2 : getPotentialTargets(tile)) {
            if ((tile2 != null && tile2 != model.getSelected()) && (tile2.isTerritory() && tile2.isSamePlayer(model.getSelected()))) {
                tile2.setCount(tile2.getCount() + telltaleTempIncrementer*10);
                tile2.setSelected2(true);
                moveTargets.add(tile2);
            }
        }
        log += "Found " + moveTargets.size() + " move targets.\n";
    }

    private void getAttackTargets(Tile tile) {
        attackTargets.clear();
        ArrayList<Tile> potentialTargets = getPotentialTargets(tile);
        if (potentialTargets.size() > 0) {
            for (Tile tile2 : getPotentialTargets(tile)) {
                if (tile2 != null && (tile2.isTerritory() && !tile2.isSamePlayer(model.getSelected()))) {
            //    if (((tile2.getTerrainType() == P1 || tile2.getTerrainType() == P2) || (tile2.getTerrainType() == P3 || tile2.getTerrainType() == P4)) && !(tile2.getTerrainType() == model.getSelected().getTerrainType())) {
                    tile2.setCount(tile2.getCount() + telltaleTempIncrementer * 10);
                    tile2.setSelected2(true);
                    attackTargets.add(tile2);
                }
            }
            log += "Found " + attackTargets.size() + " attack targets.\n";
        }
    }

    private ArrayList<Tile> getPotentialTargets(Tile tile) {
        potentialTargets.clear();
        for (Tile tile2 : getDirectAdjacents(tile)) {
            potentialTargets.add(tile2);
            if (tile2 != null && tile2.getTerrainType() == SHALLOW) {
                for (Tile tile3 : getDirectAdjacents(tile2)) {
                    potentialTargets.add(tile3);
                }
            }
        }
        log += "Found " + potentialTargets.size() + " potential targets.\n";
        return potentialTargets;
    }

    private ArrayList<Tile> getDirectAdjacents(Tile tile) {
        int row = tile.getPosition().row();
        int column = tile.getPosition().column();
        ArrayList<Tile> directAdjacents = new ArrayList<>();
        directAdjacents.add(getTile(row -2, column)); // Boven
        directAdjacents.add(getTile(row +2, column)); // Onder
        directAdjacents.add(getTile(row -1, column));
        directAdjacents.add(getTile(row +1, column));
        if (row %2 == 0) {
            directAdjacents.add(getTile(row -1, column +1));
            directAdjacents.add(getTile(row +1, column +1));
            if (column == 0) {
                directAdjacents.add(getTile(row -1, 6));
                directAdjacents.add(getTile(row +1, 6));
            }
        }
        else {
            directAdjacents.add(getTile(row -1, column -1));
            directAdjacents.add(getTile(row +1, column -1));
            if (column == 6) {
                directAdjacents.add(getTile(row -1, 0));
                directAdjacents.add(getTile(row +1, 0));
            }
        }
    //    log += "added " + directAdjacents.size() + " tiles adjacent to the tile at [" + row + ", " + column + "] with terrain " + tile.getTerrainType() + " and " + tile.getCount() + " armies.\n";
        return directAdjacents;
    }

    private Tile getTile(int row, int column) {
        Tile temptile = null;
        for (Tile tile : model.getGamemap()) {
            if (tile.getPosition().row() == row && tile.getPosition().column() == column) {
                tile.setCount(tile.getCount() + telltaleTempIncrementer);
                temptile = tile;
            }
        }
        return temptile;
    }

    private void setDice(){
        List< DiceTray> trays = Arrays.asList(vieuw.getInfoBar().getDice1(), vieuw.getInfoBar().getDice2());
        for (DiceTray tray:trays){
            tray.setOnMouseClicked(event -> {
                DiceTray selectedTray = (DiceTray) event.getSource();
                selectedTray.setDieRandom();
            });
        }
    }

    private void nextButton(){
        Icon icon = vieuw.getInfoBar().getNext_icon();
        icon.setOnMouseClicked(event -> {
            model.nextTurn();
        });
    }
    List<Integer> attackingDice = new ArrayList<>();
    List<Integer> defendingDice = new ArrayList<>();

    public int diceAvailable (int attackingArmy) {
        int diceAvailable = 1;
        if (attackingArmy > 2) {
            if (attackingArmy > 3) {
                diceAvailable = 3;
            } else {
                diceAvailable = 2;
            }
        }
        return diceAvailable;
    }

    public void setup (int attackingArmy, int defendingArmy, int diceAvailable) {
        log += "NEW SKIRMISH:";
        log += "The attacker has " + attackingArmy + " armies available.\n";
        log += "The defender has " + defendingArmy + " armies available.\n";
        log += "As attacker you can use a maximum of " + diceAvailable + " armies in this skirmish.\n";
    }

    public int castDie() {
        return (int) (Math.random() * 6 + 1);
    }

    public void castDice (int committedAttackingArmies, int defendingArmy) {
        attackingDice.add(castDie());
        if (committedAttackingArmies > 1) {
            attackingDice.add(castDie());
            if (committedAttackingArmies > 2) {
                attackingDice.add(castDie());
                if (attackingDice.get(0) + attackingDice.get(1) + attackingDice.get(2) == 18) {
                    System.out.println("666: Devilish!\n");
                }
            }
        }
        attackingDice.sort(Collections.reverseOrder());
        if (attackingDice.size() == 1) {
            vieuw.getInfoBar().getDice1().setDie(attackingDice.get(0) -1);
            log += "1 attacking die were cast.\n";
        }
        else if (attackingDice.size() == 2) {
            vieuw.getInfoBar().getDice1().setDie(attackingDice.get(0) -1, attackingDice.get(1) -1);
            log += "2 attacking dice were cast.\n";
        }
        else {
            vieuw.getInfoBar().getDice1().setDie(attackingDice.get(0) -1, attackingDice.get(1) -1, attackingDice.get(2) -1);
            log += "3 attacking dice were cast.\n";
        }
        defendingDice.add(castDie());
        if (defendingArmy > 1) {
            defendingDice.add(castDie());
            defendingDice.sort(Collections.reverseOrder());
            vieuw.getInfoBar().getDice2().setDie(defendingDice.get(0) -1, defendingDice.get(1) -1);
        }
        else {
            vieuw.getInfoBar().getDice2().setDie(defendingDice.get(0) -1);
        }
        log += "The attacker casted dice with the following results: " + attackingDice + ".\n";
        log += "The defender casted dice with the following results: " + defendingDice + ".\n";
    }

    public int defenderWinsSkirmish(int attackingArmy) {
        log += "the attacker loses an army.\n";
        return attackingArmy -1;
    }
    public int attackerWinsSkirmish(int defendingArmy) {
        log += "the defender loses an army.\n";
        return defendingArmy -1;
    }
    public int[] skirmish(int attackingArmy, int defendingArmy) {
        if (defendingDice.get(0) >= attackingDice.get(0)) {
            attackingArmy = defenderWinsSkirmish(attackingArmy);
        } else {
            defendingArmy = attackerWinsSkirmish(defendingArmy);
        }
        if (attackingDice.size() > 1 && defendingDice.size() > 1) {
            if (defendingDice.get(1) >= attackingDice.get(1)) {
                attackingArmy = defenderWinsSkirmish(attackingArmy);
            } else {
                defendingArmy = attackerWinsSkirmish(defendingArmy);
            }
        }
        return new int[] {attackingArmy, defendingArmy};
    }

    public void finishingUp() {
        defendingDice.clear();
        attackingDice.clear();
    }



    public int[] attack(int attackingArmy, int defendingArmy) {
        int committedAttackingArmies;

        int diceAvailable = diceAvailable(attackingArmy);
        setup(attackingArmy, defendingArmy, diceAvailable);
        committedAttackingArmies = diceAvailable;

        castDice(committedAttackingArmies, defendingArmy);
        int[] outcomeSkirmish = skirmish(attackingArmy, defendingArmy);
        attackingArmy = outcomeSkirmish[0];
        defendingArmy = outcomeSkirmish[1];

        finishingUp();

        return new int[] {attackingArmy, defendingArmy};
    }
}


