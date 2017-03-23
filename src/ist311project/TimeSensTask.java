
package ist311project;

public class TimeSensTask extends Task {
    private String taskTitle;
    private String taskPriority;
    private String taskDateTime;
    private String taskLocation;
    private String taskContact;
    private String taskDesc;
    
    TimeSensTask(String title, String priority, String datetime, String location, String contact, String desc) {
        super(title, priority, location, contact, desc);
        
        this.taskTitle = title;
        this.taskPriority = priority;
        this.taskDateTime = datetime;
        this.taskLocation = location;
        this.taskContact = contact;
        this.taskDesc = desc;
    }
    
    @Override
    public void printTask() {
        System.out.println(this.taskTitle);
        System.out.println(this.taskPriority);
        System.out.println(this.taskDateTime);
        System.out.println(this.taskLocation);
        System.out.println(this.taskContact);
        System.out.println(this.taskDesc);
    }
}
