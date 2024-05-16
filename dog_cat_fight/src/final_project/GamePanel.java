package final_project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import Character.Player;
import Character.Player2;
import Character.Bone;
import Health.Health;

public class GamePanel extends JPanel implements Runnable{
	int PANEL_WIDTH = 1200, PANEL_HEIGHT = 600;
	Thread gameThread;
	KeyHadler Key1 = new KeyHadler();
	KeyHadler Key2 = new KeyHadler();
	KeyHadler Key3 = new KeyHadler();
	Player player1= new Player(this,Key1);
	Player2 player2= new Player2(this,Key2);
	Bone bone = new Bone(this,Key3);
	Health health1=new Health(this,100);
	

	int FPS=60;
	public GamePanel() {
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
		this.addKeyListener(Key1);
		this.addKeyListener(Key2);
		this.addKeyListener(Key3);
		this.setFocusable(true);
	}
	
	public void startgameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 =(Graphics2D)g;
		player2.draw(g2);
		player1.draw(g2);
		bone.draw(g2);
		
		health1.draw(g2);
		g2.dispose();
	}

	// public int GetPanelWidth(){
	// 	return PANEL_WIDTH;
	// }

	// public int GetPanelHeight(){
	// 	return PANEL_HEIGHT;
	// }
	

	@Override
	public void run() {
		double interval = 1000000000/FPS; //player更新時間
		 double healthInterval = 1000000000 / 3; // 血條更新間隔，30次/秒

		double nextTime = System.nanoTime()+interval;
		 double nextHealthTime = System.nanoTime() + healthInterval;
		
		while(gameThread != null) {
			double currentTime = System.nanoTime();
			
			update();
			if(currentTime>nextHealthTime) {
				health1.updateHealth(5);
				nextHealthTime += healthInterval;
			}
			repaint();
	
			try {
				double reamainTime = nextTime - System.nanoTime();
				reamainTime = reamainTime/1000000;
				if(reamainTime<0) reamainTime=0;
				
				Thread.sleep((long) reamainTime);
				nextTime += interval;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}

	private void update() {
		player2.update();
		player1.update();
		bone.update();
	}
	
	
}
