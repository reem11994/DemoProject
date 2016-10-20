package demo;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class UpdateStatus {
	public static void main(String[] args) {
	    try{
	        	GetAccessToken getInst=new GetAccessToken();
	  		   Twitter twitter = getInst.getTwitterInstance();
    Status status = twitter.updateStatus("good morning");
    System.out.println("Successfully updated the status to [" + status.getText() + "].");
    System.exit(0);
} catch (TwitterException te) {
    te.printStackTrace();
    System.out.println("Failed to get timeline: " + te.getMessage());
    System.exit(-1);
} 
}}
