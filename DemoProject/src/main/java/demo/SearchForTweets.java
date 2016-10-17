package demo;

import java.util.List;

import twitter4j.Status;
//import demo.ReadingTextFile;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.api.TweetsResources;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class SearchForTweets {
	public static void main(String[] args) {
	   Twitter twitter = getTwitterInstance();
    try {
     
        List<Status> statuses;
        String user;
       
           user = "Reem Jazi";
           //Returns the 20 most recent statuses posted from the authenticating user.
           statuses = twitter.getUserTimeline(user);
		   // Search for Tweets
           Query o= new Query("#عاجل");
           QueryResult pp=  twitter.search(o);
      
          for (Status status : pp.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText()+"\n##########\n");
        }
    } catch (TwitterException te) {
        te.printStackTrace();
        System.out.println("Failed to get timeline: " + te.getMessage());
        System.exit(-1);
    }
  Status s;
	try {
		s = twitter.updateStatus("testTweet");
		System.out.println("Successfully updated the status to [" + s.getText() + "].");
	} catch (TwitterException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    


	}
public static Twitter getTwitterInstance()
{
      ConfigurationBuilder cb = new ConfigurationBuilder();
                               
                                 cb.setOAuthConsumerKey("VyR6noAxWLm3sUn6iT4xGOGYB")
                                 .setOAuthConsumerSecret("TEXbzD89olutpQyEjfeeNEcHEqSV9QVRYuKV1Lg6W2kT2rBPXi")
                                 .setOAuthAccessToken("787751133498449921-7smX59HK5d4ugh97Vw9M03sM0lV1zzQ")
                                 .setOAuthAccessTokenSecret("k4qaHx3ejpBtIWvJs35N8R601hsgrHVwGN4idTXUY01QB")
                                        .setJSONStoreEnabled(true);
                                
                                 TwitterFactory tf = new TwitterFactory(cb.build());  
                                
                                Twitter twitter = tf.getInstance();
                                return twitter;
}
}
