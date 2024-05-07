public class Testing {
    
    
	public static void main(String[] args) {
		munge("A"); 
	}
	
	public static String munge(String s) {
		if(s.length() >= 10) return s;
		else {
			if(s.length() > 1) {System.out.println(s);}
			char c = s.charAt(s.length()-1);
			c++;
			return munge(c + s + c);
		}
	}

      

}
