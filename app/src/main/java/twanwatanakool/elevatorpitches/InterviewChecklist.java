package twanwatanakool.elevatorpitches;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Map;

public class InterviewChecklist extends AppCompatActivity {
    private String PREF_NAME = "checkPref";
    private CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_checklist);

        updateStatus();

        //Auto-populate Checkboxes
        retrieveFromPreference();

        Button toInterviewTips = (Button) findViewById(R.id.GoToTipsButton);
        toInterviewTips.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), InterviewTips.class);
                startActivityForResult(myIntent, 0);

                saveCheckBoxStates();
                updateStatus();
            }

        });
    }

    @Override
    public void onBackPressed() {
        saveCheckBoxStates();
        updateStatus();
        super.onBackPressed();
    }

    // HELPER METHOD - sends checked state to SharedPreferences
    public void saveCheckBoxStates() {

        cb1 = (CheckBox) findViewById(R.id.ApplyCheckBox);
        cb2 = (CheckBox) findViewById(R.id.SetUpCheckBox);
        cb3 = (CheckBox) findViewById(R.id.ResearchCheckBox);
        cb4 = (CheckBox) findViewById(R.id.StudyCheckBox);
        cb5 = (CheckBox) findViewById(R.id.InterviewCheckBox);
        cb6 = (CheckBox) findViewById(R.id.FollowUpCheckBox);
        cb7 = (CheckBox) findViewById(R.id.ThanksCheckBox);

        saveToPreferences("cb1", cb1.isChecked());
        saveToPreferences("cb2", cb2.isChecked());
        saveToPreferences("cb3", cb3.isChecked());
        saveToPreferences("cb4", cb4.isChecked());
        saveToPreferences("cb5", cb5.isChecked());
        saveToPreferences("cb6", cb6.isChecked());
        saveToPreferences("cb7", cb7.isChecked());
    }

    // HELPER METHOD - Store userInput to SharedPreferences File
    public void saveToPreferences(String s, boolean b) {
        SharedPreferences.Editor editor = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.putString(s, ""+b);
        editor.commit();
    }

    // HELPER METHOD -  Update StatusText in XML
    public void updateStatus() {
        int update = 0;
        SharedPreferences prefs = this.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        Map<String, ?> keys = prefs.getAll();

        for(Map.Entry<String, ?> entry : keys.entrySet()) {
            if(entry.getValue().equals("true")) {
                update++;
            }
        }

        final TextView status = (TextView) findViewById(R.id.StatusText);
        if(update == 7) {
            status.setText("COMPLETED.");
        } else {
            status.setText(status.getText());
        }
    }

    // HELPER METHOD - Autopopulate data from SharedPreferences File to activity
    public void retrieveFromPreference() {
        SharedPreferences prefs = this.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        Map<String, ?> keys = prefs.getAll();

        for(Map.Entry<String, ?> entry : keys.entrySet()) {
            String key = entry.getKey();

            if(entry.getValue().equals("true")) {

                switch (key) {
                    case "cb1":
                        CheckBox cb1 = (CheckBox) findViewById(R.id.ApplyCheckBox);
                        cb1.setChecked(true);
                        break;
                    case "cb2":
                        CheckBox cb2 = (CheckBox) findViewById(R.id.SetUpCheckBox);
                        cb2.setChecked(true);
                        break;
                    case "cb3":
                        CheckBox cb3 = (CheckBox) findViewById(R.id.ResearchCheckBox);
                        cb3.setChecked(true);
                        break;
                    case "cb4":
                        CheckBox cb4 = (CheckBox) findViewById(R.id.StudyCheckBox);
                        cb4.setChecked(true);
                        break;
                    case "cb5":
                        CheckBox cb5 = (CheckBox) findViewById(R.id.InterviewCheckBox);
                        cb5.setChecked(true);
                        break;
                    case "cb6":
                        CheckBox cb6 = (CheckBox) findViewById(R.id.FollowUpCheckBox);
                        cb6.setChecked(true);
                        break;
                    case "cb7":
                        CheckBox cb7 = (CheckBox) findViewById(R.id.ThanksCheckBox);
                        cb7.setChecked(true);
                        break;
                }

            }

            else if(entry.getValue().equals("false")) {
                switch (key) {
                    case "cb1":
                        CheckBox cb1 = (CheckBox) findViewById(R.id.ApplyCheckBox);
                        cb1.setChecked(false);
                        break;
                    case "cb2":
                        CheckBox cb2 = (CheckBox) findViewById(R.id.SetUpCheckBox);
                        cb2.setChecked(false);
                        break;
                    case "cb3":
                        CheckBox cb3 = (CheckBox) findViewById(R.id.ResearchCheckBox);
                        cb3.setChecked(false);
                        break;
                    case "cb4":
                        CheckBox cb4 = (CheckBox) findViewById(R.id.StudyCheckBox);
                        cb4.setChecked(false);
                        break;
                    case "cb5":
                        CheckBox cb5 = (CheckBox) findViewById(R.id.InterviewCheckBox);
                        cb5.setChecked(false);
                        break;
                    case "cb6":
                        CheckBox cb6 = (CheckBox) findViewById(R.id.FollowUpCheckBox);
                        cb6.setChecked(false);
                        break;
                    case "cb7":
                        CheckBox cb7 = (CheckBox) findViewById(R.id.ThanksCheckBox);
                        cb7.setChecked(false);
                        break;
                }
            }
        }
    }

    // HELPER METHOD - Clear all values stored in SharedPreferences File
    public void clearPref() {
        SharedPreferences.Editor editor = this.getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();
    }
}
