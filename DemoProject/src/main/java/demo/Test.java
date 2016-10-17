package demo;
import java.net.*;
import java.io.*;



import java.util.List;


public class Test {
	public static void main(String[] args) {
	List<ProfileData> profileData;
	ReadingTextFile read = new ReadingTextFile();
	String s=read.readFile("f");	
  // System.out.println(s);
	profileData=read.getObjectFromJason(s);
	String id = "";
	for(int i=0;i<profileData.size();i++){
		id = profileData.get(i).getLocation();
	    System.out.println("\n dania "+id);
	} 
	
	
	 URL twitter = null;
	try {
		twitter = new URL("http://www.twitter.com/"+id);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     URLConnection yc;
	try {
		yc = twitter.openConnection();
		  BufferedReader in = new BufferedReader(
                  new InputStreamReader(
                  yc.getInputStream()));
		  
String inputLine;

		while ((inputLine = in.readLine()) != null) 
		System.out.println("####\n"+inputLine);
		
		in.close();


	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
   
	




