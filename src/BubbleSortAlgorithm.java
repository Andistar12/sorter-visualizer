public class BubbleSortAlgorithm {

    public void sort(MyArray array) {
        for (int i = 0; i < array.get_array_length(); i++) {
            for (int j = i + 1; j < array.get_array_length(); j++) {
                if (array.get_value(j) < array.get_value(i)) {
                    array.swap(i, j);
                }
            }
        }
    }

}
