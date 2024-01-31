package testing;
public class Ascii {
    
    

  public static boolean signCheck(int val) {
    return 10 == val;
 }
 
 
 public static void main(String[] args) {
    System.out.printf("%b, %b, %b", signCheck(10), signCheck(0), signCheck(-10));
 }

        
        
        
 
}
