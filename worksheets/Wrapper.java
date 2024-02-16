package worksheets;

public class Wrapper {

    public static String buildLetterString(String str) {
        String newString = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                newString += str.charAt(i);
            }
        }
        
        return newString;
    }

    public static long buildDigitString(String str) {
        String newString = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                newString += str.charAt(i);
            }
        }
        
        return Long.parseLong(newString);
    }

    public static int countChar(String str, char c) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        System.out.println(buildLetterString("Hello World!"));
        System.out.println(buildDigitString("123a4d5"));
        System.out.println(countChar("Hello World!", 'l'));
    }
}