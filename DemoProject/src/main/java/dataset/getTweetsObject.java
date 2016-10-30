package dataset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

import java.net.URL;

import java.util.ArrayList;
import java.util.List;




import twitter4j.Twitter;

import twitterFunctions.GetAccessToken;

public class getTweetsObject {
	public static void main(String[] args) {
		GetAccessToken getInstance = new GetAccessToken();
		List<StatuesData> status = null;
		ReadingTextFile read = new ReadingTextFile();
		List<File> files;
		List<String> lines;
		String t = null;
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
				String word = "fav_tweets";
				String text = f.toString();
				// System.out.println("file name "+text);
				Boolean found;
				String line;

				found = text.contains(word);
				if (found == true) {

					lines = read.readLines(f);

					// status = read.getStatuesDataFromJason(s);
					// System.out.println("!!!!"+status.size());
					for (int j = 0; j < lines.size(); j++) {
						// System.out.println("size "+lines.size());
						line = lines.get(j);
						//System.out.println("file name "+text);
						//System.out.println("####" + j + line);
						status = read.getStatuesDataFromJason(line);
						// t = status.get(j).getText();
						// System.out.println("Text No."+ j+"\t" + t);

					
					for (int e = 0; e < status.size(); e++) {
						System.out.println("file name "+text);
						// System.out.println("size "+status.size());
						t = status.get(e).getText();
						System.out.println("Text No." + e + "\t" + t);

					}}

				}
			}
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
