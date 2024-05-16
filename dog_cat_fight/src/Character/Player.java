package Character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import final_project.GamePanel;
import final_project.KeyHadler;

public class Player extends Entity{
	GamePanel gp;
	KeyHadler key1;
	
	public Player(GamePanel gp,KeyHadler key1) {
		this.gp=gp;
		this.key1=key1;
		
		setValue();
		getPlayerImage();
	}
	private void setValue() {
		x=200;
		y=700;
		speed=3;
	}
	private void getPlayerImage() {
		try {
			cat= ImageIO.read(getClass().getResourceAsStream("/player/cat.jpg"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void update() {
		if(key1.W_pressed==true) {
			y=y-speed;
		}else if(key1.S_pressed==true) {
			y=y+speed;
		}else if(key1.D_pressed==true) {
			x=x+speed;
		}else if(key1.A_pressed==true) {
			x=x-speed;
		}
		
	}
	public void draw(Graphics2D g2) {
//		g2.setColor(Color.black);
//		//g2.translate(600, 400);
//		g2.fillRect(x, y, 80, 80);
		BufferedImage image = cat;
		g2.drawImage(image, x, y, 90, 100, null);
	}
}
