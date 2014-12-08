package kr.ana.hyper.SNS;

import aurelienribon.slidinglayout.SLAnimator;
import aurelienribon.tweenengine.Tween;
import kr.ana.hyper.SNS.sequence.Parent;
import javax.swing.*;
/**
 * Created by *KvOID on 2014-11-24.
 * Email vain430@gmail.com
 * Twitter @vain430
 */
public class MainClass {

	public static void main(String[] args)
	{
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
    } catch ( ClassNotFoundException e ) {
        // TODO handle me
    } catch ( InstantiationException e ) {
        // TODO handle me
    } catch ( IllegalAccessException e ) {
        // TODO handle me
    } catch ( UnsupportedLookAndFeelException e ) {
        // TODO handle me
    }
		new Parent();
	}

	public static void ma22in(String[] args) {
		// TODO Auto-generated method stub
		Tween.registerAccessor(AnimatedPanel.class, new AnimatedPanel.Accessor());
		SLAnimator.start();

		MainFrame frame = new MainFrame();
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
