import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    private int rows, cols;
    private char[][] board;
    private char[][] mineField;
    private boolean gameState;

    public MineSweeper(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new char[rows][cols];
        this.mineField = new char[rows][cols];
        this.gameState = false;

        initializeBoard();
        placeMines();
    }

    public MineSweeper() {
        this(10, 10);
    }

    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void placeMines() {
        Random random = new Random();
        int minesToPlace = (int) (0.2 * rows * cols);

        for (int k = 0; k < minesToPlace; k++) {
            int i = random.nextInt(rows);
            int j = random.nextInt(cols);

            while (mineField[i][j] == 'X') {
                i = random.nextInt(rows);
                j = random.nextInt(cols);
            }

            mineField[i][j] = 'X';
        }
    }

    private void printBoard() {
        System.out.println("  ");
        for (int i = 0; i < cols; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void revealBoard() {
        System.out.println("Mayın Tarlası Tahtası:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(mineField[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private void makeMove(int row, int col) {
        if (mineField[row][col] == 'X') {
            gameState = true;
            revealBoard();
            System.out.println("Oyun bitti! Bir mayına çarptınız.");
        } else {
            int minesNearby = countMinesNearby(row, col);
            board[row][col] = (char) (minesNearby + '0');

            if (minesNearby == 0) {
                for (int i = row - 1; i <= row + 1; i++) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (isValidMove(i, j) && board[i][j] == '-') {
                            makeMove(i, j);
                        }
                    }
                }
            }
        }
    }

    private int countMinesNearby(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (isValidMove(i, j) && mineField[i][j] == 'X') {
                    count++;
                }
            }
        }
        return count;
    }

    public void playGame() {
        Scanner inp = new Scanner(System.in);

        while (!gameState) {
            printBoard();

            System.out.print("Satır ve Sütun Giriniz : ");
            int row = inp.nextInt();
            int col = inp.nextInt();

            if (isValidMove(row, col)) {
                makeMove(row, col);
            } else {
                System.out.println("Lütfen Belirli Aralıklarda Sayı Giriniz!");
            }

            if (isGameWon()) {
                System.out.println("Tebrikler! Oyunu Kazandınız!");
                revealBoard();
                break;
            }
        }
    }

    private boolean isGameWon() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '-' && mineField[i][j] != 'X') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Satır sayısını giriniz  : ");
        int rows = inp.nextInt();

        System.out.print("Sütun sayısını giriniz : ");
        int cols = inp.nextInt();

        MineSweeper mineSweeper = new MineSweeper(rows, cols);
        mineSweeper.playGame();
    }
}
