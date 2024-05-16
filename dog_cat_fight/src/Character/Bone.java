package Character;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import final_project.GamePanel;
import final_project.KeyHadler;

public class Bone extends Entity{
    GamePanel gp;
    KeyHadler key3;
    private long mousePressedTime;
    private double initialVelocity, xVelocity, yVelocity, angle = Math.PI/4;
    private double gravity = 0.2;


    public Bone(GamePanel gp, KeyHadler key3){
        this.gp = gp;
        this.key3 = key3;
        setValue();
        getPlayerImage();
    }

    private void setValue(){
        x = 200;
        y = 700;
        width = 50;
        height = 50;
        speed = 12;
    }

    private void getPlayerImage() {
		try {
			bone = ImageIO.read(getClass().getResourceAsStream("/player/bone.jpg"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}

    public void draw(Graphics2D g2){
        BufferedImage image = bone;
        g2.drawImage(image,x,y,width,height,null);
    }

    public void update() {
        if(key3.mouse_pressed && !key3.isThrowing){
            mousePressedTime = System.currentTimeMillis();
            System.out.println("the mouse is pressed");
        }
        else if(key3.mouse_released && key3.isThrowing){
            initialVelocity = System.currentTimeMillis() - mousePressedTime;
            System.out.println("the initial velocity is " + initialVelocity);
            initialVelocity /= 100;
            key3.isThrowing = true;
            xVelocity = initialVelocity * Math.cos(angle);
            yVelocity = initialVelocity * Math.sin(angle);
            x += xVelocity;
            yVelocity += gravity;
            y += yVelocity;
            if(y>=PANEL_HEIGHT) {
                y=PANEL_HEIGHT; 
                yVelocity=0; 
                xVelocity=0; 
                key3.isThrowing=false; //拋物運動停止
            }
            if(x >= PANEL_WIDTH - width || x <= 0){ //當骨頭碰到左右邊界時停止
                yVelocity=0; 
                xVelocity=0;
                key3.isThrowing=false; //拋物運動停止
            }
        }
        
    }
}
