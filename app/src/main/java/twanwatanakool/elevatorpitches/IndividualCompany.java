package twanwatanakool.elevatorpitches;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class IndividualCompany extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_company);

        ImageButton toChecklistLayout = (ImageButton) findViewById(R.id.button_CheckList);
        toChecklistLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), InterviewChecklist.class);
                startActivityForResult(myIntent, 0);
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

}
