import java.awt.Color;

public class WaterCell extends Cell {
    public WaterCell(char colLabel, int row, int x, int y) {
        super(colLabel, row, x, y);
    }

    @Override
    protected Color backgroundColor() {
        return new Color(140, 190, 230);
    }
};