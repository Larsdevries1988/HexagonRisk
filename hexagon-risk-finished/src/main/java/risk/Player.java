package risk;

import javafx.scene.paint.Color;

public class Player {
    private String naam;
    private Color colour;
    private int conquestPoints;
    private int savedUpArmies;

    public Player(String naam, Color colour, int conquestPoints, int savedUpArmies) {
        this.naam = naam;
        this.colour = colour;
        this.conquestPoints = conquestPoints;
        this.savedUpArmies = savedUpArmies;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public int getConquestPoints() {return conquestPoints;}

    public void setConquestPoints(int conquestPoints) {this.conquestPoints = conquestPoints;}

    public int getSavedUpArmies() {return savedUpArmies;}

    public void setSavedUpArmies(int savedUpArmies) {this.savedUpArmies = savedUpArmies;    }
}
