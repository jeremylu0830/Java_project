import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameWindow extends JFrame {
    public GameWindow() {
        setTitle("遊戲窗口");
        setSize(770, 512); // 設置視窗大小
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 點擊關閉按鈕時只關閉該視窗
        setLocationRelativeTo(null); // 將視窗置中

        JLabel backgroundLabel = new JLabel();
        add(backgroundLabel);

        ImageIcon backgroundImage = new ImageIcon("background.png");
        backgroundLabel.setIcon(backgroundImage);

        JButton menuButton = new JButton("暫停");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMenu();
            }
        });
        add(menuButton, BorderLayout.SOUTH);

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