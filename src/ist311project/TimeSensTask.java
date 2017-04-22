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

}
