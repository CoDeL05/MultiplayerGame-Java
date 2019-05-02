package main;

import java.awt.*;
import java.io.*;

public class Params {

	public static double SCREEN_WIDTH;
	public static double SCREEN_HEIGHT;
	public static int time = 0;
	public static double scaleToResX;
	public static double scaleToResY;
	public static final double NORMAL_SCREEN_WIDTH = 1920;
	public static final double NORMAL_SCREEN_HEIGHT = 1080;
	public static String DEFAULTPATH = "";
	public static int TIME = 0;
	public static final int SCROOLBORDER_X = 100, SCROLLBORDER_Y = 100;

	public static Font DEFAULTFONT = new Font("monospaced",Font.BOLD,35);

	public static int FPS = 0;

	public static int PLAYERSPEED = 5;
	static {
		try {
			File currentDirFile = new File(".");
			String helper = currentDirFile.getAbsolutePath();
			DEFAULTPATH = helper.substring(0,helper.length()-1);
		}catch(Exception e){}
	}

}
