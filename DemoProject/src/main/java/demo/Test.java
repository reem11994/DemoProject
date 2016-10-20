package demo;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
				id = profileData.get(i).getLocation();
				System.out.println("Id No."+count+ "\t"+ id);
			}

			/*
			 * StringBuilder result = new StringBuilder(); URL url; try { url =
			 * new URL("https://twitter.com//"+id); HttpURLConnection conn; try
			 * { conn = (HttpURLConnection) url.openConnection();
			 * System.out.println(conn); conn.setRequestMethod("GET");
			 * BufferedReader rd = new BufferedReader(new
			 * InputStreamReader(conn.getInputStream())); String line;
			 * PrintWriter writer = new
			 * PrintWriter("C:\\Users\\hamada1\\Desktop\\the-file-name.txt",
			 * "UTF-8");
			 * 
			 * while ((line = rd.readLine()) != null) { result.append(line);
			 * result.append("\r"); //System.out.println("line"+line);
			 * writer.println(line); writer.println("\r"); }
			 * //System.out.println("line"+ result.toString()); rd.close();
			 * 
			 * writer.close();
			 * 
			 * } catch (IOException e1) { // TODO Auto-generated catch block
			 * e1.printStackTrace(); }
			 * 
			 * 
			 * 
			 * 
			 * } catch (MalformedURLException e) { // TODO Auto-generated catch
			 * block e.printStackTrace(); }
			 * 
			 * String word = "Sorry, that page doesn’t exist"; String text =
			 * result.toString(); Boolean found;
			 * 
			 * found = text.contains(word); System.out.println("kkkkk"+found);
			 * 
			 * 
			 * 
			 * }
			 */

		}
	}}
	


   
	




