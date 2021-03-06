package kr.ana.hyper.SNS.sequence;

import kr.ana.hyper.SNS.sequence.timeline.TimeLine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by *KvOID on 2014-11-24.
 * Email vain430@gmail.com
 * Twitter @vain430
 */
public class Parent {

    public _SeqID seqID;
    private JPanel panel;
    private JFrame frame;

    public JFrame getFrame(){return frame;}
    public JPanel getPanel(){return panel;}

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

    public Parent() {
        seqID=_SeqID.SEQ_LOGIN;
        frame= new JFrame("SteamNetworkService");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        File file = new File("main.png");
        Image image= null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setIconImage(image);

        panel = new TimeLine(this);
        frame.add(panel);
        frame.setVisible(true);
    }

}
