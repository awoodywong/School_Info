package hk.edu.hkmu.schoolinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private ListView listView;
    private  SimpleAdapter adapter;

    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String language = Locale.getDefault().getLanguage();

        EditText theFilter = (EditText) findViewById(R.id.searchFilter);
        listView = (ListView) findViewById(R.id.listview);


        JsonHandlerThread jsonHandlerThread = new JsonHandlerThread();
        jsonHandlerThread.start();


        if(language == "en") {
            try {
                jsonHandlerThread.join();

                adapter = new SimpleAdapter(this,
                        SchoolInfo.schoolList,
                        R.layout.list_view_layout,
                        new String[]{SchoolInfo.ENGNAME, SchoolInfo.TELEPHONE, SchoolInfo.ENGADDRESS},
                        new int[]{R.id.engName, R.id.telephone, R.id.engAddress}
                );
                listView.setAdapter(adapter);

                theFilter.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        (MainActivity.this).adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                listView.setOnItemClickListener(
                        new AdapterView.OnItemClickListener() {
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                HashMap<String, String> school = SchoolInfo.schoolList.get(position);
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                                builder.setTitle(school.get(SchoolInfo.ENGNAME));
                                builder.setMessage("School Number: " + school.get(SchoolInfo.SCHOOLNO) + "\n" +
                                        "English Category: " + school.get(SchoolInfo.ENGCATEGORY) + "\n" +
                                        "Student Gender: " + school.get(SchoolInfo.STDGENDER) + "\n" +
                                        "Session: " + school.get(SchoolInfo.SESSION) + "\n" +
                                        "District: " + school.get(SchoolInfo.DISTRICT) + "\n" +
                                        "Finance Type: " + school.get(SchoolInfo.FINTYPE) + "\n" +
                                        "School Level: " + school.get(SchoolInfo.SCHOOLLV) + "\n" +
                                        "Telephone: " + school.get(SchoolInfo.TELEPHONE) + "\n" +
                                        "Religion: " + school.get(SchoolInfo.RELIGION));

                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();
                            }

                        }
                );
            } catch (InterruptedException e) {
                Log.e(TAG, "InterruptedException: " + e.getMessage());
            }
        }else{
            try {
                jsonHandlerThread.join();

                adapter = new SimpleAdapter(this,
                        SchoolInfo.schoolList,
                        R.layout.list_view_layout_chi,
                        new String[]{SchoolInfo.CHINAME, SchoolInfo.CHITELEPHONE, SchoolInfo.CHIADDRESS},
                        new int[]{R.id.chiName, R.id.chiTelephone, R.id.chiAddress}
                );
                listView.setAdapter(adapter);

                theFilter.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        (MainActivity.this).adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                listView.setOnItemClickListener(
                        new AdapterView.OnItemClickListener() {
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                HashMap<String, String> school = SchoolInfo.schoolList.get(position);
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                                builder.setTitle(school.get(SchoolInfo.CHINAME));
                                builder.setMessage("學模編號: " + school.get(SchoolInfo.SCHOOLNO) + "\n" +
                                        "中文類別: " + school.get(SchoolInfo.CHICATEGORY) + "\n" +
                                        "就讀學生性別: " + school.get(SchoolInfo.CHISTDGENDER) + "\n" +
                                        "學校授課時間: " + school.get(SchoolInfo.CHISESSION) + "\n" +
                                        "分區: " + school.get(SchoolInfo.CHIDISTRICT) + "\n" +
                                        "資助種類: " + school.get(SchoolInfo.CHIFINTYPE) + "\n" +
                                        "學校類型: " + school.get(SchoolInfo.CHISCHOOLLV) + "\n" +
                                        "聯絡電話: " + school.get(SchoolInfo.CHITELEPHONE) + "\n" +
                                        "宗教: " + school.get(SchoolInfo.CHIRELIGION));

                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();
                            }

                        }
                );
            } catch (InterruptedException e) {
                Log.e(TAG, "InterruptedException: " + e.getMessage());
            }
        }

    }
}