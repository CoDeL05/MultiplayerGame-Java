package engine;

import game.Bullet;
import main.Pair;
import multiplayer.Client;

import java.awt.*;
import java.awt.Image;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
public class LineOfTerrain {

    private int x,y,w,h,texW,texH,thickness=3;

    private Polygon shape;
    private int[][] points;
    private int[] xpoints,ypoints,xpoints2,ypoints2;
    private int minx,miny,maxx,maxy;
    private Image tex;
    private ImageIcon ii ;
    private String path;
    private BufferedImage bufferedImage;



    /*The inner texture*/
    private int w2,h2;
    private String path2;
    private BufferedImage innerTexture;
    private Image tex2;
    private ImageIcon ii2;
    boolean posDone = false;
    private ArrayList<Line2D.Float> lines = new ArrayList<Line2D.Float>(), linesAbs = new ArrayList<>();
    public int xOff = 0;
    public int yOff = 0;
    public LineOfTerrain(int x, int y,int[][] ps,String path,int thickness,String path2) {
        this.x = x;
        this.y = y;
        this.thickness = thickness;
        this.points = ps;
        this.path = path;
        ii = new ImageIcon(path);
        tex = ii.getImage();
        texW = tex.getWidth(null);
        texH = tex.getHeight(null);
        xpoints = new int[points.length];
        ypoints = new int[points.length];
        xpoints2 = new int[points.length];
        ypoints2 = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            xpoints[i] = points[i][0];
            ypoints[i] = points[i][1];
            xpoints2[i] = points[i][0];
            ypoints2[i] = points[i][1];
            minx = Math.min(xpoints[i], minx);
            maxx = Math.max(xpoints[i], maxx);
            miny = Math.min(ypoints[i], miny);
            maxy = Math.max(ypoints[i], maxy);
        }

        shape = new Polygon(xpoints, ypoints, points.length);

        int xPoly[] = xpoints;
        int yPoly[] = ypoints;

        shape = new Polygon(xPoly, yPoly, xPoly.length);
        bufferedImage = getLineWithTexture();


        this.path2 = path2;
        this.ii2 = new ImageIcon(path2);
        this.tex2 = ii2.getImage();
        this.w2 = tex2.getWidth(null);
        this.h2 = tex2.getHeight(null);
        setPoly();
        innerTexture = getInnerTexture();

    }
    public LineOfTerrain(int x, int y,int[][] ps,String path,int thickness) {
        this.x = x;
        this.y = y;
        this.thickness = thickness;
        this.points = ps;
        this.path = path;
        ii = new ImageIcon(path);
        tex = ii.getImage();
        texW = tex.getWidth(null);
        texH = tex.getHeight(null);
        xpoints = new int[points.length];
        ypoints = new int[points.length];
        xpoints2 = new int[points.length];
        ypoints2 = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            xpoints[i] = points[i][0];
            ypoints[i] = points[i][1];
            xpoints2[i] = points[i][0];
            ypoints2[i] = points[i][1];
            minx = Math.min(xpoints[i], minx);
            maxx = Math.max(xpoints[i], maxx);
            miny = Math.min(ypoints[i], miny);
            maxy = Math.max(ypoints[i], maxy);
        }

        shape = new Polygon(xpoints, ypoints, points.length);

        int xPoly[] = xpoints;
        int yPoly[] = ypoints;

        shape = new Polygon(xPoly, yPoly, xPoly.length);
        bufferedImage = getLineWithTexture();
        setPoly();
    }

    private void setPoly(){
        for(int i = 0;i<ypoints2.length;i++){

            ypoints2[i] += Math.abs(miny);

        }
    }

    public LineOfTerrain(int x, int y,int[][] ps,String path){
        this.x=x;
        this.y=y;
        this.points = ps;
        this.path = path;
        ii = new ImageIcon(path);
        tex = ii.getImage();
        texW = tex.getWidth(null);
        texH = tex.getHeight(null);
        xpoints = new int[points.length];
        ypoints = new int[points.length];
        xpoints2 = new int[points.length];
        ypoints2 = new int[points.length];
        for(int i =0;i<points.length;i++){
            xpoints[i] = points[i][0];
            ypoints[i] = points[i][1];
            xpoints2[i] = points[i][0];
            ypoints2[i] = points[i][1];
            minx = Math.min(xpoints[i],minx);
            maxx = Math.max(xpoints[i],maxx);
            miny = Math.min(ypoints[i],miny);
            maxy = Math.max(ypoints[i],maxy);
        }

        bufferedImage = getLineWithTexture();
        setPoly();
    }
    public LineOfTerrain(int x, int y,int[][] ps,String path,String path2){
        this.x=x;
        this.y=y;
        this.points = ps;
        this.path = path;
        ii = new ImageIcon(path);
        tex = ii.getImage();
        texW = tex.getWidth(null);
        texH = tex.getHeight(null);
        xpoints = new int[points.length];
        ypoints = new int[points.length];
        xpoints2 = new int[points.length];
        ypoints2 = new int[points.length];

        for(int i =0;i<points.length;i++){
            xpoints[i] = points[i][0];
            ypoints[i] = points[i][1];
            xpoints2[i] = points[i][0];
            ypoints2[i] = points[i][1];
            minx = Math.min(xpoints[i],minx);
            maxx = Math.max(xpoints[i],maxx);
            miny = Math.min(ypoints[i],miny);
            maxy = Math.max(ypoints[i],maxy);
        }
        bufferedImage = getLineWithTexture();


        this.path2 = path2;
        this.ii2 = new ImageIcon(path2);
        this.tex2 = ii2.getImage();
        this.w2 = tex2.getWidth(null);
        this.h2 = tex2.getHeight(null);
        setPoly();
        innerTexture = getInnerTexture();

    }

    @Deprecated // for now , the method is not yet finished
    public void setX(int x){
        this.x = x;
    }
    @Deprecated // for now , the method is not yet finished
    public void setY(int y){
        this.y = y;
    }

    public void addX(int x){
        this.x += x;
        for(Line2D l2 : linesAbs){
            l2.setLine(l2.getX1()+x,l2.getY1(),l2.getX2()+x,l2.getY2());
        }
    }
    public void addY(int y){
        this.y += y;
        for(Line2D l2 : linesAbs){
            l2.setLine(l2.getX1(),l2.getY1()+y,l2.getX2(),l2.getY2()+y);
        }
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public ArrayList<Line2D.Float> getLines(){
        return lines;
    }

    public ArrayList<Line2D.Float> getLinesAbs(){
        return linesAbs;
    }

    public BufferedImage getInnerTexture(){


        BufferedImage texture = new BufferedImage(tex2.getWidth(null),tex2.getHeight(null),BufferedImage.TYPE_INT_ARGB);
        Graphics gg = texture.getGraphics();
        gg.drawImage(tex2,0,0,null);


         BufferedImage toReturn = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        Graphics g = toReturn.getGraphics();
        Graphics2D g2d =(Graphics2D)g;
        g2d.setColor(Color.GREEN);
        g2d.fill(new Polygon(xpoints2,ypoints2,xpoints.length));
        for(int i =0;i<w*3;i++){
            for(int j =0;j<h*3;j++){
                if(toReturn.getRGB(i%(w),j%(h)) == Color.GREEN.getRGB()){

                    g2d.setColor(new Color(texture.getRGB(i%w2,j%h2)));
                    g2d.fillRect(i,j,1,1);
                }
            }
        }


        return toReturn;

    }






    public BufferedImage getLineWithTexture(){

        w = (maxx-minx);
        h = (maxy-miny);
        ii = new ImageIcon(path);
        tex = ii.getImage();
        texW = tex.getWidth(null);
        texH = tex.getHeight(null);
        BufferedImage image = new BufferedImage((int)(w*2),(int)(h*2),BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        Graphics2D g2d = ((Graphics2D)g);
        int xPoly[] = xpoints;
        for(int i = 0;i<xPoly.length;i++){
            xPoly[i] += (maxx-minx);
        }
        int yPoly[] = ypoints;
        for(int i = 0;i<xPoly.length;i++){
            yPoly[i] += (maxy-miny);
        }

        shape = new Polygon(xPoly, yPoly, xPoly.length);

        g2d.setColor(Color.GREEN);
        g2d.setStroke(new BasicStroke(thickness));
        //xpoints.length];
        for(int i = 0 ;i<xpoints.length-1;i++){
            lines.add(new Line2D.Float(xpoints[i]-maxx,ypoints[i]-maxy,xpoints[i+1]-maxx,ypoints[i+1]-maxy));
            linesAbs.add(new Line2D.Float(x+xpoints[i]-maxx,y+ypoints[i]-maxy-thickness/2,x+xpoints[i+1]-maxx,y+ypoints[i+1]-maxy-thickness/2));

        }
        for(Line2D l2d : lines){
            g2d.draw(l2d);
        }
        //g2d.draw(shape);
        BufferedImage textureImage = new BufferedImage(texW,texH,BufferedImage.TYPE_INT_ARGB);
        Graphics texG = textureImage.getGraphics();
        texG.drawImage(tex,0,0,null);

        BufferedImage toReturn  = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        Graphics finalG = toReturn.getGraphics();
        int[][][] pixels = new int[w][h][3];
        for(int i = 0;i<w;i++){
            for(int j =0;j<h;j++){
                int rgb = image.getRGB(i,j);
                Color color = new Color(rgb);
                pixels[i][j][0] = color.getRed();
                pixels[i][j][1] = color.getGreen();
                pixels[i][j][2] = color.getBlue();
                if(pixels[i][j][0] == 0 && pixels[i][j][1] == 255 && pixels[i][j][2] == 0){

                    toReturn.setRGB(i,j,textureImage.getRGB(i%textureImage.getWidth(),j%textureImage.getHeight()));

                }
            }
        }

        Graphics2D finalG2d = (Graphics2D)finalG;
        finalG.drawPolygon(xPoly,yPoly,xPoly.length);





        return toReturn;
    }






    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g.drawImage(bufferedImage,x,y,w,h,null);
        g.drawImage(innerTexture,x+xOff,y+yOff,null);



    }

}



