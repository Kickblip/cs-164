public class Testing {
    public static void main (String[] args) {

        String magic = "abracadabra";

        System.out.println(magic.indexOf("b"));
        System.out.println(magic.indexOf("a"));
        System.out.println(magic.indexOf("a", magic.indexOf("c")));
        System.out.println(magic.indexOf(1,6));
        System.out.println(magic.indexOf(magic.indexOf("c"))+1);

        // String shorter = magic.substring(1, 6);
        String shorter = magic.substring(1, magic.indexOf("a", magic.indexOf("c"))+1);
        // String shorter = magic.substring(magic.indexOf("b"), magic.indexOf("a", magic.indexOf("c"))+1);

        System.out.println(shorter);

    }
}
