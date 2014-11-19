package kr.ana.hyper.SNS;

import aurelienribon.slidinglayout.SLAnimator;
import aurelienribon.tweenengine.Tween;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tween.registerAccessor(AnimatedPanel.class, new AnimatedPanel.Accessor());
		SLAnimator.start();

		MainFrame frame = new MainFrame();
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
