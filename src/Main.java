import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
        Main window = new Main();
        window.run();
    }

    class Canvas extends JPanel {
        private final Grid grid;

        public Canvas() {
            setPreferredSize(new Dimension(720, 720));
            // 20x20 cells, 35px each, offset 10px from top/left
            this.grid = new Grid(20, 20, 35, 10, 10);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(java.awt.Color.BLACK);
            grid.paint(g);
        }
    }

    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
    }

    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(16); // ~60 FPS
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}



