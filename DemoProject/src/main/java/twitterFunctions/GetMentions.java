package twitterFunctions;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

public class GetMentions {
	public static void main(String[] args) {
		GetAccessToken getInstance = new GetAccessToken();
		Twitter twitter = getInstance.getTwitterInstance();
		try {
			User user = twitter.verifyCredentials();
			List<Status> statuses = twitter.getMentionsTimeline();
			System.out.println("Showing @" + user.getScreenName() + "'s mentions.");
			for (Status status : statuses) {
				System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
			}
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get timeline: " + te.getMessage());
			System.exit(-1);
		}
	}

}
