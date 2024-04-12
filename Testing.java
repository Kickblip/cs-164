public class Testing {

    public void initializeListFromFile(String filename) {

//         Each line in the file to read from represents a single object with the following possible formats: For a Student object: firstName lastName id

// For a Person object: firstName lastName
// USE A DELIMITER TO SEPARATE THE VALUES IN THE FILE
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
                if (tokens.length == 3) {
                    Student student = new Student(tokens[0], tokens[1], tokens[2]);
                    list.add(student);
                } else if (tokens.length == 2) {
                    Person person = new Person(tokens[0], tokens[1]);
                    list.add(person);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

public static void main(String[] args) {
    
}
      

}
