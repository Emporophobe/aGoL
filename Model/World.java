package Model;

public class World {
    private Grid _grid;
    private int _width; // in cells
    private int _height; // in cells
    private boolean running = false; // whether the world should automatically update

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
     * Get whether the world is automatically updating
     * @return True if currently running
     */
    public boolean isRunning(){
        return running;
    }

    /**
     * Start auto updating the world
     */
    public void play(){
        running = true;
    }

    /**
     * Stop auto updating the world
     */
    public void stop(){
        running = false;
    }

    /**
     * Update the grid to the next generation
     */
    public void update(){
        _grid.update();
    }

    /**
     * Clear the grid
     */
    public void clear() {
        _grid = new Grid(_width, _height);
    }
}
