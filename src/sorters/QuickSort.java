package sorters;

import framework.MyArray;
import framework.Sorter;
import framework.WindowManager;

public class QuickSort extends Sorter {

    public void sort(MyArray array, WindowManager wm) {
        quicksort(array, 0, array.get_array_length() - 1, wm);
        wm.repaint(array);
    }

    private void quicksort(MyArray array, int low, int high, WindowManager wm) {
        if (low < high) {
            int pivot = partition(array, low, high, wm);
            quicksort(array, low, pivot - 1, wm);
            quicksort(array, pivot + 1, high, wm);
        }
    }

    private int partition(MyArray array, int low, int high, WindowManager wm) {
        int i = low; // Used as a pointer to the next available space on the low side
        for (int j = low; j < high; j++) {
            if (array.get_value(j) < array.get_value(high)) {
                // Encountered value will be moved to reserve spot
                array.swap(i, j);
                wm.repaint(array);
                i++; // Increment spot
            }
        }
        // i will naturally be at the pivot spot
        array.swap(i, high);
        wm.repaint(array);
        return i;
    }

    public String toString() {
        return "Quicksort (in place)";
    }
}
