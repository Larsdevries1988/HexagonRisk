package risk.menu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import risk.GamePhase.GamePhase;
import risk.Model;
import risk.UIElements.Icon;
import risk.UIElements.IconPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import static risk.UIElements.IconPath.*;

public class SideMenu extends VBox {
   private Model model;

    public SideMenu(Model model) {
        this.model = model;
        initialize();

    }

    private void initialize() {
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20, 10, 0, 20));
        this.setSpacing(20);
        this.getChildren().addAll(
                init_icon(HEXAGON, "Change GamePhase", changeGamePhase()),
                init_icon(LIST_ALT, "Credits", test()),
                init_icon(LOGOUT, "exit", test())
        );
    }

    private Icon init_icon(IconPath iconpath, String tooltip, Runnable runnable) {
        Icon icon = new Icon(iconpath, tooltip);
        icon.setOnMouseClicked(event -> {
            runnable.run();
        });
        return icon;
    }

    private Runnable test() {
        return new Runnable() {
            @Override
            public void run() {
                Dialog<String> dialog = new Dialog<>();
                dialog.setTitle("Dialog");
                ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                dialog.setContentText("This is a sample dialog");
                dialog.getDialogPane().getButtonTypes().add(type);
                dialog.showAndWait();
            }
        };
    }

    private Runnable changeGamePhase() {
        return new Runnable() {
            @Override
            public void run() {
                ArrayList<String> list = new ArrayList<>();
                for (GamePhase phase: GamePhase.values()) {
                    list.add(phase.getLabel());
                }
                ChoiceDialog dialog = new ChoiceDialog(list.get(0), list);

                dialog.setTitle("Verander de spelfase");
                dialog.setHeaderText("selecteer de fase van het spel \nwaar je naartoe wil veranderen.");
                SVGPath graphic = new SVGPath();
                graphic.setContent(MILITARY_TECH.path);
                dialog.setGraphic(graphic);
                graphic.setFill(Color.BLUE);
                Optional<String> result = dialog.showAndWait();


                if (result.isPresent()){
                    HashMap<String,GamePhase> dict = new HashMap<>();
                    for (GamePhase phase:  GamePhase.values()){
                        dict.put(phase.getLabel(), phase);
                    }
                    GamePhase phaseResult = dict.get(result.get());
                    model.setGamePhase(phaseResult);
                }

            }
        };
    }


}
