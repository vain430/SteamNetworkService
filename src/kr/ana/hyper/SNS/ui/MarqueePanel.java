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
public class MarqueePanel extends JPanel implements ActionListener {

    private static final int RATE = 12;
    private final Timer timer = new Timer(1000 / RATE, this);
    private final JLabel label = new JLabel();
    private  final String s;
    private final int n;
    private int index;

    public MarqueePanel()
    {
        this.s="";
        this.n=0;
    }

    public void init(String s,int n)
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
        //   label.setFont(new Font("Serif", Font.ITALIC, 36));
        label.setText(sb.toString());
        this.add(label);
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
        label.setText(sb.toString());
        this.add(label);
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
        label.setText(s.substring(index, index + n));
    }
}