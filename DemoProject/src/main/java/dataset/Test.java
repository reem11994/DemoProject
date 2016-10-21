package dataset;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import twitterFunctions.ProfileData;


public class Test {
	public static void main(String[] args) {
		List<ProfileData> profileData;
		ReadingTextFile read = new ReadingTextFile();
		File dir = new File("C:\\Users\\hamada1\\Desktop\\Files\\GraduationProject\\ProfileFiles");
		File[] files = dir.listFiles();
		int count=0;
		for (File f : files) {
			//System.out.println("$$$$" + f + "\n");
			String s = read.readFile(f);
			//System.out.println(s + "\n");
			profileData = read.getObjectFromJason(s);
			String id = "";
			count++;
			for (int i = 0; i < profileData.size(); i++) {
				id = profileData.get(i).getID();
				System.out.println("Id No."+count+ "\t"+ id);
			}

			StringBuilder result = new StringBuilder();
			URL yahoo = null;
					try {
						yahoo = new URL("http://www.google.com/");
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        URLConnection yc;
					try {
					yc = yahoo.openConnection();
					BufferedReader in = new BufferedReader(
			        new InputStreamReader(yc.getInputStream()));
			        String inputLine;

			        while ((inputLine = in.readLine()) != null) 
			        System.out.println(inputLine);
			        in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
	}}
	


   
	




