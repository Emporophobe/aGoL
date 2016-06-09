package Model;

public class Grid {
    private int _width;
    private int _height;
    private Cell[][] _theGrid;

    Grid(int width, int height) {
        _width = width;
        _height = height;
        _theGrid = new Cell[width][height];

        for (int j = 0; j < height; j++){
            for (int i = 0; i < width; i++){
                _theGrid[i][j] = new Cell(i, j, false);
            }
        }
    }

    /**
     * Get the width of the grid, in cells
     * @return The width
     */
    public int getWidth(){
        return _width;
    }

    /**
     * Get the height of the grid, in cells
     * @return The height
     */
    public int getHeight(){
        return _height;
    }

    /**
     * Count the number of alive neighbors of the given cell
     * @param c The cell
     * @return The number of neighbors
     */
    int countNeighbors(Cell c){
        int x = c.getXCoord();
        int y = c.getYCoord();

        // We have a toroidal grid - the top and bottom are adjacent,
        // and the left and right are adjacent
        int ltCol = (x == 0 ? _width - 1 : x - 1);
        int rtCol = (x == _width - 1 ? 0 : x + 1);
        int upRow = (y == _height - 1 ? 0 : y + 1);
        int dnRow = (y == 0 ? _height - 1 : y - 1);

        int neighbors = 0;

        for (int row : new int[]{dnRow, y, upRow}){
            for (int col : new int[]{ltCol, x, rtCol}){
                if (_theGrid[col][row].isAlive()){
                    neighbors++;
                }
            }
        }

        return neighbors;
    }

    /**
     * Check if a cell is alive
     * @param row The row of the cell
     * @param col The column of the cell
     * @return Whether the cell at the given row and column is alive
     */
    public boolean checkCell(int row, int col){
        return _theGrid[col][row].isAlive();
    }

    /**
     * Set the state of the given cell in the grid
     * @param alive The state to set the cell to
     * @param x The cell's x-coordinate (in cell coordinates)
     * @param y The cell's y-coordinate (in cell coordinates)
     */
    public void setCellAlive(boolean alive, int x, int y){
        _theGrid[x][y].setAlive(alive);
    }

}
