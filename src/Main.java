import framework.*;
import sorters.*;

/**
 *  Entry point for program
 *  Reads in user input and runs the visualizer with a generated array
 *
 *  What happens in this class:
 *      Creates an array and fills with numbers
 *      Sort numbers
 *      Run visualizer
 */
public class Main {

    public static final int
            DEFAULT_MAX_INT = 2000, DEFAULT_VALS = 2000;

    public static final int
            WINDOW_HEIGHT = 1500, WINDOW_WIDTH = 1500;

    public static void main(String[] args) {

        // Create array
        MyArray dummy = new MyArray(DEFAULT_VALS, DEFAULT_MAX_INT);

        // Put sorter objects into arra
        Sorter[] sorters = new Sorter[10];
        sorters[0] = new SelectionSorter();
        sorters[1] = new BubbleSorter();
        sorters[2] = new Bogosort();
        sorters[3] = new RadixSort();
        sorters[4] = new QuickSort();
        sorters[5] = new RadixSorter2();
        sorters[6] = new CountingSorter();
        sorters[7] = new DoubleSelectionSort();
        sorters[8] = new InsertionSorter();
        sorters[9] = new PigeonholeSort();

        // Create visualizer
        WindowManager visualizer = new WindowManager(WINDOW_WIDTH, WINDOW_HEIGHT, sorters);
        visualizer.repaint(dummy);

        // Setup callback
        // This is run when the user hits Run
        Runnable callback_on_run = () -> {
            // Get user input, create array to sort
            int user_sort_input = visualizer.get_selected_sorter();
            MyArray array = new MyArray(visualizer.get_array_size(DEFAULT_VALS),
                    visualizer.get_max_int(DEFAULT_MAX_INT));

            // End goal
            sorters[user_sort_input].sort(array, visualizer);

            System.out.print(sorters[user_sort_input].toString());
            System.out.println(" finished sorting");
        };
        visualizer.set_on_run(callback_on_run);
    }
}
