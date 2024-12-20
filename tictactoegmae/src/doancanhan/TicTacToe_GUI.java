package doancanhan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe_GUI extends JFrame implements ActionListener {
    private final JButton[][] buttons = new JButton[3][3];
    private final TicTacToeGame game;

    public TicTacToe_GUI() {
        game = new TicTacToeGame();
        setTitle("Tic-Tac-Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(500, 250);

        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        Font buttonFont = new Font("Arial", Font.BOLD, 40);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(buttonFont);
                buttons[i][j].addActionListener(this);
                gridPanel.add(buttons[i][j]);
            }
        }

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> resetGame());

        add(gridPanel, BorderLayout.CENTER);
        add(resetButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        int row = -1, col = -1;

        // Xác định vị trí nút được nhấn
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (clickedButton == buttons[i][j]) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        // Thực hiện di chuyển nếu có thể
        if (game.makeMove(row, col)) {
            clickedButton.setText(game.getBoard()[row][col]);
            clickedButton.setForeground(game.getBoard()[row][col].equals("X") ? Color.BLUE : Color.RED);
        }

        // Kiểm tra người thắng hoặc hòa
        String winner = game.checkWinner();
        if (winner != null) {
            JOptionPane.showMessageDialog(this, winner + " wins!");
            disableButtons();
        } else if (game.isBoardFull()) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
        }
    }

    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    private void resetGame() {
        game.resetBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe_GUI TicTacToe_GUI = new TicTacToe_GUI(); /*ticTacToe_GUI*/
    }
}

