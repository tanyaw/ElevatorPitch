package twanwatanakool.elevatorpitches;

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

public class CompanyList extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Button addButton;
    private EditText editCompanyButton;
    private ListView lv;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);

        editCompanyButton = (EditText) findViewById(R.id.EditAddCompany);

        addButton = (Button) findViewById(R.id.AddCompany);
        addButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
            String userInput = editCompanyButton.getText().toString();
            if(userInput.length() > 0) {
                adapter.add(userInput);
                editCompanyButton.setText(null);
            } else {
                Toast.makeText(CompanyList.this, "Please enter a company name!", Toast.LENGTH_SHORT).show();
            }
            }
        });

        list = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);

        lv = (ListView) findViewById(R.id.companiesListView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(CompanyList.this);
    }

    @Override
    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        adapter.notifyDataSetChanged();

        //Go to Individual Company Page
        Intent myIntent = new Intent(v.getContext(), IndividualCompany.class);
        startActivityForResult(myIntent, 0);
    }
}
