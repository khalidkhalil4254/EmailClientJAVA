package app;
import javax.swing.*;
import java.net.*;
import java.util.*;

public class event extends gui{

    TOOL t;
    ArrayList msgs,mail;

    static String host="localhost";
    static int count=0,portReceive=6666,portSend=5555,portSignIn=4444,portSignUp=3333,portForget=2222,portForgetThread=7777;
    Socket socketSend;
    static String username;

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
            } catch (Exception ex) {
                System.out.println("signUp error:"+ex);
            }

        });


        send_signIn_btn.addActionListener((e)->{
            String sender=from_mailing_txt.getText();
            String receiver=to_mailing_txt.getText();
            String msg=msg_mailing_txt.getText();
            if(!sender.equals("") && !receiver.equals("") && !msg.equals("")){
                try {
                    Thread.sleep(200);
                    t.send(new Socket(host,portSend),sender);
                    t.send(new Socket(host,portSend),receiver);
                    t.send(new Socket(host,portSend),msg);
                    System.out.println(sender+" "+receiver+" "+msg);
                } catch (Exception ex) {
                    System.out.println("Send error:"+ex);
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


    }
}
