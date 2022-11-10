package risk.UIElements;


import javafx.beans.binding.Bindings;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import risk.Model;

;


public class PhaseGraphic extends StackPane {
    private Model model;
    private int size;
    private SVGPath phaseIcon;

    public PhaseGraphic(Model model){
        this.model = model;
        this.phaseIcon = new SVGPath();
        this.phaseIcon.setContent(model.getGamePhase().getPath());
        phaseIcon.setFill(Color.WHITE);
        phaseIcon.setScaleX(2.5);
        phaseIcon.setScaleY(2.5);
        this.getChildren().add(phaseIcon);
        this.getStyleClass().add("turn_counter");
        this.setBackground(new Background(new BackgroundFill(model.getPlayer().getColour(), null, null)));
        size = 170;
        this.setMaxHeight(this.size/1.1547005);
        this.setMinHeight(this.size/1.1547005);
        this.setMaxWidth(this.size);
        this.setMinWidth(this.size);

    }

    public void setBG(Color colour){
        this.setBackground((new Background(new BackgroundFill(colour, null, null))));
    }

    public void changeIcon(String content){
        phaseIcon.setContent(content);
    }
}
