package hk.edu.hkmu.schoolinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);

        JsonHandlerThread jsonHandlerThread = new JsonHandlerThread();
        jsonHandlerThread.start();

        try {
            jsonHandlerThread.join();

            SimpleAdapter adapter = new SimpleAdapter(
                    this,
                    SchoolInfo.schoolList,
                    R.layout.list_view_layout,
                    new String[] { SchoolInfo.ENGNAME, SchoolInfo.TELEPHONE, SchoolInfo.ENGADDRESS},
                    new int[] { R.id.engName, R.id.telephone, R.id.engAddress}
            );

            listView.setAdapter(adapter);

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
        } catch (InterruptedException e){
            Log.e(TAG, "InterruptedException: " + e.getMessage());
        }
    }
}