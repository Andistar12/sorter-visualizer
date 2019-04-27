package sorters;

import framework.MyArray;
import framework.Sorter;
import framework.WindowManager;

public class DoubleSelectionSort extends Sorter {
    @Override
    public void sort(MyArray array, WindowManager wm) {

        int low_index = 0, high_index = array.get_array_length() - 1;
        int low, high;

        while (low_index < high_index) {
            low = low_index;
            high = low_index;

            for (int i = low_index + 1; i <= high_index; i++) {
                if (array.get_value(i) > array.get_value(high)) high = i;
                if (array.get_value(i) < array.get_value(low)) low = i;
            }

            array.swap(low_index, low);
            array.swap(high_index, high);
            wm.repaint(array);
            low_index++; high_index--;
        }
    }

    @Override
    public String toString() {
        return "Double Selection Sort";
    }
}
