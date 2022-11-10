module com.example.poc {
    requires javafx.controls;
    requires javafx.fxml;


    opens risk to javafx.fxml;
    exports risk;
    exports risk.tile;
    opens risk.tile to javafx.fxml;
    exports risk.UIElements;
    opens risk.UIElements to javafx.fxml;
    exports risk.GamePhase;
    opens risk.GamePhase to javafx.fxml;
}