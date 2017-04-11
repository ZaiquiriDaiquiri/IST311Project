package ist311project;

public class TimeSensTask extends Task {

    private String title;
    private String priority;
    private String location;
    private String contact;
    private String description;
    private String date;
    private String time;
    
    TimeSensTask() {
        
    }

    TimeSensTask(String title, String priority, String location, String contact, String description, String date, String time) {
        super(title, priority, location, contact, description, date, time);
        this.title = title;
        this.priority = priority;
        this.location = location;
        this.contact = contact;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    @Override
    public void printTask() {
        System.out.print("Title: ");
        System.out.println(this.title);
        System.out.print("Priority: ");
        System.out.println(this.priority);
        System.out.print("Location: ");
        System.out.println(this.location);
        System.out.print("Contact: ");
        System.out.println(this.contact);
        System.out.print("Description: ");
        System.out.println(this.description);
        System.out.print("Date: ");
        System.out.println(this.date);
        System.out.print("Time: ");
        System.out.println(this.time);
    }

}
