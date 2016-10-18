package demo;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class GetAccessToken {
	public Twitter getTwitterInstance()
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
