
package ist311project;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

public class NavController{

    private NavModel navModel;
    private NavView navView;

    NavController(NavModel model, NavView view) {
        this.navModel = model;
        this.navView = view;

        //Task Creation Event Handlers
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

        //Contact Creation Event Handlers
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
        } else {}
    }

    public void showNewTaskView() {
        updateContactList(navModel.getTempContactArray());
        navView.getNewTaskView().resetFields();
        navView.getNewTaskView().show();
    }

    public void disableDateTimeSwitch() {
        navView.getNewTaskView().getDateField().setDisable(!navView.getNewTaskView().getTimeSensCheckBox().isSelected());
        navView.getNewTaskView().getHourSpinner().setDisable(!navView.getNewTaskView().getTimeSensCheckBox().isSelected());
        navView.getNewTaskView().getMinuteSpinner().setDisable(!navView.getNewTaskView().getTimeSensCheckBox().isSelected());
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
        String hour = infoView.getHourSpinner().getValue().toString();
        String minute = infoView.getMinuteSpinner().getValue().toString();
        String time = hour + ":" + minute;

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

        Label title = new Label(task.getTitle());
        Label priority = new Label(task.getPriority());
        Label location = new Label(task.getLocation());
        Label contact = new Label(task.getContact());
        Label desc = new Label(task.getDescription());
        Label date;
        Label time;

        if (task.getClass() == (new TimeSensTask()).getClass()) {
            date = new Label(task.getDate());
            time = new Label(task.getTime());
            newTaskPane.getChildren().addAll(title, priority, location, contact, desc, date, time);
        } else {
            newTaskPane.getChildren().addAll(title, priority, location, contact, desc);
        }

        newTaskPane.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

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

        newContact = new Contact(name, phone, email, address);
        contactArray.add(newContact);
        newContact.printContact();
    }

    public FlowPane contactToPane(Contact contact) {
        FlowPane newContactPane = new FlowPane();
        newContactPane.setHgap(10);
        newContactPane.setVgap(10);
        newContactPane.setPadding(new Insets(10, 10, 10, 10));
        newContactPane.setPrefWidth(685);

        Label name = new Label(contact.getName());
        Label phone = new Label(contact.getPhone());
        Label email = new Label(contact.getEmail());
        Label address = new Label(contact.getAddress());
        
        newContactPane.getChildren().addAll(name, phone, email, address);
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
