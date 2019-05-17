package engine;

import main.KeyBoard;
import main.Params;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Images {

    private int place=0;
    private int flipX=1;
    private int standardDelay = 4,delay=0;

    public int getFlipX() {
        return flipX;
    }

    public void setFlipX(int flipX) {
        this.flipX = flipX;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    private int angle;
    private boolean play=false;

    public void resume(){
        play = true;
    }
    public void stop(){
        play = false;
    }

    private class Image{
        private ImageIcon icon;
        private java.awt.Image img;

        public int getFx() {
            return fx;
        }

        public void setFx(int fx) {
            this.fx = fx;
        }

        private int fx=1;
        public int getW() {
            w=  img.getWidth(null);
            return w;
        }

        private int w;

        public int getH() {
            h = img.getHeight(null);
            return h;
        }

        private int h;

        public String getPth() {
            return pth;
        }

        private String pth;
        public Image(String pth,int w, int h){
            this.pth=pth;
            this.w=w;
            this.h=h;

            icon = new ImageIcon(pth);
            img = icon.getImage();
            w = img.getWidth(null);
            h = img.getHeight(null);

        }

        public void paint(Graphics g){

            g.drawImage(img,x,y,getW()*fx,getH(),null);
        }
    }

    private ArrayList<Image> images = new ArrayList<Image>();

    public int getX() {
        return x;
    }

    private int x;

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int y;

    public int getW() {
        place = place % images.size();
        return images.get(place).getW();
    }

    private int w;

    public int getH() {
        place = place % images.size();
        return images.get(place).getH();
    }

    private int h;
    public Images(int x, int y, String... imgs){
        this.x=x;
        this.y=y;

        for(String img : imgs){
            images.add(new Image(img,x,y));
        }

    }
    public Images(int x, int y, int delay, String... imgs){
        this.x=x;
        this.y=y;

        standardDelay = delay;

        for(String img : imgs){
            images.add(new Image(img,x,y));
        }

    }
    public void paint(Graphics g){
            place = place % images.size();
            Image img = images.get(place);
            img.setFx(flipX);
            img.paint(g);
            if(play && delay <= 0){
                place += 1;
                delay = standardDelay;
            }
            delay -= 1;
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jf = new JFrame();
                jf.setSize(400,300);
                jf.setTitle("test");
                jf.setVisible(true);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Images ims = new Images(100,100, Params.DEFAULTPATH+"assets//palawlapie1.png",Params.DEFAULTPATH+"assets//palawlapie2.png",Params.DEFAULTPATH+"assets//palawlapie3.png",Params.DEFAULTPATH+"assets//palawlapie4.png",Params.DEFAULTPATH+"assets//palawlapie5.png",Params.DEFAULTPATH+"assets//palawlapie6.png");

                Container cp = jf.getContentPane();
                cp.add(new JPanel(){
                    public void paint(Graphics g){
                        ims.paint(g);
                    }
                });

                KeyBoard kb = new KeyBoard();
                jf.addKeyListener(kb);

                ActionListener updateTask = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jf.repaint();
                        if(KeyBoard.isPressed(KeyEvent.VK_SPACE)){
                            ims.resume();
                        }else{
                            ims.stop();
                        }
                    }
                };
                new Timer(50,updateTask).start();

            }
        });



    }

}
