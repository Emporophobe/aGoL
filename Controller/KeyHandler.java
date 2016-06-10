package Controller;

import Model.Grid;
import Model.World;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyHandler {

    private static World _world;

    private static boolean _running = false;

    /**
     * Set the world the keys interact with
     *
     * @param w The world
     */
    public static void setWorld(World w){
        _world = w;
    }

    public static void HandleKeyPressed(KeyEvent e) {
        // Update once
        if (e.getCode() == KeyCode.SPACE){
            _world.update();
        }
        // Reset
        else if (e.getCode() == KeyCode.R) {
            _world.clear();
        }
        else if (e.getCode() == KeyCode.P){
            if (_world.isRunning()){
                _world.stop();
            }
            else{
                _world.play();
            }
        }
    }
}
