package twitterFunctions;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import twitter4j.Query;
import twitter4j.QueryResult;

public class SearchForTweets {
	public static void main(String[] args) {

		GetAccessToken getInstance = new GetAccessToken();
		Twitter twitter = getInstance.getTwitterInstance();
		try {
			Query query = new Query("عاجل#");
			QueryResult result;
			do {
				result = twitter.search(query);
				List<Status> tweets = result.getTweets();
				for (Status tweet : tweets) {
					System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
				}
			} while ((query = result.nextQuery()) != null);
			System.exit(0);
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
			System.exit(-1);
		}

	}

}
