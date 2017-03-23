
package ist311project;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/*
    TODO
    -Work on figuring out TabWidth, BorderPane's prefSize

    FUTURE TODO
    -Add refresh button OR automatically refresh when something new is created (maybe on create click?)
    -Turn tabs into classes
*/

public class NavView extends BorderPane {
    private NavModel navModel;
    
    private NewTaskView newTaskView;
    private NewContactView newContactView;
        
    private Button loadButton;
    private Button saveButton;
    private Button logoutButton;
    
    private HBox leftToolBar;
    private HBox rightToolBar;
    private ToolBar toolBar;
        
    private TabPane tabPane;
        private Tab taskTab;
            private FlowPane taskPane;
                private Button newTaskButton;
        private Tab contactTab;
            private FlowPane contactPane;
                private Button newContactButton;
    
    NavView(NavModel model) {
        this.navModel = model;
        
        //Creation Dialogue Classes
        newTaskView = new NewTaskView();
        newContactView = new NewContactView();
        
        //Toolbar Buttons
        loadButton = new Button("Load Data");
        saveButton = new Button("Save Data");
        logoutButton = new Button("Logout");
        
        //Toolbar
        leftToolBar = new HBox(loadButton, saveButton);
        rightToolBar = new HBox(logoutButton);
        leftToolBar.setSpacing(10);
        HBox.setHgrow(leftToolBar, Priority.ALWAYS);
        HBox.setHgrow(rightToolBar, Priority.ALWAYS);
        leftToolBar.setAlignment(Pos.CENTER_LEFT);
        rightToolBar.setAlignment(Pos.CENTER_RIGHT);
        toolBar = new ToolBar(leftToolBar, rightToolBar);
        
        //TabPane
        tabPane = new TabPane();
        tabPane.setTabMinWidth(330);
            //Task Tab & Content
            taskTab = new Tab();
            taskTab.setText("Tasks");
                taskPane = new FlowPane();
                taskPane.setHgap(10);
                taskPane.setVgap(10);
                taskPane.setPadding(new Insets(10, 10, 10, 10));
                    newTaskButton = new Button("New Task");
                taskPane.getChildren().add(newTaskButton);
            taskTab.setContent(taskPane);
            taskTab.setClosable(false);
            //Contact Tab & Content
            contactTab = new Tab();
            contactTab.setText("Contacts");
                contactPane = new FlowPane();
                contactPane.setHgap(10);
                contactPane.setVgap(10);
                contactPane.setPadding(new Insets(10, 10, 10, 10));
                    newContactButton = new Button("New Contact");
                contactPane.getChildren().add(newContactButton);
            contactTab.setContent(contactPane);
            contactTab.setClosable(false);
        //Add Tabs
        tabPane.getTabs().add(taskTab);
        tabPane.getTabs().add(contactTab);
        
        //Toolbar/Pane Placement
        this.setTop(toolBar);
        this.setCenter(tabPane);
        this.setPrefSize(710, 410);
    }
    
    //Get() Methods
    public NewTaskView getNewTaskView() {
        return this.newTaskView;
    }
    public NewContactView getNewContactView() {
        return this.newContactView;
    }
    public Button getLoadButton() {
        return this.loadButton;
    }
    public Button getSaveButton() {
        return this.saveButton;
    }
    public Button getLogoutButton() {
        return this.logoutButton;
    }
    public FlowPane getTaskPane() {
        return this.taskPane;
    }
    public Button getNewTaskButton() {
        return this.newTaskButton;
    }
    public FlowPane getContactPane() {
        return this.contactPane;
    }
    public Button getNewContactButton() {
        return this.newContactButton;
    }
    
    //MOVE TO CONTROLLER
    public void createTask(NewTaskView infoView, ArrayList<Task> taskArray) {
        String title = infoView.getTitleField().getText();
        String contact = infoView.getContactComboBox().getValue().toString();
        String location = infoView.getLocationField().getText();
        String priority = infoView.getPriorityComboBox().getValue().toString();
        String desc = infoView.getDescArea().getText();
        
        if(!infoView.getAllDayCheckBox().isSelected()) {
            String datetime = infoView.getDateTimeField().getText();
            TimeSensTask newTask = new TimeSensTask(title, datetime, contact, location, priority, desc);
            taskArray.add(newTask);
        } else if(infoView.getAllDayCheckBox().isSelected()) {
            String date = infoView.getDateField().getText();
            ToDoTask newTask = new ToDoTask(title, date, contact, location, priority, desc);
            taskArray.add(newTask);
        } else {}
    }
}
