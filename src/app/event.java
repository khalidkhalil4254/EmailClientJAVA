package app;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;

public class event extends gui{

    TOOL t;
    ArrayList msgs,senders,dates;
    ArrayList rows;
    static String host="localhost";
    static int count=0;
    static String username;

    event(){
        t=new TOOL();
        msgs=new ArrayList<String>();
        senders=new ArrayList<String>();
        dates=new ArrayList<String>();
        rows=new ArrayList<String>();
        rows.add("fskadhfi|\tkjlajdsfklj|\taskkfl\n\n");
        rows.add("fskadhfi\tkjlajdsfklj\taskkfl\n\n");
        rows.add("fskadhfi\tkjlajdsfklj\taskkfl\n\n");
        rows.add("fskadhfi\tkjlajdsfklj\taskkfl\n\n");
        rows.add("fskadhfi\tkjlajdsfklj\taskkfl\n\n");
        rows.add("fskadhfi\tkjlajdsfklj\taskkfl\n\n");
        rows.add("fskadhfi\tkjlajdsfklj\taskkfl\n\n");
        mailBox_mailing_tbl.setText(Arrays.toString(rows.toArray()));



        Thread receive=new Thread(()->{
            while(true){
                try {
                    String sender=t.receive(new ServerSocket(5555).accept());
                    String msg=t.receive(new ServerSocket(5555).accept());
                    String date=t.receive(new ServerSocket(5555).accept());
                    if(!msg.equals("") && !msg.equals(null)){
                        if(!msgs.contains(msg)){
                            rows.add(sender+"\t"+msg+"\t"+date);
                            mailBox_mailing_tbl.setText(Arrays.toString(rows.toArray()));
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        //creating events handlers:-
        SignIn_btn.addActionListener((e)->{
//            receive.start();
            String user=username_signIn_txt.getText();
            String pass=password_signIn_txt.getPassword().toString();
//             geeks = new ArrayList<String[] >();
//            try {
//                t.send(new Socket(host,5555),user);
//                t.send(new Socket(host,5555),pass);
//            } catch (Exception ex) {ex.printStackTrace();}
//
//            try {
//                String res=t.receive(new ServerSocket(5555).accept());
//                if(res=="yes"){
                from_mailing_txt.setText(user);
//                    mailing_frm.setVisible(true);
//                    signIn_frm.setVisible(false);
//                }else {
//                    receive.stop();
//                }
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }


            mailing_frm.setVisible(true);
                    signIn_frm.setVisible(false);


        });

        SignUp_btn.addActionListener((e)->{
            signUp_frm.setVisible(true);
            signIn_frm.setVisible(false);
        });

        forget_btn.addActionListener((e)->{

        });

        signOut_mailing_btn.addActionListener((e)->{
            msgs.clear();
            mailing_frm.setVisible(false);
            signIn_frm.setVisible(true);
        });

        signUp_signUp_btn.addActionListener((e)->{
            String user=username_signUp_txt.getText();
            String pass=password_signUp_txt.getPassword().toString();

            try {
                t.send(new Socket(host,5555),user);
                t.send(new Socket(host,5555),pass);
            } catch (Exception ex) {ex.printStackTrace();}

            try {
                String res=t.receive(new ServerSocket(5555).accept());
                if(res=="yes"){
                    signUp_frm.setVisible(false);
                    signIn_frm.setVisible(true);
                }else {

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });



        send_signIn_btn.addActionListener((e)->{
            String sender=from_mailing_txt.getText();
            String receiver=to_mailing_txt.getText();
            String msg=msg_mailing_txt.getText();
            if(!sender.equals("") && !receiver.equals("") && !msg.equals("")){
                try {
                    t.send(new Socket(host,5555),sender);
                    t.send(new Socket(host,5555),receiver);
                    t.send(new Socket(host,5555),msg);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


    }
}
