/*
 * 
    What is a setter?
    A setter is a method that sets the private variables of a class.

    What is a getter?
    A getter is a method that returns the private variables of a class.

    Why do you think we have/use constructors?
    Constructors initialize the variables of a class.

    What do we call the object variables Household has of type Child, Guardian, and Dog?
    We call them instance variables.

 * 
 */


public class Child {
    private String name;
    private int age;
    private double bedtime;
    private String sport;
    private String favColor;

    public Child(String name, int age, double bedtime, String sport, String favColor){
        setName(name);
        setAge(age);
        setBedtime(bedtime);
        setSport(sport);
        setFavColor(favColor);
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setBedtime(double bedtime){
        this.bedtime = bedtime;
    }
    public double getBedtime() {
        return this.bedtime;
    }
    public void setSport(String sport){
        this.sport = sport;
    }
    public String getSport(){
        return this.sport;
    }
    public void setFavColor(String favColor){
        this.favColor = favColor;
    }
    public String getFavColor(){
        return this.favColor;
    }
    public static void main(String[] args) {
        Child Roman = new Child("Roman", 8, 9.30, "baseball", "yellow");
        System.out.println(String.format("Meet %s. They are %d years old.\nThey go to bed at %d:%d every night.\nThey play %s, and their favorite color is %s.", Roman.getName(), Roman.getAge(), (int)Roman.getBedtime(), (int)((Roman.getBedtime() - (int) Roman.getBedtime()) * 100), Roman.getSport(), Roman.getFavColor()));
    }
}
