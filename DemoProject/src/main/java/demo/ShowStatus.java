package demo;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class ShowStatus {
	public static void main(String[] args) {
		
        /*if (args.length < 1) {
            System.out.println("Usage: java twitter4j.examples.tweets.ShowStatus [status id]");
            System.exit(-1);
        }*/
        try {
        	GetAccessToken getInst=new GetAccessToken();
 		   Twitter twitter = getInst.getTwitterInstance();
           // Twitter twitter = new TwitterFactory().getInstance();
 		   long id=1234567891;
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
