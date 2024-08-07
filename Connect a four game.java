import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final char EMPTY = '.';
    private static final char PLAYER_ONE = 'X';
    private static final char PLAYER_TWO = 'O';
    
    private char[][] board = new char[ROWS][COLS];
    private boolean isPlayerOneTurn = true;

    public ConnectFour() {
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = EMPTY;
            }
        }
    }

    private void printBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("1 2 3 4 5 6 7");
    }

    private boolean isValidMove(int col) {
        return col >= 0 && col < COLS && board[0][col] == EMPTY;
    }

    private void makeMove(int col) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == EMPTY) {
                board[row][col] = isPlayerOneTurn ? PLAYER_ONE : PLAYER_TWO;
                break;
            }
        }
    }

    private boolean checkWin(char player) {
        // Check horizontal, vertical, and diagonal
        return checkHorizontal(player) || checkVertical(player) || checkDiagonal(player);
    }

    private boolean checkHorizontal(char player) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] == player && board[row][col + 1] == player && 
                    board[row][col + 2] == player && board[row][col + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVertical(char player) {
        for (int col = 0; col < COLS; col++) {
            for (int row = 0; row < ROWS - 3; row++) {
                if (board[row][col] == player && board[row + 1][col] == player && 
                    board[row + 2][col] == player && board[row + 3][col] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonal(char player) {
        // Check positive slope diagonal
        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] == player && board[row - 1][col + 1] == player &&
                    board[row - 2][col + 2] == player && board[row - 3][col + 3] == player) {
                    return true;
                }
            }
        }
        // Check negative slope diagonal
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] == player && board[row + 1][col + 1] == player &&
                    board[row + 2][col + 2] == player && board[row + 3][col + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int col = 0; col < COLS; col++) {
            if (board[0][col] == EMPTY) {
                return false;
            }
        }
        return true;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printBoard();
            System.out.println("Player " + (isPlayerOneTurn ? "One" : "Two") + "'s turn");
            System.out.print("Choose a column (1-7): ");
            int col = scanner.nextInt() - 1;

            if (!isValidMove(col)) {
                System.out.println("Invalid move, try again.");
                continue;
            }

            makeMove(col);

            if (checkWin(isPlayerOneTurn ? PLAYER_ONE : PLAYER_TWO)) {
                printBoard();
                System.out.println("Player " + (isPlayerOneTurn ? "One" : "Two") + " wins!");
                break;
            }

            if (isBoardFull()) {
                printBoard();
                System.out.println("The game is a draw!");
                break;
            }

            isPlayerOneTurn = !isPlayerOneTurn;
        }
        scanner.close();
    }

    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();
        game.play();
    }
}
