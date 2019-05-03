package main;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
	public static HashMap<Integer,BulletPars> bulletTypeToPars = new HashMap<>();

	public static Font DEFAULTFONT = new Font("monospaced",Font.BOLD,35);
	static {


		bulletTypeToPars.put(0,new BulletPars(16,9,100,10));
		bulletTypeToPars.put(1,new BulletPars(4,4,10,20));

	}
	public static int FPS = 0;

	public static int PLAYERSPEED = 5;
	static {
		try {
			File currentDirFile = new File(".");
			String helper = currentDirFile.getAbsolutePath();
			DEFAULTPATH = helper.substring(0,helper.length()-1);
		}catch(Exception e){}
	}

	public static class BulletPars{

		public ArrayList<Integer> make = new ArrayList();

		public BulletPars(Integer ... ps){
			make = new ArrayList<Integer>(Arrays.asList(ps));
		}
		public ArrayList<Integer> get(){
			return make;
		}



	}

}
