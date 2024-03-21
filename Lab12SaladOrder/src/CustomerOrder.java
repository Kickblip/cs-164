import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerOrder {
    private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    private ArrayList<Salad> salads = new ArrayList<Salad>();

    /**
     * getPizzas returns the ArrayList of pizzas
     * @return pizzas
     */
    public ArrayList<Pizza> getPizzas(){
        return this.pizzas;
    }

    /**
     * getSalads returns the ArrayList of salads
     * @return salads
     */
    public ArrayList<Salad> getSalads(){
        return this.salads;
    }



    /**
     * readOrder takes in the name of a csv file and tries to create objects based on the first item in
     * each line. If the first word is "pizza", then readOrder creates a Pizza object and saves it in
     * the pizzas ArrayList. If the first word is "salad", then a Salad object is made and stored in 
     * an ArrayList called "salads". You will have to make this new arrayList.
     * In the csv file, a pizza will look like "pizza,pepperoni,tomatoes,onions"
     * A salad will look like "salad,medium,ranch"
     * @param filename the name of a file
     */
    public void readOrder(String filename){
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().toLowerCase();
                int commaIndex = line.indexOf(",");
                if (line.substring(0, commaIndex).equals("pizza")) {
                    this.pizzas.add(new Pizza(line));
                } else if (line.substring(0, commaIndex).equals("salad")) {
                    this.salads.add(new Salad(line));
                }
            }

            fileScanner.close();

        } catch (FileNotFoundException error) {
            System.out.println("File not found");
        }
    }

    /**
     * buildReceipt uses the getReceipt() method from Pizza and Salad to make a String containing all the
     * "receipt blocks" of all the items in the order. All salads must be listed after the pizzas. These
     * two for loops should look very similar.
     * @return a string containing all the receipt blocks from every item in the order.
     */
    public String buildReceipt(){
        String receipt = "--------------------\n";
        double total = 0;
        for(int i = 0; i < pizzas.size(); i++){
            String temprec = pizzas.get(i).getReceipt();
            double tempprice = pizzas.get(i).calculatePrice();
            total += tempprice;
            receipt += temprec;
            receipt += "--------------------\n";
        }
        for(int i = 0; i < salads.size(); i++){
            String temprec = salads.get(i).getReceipt();
            double tempprice = salads.get(i).calculatePrice();
            total += tempprice;
            receipt += temprec;
            receipt += "--------------------\n";
        }
        receipt += String.format("TOTAL:%14.2f\n--------------------\n",total);
        return receipt;
    }

    /**
     * printReceipt uses a PrintWriter to write the receipt to a specific file. Remeber to use
     * try/catch blocks and to close your PrintWriter, otherwise nothing will save! The buildReceipt
     * method can be useful to print the receipt.
     * @param fileName the name of the file to print to.
     */
    public void printReceipt(String fileName){
        try {
            PrintWriter writer = new PrintWriter(fileName);
            String receipt = buildReceipt();
            writer.print(receipt);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
