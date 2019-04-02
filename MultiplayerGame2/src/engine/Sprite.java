package engine;

import multiplayer.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;

public class Sprite {
	public int from ;
	private int x,y,w,h,delay=0,x2,y2;
	private String[][][] images;
	protected Image img;
	private Rectangle2D hitBox;
	public int place=0,type=0;
	private boolean alreadyScaled = false;
	private Line2D left,right,up,down;
	public int angle = 0;
	private int flipX = 1,flipY=1;
	protected int dx,dy;

	public int getDX(){
		return dx;
	}

	public int getDY(){
		return dy;
	}

	public void setDX(int dx){
		this.dx = dx;
	}
	public void setDY(int dy){
		this.dy = dy;
	}

	public int getFlipX(){
		return flipX;
	}
	public int getFlipY(){
		return flipY;
	}

	public void setFlipX(int fx){
		flipX = fx;
	}
	public void setFlipY(int fy){
		flipY = fy;
	}
	public boolean toSprites = false;
	protected String id;



	public String getId(){
		return id;
	}
	public Sprite(int x, int y, String[][][] images,boolean toSprites){
		this.x=x;
		this.y=y;
		this.images = images;
		load();
		this.toSprites  = toSprites;
		if(toSprites){
			Client.sendSprites.add(this);
		}
	}
	public Sprite(int x, int y, String[][][] images){
		this.x=x;
		this.y=y;
		this.images = images;
		load();


	}





	public boolean play = false;


	public int hashCode(){
		return getId().length()+(getY()%50)+(getX()%50)+Client.ii;
	}



	public void scale(int width,int height){
		w = width;
		h = height;
		alreadyScaled = true;
	}


	public String[][] getAnim(){
		return images[type];
	}
	public String[] getFrame(){
		return getAnim()[place % getAnim().length];
	}
	public String getImage(){
		return getFrame()[0];
	}
	public int getDelay(){
		return Integer.parseInt(getFrame()[1]);
	}
	public int getW(){
		if(!(w > 0)){
			load();
		}
		return w;
	}
	public int getH(){
		if(!(h > 0)){
			load();
		}
		return h;
	}

	public Rectangle2D getHitBox(){
		load();
		return hitBox;
	}

	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	public void addX(int x){
		this.x += x;
	}
	public void addY(int y){
		this.y += y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

	public void setX2(int x){
		this.x=x;
	}
	public void setY2(int y){
		this.y=y;
	}
	public void addX2(int x){
		this.x += x;
	}
	public void addY2(int y){
		this.y += y;
	}
	public int getX2(){
		return x;
	}
	public int getY2(){
		return y;
	}


	public boolean collide(Shape shp){
		if(shp != null && hitBox != null) {
			return shp.intersects(hitBox);
		}else{
			return false;
		}
	}


	public String toString(){
		if(img == null){
			load();
		}


		return Integer.toString(x)+
				","+Integer.toString(y)+","+
				id+","+Integer.toString(place%getAnim().length)+
				","+Integer.toString(type)+","+Integer.toString(flipX)+
				","+Integer.toString(flipY)+","+Integer.toString(angle)+","+Integer.toString(Client.ii)+","+Integer.toString(Client.awfcX)+","+Integer.toString(Client.wasYscrolled)+","+Integer.toString(from);

	}

	public void load(){
		String[][] animation = images[type];
		place = place % getAnim().length;
		String[] frame = animation[place];
		if(play){
			if(delay == 0) {
				place += 1;
				place = place % getAnim().length;
				frame = animation[place];
				delay = Integer.parseInt(frame[1]);
			}else{
				delay  -= 1;
			}
		}
		String image = frame[0];
		img = new ImageIcon(image).getImage();
		if(!alreadyScaled) {
			w = img.getWidth(null);
			h = img.getHeight(null);
		}


	}
	public void update(Graphics g){}

	public boolean vis = true;
	public void paint(Graphics g){
		if(vis){
		load();
		if(toSprites){
			Client.sendSprites.add(this);
		}
		assert img != null && w > 0 && h > 0;
		hitBox = new Rectangle2D.Float(x,y,w,h);
		left = new Line2D.Float(x,y,x,y+h);
		right = new Line2D.Float(x+w,y,x+w,y+h);
		up = new Line2D.Float(x,y,x+w,y);
		down = new Line2D.Float(x,y+h,x+w,y+h);
		int moveX = 0,moveY=0;
		if(flipX == -1){
		    moveX = w;
        }
        if(flipY == -1){
            moveY = h;
        }
			update(g);
        //getX() < 800 && getX() > 0 && getY() < 600 && getY() > 0) {
			double rotationRequired = Math.toRadians(angle);
			double locationX = img.getWidth(null) / 2;
			double locationY = img.getHeight(null) / 2;
			AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);


			Graphics2D g2d = (Graphics2D) g;

			AffineTransform old = g2d.getTransform();
			g2d.rotate(Math.toRadians(angle), x + w / 2, y + h / 2);
			if(vis) {
				g.drawImage(img, x + moveX + x2, y + moveY + y2, w * flipX, h * flipY, null);
				update(g);
			}
			g2d.setTransform(old);
			g.setColor(Color.RED);
			g.setFont(new Font("monospaced", Font.BOLD, 20));
			//g.drawString(Integer.toString(x) + "," + Integer.toString(y), x, y - 20);
		}

	}



}
