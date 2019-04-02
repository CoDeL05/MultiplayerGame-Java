package main;
import java.awt.event.*;

public class KeyBoard implements KeyListener{
	
	
	public static boolean[] keys = new boolean[524]; // 524 = amount of all existing keys
	public static int pressed = -1;
	
	public static boolean isPressed(int key) {
		return keys[key];
	}

	public static boolean isReleased(int key) {
		return keys[key] == false;
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		keys[arg0.getKeyCode()%524] = true;
		pressed = arg0.getKeyCode();
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		keys[arg0.getKeyCode()%524] = false;
		pressed = -1;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
