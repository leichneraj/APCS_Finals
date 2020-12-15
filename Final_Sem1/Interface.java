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
                    System.out.println(count + ". " + game);
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
        String gameName = games[n-1];
        Game game = new Game(gameName);
        game.viewGame();
        System.out.println("\nWould you like to edit the game (1), go back (2), or quit (3)?");
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
            String name = scanner.nextLine();
            System.out.println(name);

            print.print(name + ",");
            print.close();
            scan.close();

            Game game = new Game(name);
            game.createGame();
        } catch(Exception e) {
            System.out.println(e);
        }
        scanner.close();
    }

    public static void editGame() {

    }

}