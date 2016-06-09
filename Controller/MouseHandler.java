package Controller;

import Model.World;
import View.UI;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

public class MouseHandler {
    /**
     * The cell coordinate corresponding to clickCoord
     */
    private static Point2D cellCoord = null;
    /**
     * Whether the cell under the mouse is alive
     */
    private static boolean cellLiving = false;
    /**
     * The world to interact with
     */
    private static World theWorld = null;

    /**
     * Set the world the mouse interacts with. This needs to be set before calling the handlers
     *
     * @param w The world
     */
    public static void setWorld(World w) {
        theWorld = w;
    }

    public static void HandleMouseDown(MouseEvent e) {
        cellCoord = screenToCell(theWorld, (int) e.getX(), (int) e.getY());
        cellLiving = theWorld.getGrid().checkCell((int) cellCoord.getX(), (int) cellCoord.getY());

        boolean isAlive = theWorld.getGrid().checkCell((int) cellCoord.getX(), (int) cellCoord.getY());
        theWorld.getGrid().setCellAlive(
                !isAlive,
                (int) cellCoord.getX(),
                (int) cellCoord.getY());
    }

    public static void HandleMouseDrag(MouseEvent e) {
        int x = (int) e.getX();
        int y = (int) e.getY();

        // Check that we are in the bounds of the grid
        if (x > 0 && x < theWorld.getWidth() * UI.cellSize &&
                y > 0 && y < theWorld.getHeight() * UI.cellSize) {
            cellCoord = screenToCell(theWorld, x, y);
            theWorld.getGrid().setCellAlive(!cellLiving, (int) cellCoord.getX(), (int) cellCoord.getY());
        }
    }

    /**
     * Convert screen coordinates to cell coordinates
     *
     * @param w The world
     * @param x The x-coordinate in screen coordinates
     * @param y The y-coordinate in screen coordinates
     * @return The coordinate of the cell at the screen point
     */
    private static Point2D screenToCell(World w, int x, int y) {
        return new Point2D(x / UI.cellSize, w.getHeight() - 1 - (y / UI.cellSize)); // Integer division rounds down
    }
}
