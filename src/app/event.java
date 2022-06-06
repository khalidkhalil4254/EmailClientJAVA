package app;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.*;

public class event extends gui{


    long start = System.currentTimeMillis();

    TOOL t;
    ArrayList msgs,mail;
    Socket fileSocket;

    static String host="192.168.1.8";
    static int count=0,portReceive=6666,portSend=5555,portSignIn=8080,portSignUp=3333,portForget=2222,portForgetThread=7777,portFile=5431;
    Socket socketSend;
    static String username;


    public static byte[] getFileBytes(File file) {
        byte[] arr = new byte[0];
        try{
            FileInputStream fl = new FileInputStream(file);
            arr = new byte[(int)file.length()];
            fl.read(arr);
            fl.close();
        }catch (Exception er){

        }
        return arr;
    }


    //creating events handlers:-
    event(){
        t=new TOOL();
        msgs=new ArrayList<String>();
        mail=new ArrayList<String>();

        try {
            socketSend=new Socket(host,portSend);
        }catch (Exception e){}

        Thread receive=new Thread(()->{

            while(true){
                try {
                    String sender=t.receive(new Socket(host,portReceive));
                    String receiver=t.receive(new Socket(host,portReceive));
                    String msg=t.receive(new Socket(host,portReceive));

                    if(!msg.equals("")){
                        if(receiver.equals(username_signIn_txt.getText())){
                        if(!msgs.contains(msg)){
                            msgs.add(msg);
                            mail.add("Sender:"+sender+"\n\n\t"+"Mail:"+msg+"\n\n\n\n");
                            mailBox_mailing_tbl.setText(Arrays.toString(mail.toArray()));
                        }
                    }
                }
                } catch (Exception e) {}
            }
        });
        receive.start();


        Thread forget=new Thread(()->{
            while(true){
                try {
                    String pass=t.receive(new Socket(host,portForgetThread));
                    System.out.println(pass);
                    if(!pass.equals("")){
                        password_forget_txt.setText(pass);
                    }
                }catch (Exception er){
                    System.out.println("forget error:"+er);
                }
            }
        });


        //creating events handlers:-
        SignIn_btn.addActionListener((e)->{
            String user=username_signIn_txt.getText();
            String pass=new String(password_signIn_txt.getPassword());
        if(!user.equals("") && !pass.equals("")){
            try {
                //sending the login info to the server:-
                t.send(new Socket(host,portSignIn),user);
                t.send(new Socket(host,portSignIn),pass);

                //waiting and receiving the response from the server:-
                String res=t.receive(new Socket(host,portSignIn));
                System.out.println(res);
                if(res.equals("yes")){
                    username=user;
                    from_mailing_txt.setText(username);
                    mailing_frm.setVisible(true);
                    signIn_frm.setVisible(false);
                    password_signIn_txt.setText("");
                }else if(res.equals("no")){
                    JOptionPane.showMessageDialog(err_signIn, "Invalid SignIn!");
                }
            } catch (Exception ex) {
                //error handling in gui:-
                JOptionPane.showMessageDialog(err_signIn, "No SignIn!");
            }
        }else {
            JOptionPane.showMessageDialog(err_signIn, "Please type a valid logIn");
        }

        });

        SignUp_btn.addActionListener((e)->{
            signUp_frm.setVisible(true);
            signIn_frm.setVisible(false);
        });

        forget_btn.addActionListener((e)->{
            forget_frm.setVisible(true);
            signIn_frm.setVisible(false);
        });

        signOut_mailing_btn.addActionListener((e)->{
            msgs.clear();
            mail.clear();
            username="";
            username_signIn_txt.setText("");
            mailBox_mailing_tbl.setText("");
            from_mailing_txt.setText("");
            mailing_frm.setVisible(false);
            signIn_frm.setVisible(true);
        });

        signUp_signUp_btn.addActionListener((e)->{

            try{
            String user=username_signUp_txt.getText();
            String pass=new String(password_signUp_txt.getPassword());


            if(user.contains("@nctu.edu.eg") || user.contains("@NCTU.EDU.EG")){
                System.out.println(user+" "+pass);
                t.send(new Socket(host,portSignUp),user);
                t.send(new Socket(host,portSignUp),pass);
                String res=t.receive(new Socket(host,portSignUp));
                System.out.println(res);
                if(res.equals("yes")){
                    signUp_frm.setVisible(false);
                    signIn_frm.setVisible(true);
                }else if(res.equals("no")){
                    System.out.println("invalid Info!!!");
                }
            }else {
                JOptionPane.showMessageDialog(signUp_frm, "Please add  @nctu.edu.eg  to username!",
                        "Incomplete-Data!", JOptionPane.ERROR_MESSAGE);
            }

            } catch (Exception ex) {
                System.out.println("signUp error:"+ex);
            }

        });


        send_signIn_btn.addActionListener((e)->{
            String sender=from_mailing_txt.getText();
            String receiver=to_mailing_txt.getText();
            String msg=msg_mailing_txt.getText();
            msg+="\nsent in:"+LocalTime.now().getHour()+":"+LocalTime.now().getMinute();

            if(!sender.equals("") && !receiver.equals("") && !msg.equals("")){
            if(receiver.contains(",")){
                String arr[]=receiver.split(",");
                for(String a:arr){
                    try {
                        Thread.sleep(500);
                        t.send(new Socket(host,portSend),sender);
                        t.send(new Socket(host,portSend),a);
                        t.send(new Socket(host,portSend),msg);
                        System.out.println(sender+" "+a+" "+msg);
                    } catch (Exception ex) {
                        System.out.println("Send error:"+ex);
                    }
                }
            }else {
                try {
                    Thread.sleep(200);
                    t.send(new Socket(host,portSend),sender);
                    t.send(new Socket(host,portSend),receiver);
                    t.send(new Socket(host,portSend),msg);
                    System.out.println(sender+" "+receiver+" "+msg);
                } catch (Exception ex) {
                    System.out.println("Send error:"+ex);
                }
            }

                to_mailing_txt.setText("");
                msg_mailing_txt.setText("");
            }
        });


        submit_forget_btn.addActionListener((e)->{
            if(count==0){
                forget.start();
            }
            String user=username_forget_txt.getText();
            if(!user.equals("")){
                try {
                    t.send(new Socket(host,portForget),user);
                } catch (Exception ex) {
                    System.out.println("forget error:"+ex);
                }
            }
            username_forget_txt.setText("");
            count++;
        });

        back_forget_btn.addActionListener((e)->{
            forget_frm.setVisible(false);
            signIn_frm.setVisible(true);
        });





        uploadFile_btn.addActionListener((e)->{
            JFileChooser fileChoose=new JFileChooser();
            int res=fileChoose.showOpenDialog(null);
            if(res==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChoose.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                uploadFile_btn.setText(file.getAbsolutePath());


                byte fileBytes[]=getFileBytes(file);

                TOOL tool=new TOOL();
                try {
                    tool.sendBytes(new Socket(host,portFile),fileBytes);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        long end = System.currentTimeMillis();


        System.out.println("benchmarks:"+(end - start));


    }
}
