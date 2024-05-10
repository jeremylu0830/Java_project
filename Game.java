import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Game extends JFrame {
    public Game() {
        setTitle("Game Start");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Game.this, "Starting the game...");
                // 開始執行遊戲
            }
        });
        add(playButton);

        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMenu();
            }
        });
        add(menuButton);

        JButton historyButton = new JButton("History");
        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHistory();
            }
        });
        add(historyButton);

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(Game.this, "Are you sure you want to quit?", "Quit Game", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        add(quitButton);

        setVisible(true);
    }

    public void showMenu() {
        JOptionPane.showMessageDialog(this, "Game Menu:\n1. Settings\n2. Instructions");
        // 增加選項
    }

    public void showHistory() {
        StringBuilder history = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("history.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                history.append(line).append("\n");
            }
            reader.close();
        } catch (IOException ex) {
            history.append("Error reading history: ").append(ex.getMessage());
        }
        JOptionPane.showMessageDialog(this, "Game History:\n" + history.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Game();
            }
        });
    }
}
