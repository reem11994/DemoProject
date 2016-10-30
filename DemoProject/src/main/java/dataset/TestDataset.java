package dataset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitterFunctions.GetAccessToken;

public class TestDataset {
	public static void main(String[] args) {
		GetAccessToken getInstance = new GetAccessToken();
		Twitter twitter = getInstance.getTwitterInstance();
		List<ProfileData> profileData;
		List<Status> statuses;
		ReadingTextFile read = new ReadingTextFile();
		List<File> files;
		File curDir = new File("C:\\Users\\hamada1\\Desktop\\00\\00");
		files = getAllFiles(curDir);
		int count = 0;
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("C:\\Users\\hamada1\\Desktop\\reem.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < files.size(); i++) {
			File dir = files.get(i);
			File[] file = dir.listFiles();
			for (File f : file) {
				String word = "profile";
				String text = f.toString();
				Boolean found;

				found = text.contains(word);
				if (found == true) {

					String s = read.readFile(f);
					profileData = read.getObjectFromJason(s);

					String id = "";
					String screenName = "";

					for (int j = 0; j < profileData.size(); j++) {
						id = profileData.get(j).getID();
						screenName = profileData.get(j).getScreenName();

						System.out.println("Id No." + count + "\t" + id);
						System.out.println("ScreenName is " + screenName);
						count++;

						writer.println("Id No." + count + "\t" + id);
						writer.println("\r");

						/*
						 * try { boolean m2=
						 * is_suspended("https://www.twitter.com/"+screenName);
						 * //System.out.println("\n");
						 * System.out.println("result "+m2); } catch
						 * (InterruptedException e) { // TODO Auto-generated
						 * catch block e.printStackTrace(); } // true
						 */
						// System.out.println("############################");
					}
				}

			}
		}
		writer.close();
	}

	public static boolean is_suspended(String str_URL) throws InterruptedException {

		URL obj;
		boolean redirect = false;
		try {
			obj = new URL(str_URL);
			HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
			conn.setReadTimeout(5000);
			conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
			conn.addRequestProperty("User-Agent", "Mozilla");
			conn.addRequestProperty("Referer", "google.com");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			int status = conn.getResponseCode();

			if (status == 404) {
				return true;
			}
			if (status != HttpURLConnection.HTTP_OK) {
				if (status == HttpURLConnection.HTTP_MOVED_TEMP || status == HttpURLConnection.HTTP_MOVED_PERM
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

				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

				System.out.println("Redirect to URL : " + newUrl);

			}

			System.out.printf(conn.getURL().getPath());

			if (conn.getURL().getPath().contains("suspended")) {
				return true;
			}

			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String inputLine;
			while ((inputLine = rd.readLine()) != null) {

				if (inputLine.contains("Sorry, that page doesn’t exist!"))
					return true;
			}
			return false;

		} catch (Exception e) {
			e.printStackTrace();
			Thread.sleep(3000);
		}

		return false;

	}

	private static List<File> getAllFiles(File curDir) {

		List<File> resultList = new ArrayList<File>();
		File[] filesList = curDir.listFiles();
		for (File f : filesList) {
			if (f.isDirectory()) {
				resultList.add(f);
			}
			if (f.isFile()) {
				resultList.add(f);
			}

		}
		return resultList;
	}

}
