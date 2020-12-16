import java.util.Scanner;
import java.io.*;

public class Game {

    File storageFile; 
    
    public Game(String storageFile) { 
        this.storageFile = new File(storageFile + ".csv"); // Feeds a string the file name information then puts it in a file type.
    }

    public boolean checkGameData() { // Checks if the data is in the correct format in order to process the information correctly.
                                    // Format checking for characters are handeled in Character.java
        Scanner scan;
        boolean correct = true;
        try {
            scan = new Scanner(this.storageFile);

            int totalElements = 0;
            int count = 0;
            String[] data;
            Character character[] = new Character[4];
            while(scan.hasNextLine()) { // Counts the total elements in the file and counts each element in each line
                data = scan.nextLine().split(","); // Creates an array of the line.

                if(count == 0) {                        // checks if each line has the correct amount of elements in the array
                    if(data.length != 1) {
                        correct = false;
                    }
                } else if(count < 4 && count > 4) {
                    if(data.length != 7) {
                        correct = false;
                    } else {
                        character[count - 1] = new Character(); // Creates a new character in the character class
                        if(character[count - 1].checkCharacter(data) == false) { // Checks the character for correct values and format
                            correct = false;
                        }
                    }
                } else {
                    correct = false;
                }

                totalElements = totalElements + data.length;
                count++;
            }

            if(totalElements != 29) { // If the file doesn't have 29 total tokens then it will fail the program.
                correct = false;
            }

            scan.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        return correct; // Returns whether or not the file is in the correct format.
    }

    public void createGame(String storageFile) {
        Character character = new Character();
        Scanner scanner = new Scanner(System.in);

        character.newCharacters(0, storageFile);

        checkGameData();
        
        scanner.close();
    }

    public void viewGame() {
        Scanner scan;
        try {
            scan = new Scanner(storageFile);
            String name = null;
            int count = 0;
            if(checkGameData() == true) { // checks game data first.
                while(scan.hasNextLine()) {
                    if(count == 0) {
                        name = scan.next();
                        System.out.println("    ==---" + name.replaceAll(",", "") + "---==\n");
                        scan.nextLine();
                    } else if(count <= 3) {
                        String[] character = scan.next().split(",");
                        System.out.println(character[1] + " " + character[0] + ":\n    Strength: " + character[2] + "\n    Toughness: " + character[3] + "\n    Intelligence: " + character[4] + "\n    Magic: " + character[5] + "\n    Influence: " + character[6] + "\n");
                        scan.nextLine();
                    } else if(count == 4) {
                        String[] character = scan.next().split(",");
                        System.out.println(character[1] + " " + character[0] + ":\n    Strength: " + character[2] + "\n    Toughness: " + character[3] + "\n    Intelligence: " + character[4] + "\n    Magic: " + character[5] + "\n    Influence: " + character[6] + "\n");
                    }
                    count++;
                }
                System.out.println("    ==---" + name.replaceAll(",", "") + "---==");
            } else {
                System.out.println("Game data not in correct format.");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}