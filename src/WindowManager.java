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

                // Calculate box width and heights
                float column_width = 1.0f * WINDOW_WIDTH / array.get_array_length();
                float row_height = 1.0f * (WINDOW_HEIGHT) / array.get_max_int();

                for (int i = 0; i < array.get_array_length(); i++) {

                    // Change color
                    Color c = Color.getHSBColor(1.0f * array.get_value(i) / array.get_max_int(), 1.0f, 0.7f);
                    g.setColor(c);

                    // Calculate x and y positions
                    float x = i * column_width;
                    float y = WINDOW_HEIGHT - (array.get_value(i) * row_height);

                    g.fillRect((int) x, (int) y, (int) column_width, WINDOW_HEIGHT - (int) y);
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