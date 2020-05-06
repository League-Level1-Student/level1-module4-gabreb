package _10_pig_latin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class pigLatin implements ActionListener {
JFrame frame = new JFrame();
JPanel panel = new JPanel();
JButton b1 = new JButton();
JTextField t1 = new JTextField(20);
JTextField t2 = new JTextField(20);
PigLatinTranslator pig = new PigLatinTranslator();
	void run() {
	frame.setVisible(true);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	frame.setTitle("Pig Latin Translator");
	frame.add(panel);
	panel.add(t1);
	b1.setText("translator");
	panel.add(b1);
	panel.add(t2);
	frame.pack();
	b1.addActionListener(this);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		t2.setText(pig.translate(t1.getText()));
	}
}
