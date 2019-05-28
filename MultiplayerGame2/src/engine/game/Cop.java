package engine.game;


import engine.Images;
import engine.Sprite;
import main.Pair;
import main.Params;

import java.awt.*;

public class Cop extends Sprite {
    private boolean hatOn = true;

    private Images weapon;


    private static String[][][] images = {

            {
                    {Params.DEFAULTPATH+"assets\\glina1.png","16"},
                    {Params.DEFAULTPATH+"assets\\glina1.png","16"},
                    {Params.DEFAULTPATH+"assets\\glina1.png","16"},

                    {Params.DEFAULTPATH+"assets\\glina2.png","16"},
                    {Params.DEFAULTPATH+"assets\\glina2.png","16"},
                    {Params.DEFAULTPATH+"assets\\glina1.png","16"},

                    {Params.DEFAULTPATH+"assets\\glina3.png","16"},
                    {Params.DEFAULTPATH+"assets\\glina3.png","16"},
                    {Params.DEFAULTPATH+"assets\\glina3.png","16"},

                    {Params.DEFAULTPATH+"assets\\glina2.png","16"},
                    {Params.DEFAULTPATH+"assets\\glina2.png","16"},
                    {Params.DEFAULTPATH+"assets\\glina2.png","16"},


            },


    };
    public Cop(int x, int y,boolean send,int fr,int wType){

        super(x,y,images,false);
        from = fr;
        id = "cop";
        if(wType == 0){
            weapon = new Images(x,y,Params.DEFAULTPATH+"assets//palawlapie1.png",Params.DEFAULTPATH+"assets//palawlapie2.png",Params.DEFAULTPATH+"assets//palawlapie3.png",Params.DEFAULTPATH+"assets//palawlapie4.png",Params.DEFAULTPATH+"assets//palawlapie5.png",Params.DEFAULTPATH+"assets//palawlapie6.png");

        }
        setFlipX(-1);
    }
    
    public void update(Graphics g){
        try {
            Pair<Integer,Integer> typeToPos[] = new Pair[]{new Pair<>((getW()-25)*getFlipX(),4)};
            int mr =  getFlipX() == -1 ? weapon.getW()/2+3: 0;
            weapon.setX(getX()+typeToPos[type].getFirst()+mr);
            weapon.setY(getY()+typeToPos[type].getSecond());
            weapon.setFlipX(getFlipX());

            weapon.paint(g);


        }catch(NullPointerException e){}

    }

}
