import Game.Game;
import Game.Player;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Player 1 name");
        Player player1 = new Player(scan.nextLine());
        System.out.println("Please enter Player 2 name");
        Player player2 = new Player(scan.nextLine());
        System.out.println("Please enter size of the board");
        int size = scan.nextInt();
        while (size < 3){
            System.out.println("Size cant be less than 3");
            System.out.println("Please enter size of the board");
            size = scan.nextInt();
        }
        if (size > 3)
        {
            System.out.println("You chose advanced game. First who will get 4 in a column, row or across wins");
        }
        System.out.println("Lets begin");
        Game game = new Game(player1, player2, size);
        game.printBoard();
        while(true) {
            System.out.println(game.getName() + " turn. Please pick a row and column");
                game.setRow(scan.nextInt());
                game.setColumn(scan.nextInt());
            if(game.correctSpot(game.getRow(), game.getColumn())) {
                game.setArr(game.getRow(), game.getColumn(), game.getSign());
                game.printBoard();
            } else {
                System.out.println("Invalid row or column.");
                continue;
            }
            if(game.checkWin()){
                System.out.println(game.getName() + " wins");
                break;
            }
            game.endTurn();
        }
        scan.close();
    }
}