package ist311project;

public class ToDoTask extends Task {

    private String title;
    private String priority;
    private String location;
    private String contact;
    private String description;

    ToDoTask() {

    }

    ToDoTask(String title, String priority, String location, String contact, String description) {
        super(title, priority, location, contact, description);
        this.title = title;
        this.priority = priority;
        this.location = location;
        this.contact = contact;
        this.description = description;
    }

}
