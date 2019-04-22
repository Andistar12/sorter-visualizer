public class BubbleSorter {

    /**
     * Sorts via bubble sort the given MyArray
     */
    public void sort(MyArray array, WindowManager wm) {
        for (int i = array.get_array_length() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array.get_value(j) > array.get_value(j + 1)) {
                    array.swap(j + 1, j);
                    wm.repaint();
                }
            }
        }
    }

}
