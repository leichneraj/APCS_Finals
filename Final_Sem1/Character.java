import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class Character {

    Random random = new Random();
    String name, type = null;
    int strength, toughness, intelligence, magic, influence;

    public boolean checkCharacter(String[] character) {
        int count = 0;
        for(String characteristic : character) {
            switch(count) {
                case '0' :
                name = characteristic;
                break;
                case '1' :
                type = characteristic;
                break;
                case '2' :
                strength = Integer.parseInt(characteristic);
                break;
                case '3' :
                toughness = Integer.parseInt(characteristic);
                break;
                case '4' :
                intelligence = Integer.parseInt(characteristic);
                break;
                case '5' :
                magic = Integer.parseInt(characteristic);
                break;
                case '6' :
                influence = Integer.parseInt(characteristic);
                default:
                System.out.println("Error with switch statement in character class: checkCharacter().");
            }
            count++;
        }

        boolean correct = true;

        if(type.contains("Knight")) {
            if(!(strength >= 7 && strength <= 10)) {
                correct = false;
            } else if(!(toughness <= 6 && toughness >= 0 && intelligence <= 6 && intelligence >= 0 && magic <= 6 && magic >= 0 && influence <=6 && influence >= 0)) {
                correct = false;
            } else if((strength + toughness + intelligence + magic + influence) > 28) {
                correct = false;
            } else if((strength + toughness + intelligence + magic + influence) < 8) {
                correct = false;
            }
        } else if(type.contains("Peasant")) {
            if(!(toughness >= 7 && toughness <= 10)) {
                correct = false;
            } else if(!(strength <= 6 && strength >= 0 && intelligence <= 6 && intelligence >= 0 && magic <= 6 && magic >= 0 && influence <=6 && influence >= 0)) {
                correct = false;
            } else if((strength + toughness + intelligence + magic + influence) > 28) {
                correct = false;
            } else if((strength + toughness + intelligence + magic + influence) < 8) {
                correct = false;
            }
        } else if(type.contains("Cleric")) {
            if(!(intelligence >= 7 && intelligence <= 10)) {
                correct = false;
            } else if(!(toughness <= 6 && toughness >= 0 && strength <= 6 && strength >= 0 && magic <= 6 && magic >= 0 && influence <=6 && influence >= 0)) {
                correct = false;
            } else if((strength + toughness + intelligence + magic + influence) > 28) {
                correct = false;
            } else if((strength + toughness + intelligence + magic + influence) < 8) {
                correct = false;
            }
        } else if(type.contains("Mage")) {
            if(!(magic >= 7 && magic <= 10)) {
                correct = false;
            } else if(!(toughness <= 6 && toughness >= 0 && intelligence <= 6 && intelligence >= 0 && strength <= 6 && strength >= 0 && influence <=6 && influence >= 0)) {
                correct = false;
            } else if((strength + toughness + intelligence + magic + influence) > 28) {
                correct = false;
            } else if((strength + toughness + intelligence + magic + influence) < 8) {
                correct = false;
            }
        } else if(type.contains("Courtier")) {
            if(!(influence >= 7 && influence <= 10)) {
                correct = false;
            } else if(!(toughness <= 6 && toughness >= 0 && intelligence <= 6 && intelligence >= 0 && magic <= 6 && magic >= 0 && strength <=6 && strength >= 0)) {
                correct = false;
            } else if((strength + toughness + intelligence + magic + influence) > 28) {
                correct = false;
            } else if((strength + toughness + intelligence + magic + influence) < 8) {
                correct = false;
            }
        } else {
            correct = false;
        }
        return correct;
    }

    public void newCharacters(int characters, String storageFile) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int knight = 0, peasant = 0, cleric = 0, mage = 0, courtier = 0;
        String[] characterInfo = new String[7];
        while(characters != 5) {
            System.out.print("What would you like the character to be named? ");
            characterInfo[0] = scanner.next();
            System.out.print("What type of character would you like ('Knight','Peasant','Cleric','Mage','Courtier')? ");
            if(scanner.next().contains("Knight")) {
                knight++;
                if(knight <= 2) {
                    characterInfo[1] = "Knight";
                } else {
                    System.out.println("Only two of each type of character allowed.");
                    newCharacters(characters, storageFile);
                }
            } else if(scanner.next().contains("Peasant")) {
                if(peasant <= 2) {
                    characterInfo[1] = "Peasant";
                    peasant++;
                } else {
                    System.out.println("Only two of each type of character allowed.");
                    newCharacters(characters, storageFile);
                }
            } else if(scanner.next().contains("Cleric")) {
                if(cleric <= 2) {
                    characterInfo[1] = "Cleric";
                    cleric++;
                } else {
                    System.out.println("Only two of each type of character allowed.");
                    newCharacters(characters, storageFile);
                }
            } else if(scanner.next().contains("Mage")) {
                if(mage <= 2) {
                    characterInfo[1] = "Mage";
                    mage++;
                } else {
                    System.out.println("Only two of each type of character allowed.");
                    newCharacters(characters, storageFile);
                }
            } else if(scanner.next().contains("Courtier")) {
                if(courtier <= 2) {
                    characterInfo[1] = "Courtier";
                    courtier++;
                } else {
                    System.out.println("Only two of each type of character allowed.");
                    newCharacters(characters, storageFile);
                }
            } else {
                System.out.println("Please use correct name of type.");
                newCharacters(characters, storageFile);
            }
            characters++;
        }
        scanner.close();

        File storageFileName = new File(storageFile + ".csv");
        try {
            PrintWriter print = new PrintWriter(storageFileName);
        } catch(Exception e) {
            System.out.println(e);
        } 
    }

    public void roll(int line, String type, File file) {
        Scanner scan;
        try {
            scan = new Scanner(file);
            int count = 0;
            String[] characterData;
            while(scan.hasNextLine()) {
                if(count == line) {
                    characterData = scan.nextLine().split(",");
                } else {
                    scan.nextLine();
                    count++;
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

}