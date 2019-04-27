package sorters;

import java.util.Random;
import framework.MyArray;
import framework.Sorter;
import framework.WindowManager;

public class Bogosort extends Sorter {

    /**
     * Sorts via bubble sort the given framework.MyArray
     */
    public void sort(MyArray array, WindowManager wm) {
        while (!is_sorted(array)) {
            shuffle(array);
            wm.repaint(array);
        }
    }

    private static boolean is_sorted(MyArray array) {
        for (int i = 1; i < array.get_array_length(); i++) {
            if (array.get_value(i) < array.get_value(i - 1)) return false;
        }
        return true;
    }

    private static void shuffle(MyArray array) {
        Random random = new Random();
        // Loop over array.
        for (int i = 0; i < array.get_array_length(); i++) {
            // Get a random index of the array past the current index.
            // ... The argument is an exclusive bound.
            //     It will not go past the array's end.
            int randomValue = i + random.nextInt(array.get_array_length() - i);

            array.swap(randomValue, i);
        }
    }

    public String toString() {
        return "Bogo Sort";
    }

}
