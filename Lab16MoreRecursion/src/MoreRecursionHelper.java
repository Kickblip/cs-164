public class MoreRecursionHelper {
    /** Student: Self-Explanation
     * My base case will be when the decimal is 0
     * I'll build the binary representation from left to right
     * On each recursive call I divide the decimal by 2 to move to the right
     * I use modulo to determine if the current digit should be 0 (even) or 1 (odd)
     */
    public int toBinary(int toConvert) {
        int binary = 0;

        if (toConvert == 0) {
            binary = 0;
        } else {
            binary = (toConvert % 2) + (10 * (toBinary(toConvert / 2)));
        }

        return binary;
    }
    /** Student: Self-Explanation
     * My base case is when the last row is reached
     * The rest of the method is just adding up the rows until the last row is reached
     * 
     */
    public int pyramidTotal(int rows) {
        int total = 0;

        if (rows == 1) {
            return 1;
        } else {
            total = rows + pyramidTotal(rows - 1);
        }

        return total;
    }
    /** Student: Self-Explanation
     * First I want to change the index to 0 since the method is called in main with index = -1
     * The hard part is to find combinations using characters from the beginning and end but not middle
     * Since the method is void I'll print out the currStr when the index reaches the end of str
     * Ill have one call that includes the current character and one that doesn't
     * As I move down the string these calls branch out to include all possible combinations
     */
    public void combinations(String str, int index, String currStr) {
        if (index < 0) index = 0;

        if (index == str.length()) {
            System.out.println(currStr);
            return;
        }

        combinations(str, index + 1, currStr);
        combinations(str, index + 1, currStr + str.charAt(index));
    }
}