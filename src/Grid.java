import java.awt.Graphics;

public class Grid {
    private final int rows;
    private final int cols;
    private final int cellSize;
    private final int offsetX;
    private final int offsetY;
    private final Cell[][] cells;

    public Grid(int rows, int cols, int cellSize, int offsetX, int offsetY) {
        this.rows = rows;
        this.cols = cols;
        this.cellSize = cellSize;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.cells = new Cell[rows][cols];

        // Nested loop: generate cells row by row
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int x = offsetX + c * cellSize;
                int y = offsetY + r * cellSize;
                cells[r][c] = new Cell(r, c, x, y, cellSize);
            }
        }
    }

    public void paint(Graphics g) {
        // Draw outer border (optional)
        g.drawRect(offsetX, offsetY, cols * cellSize, rows * cellSize);

        // Draw each cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                cells[r][c].paint(g);
            }
        }
    }

}