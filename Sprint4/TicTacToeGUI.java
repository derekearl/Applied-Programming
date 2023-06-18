package Sprint4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame implements ActionListener {
    private JButton[][] buttons;
    private char currentPlayer;
    private JLabel statusLabel;

    public TicTacToeGUI() {
        buttons = new JButton[3][3];
        currentPlayer = 'X';

        JPanel gridPanel = new JPanel(new GridLayout(3, 3, 100, 100));
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));
                buttons[row][col].addActionListener(this);
                gridPanel.add(buttons[row][col]);
            }
        }

        statusLabel = new JLabel("Player " + currentPlayer + "'s turn");
        statusLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(statusLabel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setResizable(false);
        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    private void changePlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
        statusLabel.setText("Player " + currentPlayer + "'s turn");
    }

    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (buttons[row][col].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasWon(char player) {
        for (int row = 0; row < 3; row++) {
            if (buttons[row][0].getText().equals(Character.toString(player)) &&
                    buttons[row][1].getText().equals(Character.toString(player)) &&
                    buttons[row][2].getText().equals(Character.toString(player))) {
                return true;
            }
            if (buttons[0][row].getText().equals(Character.toString(player)) &&
                    buttons[1][row].getText().equals(Character.toString(player)) &&
                    buttons[2][row].getText().equals(Character.toString(player))) {
                return true;
            }
        }

        if (buttons[0][0].getText().equals(Character.toString(player)) &&
                buttons[1][1].getText().equals(Character.toString(player)) &&
                buttons[2][2].getText().equals(Character.toString(player))) {
            return true;
        }
        if (buttons[0][2].getText().equals(Character.toString(player)) &&
                buttons[1][1].getText().equals(Character.toString(player)) &&
                buttons[2][0].getText().equals(Character.toString(player))) {
            return true;
        }

        return false;
    }

    private void disableButtons() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setEnabled(false);
            }
        }
    }

    private void makeMove(int row, int col) {
        buttons[row][col].setText(Character.toString(currentPlayer));
        buttons[row][col].setEnabled(false);

        if (hasWon(currentPlayer)) {
            statusLabel.setText("Player " + currentPlayer + " wins!");
            disableButtons();
        } else if (isBoardFull()) {
            statusLabel.setText("It's a tie!");
        } else {
            changePlayer();
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (button == buttons[row][col]) {
                    makeMove(row, col);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TicTacToeGUI game = new TicTacToeGUI();
                game.setVisible(true);
            }
        });
    }
}