
package ist311project;

public abstract class Task {
    private String taskTitle;
    private String taskPriority;
    private String taskLocation;
    private String taskContact;
    private String taskDesc;
    
    Task(String title, String priority, String location, String contact, String desc) {
        this.taskTitle = title;
        this.taskPriority = priority;
        this.taskLocation = location;
        this.taskContact = contact;
        this.taskDesc = desc;
    }
    
    public void printTask() {}
}
