package kr.ana.hyper.SNS.sequence;

import kr.ana.hyper.SNS.SUtil;
import kr.ana.hyper.SNS.SteamCrawler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by *KvOID on 2014-11-24.
 * Email vain430@gmail.com
 * Twitter @vain430
 */
public class Login extends JPanel {

    private Parent parent;

    public Login(Parent p) {
        super();
        parent = p;
        parent.getFrame().setSize(280, 175);

        SUtil.moveToCenter(p);
        setLayout(null);
        JLabel userLabel = new JLabel("아이디");
        userLabel.setBounds(10, 10, 80, 25);
        add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        add(userText);

        JLabel passwordLabel = new JLabel("패스워드");
        passwordLabel.setBounds(10, 40, 80, 25);
        add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                SteamCrawler.init();
                parent.update(_SeqID.SEQ_TIMELINE,false);
            }
        });
        add(loginButton);

        JButton registerButton = new JButton("Sign In");
        registerButton.setBounds(180, 80, 80, 25);
        add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
