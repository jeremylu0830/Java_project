import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener,MouseListener {

    final int PANEL_WIDTH=1200;
    final int PANEL_HEIGHT=600;
    Image bone;
    Image backgroundImage;
    Timer timer;
    final double gravity=0.2; 
    double angle=Math.PI/4;   
    double x=0;
    double y=PANEL_HEIGHT;
    int boneWidth;
    int boneHeight;
    double xVelocity;
    double yVelocity;
    long mousePressedTime;  
    boolean isLeftThrow=true;
    boolean isThrowing=false;

    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));  
        this.setBackground(Color.white);  
        bone=new ImageIcon("src/bone.png").getImage();
        backgroundImage=new ImageIcon("src/background.png").getImage();
        boneWidth=bone.getWidth(this)/4;
        boneHeight=bone.getHeight(this)/4;
        addMouseListener(this);
        timer=new Timer(10,this); //action every 10 milliseconds
    }

    public void paint(Graphics g){
        super.paint(g);  
        Graphics2D g2D=(Graphics2D)g;
        g2D.drawImage(backgroundImage,0,0,null);
        g2D.drawImage(bone,(int)x,(int)y-boneHeight,boneWidth,boneHeight,this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        x+=xVelocity;
        yVelocity+=gravity;
        y+=yVelocity;
        if(y>=PANEL_HEIGHT) {
            y=PANEL_HEIGHT; 
            yVelocity=0; 
            xVelocity=0; 
            timer.stop();
            isThrowing=false; //拋物運動停止
        }
        if(x>=PANEL_WIDTH-boneWidth||x<=0){ //當骨頭碰到左右邊界時停止
            yVelocity=0; 
            xVelocity=0;
            timer.stop();
            isThrowing=false; //拋物運動停止
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e){}

    @Override
    public void mousePressed(MouseEvent e){
        mousePressedTime = System.currentTimeMillis(); 
    }

    @Override
    public void mouseReleased(MouseEvent e){
        if (!isThrowing){ //如果當前沒有正在拋骨頭，則進行拋骨頭操作
            long mouseReleasedTime=System.currentTimeMillis();
            long timeDifference=mouseReleasedTime-mousePressedTime;
            double initialVelocity=timeDifference/100.0; 
            double xVelocity=initialVelocity*Math.cos(angle);
            double yVelocity=-initialVelocity*Math.sin(angle);
            timer.start();
            y=PANEL_HEIGHT;
            if (isLeftThrow){ //如果是左邊拋骨頭，則往右拋
                x=0;  //左邊骨頭的初始位置
                this.xVelocity=xVelocity;
            } else { //如果是右邊拋骨頭，則往左拋
                x=PANEL_WIDTH-boneWidth; //右邊骨頭的初始位置
                this.xVelocity=-xVelocity; 
            }
            this.yVelocity=yVelocity;
            isLeftThrow=!isLeftThrow; //切換拋骨頭位置
            isThrowing=true; //開始拋物運動
        }
    }

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}
}
