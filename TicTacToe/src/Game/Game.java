package Game;

public class Game {
    private int size;
    private char[][] board;
    private Player player1;
    private Player player2;
    private int row;
    private int column;
    private static int turn = 0;


    public Game(Player player1, Player player2, int size) {
        row = 0;
        column = 0;
        this.player1 = player1;
        this.player2 = player2;
        this.size = size;
        this.board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '_';
            }
        }
    }

    public static int getTurn() {
        return turn;
    }

    public int getSize() {
        return this.size;
    }

    public char getArr(int row, int column) {
        return board[row][column];
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setArr(int row, int column, char sign) {
        if (this.board[row][column] == '_') {
            this.board[row][column] = sign;
        } else {
            System.out.println("This spot is already taken");
        }
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setRow(int row) {
            this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getName() {
        switch (getTurn() % 2) {
            case 0:
                return player1.getName();
            default:
                return player2.getName();
        }
    }

    public char getSign() {
        switch (getTurn() % 2) {
            case 0:
                return 'X';
            default:
                return 'O';
        }
    }

    public void printBoard() {
        System.out.print("\t");
        for (int i = 0; i < getSize(); i++) {
            System.out.print(i + " ");
        }
        System.out.println("");
        for (int i = 0; i < getSize(); i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < getSize(); j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public boolean correctSpot(int row, int column) {
        if (row < getSize() && column < getSize() && row >= 0 && column >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void endTurn() {
        turn++;
    }


