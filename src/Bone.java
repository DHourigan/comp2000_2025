import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/** Example Item: a Bone that can be picked up by Dogs */
public class Bone implements Item {
    private final String name;

    public Bone(String name) {
        this.name = name;
    }

    @Override
    public void draw(Graphics g, Point topLeft) {
        g.setColor(Color.WHITE);
        g.fillOval(topLeft.x, topLeft.y, 12, 8);
        g.setColor(Color.BLACK);
        g.drawOval(topLeft.x, topLeft.y, 12, 8);
    }

    @Override
    public void interact(Actor actor) {
        actor.notifyPickup(this);
    }

    @Override
    public String getName() {
        return name;
    }
};