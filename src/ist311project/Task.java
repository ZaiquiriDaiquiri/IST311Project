package ist311project;

public abstract class Task {

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
