package _12_slot_machine;


import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
JFrame frame = new JFrame();
JPanel panel;
JLabel l1 = new JLabel();
JLabel l2 = new JLabel();
JLabel l3 = new JLabel();
int r1 = new Random().nextInt(3);
int r2 = new Random().nextInt(3);
int r3 = new Random().nextInt(3);
JButton button = new JButton();
	void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		panel = new JPanel();
		frame.add(panel);
		try {
			if (r1==0) {
				panel.add(createLabelImage("Cherry.jpg"));
			}
			else if (r1==1) {
				panel.add(createLabelImage("Lime.jpg"));
			}
			else if (r1==2) {
				panel.add(createLabelImage("Orange.jpg"));
			}
			if (r2==0) {
				panel.add(createLabelImage("Cherry.jpg"));
			}
			else if (r2==1) {
				panel.add(createLabelImage("Lime.jpg"));
			}
			else if (r2==2) {
				panel.add(createLabelImage("Orange.jpg"));
			}
			if (r3==0) {
				panel.add(createLabelImage("Cherry.jpg"));
			}
			else if (r3==1) {
				panel.add(createLabelImage("Lime.jpg"));
			}
			else if (r3==2) {
				panel.add(createLabelImage("Orange.jpg"));
			}
			panel.add(button);
			button.setText("Spin");
			button.addActionListener(this);
			frame.pack();
			if (r1==r2&&r2==r3) {
				JOptionPane.showMessageDialog(null, "You WIN");
				playSound("win.wav");
			}
		
			
		
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
}
	
	
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}
	private void playSound(String fileName) { 
	    AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
	    sound.play();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		r1 = new Random().nextInt(3);
		r2 = new Random().nextInt(3);
		r3 = new Random().nextInt(3);
		frame.remove(panel);
		run();
		
	}
}
