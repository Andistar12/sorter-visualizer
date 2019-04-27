package sorters;

import framework.MyArray;
import framework.Sorter;
import framework.WindowManager;

public class CountingSorter extends Sorter {

    @Override
    public void sort(MyArray array, WindowManager wm) {
        int max = array.get_value(0);
        for (int i = 0; i < array.get_array_length(); i++)
            max = Math.max(array.get_value(i), max);
        int[] histogram = new int[max + 1];
        for (int i = 0; i < histogram.length; i++) histogram[i] = 0;
        for (int i = 0; i < array.get_array_length(); i++)
            histogram[array.get_value(i)]++;
        for (int i = 1; i < histogram.length; i++)
            histogram[i] += histogram[i - 1];
        int[] result = new int[array.get_array_length()];
        for (int i = 0; i < array.get_array_length(); i++) {
            result[histogram[array.get_value(i)] - 1] = array.get_value(i);
            histogram[array.get_value(i)]--;
        }
        for (int i = 0; i < array.get_array_length(); i++) {
            array.set_value(i, result[i]);
            wm.repaint(array);
        }
    }

    @Override
    public String toString() {
        return "Counting Sort";
    }
}
