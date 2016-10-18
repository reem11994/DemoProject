package demo;

import twitter4j.Twitter;
import twitter4j.TwitterException;

public class RetweetStatus {
	public static void main(String[] args) {
       
        try {
       
        	GetAccessToken getInst=new GetAccessToken();
	  		   Twitter twitter = getInst.getTwitterInstance();
	  		   long id=65404941;
            twitter.retweetStatus(id);
            System.out.println("Successfully retweeted status [" + id + "].");
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to retweet: " + te.getMessage());
            System.exit(-1);
        }
    }
}
