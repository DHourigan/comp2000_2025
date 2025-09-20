import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cat extends Actor {
    public Cat(String name, int col, int row) { super(name, col, row); }

    @Override
    public void draw(Graphics g, Point topLeft) {
        int x = topLeft.x + col*Cell.SIZE + 8;
        int y = topLeft.y + row*Cell.SIZE + 6;
        g.setColor(Color.ORANGE);
        g.fillOval(x, y, 20, 14);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 20, 14);
    }
};