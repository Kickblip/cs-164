public class Testing {
    public static void main (String[] args) {
        System.out.println(sub2("frankie@rhps.com"));
        System.out.println(sub3("Kakwit"));
        System.out.println(sub("Brad,Magenta,Columbia"));

    }


    public static String sub(String str) {

        return str.substring(str.indexOf(",") + 1, str.indexOf(",", str.indexOf(",") + 1));

    }



    public static String sub2(String str) {

        return str.substring(str.indexOf("@"));

    }



    public static String sub3(String str) {

        String rtn = "";

        String key = "KitHawk";

        String key2 = "abcdefgh";



        rtn += key2.charAt(key.indexOf(str.charAt(0)));

        rtn += key2.charAt(key.indexOf(str.charAt(1)));

        rtn += key2.charAt(key.indexOf(str.charAt(2)));



        return rtn;

    }


}
