public class CSVGameData extends GameData{
    CSVGameData(String gamedata, String saveData) {
        loadGameData(gamedata);
        loadSaveData(saveData);
    }
 
    void loadGameData(String gamedata) {
        Scanner file = readFile(gamedata);
        if(file == null) return;
        while(file.hasNextLine()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter(",");
            String type = line.next().trim();
            if(type.equals("MOB")) {
                monsters.add(new MOB(
                        line.next().trim(),
                        line.nextInt(),
                        line.nextInt(),
                        line.nextInt(),
                        DiceType.valueOf(line.next())));
            } else if(type.equals("FORTUNE")) {
                fortunes.add(new Fortune(
                        line.next().trim(),
                        line.nextInt(),
                        line.nextInt(),
                        line.nextInt(),
                        DiceType.valueOf(line.next())));
            }
        }
    }

    void loadSaveData(String saveData) {
        int counter = 0;
        Scanner file = readFile(saveData);
        if(file == null) return;
        while(file.hasNextLine()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter(","); 
            Knight kt = new Knight(
                    ++counter,
                    line.next().trim(),
                    line.nextInt(),
                    line.nextInt(),
                    line.nextInt(),
                    DiceType.valueOf(line.next()),
                    line.nextInt());
            knights.add(kt);
        }
    }

    private Scanner readFile(String fileName) {
        try {
            return new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return null;
        }
    }

    public void save(String filename) {
        try {
            PrintWriter writer = new PrintWriter(new File(filename));
            for(Knight kt : knights) {
                writer.println(kt.toCSV());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

}
