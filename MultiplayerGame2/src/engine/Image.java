package engine;

import main.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Image {


	private int x,y,sw,sh,ow,oh,w,h;
	private String path;
	private ImageIcon iIcon;
	private java.awt.Image img;

	private double alpha;
	public Image(int x, int y,String path){
		this.x=x;
		this.y=y;
		this.path = path;
		load();
	}
	public Image(int x, int y,String path,double alpha){
		this.x=x;
		this.y=y;
		this.path = path;
		this.alpha = alpha;
		load();
	}

	public static BufferedImage getFilledImage(java.awt.Image image,Color color){
		int w = image.getWidth(null);
		int h = image.getHeight(null);

		BufferedImage bufferedImage = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		BufferedImage nImage = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		Graphics g = bufferedImage.getGraphics();

		g.drawImage(image,0,0,null);
		g.setColor(color);
		g.fillRect(0,0,w,h);

		for(int y = 0;y<h;y++){
			for(int x = 0;x<w;x++){
				Color c = new Color(bufferedImage.getRGB(x,y));
				System.out.println(Integer.toString(c.getRed())+","+Integer.toString(color.getRed()));
				if(c.getRed() == color.getRed() && c.getGreen() == color.getGreen() && color.getBlue() == c.getBlue()){

					bufferedImage.setRGB(x,y,0x000000f);
				}else{

				}

			}
		}

		return bufferedImage;
	}

	private void load(){
		iIcon = new ImageIcon(path);
		img = iIcon.getImage();
		ow = img.getWidth(null);
		oh = img.getHeight(null);
	}

	public void paint(Graphics g){


		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float)Math.abs(((alpha*100)%100)/100)));
		g.drawImage(img,x,y,getOw(),getOh(),null);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float)1));
	}
	public void setAlpha(double alp){
		this.alpha = alp;
	}
	public String getPath(){
		return path;
	}
	public int getX(){
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getW(){
		load();
		if(sw != 0){
			return sw;
		}else{
			return ow;
		}
	}
	public int getH(){
		load();
		if(sh != 0){
			return sh;
		}else{
			return oh;
		}
	}
	public int getSw(){
		load();
		return sw;
	}
	public int getSh(){
		load();
		return sh;
	}
	public void setSw(int sw){
		this.sw = sw;
	}
	public void setSh(int sh){
		this.sh = sh;
	}
	public int getOw(){
		load();
		return ow;
	}
	public int getOh(){
		load();
		return oh;
	}

}
