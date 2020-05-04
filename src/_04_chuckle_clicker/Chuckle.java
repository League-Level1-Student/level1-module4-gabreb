package _04_chuckle_clicker;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Chuckle implements ActionListener {
	static JButton jokeButton = new JButton();
	static JButton punchline = new  JButton();
public static void main(String[] args) {
	Chuckle chuckle = new Chuckle();
	chuckle.makeButtons();
}

public void makeButtons() {
	JFrame frame = new JFrame();
	frame.setVisible(true);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	JPanel panel = new JPanel();
	frame.add(panel);
	jokeButton.setText("joke");
	punchline.setText("punchline");
	jokeButton.addActionListener(this);
	punchline.addActionListener(this);
	panel.add(jokeButton);
	panel.add(punchline);
	frame.pack();
}
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
		if (buttonPressed == jokeButton) {
			JOptionPane.showMessageDialog(null, "HI!");
			JOptionPane.showMessageDialog(null, "Why does Waldo where stripes?");
		} else if (buttonPressed == punchline) {
			JOptionPane.showMessageDialog(null, "HI!");
			JOptionPane.showMessageDialog(null, "Because he doesn't want to be spotted");
		}


		}
				
}


