package View;

import Model.Grid;
import Model.World;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class UI {
    /**
     * The length of a side of the cell, in pixels
     */
    public static final int cellSize = 8;
    /**
     * The width of the window, in cells
     */
    private int screenWidthCells;
    /**
     * The height of the window, in cells
     */
    private int screenHeightCells;

    public int getScreenHeightPixels(){
        return screenHeightCells * cellSize;
    }

    public int getScreenWidthPixels(){
        return screenWidthCells * cellSize;
    }

    public UI(World w){
        screenHeightCells = w.getHeight();
        screenWidthCells = w.getWidth();
    }

    /**
     * Draw the world
     * @param w The world
     * @param gc The graphics context
     */
    public void drawWorld(World w, GraphicsContext gc){
        gc.setFill(Color.color(0.1, 0.1, 0.1));
        gc.fillRect(0, 0, w.getWidth() * cellSize, w.getHeight() * cellSize);
        drawGrid(w.getGrid(), gc);
    }

    /**
     * Draw a grid
     * @param g The grid
     * @param gc The graphics context
     */
    private void drawGrid(Grid g, GraphicsContext gc){
        for(int x = 0; x < g.getWidth(); x++){
            for(int y = 0; y < g.getHeight(); y++){
                if (g.checkCell(x, y)){
                    drawCell(x, y, gc);
                }
            }
        }
    }

    /**
     * Draw a living cell
     * @param x The cell's x-coordinate (in cell coordinates)
     * @param y The cell's y-coordinate (in cell coordinates)
     * @param gc The graphics context
     */
    private void drawCell(int x, int y, GraphicsContext gc){
        Point2D p = cellToScreen(x, y);
        gc.setFill(Color.YELLOW);

        // Make the filled in squares slightly smaller than the cell size, to show the borders
        gc.fillRect(p.getX() + 1, p.getY() - cellSize + 1, cellSize - 2, cellSize - 2);
    }

    /**
     * Convert a cell coordinate (cartesian, cell size >= 1 pixel) to screen coordinates (0, 0 at top left)
     * @param x The x-coordinate of the cell
     * @param y The y-coordinate of the cell
     * @return A point in screen-coordinates corresponding to the top left corner of the cell
     */
    private Point2D cellToScreen(int x, int y){
        return new Point2D(x * cellSize, getScreenHeightPixels() - (y * cellSize));
    }
}
