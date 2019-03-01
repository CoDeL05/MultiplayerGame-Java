package main;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener{

	
	public static final boolean[] buttons = new boolean[5];
	
	public static int getX() {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int x = (int) b.getX();
		
		return x;
	}
	public static int getY() {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int y = (int) b.getY();
		
		return y;
	}
	
	public static int[] getPos() {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int x = (int) b.getX();
		int y = (int) b.getX();
		return new int[] {x,y};
	}
	
	public static boolean isPressed(int button) {
		return buttons[button];
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		buttons[arg0.getButton()] = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		buttons[arg0.getButton()] = false;
		
	}}
