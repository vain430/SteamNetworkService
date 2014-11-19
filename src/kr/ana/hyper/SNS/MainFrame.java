package kr.ana.hyper.SNS;

import javax.swing.JFrame;

import aurelienribon.slidinglayout.SLPanel;

public class MainFrame extends JFrame {

	private final SLPanel panel = new SLPanel();
	private final AnimatedPanel p1 = new AnimatedPanel("1" );
	private final AnimatedPanel p2 = new AnimatedPanel("2");
	private final AnimatedPanel p3 = new AnimatedPanel("3");
	private final AnimatedPanel p4 = new AnimatedPanel("4");
	private final AnimatedPanel p5 = new AnimatedPanel("5");
	
	public MainFrame()
	{
		
	}
}
