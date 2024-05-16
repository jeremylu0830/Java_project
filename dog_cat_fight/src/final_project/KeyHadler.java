package final_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;



public class KeyHadler implements KeyListener,ActionListener,MouseListener{
	public boolean W_pressed,S_pressed,A_pressed,D_pressed,Up_pressed,Down_pressed,Left_pressed,Right_pressed;
	public boolean mouse_pressed = false, mouse_released = false, isThrowing = false;


	// public KeyHadler(){
	// 	timer = new Timer(10,this);
	// }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W) {
			W_pressed=true;
		}else if (code == KeyEvent.VK_S) {
			S_pressed=true;
		}else if (code == KeyEvent.VK_A) {
			A_pressed=true;
		}else if (code == KeyEvent.VK_D) {
			D_pressed=true;
		}else if(code == KeyEvent.VK_UP) {
			Up_pressed=true;
		}else if (code == KeyEvent.VK_DOWN) {
			Down_pressed=true;
		}else if (code == KeyEvent.VK_LEFT) {
			Left_pressed=true;
		}else if (code == KeyEvent.VK_RIGHT) {
			Right_pressed=true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W) {
			W_pressed=false;
		}else if (code == KeyEvent.VK_S) {
			S_pressed=false;
		}else if (code == KeyEvent.VK_A) {
			A_pressed=false;
		}else if (code == KeyEvent.VK_D) {
			D_pressed=false;
		}else if(code == KeyEvent.VK_UP) {
			Up_pressed=false;
		}else if (code == KeyEvent.VK_DOWN) {
			Down_pressed=false;
		}else if (code == KeyEvent.VK_LEFT) {
			Left_pressed=false;
		}else if (code == KeyEvent.VK_RIGHT) {
			Right_pressed=false;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		mouse_pressed = true;
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		mouse_pressed = false;
		mouse_released = true;
		isThrowing = true;
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
	}


}
