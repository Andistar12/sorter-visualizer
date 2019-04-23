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

        String[] sorts = {
                "Selection Sort",
                "Bubble Sort",
                "Bogo Sort",
                "Radix Sort",
                //"Quick Sort"
        };



        // Create visualizer
        WindowManager visualizer = new WindowManager(sorts);
        visualizer.repaint(dummy);

        Runnable callback_on_run = new Runnable() {
            @Override
            public void run() {
                // Get user input, create array to sort
                int user_sort_input = visualizer.get_selected_sorter();
                MyArray array = new MyArray(visualizer.get_array_size(), visualizer.get_max_int());

                // Put sorter objects into array
                ArrayList<Object> sorters = new ArrayList<>();
                sorters.add(new SelectionSorter());
                sorters.add(new BubbleSorter());
                sorters.add(new Bogosort());
                sorters.add(new RadixSort());
                //sorters.add(new QuickSort());

                sorters.get(visualizer.get_selected_sorter()).sort(array, visualizer);

                Object sorter = sorters.get(visualizer.get_selected_sorter());
                sorter.sort(array, visualizer);

                SelectionSorter sorter1 = sorters.get(visualizer.get_selected_sorter());
                sorter1.sort(array, visualizer);
            }
        };
        visualizer.set_on_run(callback_on_run);
    }
}
