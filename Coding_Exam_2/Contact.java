/** Student Code for Coding Exam 2 
 *  Wyatt Hansen
 *  I have not given, received, or used any unauthorized assistance.
*/
public class Contact {
    private String name;
    private String email;
    private long phone;
    
    // student code

    /**
     * EName is the first half of the email address before the @ sign,  and lowercase!
     * @return  a string that is the contacts ename. 
     */
    public String getEName() {
        String email = getEmail();
        int targetIndex = email.indexOf('@');
        return email.substring(0, targetIndex).toLowerCase();
    }

    /**
     * Returns an US standard formatted phone number, in the format of
     * (xxx) xxx-xxxx
     * 
     * With the AreaCode, Prefix and number being each part in order.
     * 
     * Testing Hint: We be exact on the format of the number when
     * testing this method. Make sure you think about how to convert
     * 33 to 033 or numbers like that when setting your string format. Reminder
     * the %02d - requires the length to be 2, with 0 padding at the front if a single
     * digit number is passed in. 
     * 
     * @return A formatted phone number
     */
    public String getPhone() {
        int areaCode = getAreaCode();
        int prefix = getPrefix();
        int number = getNumber();

        return String.format("(%03d) %03d-%04d", areaCode, prefix, number);
    }

   
    /**
     * Loops through the String removing all non-digits from the string.
     * For example (970) 111-2222, will become 9701112222 or
     * 970.782.2910 becomes 9707822910
     * 
     * Converts the resulting String to a long, and sets the phone
     * number using setPhone(long)
     * 
     * Testing Hint: We will be randomly generating the characters
     * in addition to the 'standard' number format. We will be testing the
     * long phone number using getLongPhone()
     * 
     * @param phoneStr - a string with both digits and other characters possible
     *
     */
    public void setPhone(String phoneStr) {
        String newPhoneStr = "";
       for(int i = 0; i < phoneStr.length(); i++) {
        if (Character.isDigit(phoneStr.charAt(i))) {
            newPhoneStr += phoneStr.charAt(i);
        }
       }
        setPhone(Long.parseLong(newPhoneStr));

    }

    /**
     * Sets the phone number as long as it is 10 digits long.
     * Does not care if the area codes are valid except you do
     * not have worry about 0 phones, meaning your range is
     * between 1111111111L and 9999999999L inclusively.
     * (As a reminder: adding L at the end of a number is a way to make it a long!)
     * 
     * If the number is not within range, Do not set the number. 
     * 
     * For testing, we will generate random long numbers both within the range and
     * outside the range.
     * 
     * @param a long number
     */
    public void setPhone(long phone) {
        if (phone >= 1111111111L && phone <= 9999999999L) {
            this.phone = phone;
        }
    }
    

    // end student code
    // remember, you are free to add additional methods if that helps you!

    // provided methods and constructors, do not modify
    public Contact(String name, String email, long phone) {
        setName(name);
        setEmail(email);
        setPhone(phone);
    }

    public Contact(String name, String email, String phone) {
        setName(name);
        setEmail(email);
        setPhone(phone);
    }

    public long getLongPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public int getPrefix() {
        long tmp = phone / 10000;
        return (int) (tmp % 1000);
    }

    public int getAreaCode() {
        long tmp = phone / 10000000;
        return (int) (tmp % 1000);
    }

    public int getNumber() {
        return (int) (phone % 10000);
    }

    public String toString() {
        return String.format("{name:%s, email:%s, phone:%s}", getName(), getEmail(), getPhone());

    }
    // end provided code

    // you are free to use this main for testing if you develop in your own IDE
    public static void main(String[] args) {
        
    }


}