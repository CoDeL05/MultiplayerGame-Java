package multiplayer;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import java.io.PrintWriter;

import java.net.Socket;

import java.util.*;


import java.awt.event.KeyEvent;
import java.util.List;

import engine.Image;
import engine.LineOfTerrain;
import engine.Sprite;

import engine.game.Cop;
import game.Bullet;
import game.Guy;
import game.Player;
import main.*;

public class Client {


    public static int wasYscrolled = 0;
    private static int fDy = 0;
    public static int absY = 0;
    public static int DEATHS=0,KILLS=0;
    public static int WEAPON_TYPE = 1;

    private static ArrayList<Cop> cops = new ArrayList<Cop>();
    static{

        for(int i =0;i<4;i++){
            cops.add(new Cop(new Random().nextInt(3000),300,false,-2,0));
        }

    }


    private static ArrayList<Cop> myCops = new ArrayList<>();

    static Socket socket=null;
    public static int ii = new Random().nextInt(10909);

    public static int awfcX = 0,awfcY=0;

    private static ArrayList<Sprite> spritesToClean = new ArrayList();

    public static void removeSprite(Sprite s ){
        spritesToClean.add(s);
    }

    private static int shootInterval = Params.bulletTypeToPars.get(WEAPON_TYPE).get().get(3);

    private static int PLAYERHP = 100000;

    private static ArrayList<Sprite> spritesSentOnce = new ArrayList<Sprite>();

    public static ArrayList<LineOfTerrain> terrains = new ArrayList<LineOfTerrain>();

    public static ArrayList<String> importantIDs = new ArrayList<String>(Arrays.asList(new String[]{
            "player",
            "bullet"
    }));

    static int framesMade = 0;



    static LineOfTerrain line1 = new LineOfTerrain(0,0,new int[][]{
            {24,165},{50,167},{49,244},{61,244},{61,399},{59,400},{89,436},{121,428},{149,419},{173,407},{190,398},{227,398},{270,392},{296,383},{306,387},{351,390},{352,389},{379,389},{405,410},{433,422},{477,434},{498,438},{514,431},{533,413},{534,413},{569,413},{594,405},{629,399},{662,382},{694,374},{718,371},{748,379},{782,393},{801,396},{829,413},{857,427},{884,421},{921,416},{956,409},{981,397},{1033,395},{1075,382},{1142,400},{1173,406},{1195,401},{1217,389},{1243,378},{1260,369},{1283,351},{1306,329},{1323,311},{1347,279},{1366,252},{1389,230},{1412,215},{1444,196},{1462,194},{1481,195},{1505,207},{1525,227},{1547,255},{1572,278},{1592,296},{1605,315},{1622,331},{1648,348},{1680,362},{1726,385},{1775,402},{1833,430},{1866,453},{1921,479},{1952,478},{1982,488},{2020,491},{2055,491},{2086,506},{2131,509},{2180,489},{2210,494},{2236,512},{2237,513},{2259,512},{2287,501},{2290,495},{2323,493},{2352,508},{2381,509},{2406,506},{2428,486},{2448,475},{2470,459},{2482,445},{2495,421},{2518,384},{2552,366},{2590,350},{2620,342},{2636,317},{2654,307},{2670,297},{2706,304},{2725,313},{2762,344},{2780,387},{2805,414},{2825,452},{2858,479},{2885,501},{2922,501},{2963,507},{2983,510},{3022,512},{3054,506},{3107,503},{3134,497},{3167,508},{3172,499},{3186,495},{3209,489},{3225,486},{3257,489},{3282,495},{3321,511},{3336,514},{3397,516},{3428,512},{3470,506},{3500,497},{3541,498},{3574,501},{3599,507},{3635,504},{3676,528},{3687,539},{3687,573},{3688,574},{3660,597},{3600,647},{3533,677},{3532,697},{3483,697},{3482,684},{3480,683},{3443,682},{3442,672},{3439,672},{3375,671},{3318,666},{3231,658},{3129,677},{3108,693},{3011,717},{2986,733},{2987,774},{2902,835},{2845,895},{2803,933},{2723,978},{2695,1005},{2671,1023},{2608,1021},{2588,1065},{2588,1121},{2592,1122},{2598,1161},{2639,1195},{2706,1224},{2770,1249},{2828,1249},{2916,1239},{2974,1236},{3053,1244},{3093,1244},{3137,1244},{3168,1237},{3197,1247},{3222,1247},{3237,1251},{3254,1244},{3281,1242},{3296,1236},{3310,1223},{3326,1218},{3337,1205},{3353,1192},{3380,1184},{3381,1170},{3401,1169},{3417,1160},{3438,1150},{3456,1129},{3469,1115},{3509,1093},{3542,1043},{3568,1025},{3579,1009},{3589,997},{3608,975},{3622,955},{3646,944},{3692,929},{3741,911},{3800,889},{3842,869},{3892,842},{3934,826},{3968,808},{3992,792},{4019,775},{4048,749},{4064,723},{4102,655},{4132,623},{4156,594},{4213,569},{4250,559},{4251,562},{4303,562},{4305,573},{4345,574},{4346,579},{4379,579},{4381,576},{4411,593},{4438,606},{4472,624},{4520,670},{4567,696},{4604,747},{4627,777},{4641,793},{4664,800},{4664,805},{4726,806},{4727,809},{4748,809},{4756,807},{4801,798},{4863,805},{4914,797},{4964,801},{4997,774},{5047,760},{5048,688},{5050,491},{5111,490},{5152,498},{5224,658},{5223,701},{5204,702},{5208,784},{5207,814},{5204,864},{5204,903},{5082,1027},{4818,1070},{4173,1159},{3959,1145},{3958,1214},{3515,1213},{3290,1498},{3037,1624},{2867,1576},{2572,1563},{2261,1577},{2232,1323},{2110,1047},{2018,969},{1757,952},{1576,764},{1457,710},{1456,647},{1397,646},{1411,607},{1359,512},{1301,451},{1256,523},{1257,586},{1146,611},{805,620},{634,594},{277,538},{5,589},{2,598},{6,177},{24,165}

    }, Params.DEFAULTPATH+"assets\\grass.png",22,Params.DEFAULTPATH+"assets\\dirt.png");
    static LineOfTerrain line2 = new LineOfTerrain(200,0,new int[][]{{0,0},{80,-30},{100,-45},{140,-45},{150,20},{160,40},{140,50},{120,80},{90,80},{70,70},{50,50},{40,50},{40,40},{30,20}}, Params.DEFAULTPATH+"assets\\bricks.png",22,Params.DEFAULTPATH+"assets\\stone.png");
    static LineOfTerrain line3 = new LineOfTerrain(0,0,new int[][]{
            {1100,8},{1070,68},{1070,67},{978,82},{978,83},{976,82},{917,59},{911,58},{907,57},{906,56},{858,-1},{891,-48},{890,-48},{920,-80},{919,-80},{966,-100},{966,-99},{1005,-119},{1006,-119},{1007,-119},{1048,-92},{1052,-90},{1054,-89},{1114,-82},{1114,-83},{1115,-82},{1116,-82},{1132,-80},{1133,-80},{1134,-79},{1135,-79},{1119,1},{1119,0},{1102,21},{1102,20},{1101,20},{1090,22},{1091,22},{1100,8}

    }, Params.DEFAULTPATH+"assets\\grass.png",22,Params.DEFAULTPATH+"assets\\dirt.png");
    static LineOfTerrain line4 = new LineOfTerrain(-1500,-350,new int[][]{
            {2466,229},{2578,315},{2339,271},{2204,323},{2083,347},{1980,302},{1981,302},{1955,254},{1955,255},{1975,210},{1974,210},{1975,209},{1990,150},{1989,150},{2047,108},{2046,108},{2098,87},{2097,88},{2214,69},{2213,69},{2373,86},{2416,76},{2416,75},{2417,75},{2485,85},{2489,85},{2493,86},{2561,91},{2561,90},{2655,98},{2751,97},{2752,97},{2807,66},{2831,80},{2834,82},{2895,126},{3010,115},{3012,116},{3016,117},{3138,116},{3195,126},{3195,127},{3230,141},{3230,142},{3250,149},{3270,155},{3274,156},{3276,157},{3380,136},{3421,79},{3424,77},{3427,73},{3497,39},{3498,39},{3544,12},{3544,11},{3607,-18},{3607,-19},{3687,-26},{3688,-28},{3689,-30},{3747,-20},{3746,-20},{3748,-20},{3777,9},{3777,8},{3789,78},{3842,116},{3843,117},{3900,132},{3901,132},{3902,133},{3904,133},{3956,148},{3957,147},{3986,151},{3986,150},{3987,150},{4001,184},{4002,184},{4030,203},{4031,204},{4060,211},{4061,211},{4061,212},{4114,210},{4113,209},{4160,222},{4187,249},{4186,248},{4178,303},{4178,313},{4178,315},{4109,321},{4103,322},{4101,322},{3977,312},{3969,314},{3967,314},{3886,344},{3887,344},{3749,339},{3736,339},{3730,339},{3724,339},{3646,335},{3640,335},{3637,335},{3513,308},{3512,308},{3470,293},{3228,311},{3186,290},{3185,290},{2959,308},{2959,307},{2923,343},{2924,343},{2800,332},{2728,343},{2466,229}

    }, Params.DEFAULTPATH+"assets\\bricks.png",22,Params.DEFAULTPATH+"assets\\stone.png");
    static LineOfTerrain fakeLine ;
    static boolean scrollX = false;
    static String tp = "player";

    static PrintWriter out=null;
    static Scanner in=null ;
    static int frame = 0;

    public static ArrayList<Sprite> spritesList = new ArrayList<Sprite>(2);
    static Sprite s1;

    public static ArrayList<Sprite> sendSprites = new ArrayList<Sprite>();

    static int x= new Random().nextInt(800);

    public static KeyBoard kb;
    public static Mouse ms ;

    private static String copMes = "";

    private static ArrayList<Sprite> blocks = new ArrayList<>();

    static Guy g1 = new Guy(200,100,"mess_around",Params.DEFAULTPATH+"assets\\hoodie2.png",Params.DEFAULTPATH+"assets\\jeans.png",false);

    static boolean jump = false;
    private static int shootDelay=0;

    public static ArrayList<String> localIds = new ArrayList<String>(Arrays.asList(new String[]{"player","bullet"}));


    static int Dx=0;
    static Image night = new Image(0,0,Params.DEFAULTPATH+"assets\\night.png",0.5);
    static Image day = new Image(0,0,Params.DEFAULTPATH+"assets\\day.png",0.5);
    /**
     * Main elements of the game's mechanics**/
    static int YY = 164;
    static Player player2 = null;


    private static void readBlocks(String[][] par){
        for(String[] bl : par){
            int x = Integer.parseInt(bl[0]);
            int y = Integer.parseInt(bl[1]);
            String img = Params.DEFAULTPATH+"assets\\"+bl[2];
            blocks.add(new Sprite(x,y,new String[][][]{{{img}}},false));
        }
    }



    static class Terrain{

        private int x=0,y=0;


        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public void setX(int x){
            this.x=x;
        }
        public void setY(int y){
            this.y=y;
        }
        public void addX(int x){
            this.x += x;
        }
        public void addY(int y){
            this.y += y;
        }



        private static void controlCops(Graphics g){
            for(Cop c: cops){
                c.paint(g);
                c.update(g);
                c.place += 1;
                System.out.println(c.place);
                if(Math.abs(c.getX() - s1.getX()) < 400 && Math.abs(c.getY()-s1.getY()) < 200){


                }
            }
        }

        public void paint(Graphics g){
            framesMade += 1;

            Graphics2D g2d = (Graphics2D)g;

            AffineTransform at = AffineTransform.getTranslateInstance(x,y);
            AffineTransform at2 = AffineTransform.getTranslateInstance(0,0);
            g2d.setTransform(at);
            for(Sprite s : blocks){
                s.paint(g);
            }

            controlCops(g);

            //c.paint(g);

            for(Sprite s : spritesList) {

                if(localIds.contains(s.getId())) {

                    if(!(localIds.contains(s.getId()) && s.from == Client.ii)){
                        s.paint(g);

                    }


                }

            }

            paintBoxes(g,true);



            g2d.setTransform(at2);
        }

        public Terrain(){

        }
        public Terrain(int x, int y){
            setX(x);
            setY(y);
            readBlocks(new String[][]{{"2154","402","hardwareStore.png"},{"1997","453","grass_block.png"},{"2041","454","grass_block.png"},{"1918","447","grass_block.png"},{"2583","313","grass_block.png"},{"2680","266","grass_block.png"},{"2540","332","grass_block.png"},{"2371","454","bush2.png"},{"2890","446","bush2.png"},{"2985","459","bush2.png"},{"2890","426","bush1.png"},{"2890","406","bush1.png"},{"2986","435","bush1.png"},{"2890","384","bush1.png"},{"2987","416","bush1.png"},{"3073","449","bush2.png"},{"2952","470","grass_block.png"},{"3246","458","grass_block.png"},{"3354","478","grass_block.png"},{"3424","477","grass_block.png"},{"3557","468","grass_block.png"},{"3181","451","grass_block.png"},{"3631","472","grass_block.png"},{"3587","470","grass_block.png"},{"3653","490","grass_block.png"},{"3523","473","grass_block.png"},{"3491","471","grass_block.png"},{"3459","474","grass_block.png"},{"3667","511","grass_block.png"},{"3673","537","grass_block.png"},{"3951","772","grass_block.png"},{"3998","746","grass_block.png"},{"4034","715","grass_block.png"},{"3905","790","grass_block.png"},{"3930","784","grass_block.png"},{"3975","759","grass_block.png"},{"4009","728","grass_block.png"},{"4054","693","grass_block.png"},{"3884","808","grass_block.png"},{"3846","826","grass_block.png"},{"3867","824","grass_block.png"},{"4066","688","grass_block.png"},{"4074","658","grass_block.png"},{"4096","641","grass_block.png"},{"4108","630","grass_block.png"},{"4120","599","grass_block.png"},{"4133","578","grass_block.png"},{"3830","842","grass_block.png"},{"3802","849","grass_block.png"},{"3762","860","grass_block.png"},{"3735","871","grass_block.png"},{"3683","894","grass_block.png"},{"3703","881","grass_block.png"},{"3661","901","grass_block.png"},{"3645","912","grass_block.png"},{"3626","920","grass_block.png"},{"4155","561","grass_block.png"},{"4180","546","grass_block.png"},{"4195","522","bush1.png"},{"4353","532","bush1.png"},{"4251","519","bush2.png"},{"4724","753","bush2.png"},{"4821","752","bush2.png"},{"4912","750","bush2.png"},{"4301","526","bush2.png"},{"4193","502","bush1.png"},{"4249","501","bush1.png"},{"4297","505","bush1.png"},{"4353","511","bush1.png"},{"4194","481","bush1.png"},{"4251","484","bush1.png"},{"4297","484","bush1.png"},{"4355","490","bush1.png"},{"4356","470","bush1.png"},{"4415","558","bush1.png"},{"4477","599","bush1.png"},{"4540","644","bush1.png"},{"961","345","truck.png"},{"1085","347","truck.png"},{"3820","487","arrow_down.png"},{"3902","484","arrow_down.png"},{"3978","481","arrow_down.png"},{"3820","487","arrow_down.png"},{"1948","440","bush2.png"},{"2012","443","bush2.png"},{"1948","419","bush1.png"},{"2009","423","bush1.png"},{"2009","401","bush1.png"},{"2012","380","bush1.png"},{"1950","399","bush1.png"},{"1950","378","bush1.png"},{"1890","427","bush1.png"},{"2402","436","bush1.png"},{"2426","413","bush1.png"},{"2427","395","bush1.png"},{"2371","433","bush1.png"},{"2403","410","bush1.png"},{"2428","376","bush1.png"},{"2366","414","bush1.png"},{"2333","455","bush1.png"},{"291","335","truck.png"}});
            //new String[][]{{"1656","427","bush2.png"},{"1697","431","bush2.png"},{"2146","447","bush2.png"},{"2193","449","bush2.png"},{"1743","451","grass_block.png"},{"1763","451","grass_block.png"},{"2064","439","guy.png"},{"1799","372","hardwareStore.png"},{"1951","433","bricks.png"},{"1950","404","bricks.png"},{"1948","372","bricks.png"},{"1982","439","bricks.png"},{"1982","409","bricks.png"}});
        }

    }

    private static boolean jpd = false;


    private static void handleOnceSent(Graphics g){
        for(Sprite s : spritesSentOnce){
            s.paint(g);
        }
    }

    private static void handleNPCS(Graphics g){

       // g1.paint(g);
    }

    static Terrain t;
    private static void setupTerrain()
    {
         t = new Terrain(0,0);
         line1.xOff = 0;
         terrains.add(line1);
         terrains.add(line2);
         terrains.add(line3);
        terrains.add(line4);

    }

    private static void handleNightAndDay(Graphics g){
        day.paint(g);
        night.paint(g);
        double a = (double)(Params.TIME%24)/24;

        day.setAlpha(a);
        night.setAlpha(1-a);
    }


    static int dy = 0;
    static boolean sy = false;


    private static void cleanup(){

        Player.bullets.removeAll(Player.bulletsToRemove);
        Player.bulletsToRemove.clear();

        Client.spritesList.removeAll(Client.spritesToClean);
        Client.sendSprites.removeAll(Client.spritesToClean);
        Client.spritesToClean.clear();
        cops.clear();
        //System.out.println("Number of players or size of 'pBoxes': "+Integer.toString(pBoxes.size()));

    }

    private static void controlPlayer(Graphics g) {

        if (s1.getX() < Params.SCROOLBORDER_X || s1.getX() > 800 - Params.SCROOLBORDER_X) {
            scrollX = true;
        }

        if(s1.getY() <= 100 || s1.getY() >= 434){
            sy = true;
            if(s1.getY() <= 100 && dy > 0){
                sy = false;
            }
            if(s1.getY() >= 434 && dy < 0){
                sy = false;
            }


        }else{
            sy = false;
        }
        if(dy < 7)
        {
            if(frame % 5 == 0) {
                dy += 1;
            }
            if(sy == false) {
                s1.addY(dy);
                absY += dy;
            }else{

                t.addY(-dy);
                for(LineOfTerrain l1 : terrains) {
                    l1.addY(-dy);
                }
                wasYscrolled += dy;
                absY += dy;

            }
        }
        else {
            if(sy == false) {
                s1.addY(7);

                absY += 7;
            }else{
                absY += 7;
                wasYscrolled += 7;
                t.addY(-7);
                for(LineOfTerrain l1 : terrains) {
                    l1.addY(-7);

                }
            }
        }


        //if(KeyBoard.isPressed(KeyEvent.VK_RIGHT) || KeyBoard.isPressed(KeyEvent.VK_LEFT)){}
        //else{
        if(KeyBoard.isPressed(KeyEvent.VK_UP) && jump) {
            dy = -6;
            s1.addY(-10);
            jump = false;
            s1.addY(-5);
            if (s1.getY() > 434) {
                sy = false;
            }
            jpd = true;

        }
       // }}

        if(dy > 0){
            jpd = false;
        }

        //((Graphics2D)g).draw(new Rectangle2D.Float(b.getX(),b.getY(),16,8));

        for (LineOfTerrain l1 : terrains)
        {
            for (Line2D l2d : l1.getLinesAbs()) {


               for(Bullet b : Player.bullets){

                        if (l2d.intersects(new Rectangle2D.Float(b.getX(), b.getY(), 16, 8)) )  {

                            spritesToClean.add(b);
                            Player.bulletsToRemove.add(b);
                            removeSprite(b);

                        }


                }
                for(Sprite s : spritesList){
                    if(s instanceof Bullet){
                        if(s.from != Client.ii){
                            if(new Rectangle2D.Float(s.getX(),s.getY(),16,8).intersects(new Rectangle2D.Float(s1.getX(),s1.getY(),32,64))){
                                PLAYERHP -= Params.bulletTypeToPars.get(s.type).get().get(0);
                                if(PLAYERHP <= 0){
                                    DEATHS += 1;
                                }
                            }
                        }
                    }
                }
                for(Bullet b : Player.bullets){
                    for(Sprite s : spritesList){
                        if(s instanceof Player){
                            if(s.from != Client.ii){
                                if(new Rectangle2D.Float(b.getX(), b.getY(), 16, 8).intersects(new Rectangle2D.Float(s.getX(),s.getY(),32,64))){
                                   b.setX(Integer.MAX_VALUE);
                                   b.setY(Integer.MAX_VALUE);
                                   //Player.bullets.remove(b);
                                    spritesToClean.add(b);
                                }
                            }
                        }
                    }
                }
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.GREEN);
                g2d.setStroke(new BasicStroke(2));
                //g2d.draw(l2d);

                Line2D adj = new Line2D.Float((float) l2d.getX1(), (float) l2d.getY2(), (float) l2d.getX2(), (float) l2d.getY2());
                g2d.setColor(Color.RED);
                //g2d.draw(adj);
                Line2D opp = new Line2D.Float((float) l2d.getX1(), (float) l2d.getY1(), (float) l2d.getX1(), (float) l2d.getY2());
                g2d.setColor(Color.YELLOW);
               // g2d.draw(opp);
                //tan(a) = adj/opp => a = atan(adj/opp)
                int adjacent = (int) (l2d.getX1() - l2d.getX2());
                int opposite = (int) (l2d.getY1() - l2d.getY2());
                int alpha = (int) (Math.atan(opposite / (adjacent * 1.0001)) * 180 / Math.PI) - 90;


                Rectangle2D rect = new Rectangle2D.Float((float) s1.getX(), (float) s1.getY(), s1.getW(), s1.getH());


                if (l2d.intersects(rect) ) {

                    if(l2d.getY1() < s1.getY() && l2d.getY2() < s1.getY()){
                        s1.addY(10);
                    }


                    if(jpd){
                        if(s1.getY() >= Math.min(l2d.getY1(),l2d.getY2())){
                            if(KeyBoard.isPressed(KeyEvent.VK_RIGHT)){
                                Dx = -6;
                                s1.addY(20);
                                dy = 5;
                            }
                            if(KeyBoard.isPressed(KeyEvent.VK_LEFT)){
                                Dx = 6;
                                s1.addY(20);
                                dy = 5;
                            }
                        }
                    }

                    if(dy > 0){
                        jump = true;
                    }

                    if(dy < 0){

                           dy = 0;
                            s1.addY(10);
                        if(KeyBoard.isPressed(KeyEvent.VK_UP)) {
                            dy = 10;
                        }

                    }
                    int II = alpha;
                    if(s1.getY() > 100) {
                        dy = 0;
                    }
                    s1.addY(-1);
                    absY -= 1;

                    Dx = -(int) ((Math.sin(Math.toRadians(II)) * Params.PLAYERSPEED));

                    if(Dx == 0 ){
                        //System.out.println("tu: "+Double.toString(l2d.getX1())+","+Double.toString(l2d.getX2()));
                        if(l2d.getX2() == l2d.getX1()){
                           // System.out.println("tu: "+Double.toString(l2d.getX1())+","+Double.toString(l2d.getX2()));
                        }
                        dy = -5;

                        if(s1.getFlipX() == 0){
                            Dx = -3;
                        }else{
                            Dx = 3;
                        }


                    }
                    if(KeyBoard.isPressed(KeyEvent.VK_LEFT)){
                        s1.addY(-3);

                        absY -= 2;
                    }
                    if(KeyBoard.isPressed(KeyEvent.VK_RIGHT)){
                        s1.addY(-3);

                        absY -= 2;
                    }
                }


            }
    }

    }
    private static void handleKeysForPlayer(){

        if(KeyBoard.isPressed(KeyEvent.VK_LEFT)){
            s1.place += 1;
            if(scrollX == false) {
                if (s1.getFlipX() == 1) {
                    s1.addX(-4);

                }
                s1.addX(-Dx);
                s1.setFlipX(-1);

            }
            else{
                if(s1.getX() > 800-Params.SCROOLBORDER_X){
                    scrollX = false;
                    s1.addX(-Params.PLAYERSPEED);
                }
            }
        }

        if(KeyBoard.isPressed(KeyEvent.VK_RIGHT)){
            s1.place += 1;
            if(scrollX == false) {
                if (s1.getFlipX() == -1) {
                    s1.addX(4);
                }
                s1.addX(Dx);
                s1.setFlipX(1);

            }
            else{
                if(s1.getX() < Params.SCROOLBORDER_X){
                    scrollX = false;
                    s1.addX(Params.PLAYERSPEED);
                }

            }
        }


        if(Mouse.isPressed(1) && shootDelay <= 0){
            shootDelay = shootInterval;
            int II = (int) (360-Math.atan2(Mouse.getY()-s1.getY(), Mouse.getX()-s1.getX())*180/Math.PI)%360;

            Bullet b = new Bullet(s1.getX(),s1.getY()+16,3,II,true);
            b.type = WEAPON_TYPE;
            Player.bullets.add(b);

        }
    }



    private static void handleTerrain(){


        if(scrollX){
            if(KeyBoard.isPressed(KeyEvent.VK_LEFT) && s1.getX() < 400){
                for(LineOfTerrain l1 : terrains) {
                    l1.addX(Dx);
                }
                t.addX(Dx);

                awfcX += -Dx;

            }

            if(KeyBoard.isPressed(KeyEvent.VK_RIGHT) && s1.getX() > 400){
                for(LineOfTerrain l1 : terrains) {
                    l1.addX(-Dx);
                }
                t.addX(-Dx);

                awfcX += Dx;

            }
        }





    }

    //private static int cops = 0;
    private static void send(){
        String toPrint = "";

        for(Sprite s : sendSprites){

            if(s.getId() == "player"){
                toPrint += ((Player)s).toString()+"/";
            }else {
                toPrint += s.toString() + "/";
            }
        }
        for(Cop c: cops){
            toPrint += c.toString()+"/";
        }
        toPrint += Integer.toString(awfcX)+"/"+Integer.toString(absY);

        //toPrint = toPrint.substring(0,toPrint.length()-1);


        out.println(toPrint);
    }

    private static void read(){
        if(in.hasNextLine()){
            String line = in.nextLine();

            if(!line.equals("Start message from the server") && !line.equals("Message from server")) {
                List<String> sps = Arrays.asList(line.split("/"));

                spritesList = new ArrayList<Sprite>();
                for (String sp : sps) {
                    List<String> pars = Arrays.asList(sp.split(","));
                    if (pars.size() != 1) {

                        int x = Integer.parseInt(pars.get(0));
                        int y = Integer.parseInt(pars.get(1));

                        String img = pars.get(2);
                        int place = Integer.parseInt(pars.get(3));
                        int type = Integer.parseInt(pars.get(4));
                        int flipX = Integer.parseInt(pars.get(5));
                        int flipY = Integer.parseInt(pars.get(6));
                        int angle = Integer.parseInt(pars.get(7));
                        int from = Integer.parseInt(pars.get(8));

                        if (img.equals("player")) {



                            int awX = Integer.parseInt(pars.get(9));
                            int awY = Integer.parseInt(pars.get(10));

                            if(from == ii){
                                awX = 0;
                                awY = 0;

                            }else{

                            }
                            Player spr = new Player(x+awX, y+awY, false);
                            spr.from = from;
                            spr.place = place;
                            spr.type = type;
                            spr.setFlipX(flipX);
                            spr.setFlipY(flipY);
                            spritesList.add(spr);
                        }
                        if (img.equals("bullet")) {

                            int awX = Integer.parseInt(pars.get(9));
                            int awY = Integer.parseInt(pars.get(10));

                            if(from == ii){
                                awX = 0;
                                awY = 0;
                            }else{

                            }
                            Bullet spr = new Bullet(x+awX, y+awY, 3, angle, false);

                            spr.from = from;
                            spr.place = place;
                            spr.type = type;
                            spr.setFlipX(flipX);
                            spr.setFlipY(flipY);


                            spritesList.add(spr);
                        }
                        if (img.equals("cop")) {

                            int awX = Integer.parseInt(pars.get(9));
                            int awY = Integer.parseInt(pars.get(10));

                            if(from == ii){
                                awX = 0;
                                awY = 0;
                            }else{

                            }
                            Cop spr = new Cop(x+awX, y+awY, false, 0, 0);

                            spr.from = from;
                            spr.place = place;
                            spr.type = type;
                            spr.setFlipX(flipX);
                            spr.setFlipY(flipY);
                            spr.play = true;


                            cops.add(spr);
                        }
                        if (img.equals("guy")) {

                            int awX = Integer.parseInt(pars.get(9));
                            int awY = Integer.parseInt(pars.get(10));

                            if(from == ii){
                                awX = 0;
                                awY = 0;
                            }else{

                            }
                            Guy spr = new Guy(x+awX, y+awY, pars.get(11), pars.get(13),pars.get(14),false);
                            spr.from = from;
                            spr.place = place;
                            spr.type = type;
                            spr.setFlipX(flipX);
                            spr.setFlipY(flipY);


                            spritesSentOnce.add(spr);
                        }

                    }
                    if(pars.size() == 2){

                    }
                    else{
                        if(Integer.parseInt(pars.get(0)) <= 24) {
                            Params.TIME = Integer.parseInt(pars.get(0));
                        }
                    }
                }
            }
        }
    }


    private static void paintBoxes(Graphics g,boolean terrain){




    }

    /**Main method that puts everything together**/
    public static void main(String[] args) throws Exception{



        SwingUtilities.invokeLater(new Runnable(){
            public void run(){

                try {
                    socket = new Socket("localhost", 10005);
                }catch(Exception e){

                }

                JFrame game = new JFrame();
                game.setSize(800,600);
                Params.SCREEN_HEIGHT = 1080;
                Params.SCREEN_WIDTH = 1920;
                Params.scaleToResY = Params.SCREEN_HEIGHT/Params.NORMAL_SCREEN_HEIGHT;
                Params.scaleToResX = Params.SCREEN_WIDTH/Params.NORMAL_SCREEN_WIDTH;
             //   game.setExtendedState(JFrame.MAXIMIZED_BOTH);
                game.setVisible(true);
                game.requestFocus();
                game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                kb = new KeyBoard();
                game.addKeyListener(kb);
                ms = new Mouse();
                game.addMouseListener(ms);

                try {
                    in = new Scanner(socket.getInputStream(), "UTF-8");

                    out = new PrintWriter(socket.getOutputStream(), true);
                }catch(Exception e){}

                setupTerrain();



                JPanel canvas = new JPanel(){
                    public void paint(Graphics g) throws ConcurrentModificationException{
                        super.paint(g);
                      //  System.out.println(System.currentTimeMillis()%1000);
                        if(System.currentTimeMillis()%1000 < 20 ){
                            Params.FPS = framesMade;
                            framesMade = 0;
                            System.out.println(Params.FPS);
                        }

                        handleNightAndDay(g);

                        controlPlayer(g);
                        handleTerrain();
                        handleOnceSent(g);
                        handleNPCS(g);

                        t.paint(g);


                        paintBoxes(g,false);

                        for(LineOfTerrain lot : terrains){
                            lot.paint(g);
                            for(Line2D l2d : lot.getLinesAbs()){
                                if(l2d.getY1() < s1.getY() && l2d.getY2() < s1.getY()){
                                    ((Graphics2D)g).setColor(Color.YELLOW);
                                    ((Graphics2D)g).draw(l2d);
                                }
                            }
                        }




                        for(Sprite s : spritesList) {

                            if( localIds.contains(s.getId())) {

                                if(localIds.contains(s.getId()) && s.from == Client.ii){
                                    s.paint(g);
                                }

                            }else{
                                s.paint(g);
                            }



                        }


                        if(spritesList.size() == 0){

                                g.setFont(Params.DEFAULTFONT);
                                g.setColor(Color.RED);
                                g.drawString("Waiting for players!", 50, 100);

                        }

                            //    System.out.println(Integer.toString(Player.bullets.size())+","+Integer.toString(spritesList.size()));}catch(NullPointerException e){}
                        g.drawImage(new ImageIcon(Params.DEFAULTPATH+"assets\\bar.png").getImage(),10,10,null);
                        g.setColor(new Color(104,0,0));
                        g.fillRect(10+32 +256-(256-(int) (PLAYERHP / 1000*2.56)), 10, (256-(int) (PLAYERHP / 1000*2.56)), 32);
                            //      System.out.println(PLAYERHP);

                            cleanup();// must ALWAYS be at the very END.



                    }
                };
                canvas.setDoubleBuffered(true);

                s1 = new Player(100,Params.SCROLLBORDER_Y+64,true);
                fakeLine = new LineOfTerrain(s1.getX(),s1.getY(),new int[][]{{0,0},{20,20},{10,20},{0,0}},Params.DEFAULTPATH+"assets\\dirt.png",30);
              // terrains.add(fakeLine);
                s1.type = 1;



                ActionListener updateTask = new ActionListener(){


                    public void actionPerformed(ActionEvent evt){


                                shootInterval = Params.bulletTypeToPars.get(WEAPON_TYPE).get().get(3);
                                shootDelay -= 1;
                                for(Bullet b1 : Player.bullets) {

                                    if(b1.old == 0) {
                                        b1.angle = (int) (360-Math.atan2(Mouse.getX()-s1.getX(), Mouse.getY()-s1.getY())*180/Math.PI)%360;
                                        int II = b1.angle;

                                    }

                                    int II = b1.angle;
                                    int Dx = -(int) (Math.sin(Math.toRadians(II)) * Params.bulletTypeToPars.get(b1.type).get().get(1));
                                    int Dy = (int) (Math.cos(Math.toRadians(II)) * Params.bulletTypeToPars.get(b1.type).get().get(1));

                                    b1.addY(Dy);
                                    b1.addX(Dx);
                                    b1.old += 1;
                                    if(b1.old == Params.bulletTypeToPars.get(b1.type).get().get(2)){
                                        Player.bulletsToRemove.add(b1);
                                        spritesToClean.add(b1);
                                    }
                                    }

                                    send();

                                read();



                        handleKeysForPlayer();

                        game.repaint();

                        frame += 1;
                    }


                };
                new Timer(16,updateTask).start();


                Container cp = game.getContentPane();

                cp.add(canvas);
            }
        });








    }


}
