package twitterFunctions;

/**
 * Lists friends' ids
 *
 */
import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class GetFriendsIDs {
	public static void main(String[] args) {
		try {
			GetAccessToken getInstance = new GetAccessToken();
			Twitter twitter = getInstance.getTwitterInstance();
			long cursor = -1;
			IDs ids;
			int count = 0;
			System.out.println("Listing following ids.");
			do {
				if (0 < args.length) {
					ids = twitter.getFriendsIDs(args[0], cursor);
				} else {
					ids = twitter.getFriendsIDs(cursor);
				}
				for (long id : ids.getIDs()) {
					System.out.println(id);
					count++;
				}
				System.out.println("No. of friends " + count);
			} while ((cursor = ids.getNextCursor()) != 0);
			System.exit(0);
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get friends' ids: " + te.getMessage());
			System.exit(-1);
		}
	}

}
