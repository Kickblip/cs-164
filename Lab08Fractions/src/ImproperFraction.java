public class ImproperFraction{
    public int numerator;
    public int denominator;

    /**
     * This constructor should take two integers and make an improperFraction object
     * Fractions cannot have a denominator of 0! If the denominator is 0, set the numerator to 0 and the denominator to 1.
     * 
     * @param numerator numerator for the fraction
     * @param denominator denominator for the fraction
     */
    public ImproperFraction(int numerator, int denominator){
        if (denominator == 0){
            this.numerator = 0;
            this.denominator = 1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
        
    }

    /**
     * This constructor should take a string such as "11/2" and make an ImproperFraction object.
     * Integer.parseInt(), .substring(), and .indexOf() will all be useful.
     * Fractions cannot have a denominator of 0! If the denominator is 0, set the numerator to 0 and the denominator to 1.
     * 
     * @param fraction a string holding the numbers for a fraction in the form of "numerator/denominator"
     */
    public ImproperFraction(String fraction){
        int numerator = Integer.parseInt(fraction.substring(0, fraction.indexOf("/")));
        int denominator = Integer.parseInt(fraction.substring(fraction.indexOf("/") + 1));

        if (denominator == 0){
            this.numerator = 0;
            this.denominator = 1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
        
    }

    /**
     * This method will take data from the ImproperFraction object to produce a ProperFraction
     * @return a new ProperFraction object
     */
    public ProperFraction makeProper(){
        int wholeNum = this.numerator / this.denominator;
        int newNumerator = this.numerator % this.denominator;
        int newDenominator = this.denominator;

        return new ProperFraction(wholeNum, newNumerator, newDenominator);
        
    }

    /**
     * This method will simplify a fraction. For example, 2/6 will be turned into 1/3 after running this method.
     * A while loop and the % operator will both be useful here. (Don't forget to set this.numerator and this.denominator after finding the simplified fraction!)
     * To simplify a fraction, both the numerator and denominator should be divided by the greatest common factor. Using a while loop, you can check all of the
     * numbers. For an example of 4/6, you can start by checking 6, then 5, 4, 3, then 2. Since 4/2 and 6/2 are whole numbers, you can divide both the numerator and denominator to
     * simplify the fraction. Once you find this greatest common factor, you can use "return" to end the method.
     */
    public void simplify(){
        for (int i = this.denominator; i > 1; i--){
            if ((this.numerator % i == 0) && (this.denominator % i == 0)){
                this.numerator = this.numerator / i;
                this.denominator = this.denominator / i;
                return;
            }
        }
    }

    public String toString(){
        return numerator + "/" + denominator;
    }
}
