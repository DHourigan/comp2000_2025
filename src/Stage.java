import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Small window to render the Grid and allow simple interaction.
 */
public class Stage extends JFrame {
    Grid grid;
    public Stage(Grid grid) {
        super("Grid Stage");
        this.grid = grid;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
    }

    class Canvas extends JPanel {
        public Canvas() {
            setPreferredSize(new Dimension(800, 700));
            setFocusable(true);
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    // basic control: press 1 to make first actor try pickup on its cell
                    if (e.getKeyChar() == '1') {
                        grid.actors[0].tryPickup(grid.cells);
                        repaint();
                    } else if (e.getKeyChar() == 'm') {
                        // move actor 0 one cell to the right (demo movement)
                        Actor a = grid.actors[0];
                        a.setPos(Math.min(grid.cells.length-1, a.getCol()+1), a.getRow());
                        repaint();
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Point topLeft = grid.gridTopLeft();
            // draw cells
            for (Cell[] cell : grid.cells) {
                for (Cell cell1 : cell) {
                    cell1.draw(g, topLeft);
                }
            }
            // draw actors
            for (Actor a : grid.actors) {
                a.draw(g, topLeft);
            }
        }
    }
};