import java.lang.reflect.Array;
import java.util.ArrayList;

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

    public static void main(String args[]) {

        // Create array
        MyArray dummy = new MyArray(2000, 2000);

        // Put sorter objects into array
        Sorter[] sorters = new Sorter[6];
        sorters[0] = new SelectionSorter();
        sorters[1] = new BubbleSorter();
        sorters[2] = new Bogosort();
        sorters[3] = new RadixSort();
        sorters[4] = new QuickSort();
        sorters[5] = new RadixSorter2();

        // Create visualizer
        WindowManager visualizer = new WindowManager(sorters);
        visualizer.repaint(dummy);

        // Setup callback
        // This is run when the user hits Run
        Runnable callback_on_run = new Runnable() {
            @Override
            public void run() {
                // Get user input, create array to sort
                int user_sort_input = visualizer.get_selected_sorter();
                MyArray array = new MyArray(visualizer.get_array_size(), visualizer.get_max_int());

                // End goal
                sorters[user_sort_input].sort(array, visualizer);
            }
        };
        visualizer.set_on_run(callback_on_run);
    }
}
