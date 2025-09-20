import java.awt.Point;

/**
 * Simple grid factory that constructs a grid of Cells (various terrains),
 * places some Items and Actors.
 */
public class Grid {
    public final Cell[][] cells;
    public final Actor[] actors;

    public Grid(int cols, int rows) {
        cells = new Cell[cols][rows];
        // Fill with varied terrain
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                char label = colToLabel(c);
                if ((c+r) % 7 == 0) cells[c][r] = new WaterCell(label,r, c*Cell.SIZE, r*Cell.SIZE);
                else if ((c+r) % 5 == 0) cells[c][r] = new SandCell(label,r, c*Cell.SIZE, r*Cell.SIZE);
                else cells[c][r] = new GrassCell(label,r, c*Cell.SIZE, r*Cell.SIZE);
            }
        }

        // place some items
        cells[2][3].addItem(new Bone("BoneA"));
        cells[4][1].addItem(new Fish("FishA"));
        cells[0][0].addItem(new Bone("BoneNearStart"));

        // create some actors
        actors = new Actor[] {
            new Dog("Rex", 2, 3),
            new Cat("Whiskers", 4, 1),
            new Bird("Tweety", 1, 2)
        };
    }

    private char colToLabel(int c) {
        return (char)('A' + (c % 26));
    }

    public Point gridTopLeft() { return new Point(20,20); }
};