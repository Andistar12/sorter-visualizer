import java.util.Arrays;
import java.util.Random;

/**
 * Creates and stores the array
 * Deals with EVERYTHING relating to the int array
 */
public class MyArray {

    private int[] array;
    private int num_max;


    public MyArray(int array_length, int max_possible_val_of_num) {
        this.num_max = max_possible_val_of_num;
        this.array = new int[array_length];

        // Used to generate number
        Random r = new Random();

        // Fill array with generated vals
        for (int x = 0; x < array_length; x++) {
            array[x] = r.nextInt(max_possible_val_of_num);
        }
    }

    // TODO add shuffle method

    // TODO methods that deal with the array

    /**
     * Returns the length of the array
     */
    public int get_array_length() {
        return array.length;
    }

    /**
     * Gets the value at the given position
     */
    public int get_value(int index){
        return array[index];
    }

    /**
     * Swaps the values at index1 and index2
     */
    public void swap(int index1, int index2){
        if (index1 != index2) {
            // Swap because they are not the same

            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;

        } // Else they are the same, no action needed
    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }

}
