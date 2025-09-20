import java.awt.Color;

public class SandCell extends Cell {
    public SandCell(char colLabel, int row, int x, int y) {
        super(colLabel, row, x, y);
    }

    @Override
    protected Color backgroundColor() {
        return new Color(230, 210, 150);
    }
};