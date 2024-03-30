public class Testing {
    private static int doSomething(int[] arr) {
        int val = 0;
        for(int i = 0; i < arr.length; i++) {
            val += arr[i];
        }
        return val;
      }
      
      
      
      
      public static void main(String[] args) {
        int[] arr = {-9, 2, -10, 9, -6, 2};
        System.out.println(doSomething(arr));
      }
      

}
