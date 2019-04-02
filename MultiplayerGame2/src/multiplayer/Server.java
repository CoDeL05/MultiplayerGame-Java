package multiplayer;

import com.sun.org.apache.xpath.internal.operations.Bool;
import game.Guy;
import main.Params;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {

    private static int time = 0 ;
    static boolean add = true;
    static boolean stop = false;
    static boolean subst = false;
    static int wait = 0;
    static class ClientObject{


        public PrintWriter out=null;
        public Scanner in=null;

        public ClientObject(Socket s){

            try {
                in = new Scanner(s.getInputStream(), "UTF-8");
                out = new PrintWriter(s.getOutputStream(), true);
            }catch(IOException e){ }
            out.println("Start message from the server");
        }


    }


    static ArrayList<Guy> guys = new ArrayList<Guy>();

    static ClientObject[] ss;
    public static void main(String[] args) throws Exception {

        guys.add(new Guy(100,200, "mess_around",Params.DEFAULTPATH+"assets\\hoodie.png",Params.DEFAULTPATH+"assets\\jeans.png",false));

        final int players = 2;

        int port = 10005;
        ss = new ClientObject[players];


        ServerSocket serverSocket = new ServerSocket(port);

        for(int i = 0;i<players;i++){
            ss[i] = new ClientObject(serverSocket.accept());
            System.out.println("New Connection established!");
        }

        for(ClientObject co : ss){
            co.out.println("Message from server");
        }

        Thread mainThread = new Thread(){

            public void run(){



                int frames=0;

                while(true){
                    if(frames % 60 == 0) {
                        if(subst){
                            time -= 1;
                            if(time == 0){
                                add = true;
                                subst = false;
                            }
                        }
                       if(add){
                           time += 1;
                           if(time == 24){
                               stop = true;
                               add = false;
                           }
                       }else{
                         if(stop){
                             wait += 1;
                             time = 22;

                             if(wait == 24){
                                 subst = true;
                                 wait = 0;
                                 stop = false;
                             }
                             time -= 1;
                         }
                       }
                       if(time == 24 && add == false){
                           time = 21;
                       }
                        System.out.
                                println(Integer.toString(time)+","+ Boolean.toString(add)+","+Integer.toString(wait));
                    }
                    try {

                        String allRes = "";

                        for(ClientObject co : ss){
                            if(co.in.hasNextLine()){
                                allRes += co.in.nextLine()+"/";
                            }
                        }
                        if(frames == 10){
                            System.out.println("tu");
                            for(Guy g : guys){
                                allRes += g.toString();
                            }
                            System.out.println(allRes);
                        }
                        allRes += Integer.toString(time);



                        for(ClientObject co : ss){
                            co.out.println(allRes);
                        }
                        frames += 1;
                        Thread.sleep(16);

                    }catch(InterruptedException e){

                    }
                }
            }

        };
        mainThread.run();




    }


}
