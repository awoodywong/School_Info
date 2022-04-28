package hk.edu.hkmu.schoolinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SchoolInfo {
    public static String SCHOOLNO = "A";
    public static String ENGCATEGORY = "B";
    public static String ENGNAME = "D";
    public static String ENGADDRESS = "F";
    public static String LONGTITUDE = "H";
    public static String LATITUDE = "J";
    public static String EASTING = "L";
    public static String NORTHING = "N";
    public static String STDGENDER = "P";
    public static String SESSION = "R";
    public static String DISTRICT = "T";
    public static String FINTYPE = "V";
    public static String SCHOOLLV = "X";
    public static String TELEPHONE = "Z";
    public static String FAXNO = "AB";
    public static String WEBSITE = "AD";
    public static String RELIGION = "AF";

    public static ArrayList<HashMap<String, String>> schoolList = new ArrayList<>();

    // Creates and add school to school list
    public static void addSchool(String schoolNo, String engCategory, String engName, String engAddress,
                                 String longtitude, String latitude, String easting, String northing,
                                 String stdGender, String session, String district, String fintype,
                                 String schoolLv, String telephone, String faxno, String website,
                                 String religion) {
        // Create contact
        HashMap<String, String> school = new HashMap<>();
        school.put(SCHOOLNO, schoolNo);
        school.put(ENGCATEGORY, engCategory);
        school.put(ENGNAME, engName);
        school.put(ENGADDRESS, engAddress);
        school.put(LONGTITUDE, longtitude);
        school.put(LATITUDE, latitude);
        school.put(EASTING, easting);
        school.put(NORTHING, northing);
        school.put(STDGENDER, stdGender);
        school.put(SESSION, session);
        school.put(DISTRICT, district);
        school.put(FINTYPE, fintype);
        school.put(SCHOOLLV, schoolLv);
        school.put(TELEPHONE, telephone);
        school.put(FAXNO, faxno);
        school.put(WEBSITE, website);
        school.put(RELIGION, religion);



        // Add contact to contact list
        schoolList.add(school);
    }

}
