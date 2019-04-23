/**
 * Sort MyArray objects using selection sort
 */
public class SelectionSorter {

    public void selection_sort(MyArray array, WindowManager wm) {
        /**
         * Declare biggest_num int
         * Loop that scans the entire array
         *      Loop that scans for the biggest number
         *      Swap with current for loop position
         */

        int length = array.get_array_length();
        int biggest_num_index = 0;

        for (int final_place = length - 1; final_place >= 0; final_place--) {

            biggest_num_index = 0;

            for (int array_scanner = 0; array_scanner <= final_place; array_scanner++) {

                if (array.get_value(biggest_num_index) < array.get_value(array_scanner)){
                    biggest_num_index = array_scanner;
                    //System.out.print(biggest_num_index + " ");
                }

            }

            //array.print();
            array.swap(biggest_num_index, final_place);
            wm.repaint(array);
        }

    }


}
