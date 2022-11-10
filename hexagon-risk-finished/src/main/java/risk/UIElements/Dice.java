package risk.UIElements;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Arrays;
import java.util.List;

public class Dice extends ImageView {
    private IntegerProperty number;
    private double size;
    private ImageView image;
    private List<Image> images;

    public Dice(int number, double size){
        this.number = new SimpleIntegerProperty(number);
        this.size = size;
        images = Arrays.asList(
                new Image(Dice.class.getResourceAsStream("/images/diceGreen1.png")),
                new Image(Dice.class.getResourceAsStream("/images/diceGreen2.png")),
                new Image(Dice.class.getResourceAsStream("/images/diceGreen3.png")),
                new Image(Dice.class.getResourceAsStream("/images/diceGreen4.png")),
                new Image(Dice.class.getResourceAsStream("/images/diceGreen5.png")),
                new Image(Dice.class.getResourceAsStream("/images/diceGreen6.png")),
                new Image(Dice.class.getResourceAsStream("/images/diceRed1.png")),
                new Image(Dice.class.getResourceAsStream("/images/diceRed2.png")),
                new Image(Dice.class.getResourceAsStream("/images/diceRed3.png")),
                new Image(Dice.class.getResourceAsStream("/images/diceRed4.png")),
                new Image(Dice.class.getResourceAsStream("/images/diceRed5.png")),
                new Image(Dice.class.getResourceAsStream("/images/diceRed6.png"))
        );

        this.imageProperty().bind(Bindings.createObjectBinding(() -> images.get(this.getNumber()), this.number));
        this.setFitHeight(size);
        this.setFitWidth(size);
    }

    public int getNumber() {
        return number.get();
    }

    public IntegerProperty numberProperty() {
        return number;
    }

    public void setNumber(int number) {
        this.number.set(number);
    }
}
