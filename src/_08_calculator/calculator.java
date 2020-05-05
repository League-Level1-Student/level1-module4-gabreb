package _08_calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculator implements ActionListener {
JFrame frame = new JFrame();
JPanel panel = new JPanel();
JTextField t1 = new JTextField(12);
JLabel label = new JLabel();
JTextField t2 = new JTextField(12);
JLabel label2 = new JLabel();
JLabel label3 = new JLabel();
JLabel label4 = new JLabel();
JButton b1 = new JButton();
JButton b2 = new JButton();
JButton b3 = new JButton();
JButton b4 = new JButton();
JLabel l = new JLabel();
	void run() {
	frame.setVisible(true);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	frame.setSize(360, 200);
	frame.add(panel);
	l.setText("  ");
	panel.add(l);
	panel.add(t1);
	frame.setTitle("Simple Calculator");
	label.setText("  ");
	panel.add(label);
	panel.add(t2);
	label2.setText("   ");
	panel.add(label2);
	b1.setText("add");
	b2.setText("sub");
	b3.setText("mul");
	b4.setText("divide");
	panel.add(b1);
	panel.add(b2);
	panel.add(b3);
	panel.add(b4);
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	label3.setText("      ");
	label4.setText("");
	label4.setFont(label.getFont().deriveFont(28.0f));
	label4.setHorizontalAlignment(JLabel.CENTER);
	label4.setSize(200, 200);
	panel.add(label3);
	panel.add(label4);
	
}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed==b1) {
			int x = Integer.parseInt(t1.getText());
			int y = Integer.parseInt(t2.getText());
			label4.setText(""+(x+y));
		}
		else if (buttonPressed==b2) {
			int x = Integer.parseInt(t1.getText());
			int y = Integer.parseInt(t2.getText());
			label4.setText(""+(x-y));
		}
		else if (buttonPressed==b3) {
			int x = Integer.parseInt(t1.getText());
			int y = Integer.parseInt(t2.getText());
			label4.setText(""+(x*y));
		}
		else if (buttonPressed==b4) {
			int x = Integer.parseInt(t1.getText());
			int y = Integer.parseInt(t2.getText());
			label4.setText(""+(x/y));
		}
		
	}
}
