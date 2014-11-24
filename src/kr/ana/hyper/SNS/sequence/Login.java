package kr.ana.hyper.SNS.sequence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 415 on 2014-11-24.
 */
public class Login extends JPanel {

    Parent parent;
    public Login(Parent p) {
        super();
        parent=p;
        setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        add(loginButton);

        JButton registerButton = new JButton("TESTETESTETETSTETSTET");
        registerButton.setBounds(180, 80, 80, 25);
        add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                parent.update(_SeqID.SEQ_TIMELINE ,new TimeLine(parent));
            }
        });
    }
}
