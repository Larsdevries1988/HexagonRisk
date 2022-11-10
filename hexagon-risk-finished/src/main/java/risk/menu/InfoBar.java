package risk.menu;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import risk.GamePhase.GamePhase;
import risk.Model;
import risk.Player;
import risk.UIElements.DiceTray;
import risk.UIElements.Icon;
import risk.UIElements.PhaseGraphic;
import risk.tile.TerrainType;

import static risk.GamePhase.GamePhase.*;
import static risk.UIElements.IconPath.MILITARY_TECH;
import static risk.UIElements.IconPath.NEXT_PLAN;

public class InfoBar extends VBox {
    private final Model model;

    private final PhaseGraphic phaseGraphic;
    private Label gamePhaseLabel;
    private final Label caption;
    private final Icon next_icon;
    private final Icon hand_in_icon;
    private final DiceTray dice1;
    private final DiceTray dice2;
    private final Label reinforcementLabel;
    private final Label cp;
    private final Label movableLabel;
    public InfoBar(Model model) {
        GamePhase phase = model.getGamePhase();
        this.model = model;
        this.dice1 = new DiceTray(true);
        this.dice2 = new DiceTray(false);
        this.gamePhaseLabel = new Label(phase.getLabel());
        this.phaseGraphic = new PhaseGraphic(this.model);
        this.caption = new Label(phase.getCaption());
        this.next_icon = new Icon(NEXT_PLAN, "Volgende fase");
        this.hand_in_icon = new Icon(MILITARY_TECH, "Ruil conquest points in voor legers");
        this.reinforcementLabel = new Label("Legers om te plaatsen: " + model.getReinforcements());
        this.movableLabel = new Label("Legers om te verplaatsen: " + model.getMovable());
        this.cp = new Label("Veroverpunten: 0\nInruilwaarde: 0");
        this.init();
    }
    //    private void setGamePhase(){
//        vieuw.getSelectGamePhase().valueProperty().addListener((options, oldValue, newValue) -> {
//            model.setGamePhase(newValue);
//        });
//    }
    private void init() {
        model.gamePhaseProperty().addListener((options, oldValue, newValue) -> {
            this.gamePhaseLabel.setText(newValue.getLabel());
            this.caption.setText(newValue.getCaption());
            this.phaseGraphic.changeIcon(newValue.getPath());
            if (newValue == ATTACKING ){
                dice1.setVisible(true);
                dice2.setVisible(true);
            }
            else{
                dice1.setVisible(false);
                dice2.setVisible(false);
            }
            if (newValue == REINFORCING || newValue == PLACE_ONE){
                reinforcementLabel.setVisible(true);
                hand_in_icon.setVisible(true);
            }
            else{
                reinforcementLabel.setVisible(false);
                hand_in_icon.setVisible(false);
            }
            if (newValue == MOVING){
                movableLabel.setVisible(true);
            }
            else{
                movableLabel.setVisible(false);
            }
        });
        model.playerProperty().addListener((options, oldValue, newValue) -> {
            this.phaseGraphic.setBG(newValue.getColour());
        });

        model.reinforcementsProperty().addListener((op, ov, nv) -> {
            if (nv.intValue() > 0) {
                this.reinforcementLabel.setText("Legers om te plaatsen: " + nv);
            }
            else {
                this.reinforcementLabel.setText("Geen legers om te plaatsen");
            }
        });

        model.conquestPointsProperty().addListener((op, ov, nv) -> {
            this.cp.setText("Veroverpunten: " + nv);
        });

        model.movableProperty().addListener((op, ov, nv) -> {
            this.movableLabel.setText("Verplaatsbare Legers: " + nv);
        });

        model.conquestPointsProperty().addListener((op, ov, nv) -> {
            int armies;
            switch (nv.intValue()) {
                case 1: {
                    armies = 1;
                    break;
                }
                case 2: {
                    armies = 3;
                    break;
                }
                case 3: {
                    armies = 5;
                    break;
                }
                case 4: {
                    armies = 8;
                    break;
                }
                case 5: {
                    armies = 12;
                    break;
                }
                case 6: {
                    armies = 16;
                    break;
                }
                default: {
                    armies = 0;
                }

            }
            this.cp.setText("Veroverpunten: " + nv +"\nInruilwaarde: " + armies);
        });
        model.movableProperty().addListener((op, ov, nv) -> {
            this.movableLabel.setText("Legers om te verplaatsen: " + nv.toString());
        });



        this.reinforcementLabel.getStyleClass().add("caption");
        this.cp.getStyleClass().add("caption");
        this.movableLabel.setVisible(false);
        this.movableLabel.getStyleClass().add("caption");
        VBox diceTrays = new VBox(20, dice1, dice2);
        StackPane pane = new StackPane(diceTrays, reinforcementLabel, movableLabel);
        pane.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(20);
        HBox infoBarButtons = new HBox(40, this.hand_in_icon, this.next_icon);
        infoBarButtons.setAlignment(Pos.CENTER);
        infoBarButtons.setPadding(new Insets(20, 0, 0, 0));
        this.getChildren().addAll(phaseGraphic, gamePhaseLabel, caption, pane, this.cp, infoBarButtons);

        this.setPadding(new Insets(50, 50, 50, 50));
        this.setAlignment(Pos.CENTER);
        this.caption.getStyleClass().add("caption");
        this.caption.setWrapText(true);
        this.caption.setMaxWidth(220);
        this.gamePhaseLabel.getStyleClass().add("game_phase_label");
        this.gamePhaseLabel.setWrapText(true);
        this.gamePhaseLabel.setMaxWidth(220);
        this.gamePhaseLabel.setAlignment(Pos.CENTER);
        this.gamePhaseLabel.setTextAlignment(TextAlignment.JUSTIFY);
        this.caption.setMinHeight(280);
        this.caption.setTextAlignment(TextAlignment.JUSTIFY);
        this.caption.setPadding(new Insets(20, 0, 20, 0));
        this.dice1.setVisible(false);
        this.dice2.setVisible(false);

    }


    public Icon getNext_icon() {
        return next_icon;
    }

    public PhaseGraphic getPhaseGraphic() {
        return phaseGraphic;
    }

    public DiceTray getDice1() {
        return dice1;
    }

    public DiceTray getDice2() {
        return dice2;
    }

    public Icon getHand_in_icon() {
        return hand_in_icon;
    }
}
