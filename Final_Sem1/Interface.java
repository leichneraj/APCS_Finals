import java.util.Scanner;
import java.io.*;

public class Interface {

    public static void main(String[] args) {
        seeGames();
    }

    public static void seeGames() {
        File saves;
        Scanner scanner;
        Scanner questions = new Scanner(System.in);
        try {
            saves = new File("saves.csv");
            scanner = new Scanner(saves);
            if(scanner.hasNext()) {
                String[] games = scanner.nextLine().split(",");

                System.out.println("\n==--- Games ---==\n");
                int count = 1;
                for(String game : games) {
                    System.out.println(count + ". " + game.replaceAll("_", " "));
                    count++;
                }
                System.out.println("\n==--- Games ---===");

                actions(games);
            } else {
                System.out.println("No current games, would you like to create a new one or quit the program? (new/quit)");
                String wantNew = questions.next();
                if(wantNew.matches("new")) {
                    newGame();
                }
            }
            scanner.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        questions.close();
    }

    public static void actions(String[] games) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWould you like to 'view'/edit or 'create' a game?");
        if(scanner.next().contains("create")) {
            newGame();
        } else {
            System.out.println("Which game would you like to view/edit (use corresponding numbers)?");
            int n = scanner.nextInt();
            if(n > 0) {
                view(n, games);
            }
        }
        scanner.close();
    }

    public static void view(int n, String[] games) {
        Scanner scanner = new Scanner(System.in);
        String gameName = games[n-1].replaceAll(" ", "_");
        Game game = new Game(gameName);
        game.viewGame();
        System.out.println("\nWould you like to edit the game (1), go back (2), or quit (3)?");
        if(scanner.nextInt() == 1) {
            editGame(gameName);
        } else if(scanner.nextInt() == 2) {
            seeGames();
        } else if(scanner.nextInt() == 3) {
        }
        scanner.close();
    }

    public static void newGame() {
        File saves;
        Scanner scan;
        Scanner scanner = new Scanner(System.in);
        try {
            saves = new File("saves.csv");
            scan = new Scanner(saves);

            String[] dataBackup = scan.nextLine().split(",");
            PrintWriter print = new PrintWriter(saves);
            for(String data : dataBackup) {
                print.print(data + ",");
            }

            System.out.print("What would you like the title the game? ");
            String name = scanner.nextLine().replaceAll(" ", "_");

            int i = 0;
            while(i < dataBackup.length) {
                if(dataBackup[i] != name) {
                    print.print(name + ",");
                    Game game = new Game(name);
                    game.createGame(name);
                } else {
                    System.out.println("A game with that name already exists.");
                    seeGames();
                }
                i++;
            }

            print.close();
            scan.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        scanner.close();
    }

    public static void editGame(String gameName) {
        File gameFile = new File(gameName + ".csv");
        Scanner scan;
        Character character = new Character();
        Scanner scanner = new Scanner(System.in);
        System.out.print("What character would you like to reroll? ");
        String name = scanner.next();
        try {
            scan = new Scanner(gameFile);
            int count = 0;
            String[] data;
            while(scan.hasNextLine()) {
                data = scan.nextLine().split(",");
                if(name.contains(data[0])) {
                    character.roll(count, data[1], gameFile);
                } else {
                    scan.nextLine();
                    count++;
                }
            }
            scan.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        scanner.close();
    }

}