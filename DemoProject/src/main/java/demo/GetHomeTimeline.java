package demo;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

public class GetHomeTimeline {
	 public static void main(String[] args) {
	        try {
	            // gets Twitter instance with default credentials
	            //Twitter twitter = new TwitterFactory().getInstance();
	        	GetAccessToken getInstance = new GetAccessToken();
	    		Twitter twitter = getInstance.getTwitterInstance();
	            User user = twitter.verifyCredentials();
	            List<Status> statuses = twitter.getHomeTimeline();
	            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
	            for (Status status : statuses) {
	            	//hoon ma e3mal print for arabic langauge
	                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
	            }
	        } catch (TwitterException te) {
	            te.printStackTrace();
	            System.out.println("Failed to get timeline: " + te.getMessage());
	            System.exit(-1);
	        }
	    }

}
