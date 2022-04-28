package hk.edu.hkmu.schoolinfo;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class JsonHandlerThread extends Thread {
    private static final String TAG = "JsonHandlerThread";
    // URL to get contacts JSON file
    private static String jsonUrl = "https://storage.googleapis.com/school_list/SCH_LOC_EDB.json";

    public static String makeRequest() {
        String response = null;
        try {
            URL url = new URL(jsonUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = inputStreamToString(in);
        } catch (MalformedURLException e) {
            Log.e(TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(TAG, "ProtocolException: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
        return response;
    }

    private static String inputStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                Log.e(TAG, "IOException: " + e.getMessage());
            }
        }
        return sb.toString();
    }

    public void run() {
        String schoolStr = makeRequest();
        Log.e(TAG, "Response from url: " + schoolStr);

        if (schoolStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(schoolStr);

                // Getting JSON Array node
                JSONArray schools = jsonObj.getJSONArray("school");

                // looping through All Contacts
                for (int i = 0; i < schools.length(); i++) {
                    JSONObject c = schools.getJSONObject(i);

                    String schoolNo = c.getString("A");
                    String engCategory = c.getString("B");
                    String engName = c.getString("D");
                    String engAddress = c.getString("F");
                    String longtitude = c.getString("H");
                    String latitude = c.getString("J");
                    String easting = c.getString("L");
                    String northing = c.getString("N");
                    String stdGender = c.getString("P");
                    String session = c.getString("R");
                    String district = c.getString("T");
                    String finType = c.getString("V");
                    String schoolLv = c.getString("X");
                    String telephone= c.getString("Z");
                    String faxNo = c.getString("AB");
                    String website = c.getString("AD");
                    String religion= c.getString("AF");



                    // Add contact (name, email, address) to contact list
                    SchoolInfo.addSchool(schoolNo, engCategory, engName, engAddress, longtitude, latitude,
                            easting, northing, stdGender, session, district, finType, schoolLv, telephone,
                            faxNo, website, religion);
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
            }
        } else {
            Log.e(TAG, "Couldn't get json from server.");
        }
    }
}
