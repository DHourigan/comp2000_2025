import java.awt.Graphics;
import java.awt.Point;

/**
 * Base Actor class (players, NPCs). Demonstrates inheritance: concrete animals
 * will extend this class. Actors can move and interact with Items in Cells.
 */
public abstract class Actor implements Drawable {
    protected int col;
    protected int row;
    protected String name;

    public Actor(String name, int col, int row) {
        this.name = name;
        this.col = col;
        this.row = row;
    }

    public int getCol() { return col; }
    public int getRow() { return row; }
    public void setPos(int c, int r) { col = c; row = r; }

    // Called when actor 'picks up' an item
    public void notifyPickup(Item item) {
        System.out.println(name + " picked up: " + item.getName());
    }

    // Default interaction: try to pick up first item in the cell.
    public void tryPickup(Cell[][] grid) {
        Cell c = grid[col][row];
        if (c.getItems().size() > 0) {
            Item it = c.getItems().getItems().get(0);
            it.interact(this);
            c.getItems().remove(it);
        }
    }
    

    @Override
    public abstract void draw(Graphics g, Point topLeft);
};