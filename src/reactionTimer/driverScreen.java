/**
 * @author heinohen
 * 
 */


package reactionTimer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class driverScreen extends JFrame implements ActionListener{
	
	JButton btnStart;
	JButton btnStop;
	JLabel lblTop;
	JLabel lblBottom;
	JLabel lblInside;
	String pelaaja;
	String reactionTime;
	
	/**
	 * Constructor for the window with buttons
	 */
	
	driverScreen(String pelaaja) {
		this.pelaaja = pelaaja;
		this.reactionTime = "12:34:56";
		
		/*
		 * 
		 * BUTTON START
		 * 
		 */
		
		btnStart = new JButton();
		ImageIcon raja = new ImageIcon("raja.png");
		btnStart.setBounds(100, 100, 400, 200);
		/*
		btn.addActionListener(e -> System.out.println("moop")); // prints when pressed ( short hand for implementing actionlistener! )
		btn.addActionListener(e -> btn.setEnabled(false)); // can only press once and the disabled
		*/
		btnStart.addActionListener(this);
		btnStart.setText("Press to start! -> ");
		btnStart.setFocusable(false);
		btnStart.setIcon(raja);
		btnStart.setHorizontalTextPosition(JButton.LEFT);
		btnStart.setFont(new Font("Verdana",Font.BOLD, 15));
		
		/*
		 * 
		 * BUTTON STOP
		 * 
		 */
		
		btnStop = new JButton();
		btnStop.setBounds(200,350, 100, 50);
		btnStop.addActionListener(this);
		btnStop.setText("CLICK!");
		
		
		/**
		 * 
		 * LABEL TOP
		 * 
		 */
		
		lblTop = new JLabel("INSTRUCTIONS!");
		lblTop.setFont(new Font("Verdana", Font.BOLD, 30));
		lblTop.setForeground(Color.green);
		lblTop.setBounds(0, 0, 500, 100);
		lblTop.setHorizontalTextPosition(JLabel.LEFT);
		lblTop.setVerticalTextPosition(0);
		lblTop.setVisible(true);
		Border brdTop = BorderFactory.createLineBorder(Color.red,3);
		lblTop.setBorder(brdTop);
		
		
		/**
		 * 
		 * LABEL BOTTOM
		 * 
		 */
		
		lblBottom = new JLabel(pelaaja);
		lblBottom.setFont(new Font("Verdana", Font.BOLD, 15));
		lblBottom.setForeground(Color.red);
		lblBottom.setBounds(0, 400, 100, 70);
		lblBottom.setVisible(false);
		Border brdBottom = BorderFactory.createLineBorder(Color.red,3);
		lblBottom.setBorder(brdBottom);
		
		/**
		 * 
		 * LABEL INSIDE (FOR TIME)
		 * 
		 */
		lblInside = new JLabel();
		lblInside.setFont(new Font("Comic Sans", Font.ITALIC, 10));
		lblInside.setVisible(false);
		lblInside.setBounds(101, 400, 150, 70);
		Border brdInside = BorderFactory.createLineBorder(Color.blue, 3);
		lblInside.setBorder(brdInside);
		
		/**
		 * 
		 * 
		 * ACTUAL FRAME
		 * 
		 */
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setSize(500,500);
		this.setVisible(true);
		this.add(btnStart);
		this.add(btnStop);
		this.add(lblTop);
		this.add(lblBottom);
		this.add(lblInside);
		
	}
	
	private void reactionTest() {
		Random r = new Random();
		int time = r.nextInt(10000)+100;
		this.reactionTime = String.valueOf(time);
		lblInside.setText(reactionTime);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStart ) {
			System.out.println("Start");
			btnStart.setEnabled(false);
			lblBottom.setVisible(true);
		}
		
		if (e.getSource() == btnStop) {
			System.out.println("Stop");
			reactionTest();
			lblInside.setVisible(true);
		}
	}


}
