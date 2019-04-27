package sorters;

import framework.MyArray;
import framework.Sorter;
import framework.WindowManager;

public class BubbleSorter extends Sorter {

    /**
     * Sorts via bubble sort the given framework.MyArray
     */
    public void sort(MyArray array, WindowManager wm) {
        for (int i = array.get_array_length() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array.get_value(j) > array.get_value(j + 1)) {
                    array.swap(j + 1, j);

                    // Note: this will lag
                    //wm.repaint(array);
                }
            }
            wm.repaint(array);
        }
    }

    public String toString() {
        return "Bubble Sort";
    }

}
