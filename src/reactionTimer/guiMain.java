package reactionTimer;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class guiMain {

	public static void main(String[] args) {
		
		JLabel teksti = new JLabel("Moi");
		teksti.setHorizontalTextPosition(JLabel.CENTER);
		
		JFrame runko = new JFrame("onko tämä otsikko");
		runko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		runko.setSize(300,300);
		runko.setLocationRelativeTo(null);
		runko.add(teksti);
		runko.setVisible(true);
		
		
		
	}

}
