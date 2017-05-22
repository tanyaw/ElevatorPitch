package twanwatanakool.elevatorpitch1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class IndividualCompany extends AppCompatActivity {
    private String compName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_company);

        //Display Company Name
        updateCompanyName();

        ImageButton toChecklistLayout = (ImageButton) findViewById(R.id.button_CheckList);
        toChecklistLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), InterviewChecklist.class);
                //startActivityForResult(myIntent, 0);

                //Send companyName to next activity screen
                myIntent.putExtra("compName", compName);
                InterviewChecklist.compName = compName;
                startActivityForResult(myIntent, 0);
                //Log.d("TANYA", "Indiv compName: " + compName);
            }

        });

        ImageButton toBehavioralLayout = (ImageButton) findViewById(R.id.button_Behavioral);
        toBehavioralLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), BehavioralQuestion.class);
                startActivityForResult(myIntent, 0);
            }

        });

        ImageButton toTechnicalLayout = (ImageButton) findViewById(R.id.button_Technical);
        toTechnicalLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), TechnicalQuestion.class);
                startActivityForResult(myIntent, 0);
            }

        });

        ImageButton toTipsLayout = (ImageButton) findViewById(R.id.button_Tips);
        toTipsLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), InterviewTips.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }

    public void updateCompanyName() {
        final TextView changeCompany = (TextView) findViewById(R.id.CompanyName);

        Bundle extras = getIntent().getExtras();
        compName = extras.getString("compName");

        if(compName == null) {
            //Set company text to default value
            changeCompany.setText("COMPANY");
        } else {
            //Set company text to userInput
            changeCompany.setText(compName);
        }
    }
}
