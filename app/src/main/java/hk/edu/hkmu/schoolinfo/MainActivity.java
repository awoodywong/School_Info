package hk.edu.hkmu.schoolinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    public static final String EXTRA_MESSAGE = "URL_MESSAGE";

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

                            public static final String EXTRA_MESSAGE = "URL_MESSAGE";
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                HashMap<String, String> school = SchoolInfo.schoolList.get(position);
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                                String url = school.get(SchoolInfo.WEBSITE);

                                builder.setTitle(school.get(SchoolInfo.ENGNAME));
                                builder.setMessage("School Number: " + school.get(SchoolInfo.SCHOOLNO) + "\n" +
                                        "English Category: " + school.get(SchoolInfo.ENGCATEGORY) + "\n" +
                                        "Student Gender: " + school.get(SchoolInfo.STDGENDER) + "\n" +
                                        "Session: " + school.get(SchoolInfo.SESSION) + "\n" +
                                        "District: " + school.get(SchoolInfo.DISTRICT) + "\n" +
                                        "Finance Type: " + school.get(SchoolInfo.FINTYPE) + "\n" +
                                        "School Level: " + school.get(SchoolInfo.SCHOOLLV) + "\n" +
                                        "Telephone: " + school.get(SchoolInfo.TELEPHONE) + "\n" +
                                        "Website: " + school.get(SchoolInfo.WEBSITE) + "\n" +
                                        "Religion: " + school.get(SchoolInfo.RELIGION));

                                builder.setPositiveButton("Visit Website", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        String urlStr = url;
                                        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                                        intent.putExtra(EXTRA_MESSAGE, urlStr);
                                        startActivity(intent);
                                    }
                                });

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

                                String url = school.get(SchoolInfo.WEBSITE);

                                builder.setTitle(school.get(SchoolInfo.CHINAME));
                                builder.setMessage("????????????: " + school.get(SchoolInfo.SCHOOLNO) + "\n" +
                                        "????????????: " + school.get(SchoolInfo.CHICATEGORY) + "\n" +
                                        "??????????????????: " + school.get(SchoolInfo.CHISTDGENDER) + "\n" +
                                        "??????????????????: " + school.get(SchoolInfo.CHISESSION) + "\n" +
                                        "??????: " + school.get(SchoolInfo.CHIDISTRICT) + "\n" +
                                        "????????????: " + school.get(SchoolInfo.CHIFINTYPE) + "\n" +
                                        "????????????: " + school.get(SchoolInfo.CHISCHOOLLV) + "\n" +
                                        "????????????: " + school.get(SchoolInfo.CHITELEPHONE) + "\n" +
                                        "????????????: " + school.get(SchoolInfo.CHIWEBSITE) + "\n" +
                                        "??????: " + school.get(SchoolInfo.CHIRELIGION));

                                builder.setPositiveButton("??????????????????", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        String urlStr = url;
                                        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                                        intent.putExtra(EXTRA_MESSAGE, urlStr);
                                        startActivity(intent);
                                    }
                                });

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