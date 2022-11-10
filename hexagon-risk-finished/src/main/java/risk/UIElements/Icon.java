package risk.UIElements;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;

public class Icon extends StackPane {
    public Icon(IconPath path, String tooltipString){
        SVGPath icon = new SVGPath();
        icon.setContent(path.path);
        //icon.setFill(Color.WHITE);
        icon.setScaleX(1.2);
        icon.setScaleY(1.2);
        icon.getStyleClass().add("menu_icon");
        this.getChildren().addAll(icon);
        this.getStyleClass().add("menu_pane");
        //this.setStyle("-fx-shape: \"" + path.getPath() + "\"; ");
        Tooltip tooltip = new Tooltip(tooltipString);
        Tooltip.install(this, tooltip);

    }
}
