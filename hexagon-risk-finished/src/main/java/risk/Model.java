package risk;

import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableIntegerValue;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import risk.GamePhase.GamePhase;
import risk.tile.Position;
import risk.tile.TerrainType;
import risk.tile.Tile;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import static risk.GamePhase.GamePhase.*;
import static risk.UIElements.IconPath.MILITARY_TECH;
import static risk.tile.TerrainType.*;

public class Model {
    private final ArrayList<Tile> gamemap;
    private Tile selected;
    private Tile selected2;
    private int tileSize;

    private ObjectProperty<GamePhase> gamePhase;

    private ArrayList<GamePhase> phaseList;
    private int phaseNumber;

    private ArrayList<Player> players;
    private int playerNumber;
    private ObjectProperty<Player> player;
    private SimpleIntegerProperty reinforcements;
    private SimpleIntegerProperty movable;
    private SimpleIntegerProperty conquestPoints;
    private SimpleIntegerProperty availableMoves;



    public Model(){
        this.gamemap = new ArrayList<Tile>();
        this.tileSize = 85;
        this.earthMap();
        this.gamePhase = new SimpleObjectProperty<>(REINFORCING);
        this.phaseList = new ArrayList<>();
        this.players = new ArrayList<>();
        phaseList.add(REINFORCING);
        phaseList.add(ATTACKING);
        phaseList.add(MOVING);
        players.add(new Player(P1.label, P1.colour, 0, 0));
        players.add(new Player(P2.label, P2.colour, 0, 0));
        players.add(new Player(P3.label, P3.colour, 0, 0));
        players.add(new Player(P4.label, P4.colour, 0, 0));
        this.player = new SimpleObjectProperty<>(players.get(playerNumber));
        this.reinforcements = new SimpleIntegerProperty();
        this.movable = new SimpleIntegerProperty(7);
        this.conquestPoints = new SimpleIntegerProperty(0);
        this.availableMoves = new SimpleIntegerProperty(7);
        startTurn();



    }

    private void earthMap() {
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(0, 0)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(0, 1)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(0, 2)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(0, 3)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(0, 4)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(0, 5)));


        //this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(1, 0)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P1), this.tileSize, new Position(1, 1))); //N-Canada
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(1, 2)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(1, 3)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(1, 4)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(1, 5)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(1, 6)));


        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P1), this.tileSize, new Position(2, 0))); //Alaska
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(2, 1)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(2, 2)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(2, 3)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(2, 4)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(2, 5)));


        //this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(3, 0)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(3, 1)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P2), this.tileSize, new Position(3, 2)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(3, 3)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(3, 4)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(3, 5)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(3, 6)));


        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P1), this.tileSize, new Position(4, 0))); //Prairie Canada
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(4, 1)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P2), this.tileSize, new Position(4, 2)));//Scandinavia
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(4, 3)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P3), this.tileSize, new Position(4, 4)));//Siberia
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P4), this.tileSize, new Position(4, 5)));//Kamchatka


        //this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(5, 0)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P1), this.tileSize, new Position(5, 1))); //Atlantic-Canada
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(5, 2)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(5, 3)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(5, 4)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P4), this.tileSize, new Position(5, 5)));//Yakutsk
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(5, 6)));


        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P1), this.tileSize, new Position(6, 0))); //West-Usa
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P2), this.tileSize, new Position(6, 1))); //Cuba
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P2), this.tileSize, new Position(6, 2))); //North-East Europe
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(6, 3)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(6, 4)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P4), this.tileSize, new Position(6, 5)));


        //this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(7, 0)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P1), this.tileSize, new Position(7, 1)));//East-USA
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(7, 2)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P2), this.tileSize, new Position(7, 3)));//Ukraine
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P3), this.tileSize, new Position(7, 4)));//Ural
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P4), this.tileSize, new Position(7, 5)));//Irkutsk
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(7, 6)));


        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P1), this.tileSize, new Position(8, 0))); //Mexico
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(8, 1)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P2), this.tileSize, new Position(8, 2)));//West-Europe
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(8, 3)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P3), this.tileSize, new Position(8, 4))); //China
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(8, 5)));


        //this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(9, 0)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(9, 1)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(9, 2)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P3), this.tileSize, new Position(9, 3)));//South-europe
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P3), this.tileSize, new Position(9, 4)));//Extra
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P4), this.tileSize, new Position(9, 5)));//Mongolia
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P4), this.tileSize, new Position(9, 6)));//Japan


        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(10, 0)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(10, 1)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(10, 2)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P3), this.tileSize, new Position(10, 3)));// Middle-East
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P3), this.tileSize, new Position(10, 4)));// Indo-china
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(10, 5)));


        //this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(11, 0)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P1), this.tileSize, new Position(11, 1))); //Venezuela
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(11, 2)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(11, 3)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P3), this.tileSize, new Position(11, 4)));//Afghanistan
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(11, 5)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(11, 6)));


        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P1), this.tileSize, new Position(12, 0))); //Peru
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(12, 1)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P2), this.tileSize, new Position(12, 2)));//North-Africa
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(12, 3)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P3), this.tileSize, new Position(12, 4)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(12, 5)));


        //this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(13, 0)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P1), this.tileSize, new Position(13, 1))); //Brazil
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P2), this.tileSize, new Position(13, 2))); //NorthWest-Africa
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(13, 3)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P3), this.tileSize, new Position(13, 4))); //India
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(13, 5)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P4), this.tileSize, new Position(13, 6)));//Pitcairn


        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P1), this.tileSize, new Position(14, 0))); //Argentina
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(14, 1)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P2), this.tileSize, new Position(14, 2)));//Congo
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(14, 3)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(14, 4)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P4), this.tileSize, new Position(14, 5)));//New Guinea


        //this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(15, 0)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(15, 1)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(15, 2)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P2), this.tileSize, new Position(15, 3))); //East-Africa
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(15, 4)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P4), this.tileSize, new Position(15, 5)));//Indonesia
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(15, 6)));


        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(16, 0)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(16, 1)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(16, 2)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(SHALLOW), this.tileSize, new Position(16, 3)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(16, 4)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P4), this.tileSize, new Position(16, 5)));//Eastern Australia


        //this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(17, 0)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(17, 1)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(0), new SimpleObjectProperty<TerrainType>(WATER), this.tileSize, new Position(17, 2)));
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P2), this.tileSize, new Position(17, 3))); //South-Africa
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P3), this.tileSize, new Position(17, 4))); //Madagskar
        this.gamemap.add(new Tile(new SimpleIntegerProperty(2), new SimpleObjectProperty<TerrainType>(P4), this.tileSize, new Position(17, 5))); //West-Australia
    }

    public void startTurn(){
        Color mapcolor = this.player.get().getColour();
        int territories = this.gamemap.stream().filter(tile -> tile.getTerrainType().colour == mapcolor).map(x->1).collect(Collectors.summingInt(Integer::intValue));

        int reinforcementsFromConquestPoints = this.player.get().getSavedUpArmies();
        //setConquestPoints(getPlayer().getConquestPoints());
        this.setReinforcements(territories/3);
        this.setAvailableMoves(7);
        }



    public void nextTurn(){ // volgende fase
        this.phaseNumber = (getPhaseNumber()+1) % phaseList.size();
        setGamePhase(this.phaseList.get(phaseNumber));
        if (this.phaseNumber == 0){
            changePlayer();
            startTurn();
            setMovable(7);

        }
        for (Tile tile2 : this.getGamemap()) {
            tile2.setSelected2(false);
            tile2.setSelected(false);

        }
        this.setSelected2(null);
        this.setSelected(null);

    }

    public boolean checkIfEliminated(Player elimPlayer){
        Color activeColor =  elimPlayer.getColour();
        for (Tile tile: this.gamemap){
            Color tileColour = tile.getTerrainType().colour;
            if (tileColour == activeColor){
                return false;
            }
        }
        return true;
    }

    public void ExitPlayer(Player player){
        this.players.removeIf(x -> x == player);
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Dialog");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText("Er is een speler geelimineerd");
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }

    private  void changePlayer(){
        this.playerNumber = (this.playerNumber+1)%players.size();

        if (this.playerNumber == 0){
            for (Player player: this.players) {
                if (this.checkIfEliminated(player)){
                    ExitPlayer(player);
                }
            }
        }
        setPlayer(this.players.get(playerNumber));
        setConquestPoints(this.getPlayer().getConquestPoints());
    }

    public ArrayList<Tile> getGamemap() {
        return gamemap;
    }

    public int getTileSize() {
        return tileSize;
    }

    public GamePhase getGamePhase() {
        return gamePhase.get();
    }

    public ObjectProperty<GamePhase> gamePhaseProperty() {
        return gamePhase;
    }

    public void setGamePhase(GamePhase gamePhase) {
        this.gamePhase.set(gamePhase);
    }

    public Tile getSelected() {
        return selected;
    }

    public void setSelected(Tile selected) {
        this.selected = selected;
    }

    public Tile getSelected2() {
        return selected2;
    }

    public void setSelected2(Tile selected2) {
        this.selected2 = selected2;
    }

    public int getPhaseNumber() {
        return phaseNumber;
    }

    public void setPhaseNumber(int phaseNumber) {
        this.phaseNumber = phaseNumber;
    }

    public Player getPlayer() {
        return player.get();
    }

    public ObjectProperty<Player> playerProperty() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player.set(player);
    }

    public Number getReinforcements() {
        return reinforcements.get();
    }

    public ObservableIntegerValue reinforcementsProperty() {
        return reinforcements;
    }

    public void setReinforcements(int reinforcements) {
        this.reinforcements.set(reinforcements);
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getMovable() {
        return movable.get();
    }

    public SimpleIntegerProperty movableProperty() {
        return movable;
    }

    public void setMovable(int movable) {
        this.movable.set(movable);
    }

    public int getConquestPoints() {
        return conquestPoints.get();
    }

    public SimpleIntegerProperty conquestPointsProperty() {
        return conquestPoints;
    }

    public void setConquestPoints(int conquestPoints) {
        this.conquestPoints.set(conquestPoints);
    }

    public int getAvailableMoves() {
        return availableMoves.get();
    }

    public SimpleIntegerProperty availableMovesProperty() {
        return availableMoves;
    }

    public void setAvailableMoves(int availableMoves) {
        this.availableMoves.set(availableMoves);
    }
}
