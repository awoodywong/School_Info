package hk.edu.hkmu.schoolinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SchoolInfo {
    public static String SCHOOLNO = "A";
    public static String ENGCATEGORY = "B";
    public static String CHICATEGORY = "C";
    public static String ENGNAME = "D";
    public static String CHINAME = "E";
    public static String ENGADDRESS = "F";
    public static String CHIADDRESS = "G";
    public static String LONGTITUDE = "H";
    public static String LATITUDE = "J";
    public static String EASTING = "L";
    public static String NORTHING = "N";
    public static String STDGENDER = "P";
    public static String CHISTDGENDER = "Q";
    public static String SESSION = "R";
    public static String CHISESSION = "S";
    public static String DISTRICT = "T";
    public static String CHIDISTRICT = "U";
    public static String FINTYPE = "V";
    public static String CHIFINTYPE = "W";
    public static String SCHOOLLV = "X";
    public static String CHISCHOOLLV = "Y";
    public static String TELEPHONE = "Z";
    public static String CHITELEPHONE = "AA";
    public static String FAXNO = "AB";
    public static String CHIFAXNO = "AC";
    public static String WEBSITE = "AD";
    public static String CHIWEBSITE = "AE";
    public static String RELIGION = "AF";
    public static String CHIRELIGION = "AG";

    public static ArrayList<HashMap<String, String>> schoolList = new ArrayList<>();

    // Creates and add school to school list
    public static void addSchool(String schoolNo, String engCategory, String chiCategory, String engName, String chiName, String engAddress,
                                 String chiAddress, String longtitude, String latitude, String easting, String northing,
                                 String stdGender, String chiStdGender, String session, String chiSession, String district, String chiDistrict,
                                 String fintype, String chiFintype, String schoolLv, String chiSchoolLv, String telephone, String chiTelephone,
                                 String faxno, String chiFaxno, String website, String chiWebsite, String religion, String chiReligion) {
        // Create contact
        HashMap<String, String> school = new HashMap<>();
        school.put(SCHOOLNO, schoolNo);
        school.put(ENGCATEGORY, engCategory);
        school.put(CHICATEGORY, chiCategory);
        school.put(ENGNAME, engName);
        school.put(CHINAME, chiName);
        school.put(ENGADDRESS, engAddress);
        school.put(CHIADDRESS, chiAddress);
        school.put(LONGTITUDE, longtitude);
        school.put(LATITUDE, latitude);
        school.put(EASTING, easting);
        school.put(NORTHING, northing);
        school.put(STDGENDER, stdGender);
        school.put(CHISTDGENDER, chiStdGender);
        school.put(SESSION, session);
        school.put(CHISESSION, chiSession);
        school.put(DISTRICT, district);
        school.put(CHIDISTRICT,chiDistrict);
        school.put(FINTYPE, fintype);
        school.put(CHIFINTYPE, chiFintype);
        school.put(SCHOOLLV, schoolLv);
        school.put(CHISCHOOLLV, chiSchoolLv);
        school.put(TELEPHONE, telephone);
        school.put(CHITELEPHONE, chiTelephone);
        school.put(FAXNO, faxno);
        school.put(CHIFAXNO, chiFaxno);
        school.put(WEBSITE, website);
        school.put(CHIWEBSITE, chiWebsite);
        school.put(RELIGION, religion);
        school.put(CHIRELIGION, chiReligion);



        // Add contact to contact list
        schoolList.add(school);
    }

}
