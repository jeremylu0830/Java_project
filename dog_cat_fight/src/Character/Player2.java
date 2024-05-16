package Character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import final_project.GamePanel;
import final_project.KeyHadler;

public class Player2 extends Entity{
	GamePanel gp;
	KeyHadler key2;
	
	public Player2(GamePanel gp,KeyHadler key2) {
		this.gp=gp;
		this.key2=key2;
		
		setValue();
		getPlayerImage();
	}
	private void setValue() {
		x=1000;
		y=700;
		speed=3;
	}
	private void getPlayerImage() {
		try {
			dog= ImageIO.read(getClass().getResourceAsStream("/player/dog.jpg"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void update() {
		if(key2.Up_pressed==true) {
			y=y-speed;
		}else if(key2.Down_pressed==true) {
			y=y+speed;
		}else if(key2.Right_pressed==true) {
			x=x+speed;
		}else if(key2.Left_pressed==true) {
			x=x-speed;
		}
		
	}
	public void draw(Graphics2D g2) {
//		g2.setColor(Color.blue);
//		//g2.translate(600, 400);
//		g2.fillRect(x, y, 80, 80);
		BufferedImage image = dog;
		g2.drawImage(image, x, y, 120, 80, null);
	}
}

