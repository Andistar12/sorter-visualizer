package sorters;

import framework.MyArray;
import framework.Sorter;
import framework.WindowManager;

public class PigeonholeSort extends Sorter {

    @Override
    public String toString() {
        return "Pigeonhole Sorter";
    }

    @Override
    public void sort(MyArray array, WindowManager wm) {

        int min = array.get_value(0), max = min;

        for (int i = 0; i < array.get_array_length(); i++) {
            min = Math.min(min, array.get_value(i));
            max = Math.max(max, array.get_value(i));
        }

        int[] pigeonhole = new int[max - min + 1];
        for (int i = 0; i < pigeonhole.length; i++) pigeonhole[i] = 0;

        for (int i = 0; i < array.get_array_length(); i++) {
            pigeonhole[array.get_value(i) - min]++;
        }

        int count = 0;
        for (int i = 0; i < pigeonhole.length; i++) {
            if (pigeonhole[i] > 0) {
                for (int j = 0; j < pigeonhole[i]; j++) {
                    array.set_value(count, i);
                    count++;
                    wm.repaint(array);
                }
            }
        }
    }
}
