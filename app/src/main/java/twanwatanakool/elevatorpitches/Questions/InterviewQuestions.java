package twanwatanakool.elevatorpitches.Questions;

/**
 * Created by twanwatanakool on 5/13/17.
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Random;

public class InterviewQuestions {
    Map<String, String> techQuestions;
    Map<String, String> behaviorQuestions;

    public InterviewQuestions() {
        techQuestions = new HashMap<String, String>();
        behaviorQuestions = new HashMap<String, String>();
    }

    public void setTechQuestions() {
        techQuestions.put("What is Polymorphism?", null);
        techQuestions.put("What is the Singleton Design Pattern?", null);
        techQuestions.put("What is inheritance?", null);
        techQuestions.put("Reverse a string.", null);
        techQuestions.put("Given a dictionary of words and a String of user's input. Create a function to produce all possible auto-completions of the given string.", null);
        techQuestions.put("On a scale of 1-10, how would you rate your expertise on your best programming language and why?", null);
        techQuestions.put("What sorting algorithms do you know? Implement one of them.", null);
        techQuestions.put("Reverse a linked list recursively.", null);
        techQuestions.put("What is your favorite data structure? When would that data structure be an inefficient choice?", null);
    }

    public void setBehaviorQuestions() {
        behaviorQuestions.put("Tell me about yourself.", null);
        behaviorQuestions.put("How did you resolve a conflict?", null);
        behaviorQuestions.put("Describe a time where you worked in a group with dissenting views, how did you resolve it?", null);
        behaviorQuestions.put("What was your favorite class/project and why?", null);
        behaviorQuestions.put("Tell me about some of your relevant classes and coursework to this position.", null);
        behaviorQuestions.put("Why do you want to work at this company?", null);
        behaviorQuestions.put("What have you done to go above and beyond the specifications of a project?", null);
        behaviorQuestions.put("What is your greatest weakness?", null);
        behaviorQuestions.put("What are some of your strengths?", null);
    }

    public void setTechAnswer(String q, String a) {
        techQuestions.put(q,a);
    }

    public void setBehaveAnswer(String q, String a) {
        behaviorQuestions.put(q,a);
    }

    public String getTechQuestion() {
        if(techQuestions.isEmpty()) {
            return null;
        } else {
            Set<String> questions = techQuestions.keySet();
            Object[] q = questions.toArray();

            Random rand = new Random();
            int randIndex = rand.nextInt(q.length-1);

            return techQuestions.get(q[randIndex]);
        }
    }

    public String getBehaveQuestion() {
        if(behaviorQuestions.isEmpty()) {
            return null;
        } else {
            Set<String> questions = techQuestions.keySet();
            Object[] q = questions.toArray();

            Random rand = new Random();
            int randIndex = rand.nextInt(q.length-1);

            return behaviorQuestions.get(q[randIndex]);
        }
    }

    public String getTechAnswer(String q) {
        if(techQuestions.containsValue(q)) {
            return techQuestions.get(q);
        } else {
            return null;
        }
    }

    public String getBehaveAnswer(String q) {
        if(behaviorQuestions.containsValue(q)) {
            return behaviorQuestions.get(q);
        } else {
            return null;
        }
    }
}
