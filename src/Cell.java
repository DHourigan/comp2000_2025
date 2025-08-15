import java.awt.Graphics;

public class Cell {
    private final int row;
    private final int col;
    private final int x;     // top-left x
    private final int y;     // top-left y
    private final int size;  // width = height

    public Cell(int row, int col, int x, int y, int size) {
        this.row = row;
        this.col = col;
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void paint(Graphics g) {
        g.drawRect(x, y, size, size);
    }

   
}