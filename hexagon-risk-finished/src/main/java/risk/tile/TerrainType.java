package risk.tile;

import javafx.scene.paint.Color;
public enum TerrainType {

    P1("player One", Color.DARKRED),
    P2("Player Two", Color.DARKORCHID),
    P3("Player Three", Color.DARKOLIVEGREEN),
    P4("Player four", Color.CHOCOLATE),
    WATER("Water", Color.CORNFLOWERBLUE),
    SHALLOW("Shallow Water", Color.LIGHTSKYBLUE),
    NONE("None", Color.WHITE);

    public final String label;
    public final Color colour;




    TerrainType(String label, Color colour) {
        this.label = label;
        this.colour = colour;
    }

}