package views;

import controller.ConnectionViewController;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SplashView extends JWindow {
	JLabel img = new JLabel(new ImageIcon("solve_2.jpg"));
	private Thread t;
	private JProgressBar bar;
	
	public SplashView() {
		
		this.setSize(500,290);
		this.setLocationRelativeTo(null);
		
		t = new Thread(new Traitement ());
		bar = new JProgressBar();
		bar.setMaximum(500);
		bar.setMinimum(0);	
		bar.setBackground(Color.WHITE);
		bar.setForeground(Color.ORANGE);
		bar.setStringPainted(false);
		t.start();
		
		this.getContentPane().add(bar, BorderLayout.SOUTH);
		this.getContentPane().add(img,BorderLayout.NORTH);
		this.setBackground(Color.white);
		this.setVisible(true);
	}
	
	  class Traitement implements Runnable {
		  
		@Override
		public void run() {
			for (int val=0; val<=500; val++) {
				bar.setValue(val);
				bar.setStringPainted(true);
			if (val==500) {
				dispose();
				new ConnectionViewController();
			}
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
			}
		}			
	}
}