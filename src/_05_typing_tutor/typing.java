package _05_typing_tutor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class typing implements KeyListener {
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	char currentLetter;
	int times = 0;
	Date timeAtStart = new Date();
	void run() {
		frame.setTitle("Type or die");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	currentLetter = generateRandomLetter();
	label.setText(currentLetter+"");
	label.setFont(label.getFont().deriveFont(28.0f));
	label.setHorizontalAlignment(JLabel.CENTER);
	frame.addKeyListener(this);
	frame.add(label);
	frame.pack();
	}
	
	
char generateRandomLetter() {
    Random r = new Random();
    return (char) (r.nextInt(26) + 'a');
}


@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void keyPressed(KeyEvent e) {
	char keyPressed = e.getKeyChar();
	System.out.println("You typed: " + currentLetter);
if (keyPressed==currentLetter) {
	System.out.println("correct");
	frame.setBackground(Color.green);
	times+=1;
	if (times>=20) {
		showTypingSpeed(20);
	}
}
else if (keyPressed != e.getKeyChar()) {
	System.out.println("wrong");
	frame.setBackground(Color.RED);

}
	currentLetter=generateRandomLetter();
	label.setText(currentLetter+"");
	
}


@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
private void showTypingSpeed(int numberOfCorrectCharactersTyped) {
    Date timeAtEnd = new Date();
    long gameDuration = timeAtEnd.getTime() - timeAtStart.getTime();
    long gameInSeconds = (gameDuration / 1000) % 60;
    double charactersPerSecond = ((double) numberOfCorrectCharactersTyped / (double) gameInSeconds);
    int charactersPerMinute = (int) (charactersPerSecond * 60);
    JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute + " characters per minute.");
} 
}

