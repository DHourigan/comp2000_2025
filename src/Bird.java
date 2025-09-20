import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Bird extends Actor {
    public Bird(String name, int col, int row) { super(name, col, row); }

    @Override
    public void draw(Graphics g, Point topLeft) {
        int x = topLeft.x + col*Cell.SIZE + 10;
        int y = topLeft.y + row*Cell.SIZE + 4;
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 12, 10);
    }
};