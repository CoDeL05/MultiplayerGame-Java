package engine.game;

import java.awt.Graphics;
import java.util.LinkedList;

import engine.Image;
import engine.Sprite;
import main.Params;


public class Level {
	protected LinkedList<Sprite> sprites;
	private int lifetime = -1;
	private Image bImage ;
	public Level(LinkedList<Sprite> sprites) {
		this.sprites = sprites;
	}
	public Level(LinkedList<Sprite> sprites, int lifetime) {
		this.sprites = sprites;
		this.lifetime = lifetime;
	}
	public void backGround(String file) {

	}
	public void update(Graphics g) {
		
	}
	public void end(Graphics g) {
		
	}
	public LinkedList<Sprite> getSprites(){
		return sprites;
	}
	public void paint(Graphics g) {
		
		Thread bPainter = new Thread() {
			public void run() {
					bImage.paint(g);
			}
		};
		bPainter.run();
		
		if(lifetime == 0) {
			end(g);
		}
		lifetime -= 1;
		
		Thread spPainter = new Thread() {
			public void run() {
				for(Sprite s : sprites) {
					s.paint(g);
				}
			}
		};
		spPainter.run();
		
	}

}
