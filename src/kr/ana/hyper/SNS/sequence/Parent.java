package kr.ana.hyper.SNS.sequence;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 415 on 2014-11-24.
 */

public class Parent {

    _SeqID seqID;
    private JPanel panel;
    private JFrame frame;

    public void update(_SeqID s,JPanel next)
    {
        seqID=s;
        frame.remove(panel);
        panel=next;
        frame.add(panel);

    }
    public _SeqID getValue(String s) {
        return _SeqID.valueOf(s);
    }
    public Parent()
    {
        seqID=_SeqID.SEQ_LOGIN;
        panel = new Login(this);
        frame= new JFrame("Name");
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(800, 600);

    };

}
