package demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;


public class ReadingTextFile {


public String readFile(String filename) 
{
    String content = null;
    File file = new File("C:\\Users\\hamada1\\Desktop\\00\\00\\21796370\\profile.txt"); //for ex foo.txt
    FileReader reader = null;
    try {
        reader = new FileReader(file);
        char[] chars = new char[(int) file.length()];
        reader.read(chars);
        content = new String(chars);
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if(reader !=null){try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
    }
    return content;
}
public List<ProfileData> getObjectFromJason(String jason)
{

    List<ProfileData> profilesData;
    try
        {
           // JSONArray jsonArray = new JSONArray(jason);
            profilesData = new ArrayList<ProfileData>();
            //for(int i=0;i<jsonArray.length();i++)
                {
                    JSONObject jsonObject = new JSONObject(jason);
                   // jsonObject= (JSONObject) jsonArray.get(i);
                    ProfileData profileData = new ProfileData();
                    //countriesData.setID(jsonObject.getInt("id"));
                    profileData.setLocation(jsonObject.getString("id"));
                    //countriesData.setLon(jsonObject.getDouble("lon"));
                    //countriesData.setLat(jsonObject.getDouble("lat"));
                   // countriesData.setUrl(jsonObject.getString("url"));
                   // countriesData.setDes(jsonObject.getString("des"));
                    //countriesData.setRate(jsonObject.getInt("rate"));
                    profilesData.add(profileData);
                }
        }
    catch (JSONException e)
        {
            e.printStackTrace();
            return null;
        }

    return profilesData;
}
}
