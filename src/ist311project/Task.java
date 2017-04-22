package ist311project;

import java.io.Serializable;

public abstract class Task implements Serializable{

    private String title;
    private String priority;
    private String location;
    private String contact;
    private String description;
    private String date;
    private String time;

    Task() {

    }

    Task(String title, String priority, String location, String contact, String description) {
        this.title = title;
        this.priority = priority;
        this.location = location;
        this.contact = contact;
        this.description = description;
    }

    Task(String title, String priority, String location, String contact, String description, String date, String time) {
        this.title = title;
        this.priority = priority;
        this.location = location;
        this.contact = contact;
        this.description = description;
        this.date = date;
        this.time = time;
    }


    public String getTitle() {
        return this.title;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getLocation() {
        return this.location;
    }

    public String getContact() {
        return this.contact;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDate() {
        return this.date;
    }

    public String getTime() {
        return this.time;
    }

}
