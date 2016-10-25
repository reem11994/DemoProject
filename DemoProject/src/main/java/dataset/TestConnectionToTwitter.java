package dataset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class TestConnectionToTwitter {
	public static void main(String[] args) throws InterruptedException, IOException, Exception
	{

	boolean m2=  is_suspended("https://www.twitter.com/boom0535"); // true
	m2=is_suspended("https://www.twitter.com/PSL_U");// true
	m2=is_suspended("https://www.twitter.com/TEN_GOP");// false
	}



	public static boolean is_suspended(String str_URL) throws InterruptedException {

	URL obj;
	boolean redirect=false;
	try {
	obj = new URL(str_URL);
	HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
	conn.setReadTimeout(5000);
	conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
	conn.addRequestProperty("User-Agent", "Mozilla");
	conn.addRequestProperty("Referer", "google.com");
	conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

	int status = conn.getResponseCode();

	if(status==404)
	{
	return true;
	}
	if (status != HttpURLConnection.HTTP_OK) {
	if (status == HttpURLConnection.HTTP_MOVED_TEMP
	|| status == HttpURLConnection.HTTP_MOVED_PERM
	|| status == HttpURLConnection.HTTP_SEE_OTHER)
		redirect = true;
	}

	System.out.println("Response Code ... " + status);

	if (redirect) {

	// get redirect url from "location" header field
	String newUrl = conn.getHeaderField("Location");

	// get the cookie if need, for login
	String cookies = conn.getHeaderField("Set-Cookie");

	// open the new connnection again
	conn = (HttpsURLConnection) new URL(newUrl).openConnection();
	conn.setRequestProperty("Cookie", cookies);
	conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
	conn.addRequestProperty("User-Agent", "Mozilla");
	conn.addRequestProperty("Referer", "google.com");

	conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

	System.out.println("Redirect to URL : " + newUrl);

	}


	System.out.printf(conn.getURL().getPath());


	if(conn.getURL().getPath().contains("suspended"))
	{
	return true;
	}

	BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));


	String inputLine;
	while ((inputLine = rd.readLine()) != null)
	{

	if(inputLine.contains("Sorry, that page doesn’t exist!"))
	return true;
	}
	return false;



	} catch (Exception e) {
	e.printStackTrace();
	Thread.sleep(3000);
	}



	return false;


	
	}
}
