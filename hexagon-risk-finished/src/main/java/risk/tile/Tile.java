package risk.tile;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.css.PseudoClass;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import static risk.tile.TerrainType.*;
import static risk.tile.TerrainType.P4;

public class Tile extends StackPane {

    public boolean isTerritory () {
        return ((this.getTerrainType() == P1 || this.getTerrainType() == P2) || (this.getTerrainType() == P3 || this.getTerrainType() == P4));
    }

    public boolean isSamePlayer (Tile tile) {
        return (this.getTerrainType() == tile.getTerrainType());
    }

    private SimpleIntegerProperty count;
    //private ObjectProperty<Color> color;
    private BooleanProperty selected;
    private BooleanProperty selected2;
    private ObjectProperty<TerrainType> terrainType;
    private final int size;
    private final PseudoClass isSelected = PseudoClass.getPseudoClass("selected");
    private final PseudoClass isSelected2 = PseudoClass.getPseudoClass("selected2");
    private Label label;
    private Position position;


    public Tile(SimpleIntegerProperty count, SimpleObjectProperty<TerrainType> terrainType, int size, Position position) {
        this.count = (SimpleIntegerProperty) count;
        this.selected = new SimpleBooleanProperty(false);
        this.selected2 = new SimpleBooleanProperty(false);
        this.size = size;
        this.terrainType = terrainType;
        this.position = position;

        this.getStyleClass().add("hex-tile");
        this.setMaxHeight(this.size/1.1547005);
        this.setMinHeight(this.size/1.1547005);
        this.setMaxWidth(this.size);
        this.setMinWidth(this.size);
        this.selectedProperty().addListener(observable -> this.pseudoClassStateChanged(isSelected, this.isSelected()));
        this.selected2Property().addListener(observable -> this.pseudoClassStateChanged(isSelected2, this.isSelected2()));
        this.setBackground(new Background(new BackgroundFill(this.getTerrainType().colour, null, null)));
        this.terrainTypeProperty().addListener(observable -> this.setBackground(new Background(new BackgroundFill(this.getTerrainType().colour, null, null))));

        this.label = new Label();
        label.setTextFill(Color.WHITE);
        label.setStyle("-fx-font-size: 20px;");
        label.textProperty().bind(
                Bindings.when(this.countProperty().isNotEqualTo(0)).then(this.count.asString()).otherwise("")
        );
        this.getChildren().addAll(label);
    }



    public int getCount() {
        return count.get();
    }

    public IntegerProperty countProperty() {
        return count;
    }

    public void setCount(int count) {
        this.count.set(count);
    }

    public boolean isSelected() {
        return selected.get();
    }

    public BooleanProperty selectedProperty() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }

    public boolean isSelected2() {
        return selected2.get();
    }

    public BooleanProperty selected2Property() {
        return selected2;
    }

    public void setSelected2(boolean selected2) {
        this.selected2.set(selected2);
    }

    public TerrainType getTerrainType() {
        return terrainType.get();
    }

    public ObjectProperty<TerrainType> terrainTypeProperty() {
        return terrainType;
    }

    public void setTerrainType(TerrainType terrainType) {
        this.terrainType.set(terrainType);
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
