package game;


import engine.Sprite;
import main.Params;

import java.awt.*;

public class Cop extends Sprite {
    private boolean hatOn = true;




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
    public Cop(int x, int y,boolean send,int fr){

        super(x,y,images,false);
        from = fr;
        id = "cop";
    }
    public void update(Graphics g){


    }

}
