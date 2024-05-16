package final_project;

import javax.swing.JFrame;



public class Game {

	public static void main(String[] args) {
		JFrame window  = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1200,800);
		window.setResizable(false);
		window.setTitle("Dog cat fight");
		

		
//		Health healthBar=	new Health(100);
//		window.add(healthBar); 
		
		GamePanel gamepenal = new GamePanel();
		window.add(gamepenal);
		
		//window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamepenal.startgameThread();
//		
//		for(int i=100;i>=0;i=i-5) {
//			healthBar.setcurrentHealth(i);
//			try {
//                Thread.sleep(500); 
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//		}//test case 
	}

}
