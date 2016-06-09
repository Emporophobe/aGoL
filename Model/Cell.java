package Model;

/**
 * Represents a single cell
 */
class Cell {
    /**
     * X coordinate of cell (0 is left)
     */
    private int _xCoord;
    /**
     * Y coordinate of cell (0 is bottom)
     */
    private int _yCoord;
    /**
     * Whether cell is alive or dead
     */
    private boolean _alive;

    /**
     * Make a new Cell at the given coordinates
     * @param x The x-coordinate (in cell coordinates)
     * @param y The y-coordinate (in cell coordinates)
     * @param alive Whether the cell is alive
     */
    Cell(int x, int y, boolean alive){
        _xCoord = x;
        _yCoord = y;
        _alive = alive;
    }

    public boolean isAlive() {
        return _alive;
    }
    public void setAlive(boolean alive){
        _alive = alive;
    }

    public int getXCoord() {
        return _xCoord;
    }

    public int getYCoord(){
        return _yCoord;
    }
}
