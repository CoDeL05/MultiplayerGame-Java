package startscreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.Params;

public class Label {
	private int x, y,lifetime=-1,size;
	private String text;
	private Font font = new Font("monospaced",Font.BOLD,50);
	private Color color = new Color(200,200,200);
	public Label(int x, int y, String msg) {
		this.setX(x);
		this.setY(y);
		this.setText(msg);
		setFont(font);
		setSize(font.getSize());
	}
	public Label(int x, int y, String msg,Font f) {
		this.setX(x);
		this.setY(y);
		this.setText(msg);
		this.setFont(f);
		setSize(font.getSize());
	}
	public Label(int x, int y, String msg,Font f,int lifetime) {
		this.setX(x);
		this.setY(y);
		this.setText(msg);
		this.setFont(f);
		setSize(font.getSize());
		setLifetime(lifetime);
	}
	
	public void paint(Graphics g) {
		if(lifetime != 0)
		{
		g.setFont(font);
		g.setColor(color);
		g.drawString(text, x, y);
		lifetime -= 1;
		}
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getLifetime() {
		return lifetime;
	}

	public void setLifetime(int lifetime) {
		this.lifetime = lifetime;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSize() {
		return size;
	}

	private void setSize(int size) {
		this.size = size;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

}
