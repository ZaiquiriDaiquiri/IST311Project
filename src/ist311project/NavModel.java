
package ist311project;

import java.util.ArrayList;

public class NavModel {
    private ArrayList<Task> tempTaskArray;
    
    NavModel() {
        tempTaskArray = new ArrayList<>();
    }
    
    public ArrayList<Task> getTempTaskArray() {
        return this.tempTaskArray;
    }
}
