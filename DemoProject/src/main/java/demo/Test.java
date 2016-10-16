package demo;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.api.TweetsResources;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;
public class Test {
	public static void main(String[] args) {
    Twitter twitter = get_twitter_instance();
    try {
     
        List<Status> statuses;
        String user;
       
//            user = "Izdihar Shneneh";
//            statuses = twitter.getUserTimeline(user);
            Query o= new Query("#عاجل");
           
          QueryResult pp=  twitter.search(o);
      
     
        for (Status status : pp.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
        }
    } catch (TwitterException te) {
        te.printStackTrace();
        System.out.println("Failed to get timeline: " + te.getMessage());
        System.exit(-1);
    }
}


public static Twitter get_twitter_instance()
{
      ConfigurationBuilder cb = new ConfigurationBuilder();
                               
                                 cb.setOAuthConsumerKey("sPxuPeP9I1YQf43WowJEiBOSI")
                                 .setOAuthConsumerSecret("SQI20VhoCLRArpLeqotNhSG03Lk4v5roer5tVsxiBJcQ67U2Dz")
                                 .setOAuthAccessToken("755476527890964480-Bg3A1FBfCZVQD7L3hemLw9lcvgJpVnm")
                                 .setOAuthAccessTokenSecret("5rsn19DYp9iRP07oxlj63nvUn4B1nUhRcS9CKQFYNmzuu")
                                        .setJSONStoreEnabled(true);
                                
                                 TwitterFactory tf = new TwitterFactory(cb.build());  
                                
                                Twitter twitter = tf.getInstance();
                                return twitter;
}


}
