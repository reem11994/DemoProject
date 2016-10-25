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

import twitterFunctions.ProfileData;

public class TestDataset {
	public static void main(String[] args) {
		List<ProfileData> profileData;
		ReadingTextFile read = new ReadingTextFile();
		List<File> files;
		File curDir = new File("C:\\Users\\hamada1\\Desktop\\00\\00");
		files = getAllFiles(curDir);
		int count = 0;
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("CC:\\Users\\hamada1\\Desktop\\profiles.txt","UTF-8");
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

					for (int j = 0; j < profileData.size(); j++) {
						id = profileData.get(j).getID();

						System.out.println("Id No." + count + "\t" + id);
						count++;
						StringBuilder result = new StringBuilder();
						String line;

						writer.println("Id No." + count + "\t" + id);
						writer.println("\r");

					//	connectingToTwitter(id);

					}
				}

			}
		}
		writer.close();
	}

	private static void connectingToTwitter(String id) {
		URL url;
		try {
			url = new URL("https://www.google.com/");
			HttpURLConnection conn;

			try {
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				System.out.println(conn);
				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				if (conn.getURL().getPath().contains("suspended")) {
					System.out.println("suspended");
				}
				rd.close();

			} catch (IOException e1) { // TODO Auto-generated
										// catch block
				e1.printStackTrace();
			}

		} catch (MalformedURLException e) { // TODO
											// Auto-generated
											// catch
			e.printStackTrace();
		}

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
