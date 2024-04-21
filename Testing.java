public class Testing {
    public static String collect(Object[] array, int pos) {
        if(pos >= array.length) return "";
        if(array[pos] instanceof String[]) return collect((String[])array[pos], 0) +
                collect(array, ++pos);
        return  array[pos] + collect(array, ++pos);
    }

    public static void main(String[] args) {
        System.out.println(collect(new String[]{"j", "a", "v", "a"}, 0));
        System.out.println(collect(new Object[]{"D", new String[]{"r", ".", " "}, "Strange" }, 0));
    }
      

}
