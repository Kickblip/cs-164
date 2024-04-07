public class Testing {
  public static String stringManipulator(String str) {
    if (str.isEmpty()) return str;
    return stringManipulator(str.substring(1)) + str.charAt(0);
}
public static void main(String[] args) {
  System.out.println(stringManipulator("356"));
}
      

}
