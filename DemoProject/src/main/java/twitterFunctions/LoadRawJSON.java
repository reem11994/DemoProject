package twitterFunctions;

import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterObjectFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dataset.ReadingTextFile;
import dataset.StatuesData;

/**
 * Example application that load raw JSON forms from statuses/ directory and
 * dump status texts.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public final class LoadRawJSON {
	/**
	 * Usage: java twitter4j.examples.json.LoadRawJSON
	 *
	 * @param args
	 *            String[]
	 */		
	final static String INTERFACE = "[A-Za-z0-9].*";
	public static void main(String[] args) {

		List<File> files;
		List<String> lines;
		File curDir = new File("C:\\Users\\Lenovo\\Desktop\\00\\00");
		files = getAllFiles(curDir);
		for (int i = 0; i < files.size(); i++) {
			File dir = files.get(i);
			File[] file = dir.listFiles();
			for (File f : file) {
		
				String text = f.toString();
				Boolean found;
	
				String line1 = null;
				found = text.matches("(?i).*tweets.txt");
				
				if (found == true) {

					//System.out.println("#####" + f);
					lines = readLines(f);

					Status status;
					for (int j = 0; j < lines.size(); j++) {
						line1 = lines.get(j);
						try {
							status = TwitterObjectFactory.createStatus(line1);
							if (status.getText() != null)
								System.out.println("@" + status.getUser().getScreenName()+ "Id "+ status.getUser().getId() + " - " + status.getText());
							 Pattern p = Pattern.compile("(.*)(?<=#)(" + INTERFACE + ")(?<=\\s)(.*)");
						      Matcher m = p.matcher(status.getText()); 
						    //found1 = status.getText().matches("(.*)(?<=#)(" + INTERFACE + ")");	//("(.*)(\\s+)(#(.*))");
						      while(m.find()) {
						    	  System.out.println("rrrrrrr "+ m.group(0));
						    	  System.out.println("%%%%%%%%%%%%%%%% "+ m.group(1));
						    	  System.out.println("tttttttttttt " + m.group(2));
							   // System.out.println(">>>>>>>" + m.find());
						    	  }
						} catch (TwitterException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
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

	private static String readFirstLine(File fileName) throws IOException {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(fileName);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			return br.readLine();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ignore) {
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException ignore) {
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException ignore) {
				}
			}
		}
	}

	public static List<String> readLines(File f) {
		// Open the file
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine = null;
		List<String> lines;
		lines = new ArrayList<String>();

		// Read File Line By Line
		try {
			while ((strLine = br.readLine()) != null) {
				lines.add(strLine);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lines;

	}
}