package Controller;

import Model.World;
import View.UI;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

import java.util.HashSet;

public class MouseHandler {
    private static Point2D clickCoord = null;

    public static void HandleMouseDown(MouseEvent e){
        clickCoord = new Point2D(e.getX(), e.getY());
    }

    /**
     * Convert screen coordinates to cell coordinates
     * @param w The world
     * @param x The x-coordinate in screen coordinates
     * @param y The y-coordinate in screen coordinates
     * @return The coordinate of the cell at the screen point
     */
    private static Point2D screenToCell(World w, int x, int y){
        return new Point2D(x / UI.cellSize, w.getHeight() - 1 - (y / UI.cellSize)); // Integer division rounds down
    }

    public static void handleMouse(World w){
        if (clickCoord != null){
            Point2D cellCoord = screenToCell(w, (int)clickCoord.getX(), (int)clickCoord.getY());
            boolean isAlive = w.getGrid().checkCell((int) cellCoord.getX(), (int) cellCoord.getY());
            w.getGrid().setCellAlive(
                    !isAlive,
                    (int) cellCoord.getX(),
                    (int) cellCoord.getY());
            clickCoord = null;
        }
    }

    public static void HandleMouseReleased(MouseEvent mouseEvent) {

    }
}
