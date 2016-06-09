import Controller.MouseHandler;
import Model.World;
import View.UI;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set up Javafx objects
        Group root = new Group();
        Scene theScene = new Scene(root);

        World w = new World(75, 45);
        UI ui = new UI(w);

        Canvas canvas = new Canvas(ui.getScreenWidthPixels(), ui.getScreenHeightPixels());

        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Pass the world so the mouse handler can interact with it
        MouseHandler.setWorld(w);

        theScene.setOnMousePressed(MouseHandler::HandleMouseDown);
        theScene.setOnMouseDragged(MouseHandler::HandleMouseDrag);

        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                ui.drawWorld(w, gc);
            }
        }.start();

        root.getChildren().add(canvas);
        primaryStage.setScene(theScene);
        primaryStage.show();
    }
}
