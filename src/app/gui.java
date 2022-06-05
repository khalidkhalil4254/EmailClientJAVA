package app;
import javax.swing.*;
import java.awt.*;

public class gui {
    //creating required components:-
    JFrame signIn_frm,signUp_frm,mailing_frm,forget_frm;
    JLabel username_signIn_lbl,password_signIn_lbl,mail_mailing_lbl,send_mailing_lbl,signIn_lbl,from_mailing_lbl,to_mailing_lbl,msg_mailing_lbl,signUp_lbl,username_signUp_lbl,password_signUp_lbl,forget_lbl,username_forget_lbl,password_forget_lbl,err_signIn,err_signUp,err_mail,err_forget;
    JTextField username_signIn_txt,password_forget_txt,username_signUp_txt,from_mailing_txt,to_mailing_txt,username_forget_txt;
    JTextArea msg_mailing_txt,mailBox_mailing_tbl;
    JPasswordField password_signIn_txt,password_signUp_txt;
    JButton SignIn_btn,SignUp_btn,forget_btn,send_signIn_btn,signOut_mailing_btn,signUp_signUp_btn,submit_forget_btn,back_forget_btn;
    JButton uploadFile_btn;

    gui(){

        //sigIn Frame:-
        signIn_frm=new JFrame("SignIn");
        signIn_frm.setSize(600,560);
        signIn_frm.setLayout(null);
        signIn_frm.setResizable(false);
        signIn_frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //forget frame:-
        forget_frm=new JFrame("signUp");
        forget_frm.setSize(500,400);
        forget_frm.setLayout(null);
        forget_frm.setResizable(false);
        forget_frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //signUp Frame:-
        signUp_frm=new JFrame("signUp");
        signUp_frm.setSize(600,560);
        signUp_frm.setLayout(null);
        signUp_frm.setResizable(false);
        signUp_frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //mailing Frame:-
        mailing_frm=new JFrame("Mailing");
        mailing_frm.setSize(1200,1000);
        mailing_frm.setLayout(null);
        mailing_frm.setResizable(false);
        mailing_frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        //creating signIn components:-
        err_signIn=new JLabel("");
        err_signIn.setFont(new Font("segueUI",Font.BOLD,15));
        err_signIn.setForeground(Color.RED);
        err_signIn.setBounds(250,200,150,30);

        signIn_lbl=new JLabel("signIn:-");
        signIn_lbl.setFont(new Font("segueUI",Font.BOLD,20));
        signIn_lbl.setBounds(30,20,120,30);

        username_signIn_lbl=new JLabel("username : ");
        username_signIn_lbl.setFont(new Font("segueUI",Font.PLAIN,15));
        username_signIn_lbl.setBounds(40,90,120,28);

        username_signIn_txt=new JTextField();
        username_signIn_txt.setBounds(150,90,320,30);



        password_signIn_lbl=new JLabel("password : ");
        password_signIn_lbl.setFont(new Font("segueUI",Font.PLAIN,15));
        password_signIn_lbl.setBounds(40,150,120,28);

        password_signIn_txt=new JPasswordField();
        password_signIn_txt.setBounds(150,150,320,30);

        SignIn_btn=new JButton("LogIn");
        SignIn_btn.setBounds(180,250,250,60);

        SignUp_btn=new JButton("SignUp");
        SignUp_btn.setBounds(200,320,200,50);

        forget_btn=new JButton("Forget?");
        forget_btn.setBounds(240,400,120,50);

        //adding sigIn components:-
        signIn_frm.add(err_signIn);
        signIn_frm.add(signIn_lbl);
        signIn_frm.add(username_signIn_lbl);
        signIn_frm.add(username_signIn_txt);
        signIn_frm.add(password_signIn_lbl);
        signIn_frm.add(password_signIn_txt);
        signIn_frm.add(SignIn_btn);
        signIn_frm.add(SignUp_btn);
        signIn_frm.add(forget_btn);



        //creating forget components:-
        forget_lbl=new JLabel("Forget-password?");
        forget_lbl.setFont(new Font("segue UI",Font.BOLD,18));
        forget_lbl.setBounds(30,30,180,30);

        username_forget_lbl=new JLabel("Username : ");
        username_forget_lbl.setFont(new Font("segue UI",Font.PLAIN,16));
        username_forget_lbl.setBounds(50,100,100,30);

        username_forget_txt=new JTextField();
        username_forget_txt.setBounds(165,100,250,30);

        password_forget_lbl=new JLabel("Your password : ");
        password_forget_lbl.setFont(new Font("segue UI",Font.PLAIN,16));
        password_forget_lbl.setBounds(50,150,180,30);

        password_forget_txt=new JTextField();
        password_forget_txt.setEditable(false);
        password_forget_txt.setFont(new Font("verdana",Font.PLAIN,16));
        password_forget_txt.setBounds(165,150,250,30);

        submit_forget_btn=new JButton("Submit");
        submit_forget_btn.setFont(new Font("segue UI",Font.PLAIN,16));
        submit_forget_btn.setBounds(300,250,120,50);

        back_forget_btn=new JButton("Back");
        back_forget_btn.setFont(new Font("segue UI",Font.PLAIN,16));
        back_forget_btn.setBounds(30,250,120,50);

        //adding forget components:-
        forget_frm.add(forget_lbl);
        forget_frm.add(username_forget_txt);
        forget_frm.add(submit_forget_btn);
        forget_frm.add(username_forget_lbl);
        forget_frm.add(password_forget_lbl);
        forget_frm.add(password_forget_txt);
        forget_frm.add(back_forget_btn);



        //creating signUp components:-
        signUp_lbl=new JLabel("SignUp:-");
        signUp_lbl.setFont(new Font("verdana",Font.BOLD,25));
        signUp_lbl.setBounds(30,20,200,30);

        username_signUp_lbl=new JLabel("username:");
        username_signUp_lbl.setFont(new Font("verdana",Font.PLAIN,16));
        username_signUp_lbl.setBounds(60,120,200,30);

        username_signUp_txt=new JTextField();
        username_signUp_txt.setBounds(220,120,320,30);

        password_signUp_lbl=new JLabel("password:");
        password_signUp_lbl.setFont(new Font("verdana",Font.PLAIN,16));
        password_signUp_lbl.setBounds(60,170,200,30);

        password_signUp_txt=new JPasswordField();
        password_signUp_txt.setBounds(220,170,320,30);

        signUp_signUp_btn=new JButton("SignUp");
        signUp_signUp_btn.setBounds(220,360,160,50);

        //adding signUp components:-
        signUp_frm.add(signUp_lbl);
        signUp_frm.add(username_signUp_lbl);
        signUp_frm.add(password_signUp_lbl);
        signUp_frm.add(username_signUp_txt);
        signUp_frm.add(password_signUp_txt);
        signUp_frm.add(signUp_signUp_btn);


        //creating mailing components:-
        mail_mailing_lbl=new JLabel("MailBox:-");
        mail_mailing_lbl.setFont(new Font("segueUI",Font.BOLD,25));
        mail_mailing_lbl.setBounds(30,360,120,30);

        send_mailing_lbl=new JLabel("Send:-");
        send_mailing_lbl.setFont(new Font("segueUI",Font.BOLD,25));
        send_mailing_lbl.setBounds(30,30,120,30);

        from_mailing_lbl=new JLabel("FROM : ");
        from_mailing_lbl.setFont(new Font("verdana",Font.PLAIN,20));
        from_mailing_lbl.setBounds(30,120,100,30);

        from_mailing_txt=new JTextField();
        from_mailing_txt.setEditable(false);
        from_mailing_txt.setBounds(180,120,560,30);

        to_mailing_lbl=new JLabel("TO : ");
        to_mailing_lbl.setFont(new Font("verdana",Font.PLAIN,20));
        to_mailing_lbl.setBounds(30,170,100,30);

        to_mailing_txt=new JTextField();
        to_mailing_txt.setBounds(180,170,560,30);

        msg_mailing_lbl=new JLabel("Mail : ");
        msg_mailing_lbl.setFont(new Font("verdana",Font.PLAIN,20));
        msg_mailing_lbl.setBounds(30,220,100,30);

        msg_mailing_txt=new JTextArea();
        msg_mailing_txt.setFont(new Font("verdana",Font.PLAIN,18));
        JScrollPane scroll = new JScrollPane (msg_mailing_txt,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(180,220,560,120);

        signOut_mailing_btn=new JButton("SignOUT");
        signOut_mailing_btn.setBounds(540,860,120,50);

        send_signIn_btn=new JButton("Send");
        send_signIn_btn.setBounds(820,200,120,50);


        mailBox_mailing_tbl=new JTextArea();
        mailBox_mailing_tbl.setEditable(false);
        mailBox_mailing_tbl.setFont(new Font("verdana",Font.PLAIN,16));
        JScrollPane scroll1 = new JScrollPane (mailBox_mailing_tbl,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll1.setBounds(100,420,1000,420);


        uploadFile_btn=new JButton("Upload File");
        uploadFile_btn.setBounds(820,280,180,50);


        //adding mailing components:-
        mailing_frm.add(mail_mailing_lbl);
        mailing_frm.add(send_mailing_lbl);
        mailing_frm.add(from_mailing_lbl);
        mailing_frm.add(to_mailing_lbl);
        mailing_frm.add(msg_mailing_lbl);
        mailing_frm.add(from_mailing_txt);
        mailing_frm.add(to_mailing_txt);
        mailing_frm.add(signOut_mailing_btn);
        mailing_frm.add(send_signIn_btn);
        mailing_frm.add(scroll);
        mailing_frm.add(scroll1);
        mailing_frm.add(uploadFile_btn);


        //run the app
        signIn_frm.setVisible(true);

    }

}
