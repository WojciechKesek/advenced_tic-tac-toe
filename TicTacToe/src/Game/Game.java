package Game;

import java.util.Scanner;

public class Game {
    private int size;
    private char[][] board;
    private Player player1;
    private Player player2;
    private int row;
    private int column;
    private int turn;


    public Game(Player player1, Player player2, int size) {
        this.row = 0;
        this.column = 0;
        this.turn = 0;
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

    public int getTurn() {
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
            this.board[row][column] = sign;
    }
    public boolean correctSpot(int row, int column) {
        if (row < getSize()
                && column < getSize()
                && row >= 0
                && column >= 0) {
            return true;
        } else {
            System.out.println("Invalid row or column");
            return false;
        }
    }
    public boolean alreadyTaken(int row, int column){
        if(this.board[row][column] != '_'){
            System.out.println("This spot is already taken.");
            return true;
        }
        return false;
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


    public void endTurn() {
        turn++;
    }

    public boolean checkWin() {
        int winVertical = 0;
        int winHorizontal = 0;
        int winAcross1 = 0;
        int winAcross2 = 0;
        int victory;
        if (getSize() > 3)
            victory = 3;
        else {
            victory = 2;
        }
        for (int i = 0; i < getSize() - 1; i++) {
            for (int j = 0; j < getSize() - 1; j++) {
                if (board[i][j] == board[i][j + 1]
                        && board[i][j] == getSign()) {
                    winHorizontal++;
                } else {
                    winHorizontal = 0;
                }
                if (board[j][i] == board[j][i + 1]
                        && board[j][i] == getSign()) {
                    winVertical++;
                } else {
                    winVertical = 0;
                }
                if (i + j + 1 < getSize()
                        && board[i + j][j] == board[i + j + 1][j + 1]
                        && board[i + j][i] == getSign()) {
                    winAcross1++;
                } else {
                    winAcross1 = 0;
                }
                /*if (i - j - 1 >= 0
                        && board[i - j][j] == board[i - j - 1][j - 1]
                        && board[i - j][j] == getSign()) {
                    winAcross2++;
                } else {
                    winAcross2 = 0;
                }*/
            }
        }
        if (winHorizontal == victory || winVertical == victory || winAcross1 == victory) {
            return true;
        }
        return false;
    }
}

