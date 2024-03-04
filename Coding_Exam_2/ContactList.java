import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


/**
 * Student Code for Coding Exam 2
 * Wyatt Hansen
 * I have not given, received, or used any unauthorized assistance.
 */
public class ContactList {
    private ArrayList<Contact> contacts = new ArrayList<>();


    /**
     * Reads a comma separated value file of the format
     * Name,Email,Phone
     * 
     * And builds a new contact based on that list
     * (1) one contact per line of file
     * (2) stores the contact in ArrayList<Contact> contacts.
     * 
     * You do not have to worry about the line being in the correct format,
     * but you should be careful about empty / blank lines due to
     * some operating systems needing them at the end of files.
     * (hint: !line.isEmpty())
     * 
     * Testing hint: this is the last point of the coding exam. We will
     * test with the provided file, and a few other files to
     * make sure you are not coding specific to that one file.
     * 
     * @param fileName name of file
     */
    public void loadListFromFile(String fileName) {
        try {
           Scanner fileScanner = new Scanner(new File(fileName));
           while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                this.contacts.add(parseLine(line));
           }
            fileScanner.close();

        }catch(Exception ex) {
            System.err.println("Error reading file: " + ex.getMessage());
            System.exit(1);
        }

    }
    
    // this method is untested, and simply here as a hint to help you
    // write the code for loadListFromFile - based on examples
    // from lecture notes
    private Contact parseLine(String line) {
        Scanner sLine = new Scanner(line);
        sLine.useDelimiter(",");

        String name = sLine.next();
        String email = sLine.next();
        String phone = sLine.next();

        sLine.close();

        return new Contact(name, email, phone);
    }

    /** provided methods - used for testing  - to not modify*/
    public ArrayList<Contact> getContacts(){
        return contacts;
    }

    public void printList() {
        for(Contact c : contacts) {
            System.out.println(c.getName() + String.format(" (%s)", c.getEName()));
            System.out.printf("   phone:%s  email:%s\n\n", c.getPhone(), c.getEmail());
        }
    }

    // end provided methods

    public static void main(String[] args) {
        ContactList list = new ContactList();
        list.loadListFromFile("contacts.csv");

        list.printList();
    }
}
