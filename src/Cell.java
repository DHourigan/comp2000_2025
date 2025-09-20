import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Abstract Cell that knows how to draw itself. Concrete terrain types
 * extend this class to provide different appearance / behaviour.
 */
public abstract class Cell extends Rectangle implements Drawable {
    public static final int SIZE = 40;
    protected char colLabel;
    protected int row;
    protected ItemBag<Item> items;

    public Cell(char colLabel, int row, int x, int y) {
        super(x, y, SIZE, SIZE);
        this.colLabel = colLabel;
        this.row = row;
        this.items = new ItemBag<>();
    }

    public void addItem(Item it) {
        items.add(it);
    }

    public ItemBag<Item> getItems() {
        return items;
    }

    // Default draw renders a colored background (provided by subclass)
    @Override
    public void draw(Graphics g, Point topLeft) {
        Color bg = backgroundColor();
        g.setColor(bg);
        g.fillRect(topLeft.x + x, topLeft.y + y, width, height);
        g.setColor(Color.DARK_GRAY);
        g.drawRect(topLeft.x + x, topLeft.y + y, width, height);

        // draw up to two items in the cell
        int offset = 4;
        int idx = 0;
        for (Item it : items.getItems()) {
            if (idx >= 2) break;
            Point p = new Point(topLeft.x + x + offset + idx*16, topLeft.y + y + height/2 - 6);
            it.draw(g, p);
            idx++;
        }
    }

    // Subclasses provide terrain color
    protected abstract Color backgroundColor();
};