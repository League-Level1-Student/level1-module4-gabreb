package _01_nasty_surprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TrickorTreat implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	JButton button2 = new JButton();
	void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(button);
		panel.add(button2);
		button.setText("Trick");
		button2.setText("Treat");
		button.addActionListener(this);
		button2.addActionListener(this);
		frame.pack();
	}
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
if (buttonPressed==button) {
	showPictureFromTheInternet("https://www.google.com/imgres?imgurl=https%3A%2F%2Fi.imgflip.com%2Fams2j.jpg&imgrefurl=https%3A%2F%2Fimgflip.com%2Fmemetemplate%2F17858971%2FEvil-Puppy&tbnid=6zZmttGfOotnlM&vet=12ahUKEwjupu-ql5HpAhVFBDQIHR6zCJwQMygAegUIARDkAQ..i&docid=e3lSy1wcDHx40M&w=254&h=198&q=evil%20puppy&safe=strict&client=safari&ved=2ahUKEwjupu-ql5HpAhVFBDQIHR6zCJwQMygAegUIARDkAQ");
}
else if (buttonPressed==button2) {
	showPictureFromTheInternet("https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.thelabradorsite.com%2Fwp-content%2Fuploads%2F2019%2F03%2FCute-puppy-Names-Over-200-Adorable-Ideas-LS-long.jpg&imgrefurl=https%3A%2F%2Fwww.thelabradorsite.com%2Fcute-puppy-names%2F&tbnid=nVWN3jZwTuBpGM&vet=12ahUKEwi8i6ynl5HpAhVZAjQIHdClA2gQMygAegUIARCmAg..i&docid=asclfktjFLoRYM&w=1200&h=650&q=cute%20puppy&safe=strict&client=safari&ved=2ahUKEwi8i6ynl5HpAhVZAjQIHdClA2gQMygAegUIARCmAg");
}
		
	}

private void showPictureFromTheInternet(String imageUrl) {
    try {
        URL url = new URL(imageUrl);
        Icon icon = new ImageIcon(url);
        JLabel imageLabel = new JLabel(icon);
        JFrame frame = new JFrame();
        frame.add(imageLabel);
        frame.setVisible(true);
        frame.pack();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
}
}
