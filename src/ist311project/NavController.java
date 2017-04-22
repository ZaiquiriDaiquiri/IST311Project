package ist311project;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

public class NavController {

    private NavModel navModel;
    private NavView navView;

    NavController(NavModel model, NavView view) {
        this.navModel = model;
        this.navView = view;

        //TASK CREATION
        //When 'Create Task' is pressed
        navView.getNewTaskButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showNewTaskView();
            }
        });

        //When 'Time Sensitive' is checked
        navView.getNewTaskView().getTimeSensCheckBox().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                disableDateTimeSwitch();
            }
        });

        //When 'Create' (Task) is pressed
        navView.getNewTaskView().getCreateButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                createTask(navModel.getTempTaskArray());
                displayTasks(navModel.getTempTaskArray());
                closeNewTaskView();
            }
        });

        //When 'Cancel' (Task) is pressed
        navView.getNewTaskView().getCancelButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                closeNewTaskView();
            }
        });

        //CONTACT CREATION
        //When 'Create Contact' is pressed
        navView.getNewContactButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showNewContactView();
            }
        });

        //When 'Create' (Contact) is pressed
        navView.getNewContactView().getCreateButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                createContact(navModel.getTempContactArray());
                displayContacts(navModel.getTempContactArray());
                closeNewContactView();
            }
        });

        //When 'Cancel' (Contact) is pressed
        navView.getNewContactView().getCancelButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                closeNewContactView();
            }
        });
    }

    public void updateContactList(ArrayList<Contact> contactArray) {
        if (!contactArray.isEmpty()) {
            navView.getNewTaskView().getContactList().clear();
            navView.getNewTaskView().getContactList().add("None");

            for (int i = 0; i < contactArray.size(); i++) {
                navView.getNewTaskView().getContactList().add(contactArray.get(i).getName());
            }
        } else {
        }
    }

    public void showNewTaskView() {
        updateContactList(navModel.getTempContactArray());
        navView.getNewTaskView().resetFields();
        navView.getNewTaskView().show();
    }

    public void disableDateTimeSwitch() {
        navView.getNewTaskView().getDateField().setDisable(!navView.getNewTaskView().getTimeSensCheckBox().isSelected());
        navView.getNewTaskView().getHourComboBox().setDisable(!navView.getNewTaskView().getTimeSensCheckBox().isSelected());
        navView.getNewTaskView().getMinuteComboBox().setDisable(!navView.getNewTaskView().getTimeSensCheckBox().isSelected());
        navView.getNewTaskView().getAmPmComboBox().setDisable(!navView.getNewTaskView().getTimeSensCheckBox().isSelected());
    }

    public void createTask(ArrayList<Task> taskArray) {
        NewTaskView infoView = this.navView.getNewTaskView();

        Task newTask;
        String title = infoView.getTitleField().getText();
        String priority = infoView.getPriorityComboBox().getValue().toString();
        String location = infoView.getLocationField().getText();
        String contact = infoView.getContactComboBox().getValue().toString();
        String desc = infoView.getDescArea().getText();
        String date = infoView.getDateField().getValue().toString();
        String hour = infoView.getHourComboBox().getValue().toString();
        String minute = infoView.getMinuteComboBox().getValue().toString();
        String amPm = infoView.getAmPmComboBox().getValue().toString();
        String time = hour + ":" + minute + " " + amPm;

        if (infoView.getTimeSensCheckBox().isSelected()) {
            newTask = new TimeSensTask(title, priority, location, contact, desc, date, time);
            taskArray.add(newTask);
        } else {
            newTask = new ToDoTask(title, priority, location, contact, desc);
            taskArray.add(newTask);
        }
    }

    public FlowPane taskToPane(Task task) {
        FlowPane newTaskPane = new FlowPane();
        newTaskPane.setHgap(10);
        newTaskPane.setVgap(10);
        newTaskPane.setPadding(new Insets(10, 10, 10, 10));
        newTaskPane.setPrefWidth(685);

        StringBuilder taskString = new StringBuilder();

        if (!task.getTitle().equals("")) {
            String title = "Title: " + task.getTitle();
            taskString.append(title);
        } else {
        }

        String priority = "\nPriority: " + task.getPriority();
        taskString.append(priority);

        if (!task.getLocation().equals("")) {
            String location = "\nLocation: " + task.getLocation();
            taskString.append(location);
        } else {
        }

        if (!task.getContact().equals("None") && !task.getContact().equals("Choose Contact")) {
            String contact = "\nContact: " + task.getContact();
            taskString.append(contact);
        } else {
        }

        if (!task.getDescription().equals("")) {
            String desc = "\nDescription: " + task.getDescription();
            taskString.append(desc);
        } else {
        }

        String date;
        String time;

        if (task.getClass() == (new TimeSensTask()).getClass()) {
            date = "\nDate: " + task.getDate();
            taskString.append(date);

            time = "\nTime: " + task.getTime();
            taskString.append(time);

            newTaskPane.getChildren().add(new Label(taskString.toString()));
        } else {
            newTaskPane.getChildren().add(new Label(taskString.toString()));
        }

        newTaskPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        return newTaskPane;
    }

    public void clearTasks() {
        navView.getTaskListPane().getChildren().clear();
    }

    public void displayTasks(ArrayList<Task> taskArray) {
        clearTasks();

        for (int i = 0; i < taskArray.size(); i++) {
            navView.getTaskListPane().add(taskToPane(taskArray.get(i)), 0, i);
        }
    }

    public void closeNewTaskView() {
        navView.getNewTaskView().close();
    }

    public void showNewContactView() {
        navView.getNewContactView().resetFields();
        navView.getNewContactView().show();
    }

    public void createContact(ArrayList<Contact> contactArray) {
        NewContactView infoView = this.navView.getNewContactView();

        Contact newContact;
        String name = infoView.getNameField().getText();
        String phone = infoView.getPhoneField().getText();
        String email = infoView.getEmailField().getText();
        String address = infoView.getAddressField().getText();
        String contactType = infoView.getContactTypeBox().getValue().toString();

        newContact = new Contact(name, phone, email, address, contactType);
        contactArray.add(newContact);
    }

    public FlowPane contactToPane(Contact contact) {
        FlowPane newContactPane = new FlowPane();
        newContactPane.setHgap(10);
        newContactPane.setVgap(10);
        newContactPane.setPadding(new Insets(10, 10, 10, 10));
        newContactPane.setPrefWidth(685);

        StringBuilder contactString = new StringBuilder();

        if (!contact.getName().equals("")) {
            String name = "Name: " + contact.getName();
            contactString.append(name);
        } else {
        }

        if (!contact.getPhone().equals("")) {
            String phone = "\nPhone: " + contact.getPhone();
            contactString.append(phone);
        } else {
        }

        if (!contact.getEmail().equals("")) {
            String email = "\nEmail: " + contact.getEmail();
            contactString.append(email);
        } else {
        }

        if (!contact.getAddress().equals("")) {
            String address = "\nAddress: " + contact.getAddress();
            contactString.append(address);
        } else {
        }

        String contactType = "\n" + contact.getContactType() + " Contact";
        contactString.append(contactType);

        newContactPane.getChildren().add(new Label(contactString.toString()));
        newContactPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));

        return newContactPane;
    }

    public void clearContacts() {
        navView.getContactListPane().getChildren().clear();
    }

    public void displayContacts(ArrayList<Contact> contactArray) {
        clearContacts();
        for (int i = 0; i < contactArray.size(); i++) {
            navView.getContactListPane().add(contactToPane(contactArray.get(i)), 0, i);
        }
    }

    public void closeNewContactView() {
        navView.getNewContactView().close();
    }
}
