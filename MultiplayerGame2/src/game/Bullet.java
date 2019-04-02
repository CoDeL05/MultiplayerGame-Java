package game;

import engine.Sprite;
import main.Params;
import multiplayer.Client;

import java.awt.*;

public class Bullet extends Sprite {

    private int speed = 0;
    private int life = 100;
    public int old = 0;
    public Bullet(int x, int y, int speed,int angle,boolean send){
        super(x,y,new String[][][]{
                {
                        {Params.DEFAULTPATH+"assets\\bullet.png","16"},
                }
        },send);
        this.angle = angle+90;

        id = "bullet";


    }

    @Override
    public void update(Graphics graphics)
    {

    }

}
