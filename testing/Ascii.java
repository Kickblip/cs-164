package testing;
public class Ascii {
    
    

    public static String formatterA(double val) {


        return String.format("%.2f%%,%2d", val, (int) val);
        
        }
        
         
        
        public static void main(String[] args) {
        
          System.out.println(formatterA(10/3.0));
        
        }
        
        
        
 
}
