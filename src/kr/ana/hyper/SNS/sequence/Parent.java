package kr.ana.hyper.SNS.sequence;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 415 on 2014-11-24.
 */

public class Parent {
    public static enum SeqID{
        SEQ_LOGIN,
        SEQ_TIMELINE,
        SEQ_TRADEMARKETHOME;
        private SeqID current;
        public void set (SeqID s)
        {
            this.current=s;
        };
        public SeqID get ()
        {
            return current;
        }
    };


    private JPanel panel;
    private JFrame frame;
    public Parent()
    {
        panel = new Login(this);
        frame= new JFrame("Name");
        frame.add(panel);
    };

}
