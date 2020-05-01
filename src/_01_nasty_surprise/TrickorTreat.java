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
		if (buttonPressed == button) {
			showPictureFromTheInternet(
					"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRo0dmiLG9Z6WgJLjUAOHf02MqHfx3H2IfEOMbxpNs9sn63FAap&usqp=CAU");
			frame.pack();
		} else if (buttonPressed == button2) {
			showPictureFromTheInternet(
					"https://www.thelabradorsite.com/wp-content/uploads/2019/03/Cute-puppy-Names-Over-200-Adorable-Ideas-LS-long.jpg");
			frame.pack();
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
