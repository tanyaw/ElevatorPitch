package twanwatanakool.elevatorpitches.Questions;

/**
 * Created by twanwatanakool on 5/13/17.
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Random;

public class InterviewQuestions {
    Map<Integer, String> techQuestions;
    Map<Integer, String> behaviorQuestions;

    public InterviewQuestions() {
        techQuestions = new HashMap<Integer, String>();
        behaviorQuestions = new HashMap<Integer, String>();

        setTechQuestions();
        setBehaviorQuestions();
    }

    public void setTechQuestions() {
        techQuestions.put(1, "What is Polymorphism?");
        techQuestions.put(2, "What is the Singleton Design Pattern?");
        techQuestions.put(3, "What is Inheritance?");
        techQuestions.put(4, "Reverse a string.");
        techQuestions.put(5, "Given a dictionary of words and a String of user's input. Create a function to produce all possible auto-completions of the given string.");
        techQuestions.put(6, "On a scale of 1-10, how would you rate your expertise on your best programming language and why?");
        techQuestions.put(7, "What sorting algorithms do you know? Implement one of them.");
        techQuestions.put(8, "Reverse a linked list recursively.");
        techQuestions.put(9, "What is your favorite data structure? When would that data structure be an inefficient choice?");
        techQuestions.put(10, "What is the difference between passing by reference and passing by value?");
        techQuestions.put(11, "Using OOP design patterns, create an online shopping cart system.");
        techQuestions.put(12, "Using OOP design patterns, create an ATM system.");
        techQuestions.put(13, "What is the difference between interfaces and abstract classes?");
    }

    public void setBehaviorQuestions() {
        behaviorQuestions.put(1, "Tell me about yourself.");
        behaviorQuestions.put(2, "How do you deal with conflict?");
        behaviorQuestions.put(3, "Describe a time where you worked in a group with dissenting views, how did you resolve it?");
        behaviorQuestions.put(4, "What was your favorite class/project and why?");
        behaviorQuestions.put(5, "Tell me about some of your relevant classes and coursework to this position.");
        behaviorQuestions.put(6, "Why do you want to work at this company?");
        behaviorQuestions.put(7, "What have you done to go above and beyond the specifications of a project?");
        behaviorQuestions.put(8, "What is your greatest weakness?");
        behaviorQuestions.put(9, "What are some of your strengths?");
        behaviorQuestions.put(10, "Tell me about how you worked effectively under pressure.");
        behaviorQuestions.put(11, "How do you handle multiple deadlines?");
        behaviorQuestions.put(12, "What do you do if you disagree with someone at work?");
        behaviorQuestions.put(13, "Give an example of how you worked on a team.");
    }

    public void setTechAnswer(int q, String a) {
        techQuestions.put(q,a);
    }

    public void setBehaveAnswer(int q, String a) {
        behaviorQuestions.put(q,a);
    }

    public String getTechQuestion() {
        if(techQuestions.isEmpty()) {
            return null;
        } else {
            int size = techQuestions.size();

            Random rand = new Random();
            int randKey = rand.nextInt(size)+1;

            return techQuestions.get(randKey);
        }
    }

    public String getBehaveQuestion() {
        if(behaviorQuestions.isEmpty()) {
            return null;
        } else {
            int size = behaviorQuestions.size();

            Random rand = new Random();
            int randKey = rand.nextInt(size)+1;

            return behaviorQuestions.get(randKey);
        }
    }

    //NOT IMPLEMENTED YET HAHAHAH
    public String getTechAnswer(int q) {

        return null;
    }

    public String getBehaveAnswer(int q) {

        return null;
    }
}
