import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;

public class Game extends JFrame {
    private JFrame gameFrame;
    private GameWindow gameWindow;

    public Game() {
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        // 創建 Play 按鈕
        JButton playButton = new JButton("開始遊戲");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow = new GameWindow();
                gameWindow.setVisible(true);
                setVisible(false);
            }
        });
        add(playButton);

        JButton historyButton = new JButton("歷史紀錄");
        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHistory();
            }
        });
        add(historyButton);

        JButton quitButton = new JButton("退出");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(Game.this, "確定要退出嗎？", "退出遊戲", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        add(quitButton);

        setVisible(true);
    }

    // 顯示遊戲歷史記錄
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
            history.append("讀取歷史記錄時出錯: ").append(ex.getMessage());
        }
        JOptionPane.showMessageDialog(this, "遊戲歷史記錄:\n" + history.toString());
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


class GameWindow extends JFrame {
    public GameWindow() {
        setTitle("遊戲窗口");
        setSize(1200, 800); // 設置視窗大小
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 點擊關閉按鈕時只關閉該視窗
        setLocationRelativeTo(null); // 將視窗置中

        JLabel backgroundLabel = new JLabel();
        

        ImageIcon backgroundImage = new ImageIcon("background.png");
        backgroundImage.getImage().getScaledInstance(1200, 800,Image.SCALE_DEFAULT);
        backgroundLabel.setIcon(backgroundImage);
        add(backgroundLabel);
        
        JButton menuButton = new JButton("暫停");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMenu();
            }
        });
        add(menuButton, BorderLayout.SOUTH);
        this.pack();
        setVisible(true);
    }

    private void showMenu() {
        Object[] options = {"繼續遊戲", "退出"};
        int choice = JOptionPane.showOptionDialog(this,
                "選擇操作",
                "遊戲暫停",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (choice == 0) {
            // 繼續遊戲
            setVisible(true);
        } else if (choice == 1) {
            // 退出
            System.exit(0);
        }
    }
}
