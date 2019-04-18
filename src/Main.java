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
        int array_size = 100; // TODO setup scanner and read in input
        int nums_max = 100; // TODO

        BubbleSorter bubble = new BubbleSorter();
        SelectionSorter select = new SelectionSorter();
        MyArray array = new MyArray(array_size, nums_max);

        WindowManager visualizer = new WindowManager(array);
        //visualizer.repaint();
        select.selection_sort(array, visualizer);
        //bubble.sort(array, visualizer);



        /*
        // Create array
        MyArray array = new MyArray(array_size, nums_max);
        array.print();

        // Create sorter
        SelectionSorter SelSort = new SelectionSorter();

        // Sort and print
        SelSort.selection_sort(array);
        array.print();


        // Everything below is for bubble sort

        System.out.println();

        // Create array
        MyArray array2 = new MyArray(array_size, nums_max);
        array2.print();

        // Create sorter
        BubbleSorter bubbleSortAlgorithm = new BubbleSorter();

        // Sort and print
        bubbleSortAlgorithm.sort(array2);
        array2.print();
        */
    }
}
