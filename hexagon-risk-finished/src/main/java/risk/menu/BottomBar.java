package risk.menu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import risk.Model;
import risk.UIElements.DiceTray;

public class BottomBar extends StackPane {
    private Model model;
    private final DiceTray dice1;
    private final DiceTray dice2;
    public BottomBar(Model model){
        this.model = model;
        this.dice1 = new DiceTray(true);
        this.dice2 = new DiceTray(false);
        HBox vbox = new HBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        vbox.getChildren().addAll(this.dice1, this.dice2);
        this.setPadding(new Insets(0, 50, 10, 50));
        this.getChildren().addAll(vbox);
        this.dice1.setDieRandom();
        this.dice2.setDieRandom();
    }

    public DiceTray getDice1() {
        return dice1;
    }

    public DiceTray getDice2() {
        return dice2;
    }


}
