package _11_whack_a_mole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class whacky implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	int random = new Random().nextInt(24);
	void run() {
frame.setVisible(true);
frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
frame.add(panel);
frame.setSize(359,230);
frame.setTitle("Whack a mole for fame and glory!");

drawButton(random);
	}
	void drawButton(int random) {
		for (int i = 0; i < 24; i++) {
			JButton button = new JButton();
			panel.add(button);
			button.addActionListener(this);
			if (i==random) {
				button.setText("mole!");
			}
		
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed.getText().equalsIgnoreCase("mole!")) {
		}
		else {
			speak("Miss!");
		}
		frame.remove(panel);
		random = new Random().nextInt(24);
		drawButton(random);
		
	}
	void speak(String words) { 
	    try { 
	        Runtime.getRuntime().exec("say " + words).waitFor();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
}
