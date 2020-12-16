import java.util.Random;

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
}