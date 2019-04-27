package sorters;

import framework.MyArray;
import framework.Sorter;
import framework.WindowManager;

public class RadixSort extends Sorter {

    /**
     *
     */


    public void sort(MyArray array, WindowManager wm) {
        int numsLength = array.get_array_length();
        int biggestNum = 0;
        for (int x = 0; x < numsLength; x++) {
            if (array.get_value(x) > biggestNum) {
                biggestNum = array.get_value(x);
            }
        }
        int modulo_limit = String.valueOf(biggestNum).length();
        for (int modulo_loop = 10; modulo_loop <= Math.pow(10, modulo_limit); modulo_loop *= 10) {
            int[][] bucket = new int[10][array.get_array_length()];
            int[] position_digit = new int[10];
            for (int array_scanner = 0; array_scanner < array.get_array_length(); array_scanner++) {
                int digit = array.get_value(array_scanner) % modulo_loop / (modulo_loop / 10);
                bucket[digit][position_digit[digit]] = array.get_value(array_scanner);
                position_digit[digit]++;
            }
            int index = 0;
            for(int x = 0; x < bucket.length; x++){
                for(int y = 0; y < position_digit[x]; y++){
                    array.set_value(index, bucket[x][y]);
                    index++;
                    wm.repaint(array);
                }
            }
        }
    }

    public String toString() {
        return "Radix Sort (Base 10 LSD)";
    }
}
