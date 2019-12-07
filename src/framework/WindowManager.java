package framework;

import javax.swing.*;
import java.awt.*;

/**
 * Display window to display the array
 */
public class WindowManager {
    private JPanel canvas;

    private JTextField txfArraySize;
    private JTextField txfRange;
    private JButton btnRun;
    private JComboBox comboSorts;
    private JSlider slider1;
    private JLabel lblDelay;
    private JRadioButton btnCircles;

    private Thread thread;
    private boolean shouldStop = false;

    // Temp variable for the class to allow access to paint
    private MyArray array;

    public WindowManager(int width, int height, Sorter[] sorts){
        // Create the window and canvas
        JFrame window = new JFrame("Sorting Visualizations");
        canvas = new JPanel() { // This is a custom JPanel
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g); // Wipes the screen


                if (array != null) {
                    if (btnCircles.isSelected()) {
                        // Circle

                        float angle = (float) (2.0f * Math.PI / array.get_array_length());
                        for (int i = 0; i < array.get_array_length(); i++) {
                            // Change color via hue
                            Color c = Color.getHSBColor(1.0f * array.get_value(i) / array.get_max_int(), 1.0f, 0.7f);
                            g.setColor(c);

                            // tRiGoNoMeTrY iS uSeFuL
                            int[] x = {0, 0, 0};
                            int[] y = {0, 0, 0};
                            x[0] = canvas.getWidth() / 2;
                            y[0] = canvas.getHeight() / 2;
                            x[1] = (int) (x[0] * Math.cos((i) * angle + Math.PI / 2.0f) + x[0]);
                            y[1] = (int) (y[0] * -Math.sin((i) * angle + Math.PI / 2.0f) + y[0]);
                            x[2] = (int) (x[0] * Math.cos((i + 1) * angle + Math.PI / 2.0f) + x[0]);
                            y[2] = (int) (y[0] * -Math.sin((i + 1) * angle + Math.PI / 2.0f) + y[0]);

                            g.fillPolygon(x, y, 3);
                        }
                    } else {
                        // Bars

                        // Calculate box width and heights
                        float column_width = 1.0f * canvas.getWidth() / array.get_array_length();
                        float row_height = 1.0f * (canvas.getHeight()) / array.get_max_int();

                        for (int i = 0; i < array.get_array_length(); i++) {
                            // Change color
                            Color c = Color.getHSBColor(1.0f * array.get_value(i) / array.get_max_int(), 1.0f, 0.7f);
                            g.setColor(c);

                            // Calculate x and y positions
                            float x = i * column_width;
                            x = Math.max(x, 1.0f);
                            float y = canvas.getHeight() - (array.get_value(i) * row_height);

                            // Draw box
                            g.fillRect((int) x, (int) y, (int) column_width, canvas.getHeight() - (int) y);
                        }
                    }
                }
            }
        };

        // Create the UI
        // Intellij should let you minimize this code block
        final JPanel contentPane = new JPanel();
        {
            contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            contentPane.setLayout(new GridBagLayout());
            final JPanel panel1 = new JPanel();
            panel1.setLayout(new GridBagLayout());
            GridBagConstraints gbc;
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = GridBagConstraints.BOTH;
            contentPane.add(panel1, gbc);
            final JPanel panel2 = new JPanel();
            panel2.setLayout(new GridBagLayout());
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridheight = 2;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = GridBagConstraints.BOTH;
            panel1.add(panel2, gbc);
            final JPanel panel3 = new JPanel();
            panel3.setLayout(new GridBagLayout());
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = GridBagConstraints.BOTH;
            panel2.add(panel3, gbc);
            JLabel lblArraySize = new JLabel();
            lblArraySize.setText("Array Size");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.WEST;
            panel3.add(lblArraySize, gbc);
            txfArraySize = new JTextField();
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.weightx = 100.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panel3.add(txfArraySize, gbc);
            JLabel lblRange = new JLabel();
            lblRange.setText("Number Range 0-");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.WEST;
            panel2.add(lblRange, gbc);
            txfRange = new JTextField();
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.weightx = 100.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panel2.add(txfRange, gbc);
            comboSorts = new JComboBox<>(sorts);
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panel1.add(comboSorts, gbc);
            final JPanel panel4 = new JPanel();
            panel4.setLayout(new GridBagLayout());
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.BOTH;
            panel1.add(panel4, gbc);
            lblDelay = new JLabel();
            lblDelay.setText("Delay: 1000ms");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 10.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.WEST;
            panel4.add(lblDelay, gbc);
            btnRun = new JButton();
            btnRun.setText("Run");
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panel4.add(btnRun, gbc);
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 100.0;
            gbc.weighty = 100.0;
            gbc.fill = GridBagConstraints.BOTH;
            contentPane.add(canvas, gbc);
            slider1 = new JSlider();
            slider1.setMajorTickSpacing(10);
            slider1.setMaximum(1000);
            slider1.setValue(1000);
            slider1.addChangeListener(changeEvent -> repaint(null));
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            contentPane.add(slider1, gbc);
            final JPanel panel5 = new JPanel();
            panel5.setLayout(new GridBagLayout());
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.WEST;
            contentPane.add(panel5, gbc);
            JLabel drawStyle = new JLabel("Render style: ");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.WEST;
            panel5.add(drawStyle, gbc);
            ButtonGroup bg = new ButtonGroup();
            JRadioButton btnBars = new JRadioButton("Bars", true);
            btnCircles = new JRadioButton("Circles", false);
            bg.add(btnBars);
            bg.add(btnCircles);
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.WEST;
            panel5.add(btnBars, gbc);
            gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.WEST;
            panel5.add(btnCircles, gbc);
        }

        // Set up the window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(new Dimension(width, height));
        window.setResizable(false);
        window.setContentPane(contentPane);
        window.setVisible(true);
    }

    /**
     * Repaints the canvas, then waits a preset amount of time
     * If null, only the delay label will change
     */
    public void repaint(MyArray array) {
        if (shouldStop) return;
        int delay = get_delay();
        int nano = delay % 1000000;
        int millis = delay / 1000000;
        lblDelay.setText("Delay: " + millis + "ms " + nano + "ns");


        if (array != null) {
            this.array = array;
            canvas.repaint();
            try {
                Thread.sleep(millis, nano);
            } catch (InterruptedException e) {
                // Ignore
            }
        }
    }

    /**
     * Gets the user inputted value for size of array
     */
    public int get_array_size(int val) {
        try {
            return Integer.parseInt(txfArraySize.getText());
        } catch (NumberFormatException nfe) {
            // Ignore
        }
        txfArraySize.setText(val + "");
        return val;
    }

    /**
     * Gets the user inputted value for max possible int in array
     */
    public int get_max_int(int val) {
        try {
            return Integer.parseInt(txfRange.getText());
        } catch (NumberFormatException nfe) {
            // Ignore
        }
        txfRange.setText(val + "");
        return val;
    }

    public void set_on_run(Runnable run) {
        btnRun.addActionListener(e -> {
            if (thread != null) {
                // Wait for other thread to stop
                shouldStop = true;
                //thread.interrupt();
                while(thread.isAlive()) {
                    // Stall
                }

                thread = null;
            }
            shouldStop = false;
            thread = new Thread(run);
            thread.start();
        });
    }

    public int get_selected_sorter() {
        return comboSorts.getSelectedIndex();
    }

    /**
     * Gets the user inputted value for delay time in nano
     */
    private int get_delay() {
        double exp = slider1.getValue() / 100.0 - 9; // Range -9, 1
        exp = Math.min(0, exp); // Range -9, 0
        return (int) (Math.pow(10.0, exp) * 100000000.0);
    }
}