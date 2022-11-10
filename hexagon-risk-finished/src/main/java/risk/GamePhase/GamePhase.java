package risk.GamePhase;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.shape.Path;

import static risk.UIElements.IconPath.*;

public enum GamePhase {
    REINFORCING(
            "Versterken",
            "stap 1: klik op de tegel waar je troepen wil plaatsen \n\nStap 2: Klik nogmaals op de tegel om troepen te plaatsen",
            PARAGLIDING.path
            ),
    ATTACKING(
            "Aanvallen",
            "Stap 1: Klik op de tegel vanuit waar je aan wil vallen.\n\nStap 2: klik op de tegel die je aan wil vallen. \n\nStap 3: klik nogmaals op een van beide tegels om aan te vallen.",
            SWORDS.path
             ),
    MOVING (
            "Verplaatsen",
            "Stap 1: Klik op de tegel vanuit waar je troepen wil verwijderen. \n\nStap 2: klik op de tegel waar je troepen naartoe wil verplaatsen \n\nStap 3: Klik nogmaals op een van beide tegels om troepen te verplaatsen",
            SHIPPING.path
    ),
    PLACE_ONE ("Versterk Een", "stap 1: klik op de tegel waar je troepen wil plaatsen \n Stap 2: Klik nogmaals op de tegel om troepen te plaatsen", ADD_LOCATION.path),
    SET_P1("Naar speler 1", "Debugmode", ADD_LOCATION.path),
    SET_P2("Naar speler 2", "Debugmode", ADD_LOCATION.path),
    SET_P3("Naar speler 3", "Debugmode", ADD_LOCATION.path),
    SET_P4("Naar speler 4", "Debugmode", ADD_LOCATION.path),
    SET_SHALLOW("Naar laag water", "Debugmode", ADD_LOCATION.path),
    SET_WATER("Naar hoog water", "Debugmode", ADD_LOCATION.path),
    INCREMENT("Voeg leger toe", "Debugmode", FLAG.path),

    DECREMENT("Verwijder een leger", "Debugmode", FLAG.path),
    SELECT("Selecteer", "Debugmode", FLAG.path),
    SELECTTWO("Selecteer Twee", "Debugmode", FLAG.path),
    DONOTHING("Doe niets", "Debugmode", FLAG.path),
    ;

    private final  SimpleObjectProperty<String> label;
    private final SimpleObjectProperty<String> caption;
    private final ObjectProperty<String> path;

    GamePhase(String label, String caption, String path){
        this.label= new SimpleObjectProperty<>(label);
        this.caption = new SimpleObjectProperty<>(caption);
        this.path = new SimpleObjectProperty<>(path);
    }

    public String getPath() {
        return path.get();
    }

    public ObjectProperty<String> pathProperty() {
        return path;
    }



    public String getLabel() {
        return label.get();
    }

    public SimpleObjectProperty<String> labelProperty() {
        return label;
    }


    public String getCaption() {
        return caption.get();
    }


}
