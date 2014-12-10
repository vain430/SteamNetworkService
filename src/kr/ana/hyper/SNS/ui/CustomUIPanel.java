package kr.ana.hyper.SNS.ui;

import kr.ana.hyper.SNS.sequence.Parent;

import javax.swing.*;
import java.awt.*;

/**
 * Created by *KvOID on 2014-11-24.
 * Email vain430@gmail.com
 * Twitter @vain430
 */
public class CustomUIPanel extends JPanel{
    private Parent parent;
    public CustomUIPanel(Parent p)
    {
        super();
        parent=p;
    }

    public void setDefaultCustomUi()
    {
    //    parent.getFrame().setUndecorated(true);
  //      parent.getFrame().getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    }

}
