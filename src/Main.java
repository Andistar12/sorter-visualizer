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

        // Get user input
        int array_size = 12; // TODO setup scanner and read in input
        int nums_max = 1000; // TODO

        Bogosort bogo = new Bogosort();
        BubbleSorter bubble = new BubbleSorter();
        SelectionSorter select = new SelectionSorter();

        MyArray array = new MyArray(array_size, nums_max);

        WindowManager visualizer = new WindowManager(array);
        select.selection_sort(array, visualizer);
        //bubble.sort(array, visualizer);
        //bogo.sort(array, visualizer);
    }
}
