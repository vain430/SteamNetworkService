package kr.ana.hyper.SNS;

import kr.ana.hyper.SNS.sequence.Parent;

import java.awt.*;

/**
 * Created by *KvOID on 2014-11-24.
 * Email vain430@gmail.com
 * Twitter @vain430
 */
public class SUtil {
    public static void moveToCenter(Parent p)
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - p.getFrame().getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - p.getFrame().getHeight()) / 2);
        p.getFrame().setLocation(x, y);
    }
    public static Dimension getWindowSize(Parent p)
    {
        return p.getFrame().getBounds().getSize();
    }


}
