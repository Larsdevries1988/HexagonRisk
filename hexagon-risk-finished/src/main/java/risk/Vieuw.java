package risk;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import risk.menu.BottomBar;
import risk.menu.InfoBar;
import risk.menu.MainView;
import risk.menu.SideMenu;
import javafx.scene.layout.*;


public class Vieuw {
    private final Model model;
    private final SideMenu sideMenu;
    private final InfoBar infoBar;
    private final BottomBar bottomBar;


    public Vieuw(Model model) {
        this.model = model;
        this.sideMenu = new SideMenu(this.model);
        this.infoBar = new InfoBar(this.model);
        this.bottomBar = new BottomBar(this.model);
    }


    public Region getVieuw() {
        StackPane stack = background();
        BorderPane bPane = new BorderPane();
        stack.getChildren().add(bPane);
        bPane.setCenter(new MainView(model));
        bPane.setRight(this.infoBar);
        bPane.setLeft(this.sideMenu);
        //bPane.setBottom(this.bottomBar);
        return stack;
    }

    private StackPane background(){
        StackPane stack = new StackPane();
        stack.setBackground(new Background(new BackgroundFill(Color.rgb(26,27,38), null, null)));
        Image image = new Image(getClass().getResourceAsStream("/images/map2.png"));
        ImageView imageView = new ImageView(image);
        imageView.setOpacity(0.4);
        stack.getChildren().add(imageView);

        return stack;
    };


    public InfoBar getInfoBar() {
        return infoBar;
    }
    public BottomBar getBottomBar() {
        return bottomBar;
    }
}