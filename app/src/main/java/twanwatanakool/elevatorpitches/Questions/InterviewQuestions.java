package twanwatanakool.elevatorpitches.Questions;

/**
 * Created by twanwatanakool on 5/13/17.
 */

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;



public class InterviewQuestions {
    private ArrayList<String> techQuestionList = new ArrayList<>();
    private ArrayList<String> behaviorQuestionList = new ArrayList<>();
    private Context context;

    public InterviewQuestions(Context myContext) {
        this.context = myContext;
        setTechQuestions();
        setBehaviorQuestions();
    }

    public void setBehaviorQuestions() {
        BufferedReader in = null;
        try {
            AssetManager assetManager = context.getAssets();
            InputStream is =  assetManager.open("behaviorQuestions.txt");
            Reader reader = new InputStreamReader(is);
            in = new BufferedReader(reader);

            String line;
            while((line = in.readLine()) != null) {
                behaviorQuestionList.add(line);
            }
        } catch (IOException e) {
            Log.d("Error", "This file does not exist");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e){
                    Log.e("Error", "Cannot close file reader");
                }
            }
        }
    }

    public void setTechQuestions() {
        BufferedReader in = null;
        try {
            AssetManager assetManager = context.getAssets();
            InputStream is =  assetManager.open("techQuestions.txt");
            Reader reader = new InputStreamReader(is);
            in = new BufferedReader(reader);

            String line;
            while((line = in.readLine()) != null) {
                techQuestionList.add(line);
            }
        } catch (IOException e) {
            Log.d("Error", "This file does not exist");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e){
                    Log.e("Error", "Cannot close file reader");
                }
            }
        }
    }

    public String getTechQuestion() {
        if(techQuestionList.isEmpty()) {
            return null;
        } else {
            Random rand = new Random();
            int randIndex = rand.nextInt((techQuestionList.size()-1));
            return techQuestionList.get(randIndex);
        }
    }

    public String getBehaviorQuestion() {
        if(behaviorQuestionList.isEmpty()) {
            return null;
        } else {
            Random rand = new Random();
            int randIndex = rand.nextInt((behaviorQuestionList.size()-1));
            return behaviorQuestionList.get(randIndex);
        }
    }

    //NOT IMPLEMENTED YET HAHAHAH
    public void setTechAnswer(int q, String a) {

    }

    public void setBehaveAnswer(int q, String a) {

    }

    public String getTechAnswer(int q) {

        return null;
    }

    public String getBehaveAnswer(int q) {

        return null;
    }
}
