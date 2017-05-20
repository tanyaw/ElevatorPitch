package twanwatanakool.elevatorpitches;

/**
 * Created by twanwatanakool on 5/19/17.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> dressCode = new ArrayList<>();
        dressCode.add("FOR MEN:\n Tops - Dress shirt, Open-collar, Polo Shirt \n Bottoms - Slacks or Khakis \n Shoes - Dress shoes or loafers");
        dressCode.add("FOR WOMEN:\n Tops - Blouse or Dress \n Bottoms - Slacks, Skirt at knee-length \n Shoes - Closed-toe Heels or Flats");

        List<String> elevatorPitch = new ArrayList<>();
        elevatorPitch.add("INTRO YOURSELF - Name, Year, Major" +
                "\nEXPERIENCE - Internships, Clubs, Projects" +
                "\nGOAL- Internship or Full-time position");
        elevatorPitch.add("Make eye contact, smile, and offer a firm handshake");
        elevatorPitch.add("Provide your resume to recruiter");
        elevatorPitch.add("Ask for recruiter's business card/contact info");

        List<String> research = new ArrayList<>();
        research.add("Look up positions and programs within the company you are interested in");
        research.add("Tailor your answers to your interests and the company’s interests");
        research.add("Be familiar with their products and/or projects.");

        List<String> dataStructures = new ArrayList<>();
        dataStructures.add("Array");
        dataStructures.add("Lists");
        dataStructures.add("Queue");
        dataStructures.add("Stack");
        dataStructures.add("Trees");
        dataStructures.add("Heaps");
        dataStructures.add("Graphs");

        List<String> askRecruiter = new ArrayList<>();
        askRecruiter.add("What kinds of skills and experience do you look for in the employees you hire?");
        askRecruiter.add("Are graduate degrees important to advancing within your organization? Which ones?");
        askRecruiter.add("What kind of entry-level positions exist within your organization?");
        askRecruiter.add("What is the hiring process like?");
        askRecruiter.add("What kinds of projects do engineers/interns work on?");
        askRecruiter.add("What is the company culture like?");

        expandableListDetail.put("Research the Company", research);
        expandableListDetail.put("Elevator Pitch", elevatorPitch);
        expandableListDetail.put("Data Structures", dataStructures);
        expandableListDetail.put("Dress Code", dressCode);
        expandableListDetail.put("Questions to Ask Recruiters", askRecruiter);
        return expandableListDetail;
    }
}