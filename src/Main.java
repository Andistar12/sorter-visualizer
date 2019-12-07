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

    private static final int
            DEFAULT_MAX_INT = 500, DEFAULT_VALS = 500;

    private static final int
            WINDOW_HEIGHT = 750, WINDOW_WIDTH = 750;

    public static void main(String[] args) {

        // Create array
        MyArray dummy = new MyArray(DEFAULT_VALS, DEFAULT_MAX_INT);

        // Put sorter objects into array
        Sorter[] sorters = {
            new SelectionSorter(),
            new BubbleSorter(),
            new RadixSort(),
            new QuickSort(),
            new RadixSorter2(),
            new CountingSorter(),
            new DoubleSelectionSort(),
            new InsertionSorter(),
            new PigeonholeSort(),
        };

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
