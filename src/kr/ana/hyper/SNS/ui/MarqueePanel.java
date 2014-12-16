package kr.ana.hyper.SNS.ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by *KvOID on 2014-12-10.
 * Email vain430@gmail.com
 * Twitter @vain430
 */
/** Side-scroll n characters of s. */
public class MarqueePanel extends JLabel implements ActionListener {

    private static final int RATE = 12;
    private final Timer timer = new Timer(1000 / RATE, this);
    private   String s;
    private  int n;
    private int index;

    public MarqueePanel()
    {
        this.s="";
        this.n=0;
    }

    public void setText(String s,int n)
    {
        if (s == null || n < 1) {
            throw new IllegalArgumentException("Null string or n < 1");
        }
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
        this.s = sb + s + sb;
        this.n = n;
        setText(sb.toString());
    }


    public MarqueePanel(String s, int n) {
        if (s == null || n < 1) {
            throw new IllegalArgumentException("Null string or n < 1");
        }
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
        this.s = sb + s + sb;
        this.n = n;
     //   label.setFont(new Font("Serif", Font.ITALIC, 36));
        setText(sb.toString());
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        index++;
        if (index > s.length() - n) {
            index = 0;
        }
        setText(s.substring(index, index + n));
    }
}