package game;

import engine.Sprite;
import main.Params;
import multiplayer.Client;

import javax.swing.*;
import java.awt.*;

public class Guy extends Sprite {

    private String job = "mess_arround";
    public Color c1 = new Color(0,0,0,0);
    public Color c2 = new Color(0,0,0,0);
    private Image i1,i2;
    private String p1,p2;
    private int w1,h1,w2,h2;
    public String getJob(){
        return job;
    }

    private void setupImages(String p1, String p2){
        this.p1 = p1;
        this.p2 = p2;
        this.i1 = new ImageIcon(p1).getImage();
        this.i2 = new ImageIcon(p2).getImage();

        w1 = i1.getWidth(null);
        h1 = i1.getHeight(null);

        w2 = i2.getWidth(null);
        h2 = i2.getHeight(null);


        if(c1.getAlpha() != 0) {
            i1 = engine.Image.getFilledImage(i1, c1);
        }
        if(c2.getAlpha() != 0) {
            i2 = engine.Image.getFilledImage(i2, c2);
        }

    }


    public String getP1(){
        return p1;
    }
    public String getP2(){
        return p2;
    }

    public String toString(){
        if(img == null){
            load();
        }


        return Integer.toString(getX())+
                ","+Integer.toString(getY())+","+
                id+","+Integer.toString(place%getAnim().length)+
                ","+Integer.toString(type)+","+Integer.toString(getFlipX())+
                ","+Integer.toString(getFlipY())+","+Integer.toString(angle)+","+Integer.toString(Client.ii)+","+Integer.toString(Client.awfcX)+","+Integer.toString(Client.wasYscrolled)+","+Integer.toString(from)+","+getJob()+","+p1+","+p2+",";

    }
    public Guy(int x, int y, String jb, String p1 , String p2,boolean send){
        super(x,y,new String[][][]{
                {
                        {Params.DEFAULTPATH+"assets\\guy_head.png","16"},
                }
        },send);
        id = "guy";
        this.job = jb;
        setupImages(p1,p2);


    }

    @Override
    public void update(Graphics graphics)
    {

        graphics.drawImage(i1,getX(),getY(),null);
        graphics.drawImage(i2,getX(),getY(),null);

    }

}
