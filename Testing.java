public class Testing {


/**Problem 3
 * @author Liam Barrett and Prajjol Neupane
 * @param array1
 * @return array1 with the max value swaped with the last index of the array
 * Step-by-step algorithm
 * Assign array1 to a temporary integer variable
 * Create integer variable to hold the index
 * Use a for each loop to iterate through each element i in the array1
 * Store the temporary integer with the max value in each element in array1
 * Swap the max value found with the last index of array1 which is length() - 1
 *
 */

   public static int[] SwapMaxWithLast(int[] array1) {
    int[] temparr = array1;
    int max = 0;
    int idx = 0;
    for (int i : array1) {
        if (i > max) {
            max = i;
            for (int j = 0; j < array1.length; j++) {
                if (array1[j] == max) {
                    idx = j;
                }
            }
        }
    }
    temparr[idx] = array1[array1.length - 1];
    temparr[array1.length - 1] = max;

    return temparr;
   }

public static void main(String[] args) {
    int[] test = SwapMaxWithLast(new int[] {4, 3, 5, 2, 1});
    for (int i : test) {
        System.out.print(i + " ");
    }
}
      

}
