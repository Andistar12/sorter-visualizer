package sorters;

import framework.MyArray;
import framework.Sorter;
import framework.WindowManager;

public class InsertionSorter extends Sorter {
    @Override
    public String toString() {
        return "Insertion Sort";
    }

    @Override
    public void sort(MyArray array, WindowManager wm) {
        int temp, index;

        for (int i = 1; i < array.get_array_length(); i++) {
            index = i;
            for (int j = 0; j < i; j++) {
                if (array.get_value(j) > array.get_value(index)) {
                    index = j;
                    break;
                }
            }

            if (index != i) {
                temp = array.get_value(i);
                for (int k = i; k > index; k--) {
                    array.set_value(k, array.get_value(k - 1));

                    // Note: this will lag
                    //wm.repaint(array);
                }
                array.set_value(index, temp);
                wm.repaint(array);
            }
        }
    }
}
