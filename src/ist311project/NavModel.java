package ist311project;

import java.util.ArrayList;

public class NavModel {

    private ArrayList<Task> tempTaskArray;
    private ArrayList<Contact> tempContactArray;

    NavModel() {
        tempTaskArray = new ArrayList<>();
        tempContactArray = new ArrayList<>();
    }

    public ArrayList<Task> getTempTaskArray() {
        return this.tempTaskArray;
    }

    public ArrayList<Contact> getTempContactArray() {
        return this.tempContactArray;
    }

}
