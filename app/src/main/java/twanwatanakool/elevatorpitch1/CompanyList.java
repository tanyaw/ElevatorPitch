package twanwatanakool.elevatorpitch1;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class CompanyList extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Button addButton;
    private EditText editCompanyButton;
    private ListView lv;
    private String PREF_NAME = "MAY_ALL_UR_DATA_PERSIST.txt";
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);


        //Auto-populate
        retrieveFromPreference();

        editCompanyButton = (EditText) findViewById(R.id.EditAddCompany);

        addButton = (Button) findViewById(R.id.AddCompany);
        addButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
            String userInput = editCompanyButton.getText().toString();
            if(userInput.length() > 0) {
                adapter.add(userInput);
                saveToPreferences(userInput);

                //Clear text in edit text widget
                editCompanyButton.setText(null);
            } else {
                Toast.makeText(CompanyList.this, "Please enter a company name!", Toast.LENGTH_SHORT).show();
            }
            }
        });

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, list);

        lv = (ListView) findViewById(R.id.companiesListView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(CompanyList.this);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb=new AlertDialog.Builder(CompanyList.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete " + adapter.getItem(position));
                final int positionToRemove = position;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        removeFromPreferences(adapter.getItem(positionToRemove));
                        adapter.remove(adapter.getItem(positionToRemove));
                        adapter.notifyDataSetChanged();
                    }});
                adb.show();

                return true;
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        adapter.notifyDataSetChanged();

        //Go to Individual Company Page
        String compName = list.get(position);
        Intent myIntent = new Intent(v.getContext(), IndividualCompany.class);
        myIntent.putExtra("compName", compName);
        startActivity(myIntent);
    }

    public void removeFromPreferences(String userInput) {
        SharedPreferences.Editor editor = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.remove(userInput);
        editor.commit();
    }

// HELPER METHOD - Store userInput to SharedPreferences File
    public void saveToPreferences(String userInput) {
        SharedPreferences.Editor editor = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.putString(userInput, userInput);
        editor.commit();
    }

    // HELPER METHOD - Autopopulate data from SharedPreferences File to activity
    public void retrieveFromPreference() {
        SharedPreferences prefs = this.getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        Map<String, ?> keys = prefs.getAll();

        for(Map.Entry<String, ?> entry : keys.entrySet()) {
            list.add(entry.getKey());
        }
    }

    // HELPER METHOD - Clear all values stored in SharedPreferences File
    public void clearPref() {
        SharedPreferences.Editor editor = this.getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();
    }
}
