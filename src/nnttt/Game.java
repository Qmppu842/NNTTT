package nnttt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author olindqvi
 */
public class Game {

    private StateOfSquare[][] board;
    /**
     * Turns: Even = X Odd = O
     */
    private int turnNumber;
    private boolean isP1Human;
    private boolean isP2Human;

    public Game() {
        StateOfSquare st = StateOfSquare.EMPTY;
        board = new StateOfSquare[3][3];
//        Arrays.fill(board, st);
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                board[y][x] = st;
            }
        }

        turnNumber = 0;
        isP1Human = false;
        isP2Human = false;
    }

    public void init() {
        System.out.println(this.toString());
        System.out.println();

        Scanner input = new Scanner(System.in);

        while (this.checkWinners().equals(StateOfSquare.EMPTY)) {
            System.out.print("input ((x|o)xy): ");
            String line = input.nextLine();
            char vuor = line.charAt(0);
            int x = line.charAt(1) - 48;
            int y = line.charAt(2) - 48;

            StateOfSquare t = StateOfSquare.EMPTY;
            if (vuor == 'x') {
                t = t.X;
            } else {
                t = t.O;
            }
            boolean menikoInput = this.inputTurn(t, y, x);
            System.out.println("vuor: " + vuor + "| x: " + x + "| y: " + y);
            System.out.println("meniko: " + menikoInput);
            System.out.println("turn: " + this.getTurnNumber());
            System.out.println();
            System.out.println(this.toString());
            System.out.println();

        }

        System.out.println();
        System.out.println("Done!");
        System.out.println("And the winner is: " + this.checkWinners().getName());

    }

    public void setPlayer1toHuman() {
        isP1Human = true;
    }

    public void setPlayer2toHuman() {
        isP2Human = true;
    }

    public boolean inputTurn(StateOfSquare turn, int posY, int posX) {
        StateOfSquare st = board[posY][posX];
        if (!st.equals(StateOfSquare.EMPTY)) {
            return false;
        }
        if (turnNumber % 2 == 0) {
            if (!turn.equals(StateOfSquare.X)) {
                return false;
            }
        } else if (!turn.equals(StateOfSquare.O)) {
            return false;
        }
        board[posY][posX] = turn;
        turnNumber++;
        return true;
    }

    public ArrayList<StateOfSquare> flatBoard() {
        ArrayList<StateOfSquare> flat = new ArrayList<>();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                flat.add(board[x][y]);
            }
        }
        return flat;
    }

    public StateOfSquare checkWinners() {
        StateOfSquare hor = checkWinnersHorizontal();
        StateOfSquare ver = checkWinnersVertical();
        StateOfSquare cor = checkWinnersCorner();

        if (!hor.equals(StateOfSquare.EMPTY)) {
            return hor;
        }

        if (!ver.equals(StateOfSquare.EMPTY)) {
            return ver;
        }

        if (!cor.equals(StateOfSquare.EMPTY)) {
            return cor;
        }

        return StateOfSquare.EMPTY;
    }

    private StateOfSquare checkWinnersHorizontal() {
        for (int y = 0; y < 3; y++) {
            int val = 0;
            for (int x = 0; x < 3; x++) {
                val += board[x][y].getValue();
            }
            if (val >= 3) {
                return StateOfSquare.X;
            } else if (val <= -3) {
                return StateOfSquare.O;
            }
        }

        return StateOfSquare.EMPTY;
    }

    private StateOfSquare checkWinnersVertical() {
        for (int x = 0; x < 3; x++) {
            int val = 0;
            for (int y = 0; y < 3; y++) {
                val += board[x][y].getValue();
            }
            if (val >= 3) {
                return StateOfSquare.X;
            } else if (val <= -3) {
                return StateOfSquare.O;
            }
        }

        return StateOfSquare.EMPTY;
    }

    private StateOfSquare checkWinnersCorner() {
        int val = 0;
        for (int i = 0; i < 3; i++) {
            val += board[i][i].getValue();
        }

        int val1 = 0;
        for (int i = 0; i < 3; i++) {
            val1 += board[2 - i][i].getValue();
        }

        if (val >= 3) {
            return StateOfSquare.X;
        } else if (val <= -3) {
            return StateOfSquare.O;
        }

        if (val1 >= 3) {
            return StateOfSquare.X;
        } else if (val1 <= -3) {
            return StateOfSquare.O;
        }

        return StateOfSquare.EMPTY;
    }

    @Override
    public String toString() {
        String boardState = "";
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                boardState += board[y][x].getName();
                if (x != 2) {
                    boardState += "|";
                }
            }
            boardState += "\n";
            if (y != 2) {
                boardState += "-+-+-\n";
            }
        }
        return boardState;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

}
