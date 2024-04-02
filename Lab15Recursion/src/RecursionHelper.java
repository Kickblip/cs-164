public class RecursionHelper {
    /** Self Explanation - Remember to detail your base and recursive cases.
     * I'll start at the end of the string and move backwards, adding each character to the result.
     * My base case is when the index is less than 0, meaning I've reached the beginning of the string.
     */
    public String reverseString(String str) {
        return reverseString(str, str.length() - 1);
    }

    public String reverseString(String str, int index) {
        if (index < 0) return "";
        return str.charAt(index) + reverseString(str, index - 1);
    }
    /** Self Explanation - Remember to detail your base and recursive cases.
     * I go digit by digit starting with the rightmost digit, adding the cube of each digit to the total.
     * My base case is when number/10 is 0, meaning I've gone through all the digits.
     */
    public int armstrongNumber(int num, int total) {
        if (num == 0) return total;
        total += Math.pow(num % 10, 3);
        return armstrongNumber(num / 10, total);
    }

    /** Self Explanation - Remember to detail your base and recursive cases.
     * I compare the first and last characters of the string, moving inwards until I reach the middle.
     * My base case is when the start index is greater than or equal to the end index, which means they have overlapped.
     * If a false hasn't been returned by this point, the string is a palindrome.
     */
    public boolean palindromeChecker(String str) {
        if (str.length() == 0 || str.length() == 1) return true;
        return palindromeChecker(str, str.length() - 1, 0);
    }

    public boolean palindromeChecker(String str, int end, int start) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return palindromeChecker(str, end - 1, start + 1);
    }
}
