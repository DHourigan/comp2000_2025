import java.awt.Color;

public class GrassCell extends Cell {
    public GrassCell(char colLabel, int row, int x, int y) {
        super(colLabel, row, x, y);
    }

    @Override
    protected Color backgroundColor() {
        return new Color(150, 220, 120);
    }
};