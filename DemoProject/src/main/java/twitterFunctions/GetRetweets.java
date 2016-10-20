package twitterFunctions;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * Shows up to 100 of the first retweets of a given tweet.
 *
 */
public class GetRetweets {
	public static void main(String[] args) {

		try {
			GetAccessToken getInst = new GetAccessToken();
			Twitter twitter = getInst.getTwitterInstance();
			long id = 18720140;
			List<Status> statuses = twitter.getRetweets(id);
			for (Status status : statuses) {
				System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
			}
			System.out.println("done.");
			System.exit(0);
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get retweets: " + te.getMessage());
			System.exit(-1);
		}
	}

}
