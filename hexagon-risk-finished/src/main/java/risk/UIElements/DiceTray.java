package risk.UIElements;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class DiceTray extends HBox {
    private Dice dice1;
    private Dice dice2;
    private Dice dice3;
    private boolean isGreen;

    public DiceTray(boolean isGreen){
        int diceSize = 50;
        int cor = isGreen ? 0 : 6;
        this.isGreen = isGreen;
        this.dice1 = new Dice(cor, diceSize);
        this.dice2 = new Dice(cor, diceSize);
        this.dice3 = new Dice(cor, diceSize);
        this.getChildren().addAll(dice1,dice2,dice3);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
    }

    public void setDie (int dice1, int dice2, int dice3){
        this.dice3.setVisible(true);
        this.dice2.setVisible(true);
        int cor = isGreen ? 0 : 6;
        this.dice1.setNumber(dice1+cor);
        this.dice2.setNumber(dice2+cor);
        this.dice3.setNumber(dice3+cor);
    }

    public void setDie (int dice1, int dice2){
        this.setDie(dice1, dice2, 1);
        dice3.setVisible(false);
        }

    public void setDie (int dice1){
        this.setDie(dice1, dice1, 1);
        dice2.setVisible(false);
        dice3.setVisible(false);
    }


    public int castDie() {
        return (int) (Math.floor(Math.random() * 6));
    }

    public void setDieRandom(){
        setDie(castDie(), castDie(), castDie());

    }
}
