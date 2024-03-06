public class Testing {
    public static void main (String[] args) {

        
    int value = 0;
    StringBuilder build = new StringBuilder();
    do {
    build.append(value++);
    } while (++value < 10);
    
    System.out.println(build.toString()); // print 1
    
    String hello = "What's----the---motto---with-you?";
    while(hello.contains("--")) {
    hello = hello.replaceFirst("---", "-");
    hello = hello.replaceFirst("--", "-");
    System.out.println(hello);
    }
    
    System.out.println(hello); // print 2
 

    }
}
