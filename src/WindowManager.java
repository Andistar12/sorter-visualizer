import javax.swing.*;
import java.awt.*;

/**
 * Display window to display the array
 */
public class WindowManager {

    public static final int
            WINDOW_HEIGHT = 500, WINDOW_WIDTH = 500;

    private JFrame window;
    private JPanel canvas;

    public WindowManager(MyArray array) {
        window = new JFrame("Sorter");
        canvas = new JPanel() { // This is a custom JPanel
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g); // Wipes the screen
                g.setColor(Color.BLACK);

                int column_width = WINDOW_WIDTH / array.get_array_length();
                int scalar = WINDOW_HEIGHT / array.get_max_int();

                int index_finder = 0;
                for (int column_loop = 0; column_loop < array.get_array_length() * column_width; column_loop += column_width) {
                    int x = column_loop;
                    int y = WINDOW_HEIGHT - (array.get_value(index_finder) * scalar);
                    int column_height = WINDOW_HEIGHT - y;
                    g.fillRect(x, y, column_width, column_height);
                    index_finder++;
                }
            }
        };

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        window.setResizable(false);
        window.setContentPane(canvas);
        window.setVisible(true);
    }

    public void repaint() {
        canvas.repaint();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}