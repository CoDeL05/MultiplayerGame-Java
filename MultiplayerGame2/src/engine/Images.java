package engine;

import java.awt.Image;
import java.util.ArrayList;

public class Images {

    private ArrayList<Image> images = new ArrayList<Image>();
    private int x,y,w,h;
    public Images(int x, int y, String... imgs){
        this.x=x;
        this.y=y;
    }

}
