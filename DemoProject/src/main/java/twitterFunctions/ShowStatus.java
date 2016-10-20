package twitterFunctions;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class ShowStatus {
	public static void main(String[] args) {

		try {
			GetAccessToken getInst = new GetAccessToken();
			Twitter twitter = getInst.getTwitterInstance();
			long id = 1234567891;
			Status status = twitter.showStatus(id);
			System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
			System.exit(0);
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to show status: " + te.getMessage());
			System.exit(-1);
		}
	}

}
