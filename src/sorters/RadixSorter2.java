package sorters;

import framework.MyArray;
import framework.Sorter;
import framework.WindowManager;

public class RadixSorter2 extends Sorter {

    @Override
    public String toString() {
        return "Radix Sort (Base 2 LSD)";
    }

    @Override
    public void sort(MyArray array, WindowManager wm) {

        int[][] buckets = new int[2][array.get_array_length()];
        int[] bucket_count = {0,0};
        int index;
        int max_bits = 0;

        for (int i = 0; i < array.get_array_length(); i++) {
            max_bits = Math.max(get_bit_count(array.get_value(i)), max_bits);
        }

        for (int i = 0; i < max_bits; i++) {
            for (int j = 0; j < bucket_count.length; j++) bucket_count[j] = 0;
            for (int j = 0; j < array.get_array_length(); j++) {
                index = (array.get_value(j) >> i) & 0b1;
                buckets[index][bucket_count[index]] = array.get_value(j);
                bucket_count[index]++;
            }

            index = 0;
            for (int j = 0; j < buckets.length; j++) {
                for (int k = 0; k < bucket_count[j]; k++) {
                    array.set_value(index, buckets[j][k]);
                    index++;
                    wm.repaint(array);
                }
            }
        }
    }

    private static int get_bit_count(int num) {
        int bits = 0;
        while (num > 0) {
            bits++;
            num = num >> 1;
        }
        return bits;
    }
}