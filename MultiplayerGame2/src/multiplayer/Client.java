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


import com.sun.org.apache.xpath.internal.operations.Bool;
import engine.Image;
import engine.LineOfTerrain;
import engine.Sprite;


import game.Bullet;
import game.Guy;
import game.Player;
import main.*;

public class Client {


    public static int wasYscrolled = 0;
    private static int fDy = 0;
    public static int absY = 0;

    static Socket socket=null;
    public static int ii = new Random().nextInt(10909);

    public static int awfcX = 0,awfcY=0;


    private static ArrayList<Sprite> spritesSentOnce = new ArrayList<Sprite>();

    public static ArrayList<LineOfTerrain> terrains = new ArrayList<LineOfTerrain>();

    public static ArrayList<String> importantIDs = new ArrayList<String>(Arrays.asList(new String[]{
            "player",
            "bullet"
    }));

    static LineOfTerrain line1 = new LineOfTerrain(0,0,new int[][]{
            {2,166},{26,167},{50,244},{49,244},{61,399},{61,400},{59,436},{89,442},{135,418},{160,409},{160,408},{195,398},{196,398},{227,392},{270,383},{296,387},{306,390},{351,389},{352,389},{379,410},{405,422},{433,434},{477,428},{510,418},{531,413},{533,413},{534,413},{569,405},{594,395},{641,368},{680,363},{711,378},{712,378},{714,379},{748,393},{782,413},{783,413},{829,427},{857,421},{884,427},{928,420},{929,419},{981,397},{981,395},{1033,382},{1075,400},{1142,414},{1165,421},{1165,420},{1194,415},{1216,395},{1217,390},{1223,373},{1224,369},{1260,345},{1260,344},{1264,322},{1265,320},{1295,313},{1296,312},{1297,311},{1323,279},{1347,252},{1366,223},{1381,204},{1407,197},{1406,197},{1407,196},{1444,183},{1444,182},{1457,168},{1486,171},{1486,172},{1496,181},{1518,204},{1519,205},{1526,238},{1548,273},{1561,315},{1570,349},{1571,350},{1572,350},{1593,387},{1594,387},{1610,417},{1611,417},{1619,449},{1620,449},{1643,476},{1672,488},{1718,485},{1786,487},{1849,488},{1886,479},{1921,505},{1922,505},{1923,505},{1924,505},{1984,491},{1985,491},{2020,491},{2055,499},{2074,508},{2074,509},{2131,489},{2180,494},{2210,512},{2236,513},{2237,512},{2259,501},{2287,495},{2290,493},{2323,499},{2347,509},{2348,509},{2381,506},{2406,472},{2425,466},{2425,465},{2442,441},{2442,440},{2443,436},{2456,424},{2458,423},{2459,422},{2460,421},{2495,373},{2495,371},{2509,315},{2510,313},{2509,256},{2509,253},{2507,201},{2498,200},{2508,172},{2530,141},{2557,94},{2558,94},{2604,76},{2639,152},{2652,195},{2651,196},{2686,244},{2687,244},{2697,313},{2698,313},{2725,344},{2762,419},{2762,418},{2789,469},{2822,496},{2822,497},{2868,501},{2922,507},{2963,510},{2983,512},{3022,506},{3054,503},{3107,497},{3134,508},{3167,499},{3172,495},{3186,489},{3209,486},{3225,489},{3257,495},{3282,511},{3321,514},{3336,516},{3397,512},{3428,506},{3470,497},{3500,498},{3541,501},{3574,507},{3599,486},{3625,482},{3626,482},{3639,528},{3676,539},{3687,573},{3687,574},{3688,597},{3660,647},{3600,677},{3533,697},{3532,697},{3483,684},{3482,683},{3480,682},{3443,672},{3442,672},{3439,671},{3375,666},{3318,658},{3231,677},{3129,693},{3108,717},{3011,733},{2986,774},{2987,835},{2902,895},{2845,933},{2803,978},{2723,1005},{2695,1023},{2671,1021},{2608,1065},{2588,1121},{2588,1122},{2592,1161},{2598,1195},{2639,1224},{2706,1249},{2770,1249},{2828,1239},{2916,1236},{2974,1244},{3053,1244},{3093,1244},{3137,1237},{3168,1247},{3197,1247},{3222,1251},{3237,1243},{3237,1242},{3281,1236},{3296,1219},{3297,1218},{3326,1205},{3337,1192},{3353,1184},{3380,1170},{3381,1169},{3401,1151},{3401,1150},{3438,1129},{3456,1115},{3469,1101},{3470,1100},{3482,1091},{3482,1090},{3491,1079},{3492,1078},{3510,1065},{3509,1065},{3527,1043},{3542,1025},{3568,999},{3569,997},{3589,961},{3589,959},{3592,955},{3622,944},{3646,929},{3692,913},{3732,903},{3732,902},{3792,887},{3795,886},{3817,873},{3818,872},{3838,856},{3838,855},{3884,851},{3893,826},{3894,826},{3934,808},{3968,792},{3992,793},{4020,760},{4021,759},{4029,749},{4048,723},{4064,655},{4102,600},{4102,599},{4116,585},{4142,565},{4142,564},{4197,569},{4196,568},{4218,559},{4250,562},{4251,562},{4303,573},{4305,574},{4345,579},{4346,579},{4379,576},{4381,575},{4416,573},{4465,584},{4478,636},{4532,720},{4560,745},{4587,777},{4627,799},{4628,800},{4664,805},{4664,806},{4726,809},{4727,809},{4748,807},{4756,798},{4801,805},{4863,797},{4914,801},{4964,774},{4997,754},{5037,688},{5048,646},{5049,643},{5068,590},{5068,589},{5084,548},{5137,546},{5152,543},{5177,553},{5206,564},{5207,564},{5222,579},{5223,580},{5224,658},{5224,701},{5223,702},{5204,784},{5208,814},{5207,864},{5204,903},{5204,1027},{5082,1070},{4818,1159},{4173,1145},{3959,1214},{3958,1213},{3515,1498},{3290,1624},{3037,1576},{2867,1563},{2572,1577},{2261,1323},{2232,1047},{2110,969},{2018,952},{1757,764},{1576,710},{1457,647},{1456,646},{1397,607},{1411,512},{1359,451},{1301,523},{1256,586},{1257,611},{1146,620},{805,594},{634,538},{277,589},{5,598},{2,166}

    }, Params.DEFAULTPATH+"assets\\grass.png",22,Params.DEFAULTPATH+"assets\\dirt.png");
    static LineOfTerrain line2 = new LineOfTerrain(200,0,new int[][]{{0,0},{80,-30},{100,-45},{140,-45},{150,20},{160,40},{140,50},{120,80},{90,80},{70,70},{50,50},{40,50},{40,40},{30,20}}, Params.DEFAULTPATH+"assets\\bricks.png",22,Params.DEFAULTPATH+"assets\\stone.png");
    static LineOfTerrain line3 = new LineOfTerrain(0,0,new int[][]{
            {1100,8},{1070,68},{1070,67},{978,82},{978,83},{976,82},{917,59},{911,58},{907,57},{906,56},{858,-1},{891,-48},{890,-48},{920,-80},{919,-80},{966,-100},{966,-99},{1005,-119},{1006,-119},{1007,-119},{1048,-92},{1052,-90},{1054,-89},{1114,-82},{1114,-83},{1115,-82},{1116,-82},{1132,-80},{1133,-80},{1134,-79},{1135,-79},{1119,1},{1119,0},{1102,21},{1102,20},{1101,20},{1090,22},{1091,22},{1100,8}

    }, Params.DEFAULTPATH+"assets\\grass.png",22,Params.DEFAULTPATH+"assets\\dirt.png");
    static LineOfTerrain line4 = new LineOfTerrain(-1500,-350,new int[][]{
            {2466,229},{2578,315},{2339,271},{2204,323},{2083,347},{1980,302},{1981,302},{1955,254},{1955,255},{1975,210},{1974,210},{1975,209},{1990,150},{1989,150},{2047,108},{2046,108},{2098,87},{2097,88},{2214,69},{2213,69},{2373,86},{2416,76},{2416,75},{2417,75},{2485,85},{2489,85},{2493,86},{2561,91},{2561,90},{2655,98},{2751,97},{2752,97},{2807,66},{2831,80},{2834,82},{2895,126},{3010,115},{3012,116},{3016,117},{3138,116},{3195,126},{3195,127},{3230,141},{3230,142},{3250,149},{3270,155},{3274,156},{3276,157},{3380,136},{3421,79},{3424,77},{3427,73},{3497,39},{3498,39},{3544,12},{3544,11},{3607,-18},{3607,-19},{3687,-26},{3688,-28},{3689,-30},{3747,-20},{3746,-20},{3748,-20},{3777,9},{3777,8},{3789,78},{3842,116},{3843,117},{3900,132},{3901,132},{3902,133},{3904,133},{3956,148},{3957,147},{3986,151},{3986,150},{3987,150},{4001,184},{4002,184},{4030,203},{4031,204},{4060,211},{4061,211},{4061,212},{4114,210},{4113,209},{4160,222},{4187,249},{4186,248},{4178,303},{4178,313},{4178,315},{4109,321},{4103,322},{4101,322},{3977,312},{3969,314},{3967,314},{3886,344},{3887,344},{3749,339},{3736,339},{3730,339},{3724,339},{3646,335},{3640,335},{3637,335},{3513,308},{3512,308},{3470,293},{3228,311},{3186,290},{3185,290},{2959,308},{2959,307},{2923,343},{2924,343},{2800,332},{2728,343},{2466,229}

    }, Params.DEFAULTPATH+"assets\\bricks.png",22,Params.DEFAULTPATH+"assets\\stone.png");

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

    private static ArrayList<Sprite> blocks = new ArrayList<>();

    static Guy g1 = new Guy(200,100,"mess_around",Params.DEFAULTPATH+"assets\\hoodie2.png",Params.DEFAULTPATH+"assets\\jeans.png",false);

    static boolean jump = false;


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




        public void paint(Graphics g){
            Graphics2D g2d = (Graphics2D)g;

            AffineTransform at = AffineTransform.getTranslateInstance(x,y);
            AffineTransform at2 = AffineTransform.getTranslateInstance(0,0);
            g2d.setTransform(at);
            for(Sprite s : blocks){
                s.paint(g);
            }
            for(Sprite s : spritesList) {

                if(localIds.contains(s.getId())) {

                    if(!(localIds.contains(s.getId()) && s.from == Client.ii)){
                        s.paint(g);

                    }


                }

            }

            g2d.setTransform(at2);
        }

        public Terrain(){

        }
        public Terrain(int x, int y){
            setX(x);
            setY(y);
            readBlocks(new String[][]{{"1656","427","bush2.png"},{"1697","431","bush2.png"},{"2146","447","bush2.png"},{"2193","449","bush2.png"},{"1743","451","grass_block.png"},{"1763","451","grass_block.png"},{"2064","439","guy.png"},{"1799","372","hardwareStore.png"},{"1951","433","bricks.png"},{"1950","404","bricks.png"},{"1948","372","bricks.png"},{"1982","439","bricks.png"},{"1982","409","bricks.png"}});
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

                        if (l2d.intersects(new Rectangle2D.Float(b.getX(), b.getY(), 16, 8))) {

                            b.vis = false;
                            b.setX(-Integer.MAX_VALUE);
                            b.setY(-Integer.MAX_VALUE);
                            Player.bulletsToRemove.add(b);
                        }


                }/**/

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


                if (l2d.intersects(rect)) {

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


        if(Mouse.isPressed(1)){

            int II = (int) (360-Math.atan2(Mouse.getY()-s1.getY(), Mouse.getX()-s1.getX())*180/Math.PI)%360;

            Player.bullets.add(new Bullet(s1.getX(),s1.getY(),3,II,true));

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

    private static void send(){
        String toPrint = "";
        for(Sprite s : sendSprites){
            if(s.getId() == "player"){
                toPrint += ((Player)s).toString()+"/";
            }else {
                toPrint += s.toString() + "/";
            }
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

                        System.exit(0);

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



                        handleNightAndDay(g);


                        t.paint(g);
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


                        controlPlayer(g);
                        handleTerrain();
                        handleOnceSent(g);
                        handleNPCS(g);

                        cleanup();// must ALWAYS be at the very END.



                    }
                };
                canvas.setDoubleBuffered(true);

                s1 = new Player(100,Params.SCROLLBORDER_Y+64,true);

                s1.type = 1;



                ActionListener updateTask = new ActionListener(){


                    public void actionPerformed(ActionEvent evt){



                                for(Bullet b1 : Player.bullets) {

                                    if(b1.old == 0) {
                                        b1.angle = (int) (360-Math.atan2(Mouse.getX()-s1.getX(), Mouse.getY()-s1.getY())*180/Math.PI)%360;
                                        int II = b1.angle;

                                    }

                                    int II = b1.angle;
                                    int Dx = -(int) (Math.sin(Math.toRadians(II)) * 9);
                                    int Dy = (int) (Math.cos(Math.toRadians(II)) * 9);

                                    b1.addY(Dy);
                                    b1.addX(Dx);
                                    b1.old += 1;
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
