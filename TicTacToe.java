import javax.swing.JOptionPane;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

//BRETT RAINIEL ESPIRITU 
//Tic Tac Toe is fun!.

public class TicTacToe extends Frame implements ActionListener {
    private Button[][] buttons = new Button[3][3];
    private char currentPlayer = 'X';
    private Button newGameButton;
    private Button exitButton;

    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setLayout(new GridLayout(4, 3));
        initializeButtons();
        initializeNewGameButton();
        initializeExitButton();
        setSize(300, 400);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }   

    private void initializeButtons() {
        for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            buttons[i][j] = new Button();
            buttons[i][j].setFont(new Font("Arial", Font.BOLD, 48));
                    buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }
    }

    private void initializeNewGameButton() {
        newGameButton = new Button("New Game");
            newGameButton.setBackground(Color.GREEN);
        newGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        add(newGameButton);
    }

    private void initializeExitButton() {
        exitButton = new Button("Exit");
             exitButton.setBackground(Color.RED);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(exitButton);
    }

    public void actionPerformed(ActionEvent ae) {
        Button clickedButton = (Button) ae.getSource();
        if (clickedButton.getLabel().equals("")) {
            clickedButton.setLabel(String.valueOf(currentPlayer));
            if (checkWinner()) {
                JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
                resetGame();
            } else if (isGridFull()) {
                JOptionPane.showMessageDialog(this, "DRAW!!!");
                resetGame();
                } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private boolean checkWinner() {
        
                for (int i = 0; i < 3; i++) {
            if (!buttons[i][0].getLabel().equals("") &&
                buttons[i][0].getLabel().equals(buttons[i][1].getLabel()) &&
                buttons[i][0].getLabel().equals(buttons[i][2].getLabel())) {
                return true;
            }
        }
        
                for (int j = 0; j < 3; j++) {
            if (!buttons[0][j].getLabel().equals("") &&
                buttons[0][j].getLabel().equals(buttons[1][j].getLabel()) &&
                buttons[0][j].getLabel().equals(buttons[2][j].getLabel())) {
                return true;
            }
        }
        
             if (!buttons[0][0].getLabel().equals("") &&
            buttons[0][0].getLabel().equals(buttons[1][1].getLabel()) &&
            buttons[0][0].getLabel().equals(buttons[2][2].getLabel())) {
            return true;
        }
                if (!buttons[0][2].getLabel().equals("") &&
            buttons[0][2].getLabel().equals(buttons[1][1].getLabel()) &&
            buttons[0][2].getLabel().equals(buttons[2][0].getLabel())) {
            return true;
        }
        return false;
    }

    private boolean isGridFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getLabel().equals("")) {
                return false;
                }
            }
        }
        return true;
    }

    private void resetGame() {
        currentPlayer = 'X';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setLabel("");
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
