package _11_whack_a_mole;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class whacky implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	int times = 0;
	int timeM = 0;
	int random = new Random().nextInt(24);
	Date timeAtStart = new Date();
	void run() {
		System.out.println(times);
		System.out.println(timeM);
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
			times+=1; 
			playSound("win.wav");
			if (times==10) {
				endGame(timeAtStart, times);
				
			}
		}
		else {
			timeM+=1;
			if (timeM==1) {
				speak("Miss!");
			}
			else if (timeM==2) {
				speak("Could you be more incompetent!");
			}
			else if (timeM==3) {
				speak("Your IQ is five!");
			}
			else if (timeM==4) {
				speak("Go wash dishes you incompetent slime!");
			}
			else if (timeM==5) {
				speak("Your incompetence has killed you");
				System.exit(0);
			}
		}
		frame.dispose();
		run();
		
		
	}
	void speak(String words) { 
	    try { 
	        Runtime.getRuntime().exec("say " + words).waitFor();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	private void endGame(Date timeAtStart, int molesWhacked) { 
	    Date timeAtEnd = new Date();
	    JOptionPane.showMessageDialog(null, "Your whack rate is "
	            + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	                  + " moles per second.");
	}
	private void playSound(String fileName) { 
	    AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
	    sound.play();
	}
	
}
