package game;


import engine.Sprite;
import main.Params;

import java.awt.*;
import java.util.ArrayList;
public class Player extends Sprite {
    private boolean hatOn = true;
    public static ArrayList<Bullet> bullets = new ArrayList<Bullet>();

    public static ArrayList<Bullet> bulletsToRemove = new ArrayList<>();



    public void cleanBullets(){

    }

    private static String[][][] images = {

                    {
                            {Params.DEFAULTPATH+"assets\\playerNoHat1.png","16"},
                            {Params.DEFAULTPATH+"assets\\playerNoHat1.png","16"},
                            {Params.DEFAULTPATH+"assets\\playerNoHat1.png","16"},

                            {Params.DEFAULTPATH+"assets\\playerNoHat2.png","16"},
                            {Params.DEFAULTPATH+"assets\\playerNoHat2.png","16"},
                            {Params.DEFAULTPATH+"assets\\playerNoHat2.png","16"},

                            {Params.DEFAULTPATH+"assets\\playerNoHat3.png","16"},
                            {Params.DEFAULTPATH+"assets\\playerNoHat3.png","16"},
                            {Params.DEFAULTPATH+"assets\\playerNoHat3.png","16"},

                            {Params.DEFAULTPATH+"assets\\playerNoHat4.png","16"},
                            {Params.DEFAULTPATH+"assets\\playerNoHat4.png","16"},
                            {Params.DEFAULTPATH+"assets\\playerNoHat4.png","16"},


                    },
                    {
                            {Params.DEFAULTPATH+"assets\\playerWithHat1.png","16"},
                            {Params.DEFAULTPATH+"assets\\playerWithHat1.png","16"},
                            {Params.DEFAULTPATH+"assets\\playerWithHat1.png","16"},

                            {Params.DEFAULTPATH+"assets\\playerWithHat2.png","16"},
                            {Params.DEFAULTPATH+"assets\\playerWithHat2.png","16"},
                            {Params.DEFAULTPATH+"assets\\playerWithHat2.png","16"},

                            {Params.DEFAULTPATH+"assets\\playerWithHat3.png","16"},
                            {Params.DEFAULTPATH+"assets\\playerWithHat3.png","16"},
                            {Params.DEFAULTPATH+"assets\\playerWithHat3.png","16"},

                            {Params.DEFAULTPATH+"assets\\playerWithHat4.png","16"},
                            {Params.DEFAULTPATH+"assets\\playerWithHat4.png","16"},
                            {Params.DEFAULTPATH+"assets\\playerWithHat4.png","16"},


                    },

    };
    public Player(int x, int y,boolean send){

        super(x,y,images,send);
        id = "player";
    }
    public void update(Graphics g){
        if(hatOn){
            type=1;
        }else{
            type=0;
        }

    }

}
