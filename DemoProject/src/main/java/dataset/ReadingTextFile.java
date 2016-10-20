package dataset;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import twitterFunctions.ProfileData;

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

	public List<ProfileData> getObjectFromJason(String jason) {

		List<ProfileData> profilesData;
		try {

			profilesData = new ArrayList<ProfileData>();

			{
				JSONObject jsonObject = new JSONObject(jason);
				ProfileData profileData = new ProfileData();
				profileData.setID(jsonObject.getString("id"));
				profilesData.add(profileData);
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}

		return profilesData;
	}
}
