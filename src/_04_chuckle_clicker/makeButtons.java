package _04_chuckle_clicker;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class makeButtons {
	
	makeButtons (String buttonname) {
	JFrame frame = new JFrame();
	frame.setVisible(true);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	JButton button = new JButton();
	button.setText(buttonname);
	JPanel panel = new JPanel();
	frame.add(panel);
	panel.add(button);
	}
}
