package Model;

public class World {
    private Grid _grid;
    private int _width; // in cells
    private int _height; // in cells

    public World(int width, int height){
        _width = width;
        _height = height;
        _grid = new Grid(width, height);
    }

    public int getWidth(){
        return _width;
    }

    public int getHeight(){
        return _height;
    }

    public Grid getGrid(){
        return _grid;
    }

    /**
     * Update the grid to the next generation
     */
    public void update(){
        _grid.update();
    }
}
