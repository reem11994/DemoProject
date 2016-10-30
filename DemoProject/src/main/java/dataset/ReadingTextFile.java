package dataset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ReadingTextFile {


	public String readFile(File f) {
		String content = null;
		FileReader reader = null;
		try {
			reader = new FileReader(f);
			char[] chars = new char[(int) f.length()];
			reader.read(chars);
			content = new String(chars);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return content;
	}
	
	//////////////////////////////////////////
	
	public List<String> readLines(File f) {
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
		List<StatuesData> statuses;
		List<String> lines;
		statuses = new ArrayList<StatuesData>();
		lines = new ArrayList<String>();
		ReadingTextFile read = new ReadingTextFile();

		//Read File Line By Line
		try {
			while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
			  //System.out.println ("oooo"+strLine);
			  //System.out.println("$$$$$$$$$$$$$$\n");
				//continue;
				lines.add(strLine);
				//statuses = read.getStatuesDataFromJason(strLine);
				
			
			}
			
			//Close the input stream
			br.close();
			/*String tweet=null;
			System.out.println("size !!  "+statuses.size());
			
			for (int j = 0; j < statuses.size(); j++) {
				//System.out.println("size"+statuses.size());
				tweet =  statuses.get(j).getText();
				//screenName = profileData.get(j).getScreenName();

				System.out.println("###tweets  " + tweet);
			
		}*/
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	return 	lines;
	
		
	}
	public List<ProfileData> getObjectFromJason(String jason) {

		List<ProfileData> profilesData;
		try {

			profilesData = new ArrayList<ProfileData>();

			{
				JSONObject jsonObject = new JSONObject(jason);
				ProfileData profileData = new ProfileData();
				profileData.setID(jsonObject.getString("id"));
				
				profileData.setScreenName(jsonObject.getString("screen_name"));
				profilesData.add(profileData);
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}

		return profilesData;
	}
	public List<StatuesData> getStatuesDataFromJason(String jason) {

		List<StatuesData> statuesData ;
		try {

			statuesData = new ArrayList<StatuesData>();

			{
				JSONObject jsonObject = new JSONObject(jason);
				StatuesData  stat = new StatuesData();
				stat.setText(jsonObject.getString("text"));
				
				
				statuesData.add(stat);
				//System.out.println("***************"+stat);
			//System.out.println("@@@@@@@@@@@@@@@@");
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}

		return statuesData;
	}
}
