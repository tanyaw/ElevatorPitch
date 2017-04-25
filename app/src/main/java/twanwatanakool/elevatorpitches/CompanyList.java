package twanwatanakool.elevatorpitches;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class CompanyList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);

        Button toIndividualCoScreen = (Button) findViewById(R.id.Company1);
        toIndividualCoScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), IndividualCompany.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }
}
