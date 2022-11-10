package risk.menu;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import risk.Model;
import risk.tile.Tile;

public class MainView extends VBox {
    private final Model model;

    public MainView(Model model) {
        this.model = model;
        this.init();
    }

    private void init() {
        Pane pane = new Pane();
        HBox box = new HBox();
        box.setAlignment(Pos.CENTER);
        this.setAlignment(Pos.CENTER);
        box.getChildren().add(pane);
        this.getChildren().add(box);
        for (Tile tile : this.model.getGamemap()) {
            int row = tile.getPosition().row();
            int column = tile.getPosition().column();
            int tileSize = model.getTileSize();
            tile.setLayoutY(row * tileSize / 2 / 1.1547005);
            if (row % 2 != 0) {
                tile.setLayoutX(column * tileSize * 1.5);
            } else {
                tile.setLayoutX(column * tileSize * 1.5 + tileSize * 0.75);
            }
            pane.getChildren().add(tile);


        }
    }
}