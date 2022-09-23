import Game.Game;
import Game.Player;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            Player[] player = playerSetup();
            Game game = new Game(player[0], player[1], boardSetup());
            System.out.println("\nLets begin! \n");
            game.printBoard();
            while(true) {
                System.out.println("\n" + game.getName() + " turn.\n");
                int[] spot = askUser();
                while(!game.correctSpot(spot[0], spot[1]) || game.alreadyTaken(spot[0], spot[1])){
                    spot = askUser();
                    continue;
                }
                game.setRow(spot[0]);
                game.setColumn(spot[1]);
                game.setBoard(game.getRow(), game.getColumn(), game.getSign());
                game.printBoard();
                if(game.checkWin()){
                    System.out.println(game.getName() + " wins!");
                    System.out.println("\nIf you want to play again type 'yes', else press enter.");
                    scan.nextLine();
                    break;
                }
                game.endTurn();
            }
            if(!scan.nextLine().equals("yes")){
                break;
            }
        }
        scan.close();
    }
    public static Player[] playerSetup(){
        Player[] player = new Player[2];
        System.out.println("\nPlease enter Player 1 name");
        player[0] = new Player(scan.nextLine());
        System.out.println("\nPlease enter Player 2 name");
        player[1] = new Player(scan.nextLine());
        return player;
    }
    public static int boardSetup(){
        System.out.println("\nPlease enter size of the board");
        while(!scan.hasNextInt()){
            System.out.println("Invalid input. Please enter size of the board");
            scan.nextLine();
        }
        int size = scan.nextInt();
        while (size < 3){
            System.out.println("Size cant be less than 3");
            System.out.println("\nPlease enter size of the board");
            size = scan.nextInt();
        }
        if (size > 3)
        {
            System.out.println("\nYou chose advanced game. First who will get 4 in a column, row or across wins");
        }
        return size;
    }

    public static int[] askUser() {
        int[] spot = new int[2];
        while(true) {
            System.out.println("Please pick a row and column");
            if (!scan.hasNextInt()) {
                System.out.println("Invalid input.");
                scan.nextLine();
                continue;
            } else {
                spot[0] = scan.nextInt();
                spot[1] = scan.nextInt();
                return spot;
            }
        }
    }
}
