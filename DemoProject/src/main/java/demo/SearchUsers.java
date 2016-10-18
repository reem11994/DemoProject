package demo;

import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

public class SearchUsers {
	public static void main(String[] args) {
       
        try {
            //Twitter twitter = new TwitterFactory().getInstance();
        	GetAccessToken getInstance = new GetAccessToken();
    		Twitter twitter = getInstance.getTwitterInstance();
            int page = 1;
            ResponseList<User> users;
            do {
                users = twitter.searchUsers("dania", page);
                for (User user : users) {
                    if (user.getStatus() != null) {
                        System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
                    } else {
                        // the user is protected
                        System.out.println("@" + user.getScreenName());
                    }
                }
                page++;
            } while (users.size() != 0 && page < 50);
            System.out.println("done.");
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search users: " + te.getMessage());
            System.exit(-1);
        }
    }

}
