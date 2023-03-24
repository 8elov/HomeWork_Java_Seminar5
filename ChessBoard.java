// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску.

public class ChessBoard {
    private static final int BOARD_SIZE = 8;
    private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    public void solve() {
        if (solve(0)) {
            printBoard();
        } else {
            System.out.println("Решение не найдено");
        }
    }

    private boolean solve(int colIndex) {
        if (colIndex == BOARD_SIZE) {
            return true;
        }

        for (int rowIndex = 0; rowIndex < BOARD_SIZE; ++rowIndex) {
            if (canPlaceQueen(rowIndex, colIndex)) {
                placeQueen(rowIndex, colIndex);

                if (solve(colIndex + 1)) {
                    return true;
                }

                removeQueen(rowIndex, colIndex);
            }
        }

        return false;
    }

    private boolean canPlaceQueen(int rowIndex, int colIndex) {
        for (int i = 0; i < colIndex; ++i) {
            if (board[rowIndex][i] == 1) {
                return false;
            }
        }

        for (int i = rowIndex, j = colIndex; i >= 0 && j >= 0; --i, --j) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = rowIndex, j = colIndex; i < BOARD_SIZE && j >= 0; ++i, --j) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private void placeQueen(int rowIndex, int colIndex) {
        board[rowIndex][colIndex] = 1;
    }

    private void removeQueen(int rowIndex, int colIndex) {
        board[rowIndex][colIndex] = 0;
    }

    private void printBoard() {
        for (int i = 0; i < BOARD_SIZE; ++i) {
            for (int j = 0; j < BOARD_SIZE; ++j) {
                System.out.print(board[i][j] == 1 ? "X " : "0 ");
            }
            System.out.println();
        }
    }
}
