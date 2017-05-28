package twanwatanakool.elevatorpitch1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Map;

//TODO 2. Put backend storing/retrieving in background threads using AsyncTask

public class InterviewChecklist extends AppCompatActivity {
    private String PREF_NAME = "checkPref";
    private CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7;
    public static String compName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_checklist);

        //Get compName for unique IDs
//        Bundle bundle = getIntent().getExtras();
//        if(bundle != null){
//            compName = bundle.getString("compName");
//
//        } else {
//            Log.d("ERROR","compName is null");
//        }


        //Set xml status text
        updateStatus();

        //Initialize and Auto-populate Checkboxes
        initCheckboxes();
        retrieveFromPreference();
    }

    @Override
    public void onBackPressed() {
        saveCheckBoxStates();
        super.onBackPressed();
    }

    // HELPER METHOD - Creates CheckBox objects
    public void initCheckboxes() {
        cb1 = (CheckBox) findViewById(R.id.ApplyCheckBox);
        cb2 = (CheckBox) findViewById(R.id.SetUpCheckBox);
        cb3 = (CheckBox) findViewById(R.id.ResearchCheckBox);
        cb4 = (CheckBox) findViewById(R.id.StudyCheckBox);
        cb5 = (CheckBox) findViewById(R.id.InterviewCheckBox);
        cb6 = (CheckBox) findViewById(R.id.FollowUpCheckBox);
        cb7 = (CheckBox) findViewById(R.id.ThanksCheckBox);
    }

    public void saveCheckBoxStates() {
        saveToPreferences(compName+"cb1", cb1.isChecked());
        saveToPreferences(compName+"cb2", cb2.isChecked());
        saveToPreferences(compName+"cb3", cb3.isChecked());
        saveToPreferences(compName+"cb4", cb4.isChecked());
        saveToPreferences(compName+"cb5", cb5.isChecked());
        saveToPreferences(compName+"cb6", cb6.isChecked());
        saveToPreferences(compName+"cb7", cb7.isChecked());

        updateStatus();
    }

    // HELPER METHOD - Store userInput to SharedPreferences File
    public void saveToPreferences(String s, boolean b) {
        SharedPreferences.Editor editor = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.putString(s, ""+b);
        editor.commit();
    }

    public void updateStatus() {
        int update = 0;
        SharedPreferences prefs = this.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        Map<String, ?> keys = prefs.getAll();

        for(Map.Entry<String, ?> entry : keys.entrySet()) {
            if(entry.getKey().contains(compName) && entry.getValue().equals("true")) {
                update++;
            }
        }

        final TextView status = (TextView) findViewById(R.id.StatusText);
        if(update == 7) {
            status.setText("COMPLETED");
        } else {
            status.setText(status.getText());
        }
    }

    // HELPER METHOD - Auto-populate data from SharedPreferences to activity
    public void retrieveFromPreference() {
        SharedPreferences prefs = this.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        Map<String, ?> keys = prefs.getAll();

        for (Map.Entry<String, ?> entry : keys.entrySet()) {
            String key = entry.getKey();

            if (key.contains(compName)) {
                if (key.contains("cb1")) {
                    if (entry.getValue().equals("true")) {
                        cb1.setChecked(true);
                    }

                    if (entry.getValue().equals("false")) {
                        cb1.setChecked(false);
                    }
                }

                if (key.contains("cb2")) {
                    if (entry.getValue().equals("true")) {
                        cb2.setChecked(true);
                    }

                    if (entry.getValue().equals("false")) {
                        cb2.setChecked(false);
                    }
                }

                if (key.contains("cb3")) {
                    if (entry.getValue().equals("true")) {
                        cb3.setChecked(true);
                    }

                    if (entry.getValue().equals("false")) {
                        cb3.setChecked(false);
                    }
                }

                if (key.contains("cb4")) {
                    if (entry.getValue().equals("true")) {
                        cb4.setChecked(true);
                    }

                    if (entry.getValue().equals("false")) {
                        cb4.setChecked(false);
                    }
                }

                if (key.contains("cb5")) {
                    if (entry.getValue().equals("true")) {
                        cb5.setChecked(true);
                    }

                    if (entry.getValue().equals("false")) {
                        cb5.setChecked(false);
                    }
                }

                if (key.contains("cb6")) {
                    if (entry.getValue().equals("true")) {
                        cb6.setChecked(true);
                    }

                    if (entry.getValue().equals("false")) {
                        cb6.setChecked(false);
                    }
                }

                if (key.contains("cb7")) {
                    if (entry.getValue().equals("true")) {
                        cb7.setChecked(true);
                    }

                    if (entry.getValue().equals("false")) {
                        cb7.setChecked(false);
                    }
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