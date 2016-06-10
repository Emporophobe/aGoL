package Controller;

import Model.World;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyHandler {

    private static World _world;

    /**
     * Set the world the keys interact with
     *
     * @param w The world
     */
    public static void setWorld(World w){
        _world = w;
    }

    public static void HandleKeyPressed(KeyEvent e) {
        if (e.getCode() == KeyCode.SPACE){
            _world.update();
        }
    }
}
