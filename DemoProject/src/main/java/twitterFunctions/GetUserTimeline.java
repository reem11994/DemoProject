package twitterFunctions;

import twitter4j.Twitter;

import java.util.List;

import twitter4j.Status;
import twitter4j.TwitterException;


public class GetUserTimeline {
	public static void main(String[] args) {
		GetAccessToken getInstance = new GetAccessToken();
		Twitter twitter = getInstance.getTwitterInstance();
		try {
			List<Status> statuses;
			String user;
			if (args.length == 1) {
				user = args[0];
				statuses = twitter.getUserTimeline(user);
			} else {
				user = twitter.verifyCredentials().getScreenName();
				statuses = twitter.getUserTimeline();
			}
			System.out.println("Showing @" + user + "'s user timeline.");
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
