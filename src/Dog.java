import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Dog extends Actor {
    public Dog(String name, int col, int row) { super(name, col, row); }

    @Override
    public void draw(Graphics g, Point topLeft) {
        int x = topLeft.x + col*Cell.SIZE + 6;
        int y = topLeft.y + row*Cell.SIZE + 6;
        g.setColor(Color.GRAY);
        g.fillOval(x, y, 24, 18);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 24, 18);
    }
};