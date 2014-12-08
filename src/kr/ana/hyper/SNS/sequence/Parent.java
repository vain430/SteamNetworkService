package kr.ana.hyper.SNS.sequence;

import kr.ana.hyper.SNS.CustomUIPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by *KvOID on 2014-11-24.
 * Email vain430@gmail.com
 * Twitter @vain430
 */
public class Parent {

    public _SeqID seqID;
    private JPanel panel;
    private JFrame frame;

    public JFrame getFrame(){return frame;};
    public JPanel getPanel(){return panel;};

    public void update(_SeqID s,boolean hide)
    {
        JPanel next;
        seqID=s;
        if(hide)
            frame.setVisible(false);
        switch(seqID)
        {
            case SEQ_LOGIN:
                next= new Login(this);
                break;
            case SEQ_TIMELINE:
                next= new TimeLine(this);
                break;
            default:
                next= new JPanel();
        }
        panel=next;
        frame.getContentPane().removeAll();
        frame.printAll(frame.getGraphics());
        frame.add(panel);
        frame.setVisible(true);
    }

    public Parent()
    {
        seqID=_SeqID.SEQ_LOGIN;
        frame= new JFrame("SteamNetworkService");
        panel = new TimeLine(this);
        frame.add(panel);
        frame.setVisible(true);
    };

}
