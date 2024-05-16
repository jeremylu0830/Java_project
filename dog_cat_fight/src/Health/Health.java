package Health;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import final_project.GamePanel;

public class Health extends JPanel {
	public int maxHealth;
	public int currentHealth;
	GamePanel gp;
	
	public Health(GamePanel gp,int maxHealth) {
		this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.gp=gp;
	}

	public void draw(Graphics2D g2) {
        // 绘制血条的底部
        g2.setColor(Color.GRAY);
        g2.fillRect(10, 10, 200, 20); // 底部血条的位置和大小
        
        // 计算当前血量占总血量的比例
        double healthRatio = (double) currentHealth / maxHealth;
        
        // 绘制当前血量的血条
        g2.setColor(Color.RED);
        int width = (int) (healthRatio * 200); // 血条长度
        g2.fillRect(10, 10, width, 20); // 当前血条的位置和大小
		
	}
	public void updateHealth(int gg_health) {
		currentHealth=currentHealth-gg_health;
	}
	
//	public void setcurrentHealth(int currentHealth) {
//		if(currentHealth>=0 && currentHealth<maxHealth) {
//			this.currentHealth=currentHealth;
//			repaint();
//		}
//	}
//	protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        
//        // 绘制血条的底部
//        g.setColor(Color.GRAY);
//        g.fillRect(10, 10, 200, 20); // 底部血条的位置和大小
//        
//        // 计算当前血量占总血量的比例
//        double healthRatio = (double) currentHealth / maxHealth;
//        
//        // 绘制当前血量的血条
//        g.setColor(Color.RED);
//        int width = (int) (healthRatio * 200); // 血条长度
//        g.fillRect(10, 10, width, 20); // 当前血条的位置和大小
//    }
}
