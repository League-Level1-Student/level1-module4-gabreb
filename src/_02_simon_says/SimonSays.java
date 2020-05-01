package _02_simon_says;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.IOException;

public class SimonSays extends KeyAdapter {

	HashMap<Integer, String> images = new HashMap<Integer, String>();
	private int imageIndex;
	private int tries = 0;
	private boolean simonSays = false;
	Date timeAtStart;
	int randy = new Random().nextInt(2);
	int score = 0;
	// Complete steps 1 - 7 before you test
	// 1. Declare a JFrame variable
	JFrame frame = new JFrame();

	public void run() {
		// 2. Add the four images that match keyboard keys like this:
		// images.put(new Integer(KeyEvent.VK_UP), "up.jpg");
		images.put(new Integer(KeyEvent.VK_UP), "up.jpg");
		images.put(new Integer(KeyEvent.VK_LEFT), "left.jpg");
		images.put(new Integer(KeyEvent.VK_RIGHT), "right.jpg");
		images.put(new Integer(KeyEvent.VK_DOWN), "down.jpg");

		// 3. Use a JOptionPane to tell the user the rules: "Press the matching
		// key when
		// 'Simon says' otherwise press a different key"
		JOptionPane.showMessageDialog(null,
				"If simon says press that key then press that key. Otherwise press a different key.");
		// 4. Call the showImage method to show an image
		showImage();
	}

	public void keyPressed(KeyEvent e) {
		// 15. Make a points variable to track the score.
		int keyCode = e.getKeyCode();

		// 16. If the keyCode matches the imageIndex and "Simon says"
		if (simonSays && imageIndex == keyCode) {
			score += 1;
			speak("correct");
			tries ++;
		} else if (!simonSays && imageIndex != keyCode) {
			score += 1;
			speak("correct");
			tries++;
		}
			else { 
				score -= 1;
				tries++;
			}
		if (tries==9) {
			JOptionPane.showMessageDialog(null, "Your score is " + score);
			System.exit(0);
			frame.dispose();
		}
		showImage();

		// 17. Increase the value of score

		// 18. Use the speak method to tell the user they were correct

		// 19. If the keyCode doesn't match the imageIndex and "Simon didn't
		// say..."

		// 20. Increase the value of score

		// 21. Use the speak method to tell the user they were correct

		// 22. Increment tries by 1

		// 25. If tries is greater than 9 (or however many you want)...

		// 26. Tell the user their score

		// 27. Exit the program

		// 23. Dispose of the frame

		// 24. Call the showImage method to show a new image
	}

	private void showImage() {
		// 5. Initialize your frame to a new JFrame()
		JFrame frame = new JFrame();
		frame.setVisible(true);
		// 6. Set the frame to visible
		frame.add(getNextRandomImage());

		// 8. Set the name of your frame
		frame.setTitle("SimonSays");
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		// 9. Pack the frame

		// 10. Set the defaultCloseOperation of your frame to
		// JFrame.EXIT_ON_CLOSE
		frame.addKeyListener(this);
		// 11. Add a key listener to the frame
		randy = new Random().nextInt(2);
		if (randy == 0) {
			simonSays = true;
			if (imageIndex == 39) {
				speak("Simon says press right key");
			} else if (imageIndex == 37) {
				speak("Simon says press left key");
			} else if (imageIndex == 38) {
				speak("Simon says press up key");
			} else if (imageIndex == 40) {
				speak("Simon says press down key");
			}

		}
		if (randy == 1) {
			simonSays = false;
			if (imageIndex == 39) {
				speak("press right key");
			} else if (imageIndex == 37) {
				speak("press left key");
			} else if (imageIndex == 38) {
				speak("press up key");
			} else if (imageIndex == 40) {
				speak("press down key");
			}
		}

// 12. Create a new instance of Random

		// 13. Use the Random and the speak method to either say
		// "Simon says press this key" or "Press this key"

		// 14. Above, set the value of simonSays to true/false appropriately

	}

	private Component getNextRandomImage() {
		this.imageIndex = new Random().nextInt(4) + 37;
		return loadImage(images.get(imageIndex));
	}

	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/*
 * BONUS! Add a timer : ~~~ where the code starts running ~~~ timeAtStart =
 * newDate();
 *
 * ~~~ where the code ends ~~~ Date timeAtEnd = new Date();
 * System.out.println((timeAtEnd.getTime()-timeAtStart.getTime())/1000);
 * System.exit(0);
 */
