import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/** Example Item: fish for cats (just a simple drawable item) */
public class Fish implements Item {
    private final String name;
    public Fish(String name) { this.name = name; }

    @Override
    public void draw(Graphics g, Point topLeft) {
        g.setColor(Color.ORANGE);
        g.fillOval(topLeft.x, topLeft.y, 10, 6);
        g.setColor(Color.BLACK);
        g.drawLine(topLeft.x+2, topLeft.y+3, topLeft.x+8, topLeft.y+3);
    }

    @Override
    public void interact(Actor actor) {
        actor.notifyPickup(this);
    }

    @Override
    public String getName() { return name; }
};