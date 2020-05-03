package _05_typing_tutor;

import java.util.Random;

import javax.swing.JFrame;

public class typing {
	char currentLetter;
	currentLetter = generateRandomLetter();
	
	void run () {
		generateRandomLetter letter = new generateRandomLetter();
	}
char generateRandomLetter() {
    Random r = new Random();
    return (char) (r.nextInt(26) + 'a');
}
}

