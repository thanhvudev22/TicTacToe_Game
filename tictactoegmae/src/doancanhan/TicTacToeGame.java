
package doancanhan;

public final class TicTacToeGame {
    private final String[][] board = new String[3][3];
    private boolean playerXTurn = true;

    public TicTacToeGame() {
        resetBoard();
    }

    public String[][] getBoard() {
        return board;
    }

    public boolean makeMove(int row, int col) {
        if (board[row][col].equals("")) {
            board[row][col] = playerXTurn ? "X" : "O";
            playerXTurn = !playerXTurn;
            return true;
        }
        return false;
    }

    public String checkWinner() {
        // Kiểm tra hàng
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].equals("") && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                return board[i][0];
            }
        }

        // Kiểm tra cột
        for (int j = 0; j < 3; j++) {
            if (!board[0][j].equals("") && board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j])) {
                return board[0][j];
            }
        }

        // Kiểm tra đường chéo
        if (!board[0][0].equals("") && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            return board[0][0];
        }

        if (!board[0][2].equals("") && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
            return board[0][2];
        }

        return null;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "";
            }
        }
        playerXTurn = true;
    }
}

