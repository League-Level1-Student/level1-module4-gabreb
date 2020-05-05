package _09_latest_tweet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class twitter implements ActionListener {
JFrame frame = new JFrame();
JPanel panel = new JPanel();
JTextField t1 = new JTextField(12);
JButton b1 = new JButton();
JLabel label = new JLabel();
	void run() {
	String myman = t1.getText(); 
	frame.setVisible(true);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	frame.add(panel);
	panel.add(t1);
	b1.setText("Search the Twitterverse");
	b1.addActionListener(this);
	panel.add(b1);
	frame.pack();
}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Tweet, Tweet");
		String myman = t1.getText(); 
		String go = getLatestTweet(myman);
		frame.remove(panel);
		label.setText(go);
		frame.add(label);
		frame.pack();
	}
	
	
	private String getLatestTweet(String searchingFor) {

	    Twitter twitter = new TwitterFactory().getInstance();

	    AccessToken accessToken = new AccessToken(
	        "2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
	        "vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");
	    twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN",
	        "6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");
	    twitter.setOAuthAccessToken(accessToken);

	Query query = new Query(searchingFor);
	    try {
	        QueryResult result = twitter.search(query);
	        return result.getTweets().get(0).getText();
	    } catch (Exception e) {
	        System.err.print(e.getMessage());
	        return "What the heck is that?";
	    }
	}
}
