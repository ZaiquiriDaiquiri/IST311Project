
package ist311project;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class NavController {
    private NavModel navModel;
    private NavView navView;
    
    NavController(NavModel model, NavView view) {
        this.navModel = model;
        this.navView = view;
        
        //Task Creation Event Handlers
        //Action when 'Create Task' is pressed
        navView.getNewTaskButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showNewTaskView();
            }
        });
        
            //Action when 'All Day' is checked
            navView.getNewTaskView().getAllDayCheckBox().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    disableDateTimeSwitch();
                }
            });
            //Action when 'Create' is pressed
            navView.getNewTaskView().getCreateButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //TASK CREATION
                    createTask(navModel.getTempTaskArray());
                    displayTasks(navModel.getTempTaskArray());
                }
            });
            //Action when 'Cancel' is pressed
            navView.getNewTaskView().getCancelButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    closeNewTaskView();
                }
            });
        
        //Contact Creation Event Handlers
        //Action when 'Create Contact' is pressed
        navView.getNewContactButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showNewContactView();
            }
        });
        
            //Action when 'Contact Type' is changed
            navView.getNewContactView().getContactTypeComboBox().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(navView.getNewContactView().getContactTypeComboBox().equals("Professional")) {
                        //Disables non-professional fields
                        navView.getNewContactView().getNicknameField().setDisable(true);
                    } else if(navView.getNewContactView().getContactTypeComboBox().equals("Professional")) {
                        //Disables non-personal fields
                        navView.getNewContactView().getCompField().setDisable(true);
                        navView.getNewContactView().getCompTitleField().setDisable(true);
                    } else {}
                }
            });
            //Action when 'Create' is pressed
            navView.getNewContactView().getCreateButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //CONTACT CREATION
                }
            });
            //Action when 'Cancel' is pressed
            navView.getNewContactView().getCancelButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    closeNewContactView();
                }
            });
    }
    
    public void showNewTaskView() {
        navView.getNewTaskView().show();
    }
    
    public void disableDateTimeSwitch() {
        navView.getNewTaskView().getDateTimeField().setDisable(navView.getNewTaskView().getAllDayCheckBox().isSelected());
        navView.getNewTaskView().getDateField().setDisable(!navView.getNewTaskView().getAllDayCheckBox().isSelected());
    }
    
    public void createTask(ArrayList<Task> taskArray) {
        NewTaskView infoView = this.navView.getNewTaskView();
        
        Task newTask;
        String title = infoView.getTitleField().getText();
        String contact = infoView.getContactComboBox().getValue().toString();
        String location = infoView.getLocationField().getText();
        String priority = infoView.getPriorityComboBox().getValue().toString();
        String desc = infoView.getDescArea().getText();
        
        if(!infoView.getAllDayCheckBox().isSelected()) {
            String datetime = infoView.getDateTimeField().getText();
            newTask = new TimeSensTask(title, priority, datetime, location, contact, desc);
            taskArray.add(newTask);
        } else if(infoView.getAllDayCheckBox().isSelected()) {
            String date = infoView.getDateField().getText();
            newTask = new ToDoTask(title, priority, date, location, contact, desc);
            taskArray.add(newTask);
        } else {}
    }
    
    //Creates a pane from a given task
    public FlowPane taskToPane(Task task) {
        FlowPane newTaskPane = new FlowPane();
        newTaskPane.setHgap(10);
        newTaskPane.setVgap(10);
        
        Label title = new Label(task.getTitle());
        Label priority = new Label(task.getPriority());
        Label datetime = new Label(task.getDateTime());
        Label location = new Label(task.getLocation());
        Label contact = new Label(task.getContact());
        Label desc = new Label(task.getDesc());
        
        newTaskPane.getChildren().addAll(title, priority, datetime, location, contact, desc);
        return newTaskPane;
    }
    
    //Clears the task list
    public void clearTasks() {
        navView.getTaskListPane().getChildren().clear();
    }
    
    //Displays all tasks in the given data structure
    public void displayTasks(ArrayList<Task> taskArray) {
        clearTasks();
        for(int i = 0; i < taskArray.size(); i++) {
            navView.getTaskListPane().getChildren().add(taskToPane(taskArray.get(i)));
        }
    }
    
    public void closeNewTaskView() {
        navView.getNewTaskView().close();
    }
    
    public void showNewContactView() {
        navView.getNewContactView().show();
    }
    
    public void closeNewContactView() {
        navView.getNewContactView().close();
    }
}
