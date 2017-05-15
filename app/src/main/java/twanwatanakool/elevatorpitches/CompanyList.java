package twanwatanakool.elevatorpitches;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
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
    ArrayList<String> list = new ArrayList<>();;
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

                editCompanyButton.setText(null);
            } else {
                Toast.makeText(CompanyList.this, "Please enter a company name!", Toast.LENGTH_SHORT).show();
            }
            }
        });

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);

        lv = (ListView) findViewById(R.id.companiesListView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(CompanyList.this);
    }

    @Override
    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        adapter.notifyDataSetChanged();

        //Go to Individual Company Page
        String compName = list.get(position);
        Intent myIntent = new Intent(v.getContext(), IndividualCompany.class);
        myIntent.putExtra("compName", compName);
        startActivityForResult(myIntent, 0);
    }

    // HELPER METHOD - Clear all values stored in SharedPreferences File
    public void clearPref() {
        SharedPreferences.Editor editor = this.getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.clear();
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
}
