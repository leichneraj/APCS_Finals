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
            while(scan.hasNextLine()) { // Counts the total elements in the file and counts each element in each line
                data = scan.nextLine().split(","); // Creates an array of the line.

                if(count == 0) {                        // checks if each line has the correct amount of elements in the array
                    if(data.length != 1) {
                        correct = false;
                    }
                } else if(count < 4 && count > 4) {
                    if(data.length != 7) {
                        correct = false;
                    }
                } else {
                    correct = false;
                }

                totalElements = totalElements + data.length;
                count++;
            }

            if(totalElements != 29) { // If the file doesn't have 29 total tokens then it will fail the program.
                System.out.println("\nSystem error. File " + this.storageFile + " does not contain the correct file format. Unable to complete process.");
                correct = false;
            }

            scan.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        return correct; // Returns whether or not the file is in the correct format.
    }

    public void createGame() {

    }

    public void changeName(String name) {

    }

    public void viewGame() {
        Scanner scan;
        try {
            scan = new Scanner(storageFile);
            String name = null;
            int count = 0;
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
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}