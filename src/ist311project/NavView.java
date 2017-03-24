
package ist311project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
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
            private GridPane taskPane;
                private Button newTaskButton;
                private GridPane taskListPane;
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
                taskPane = new GridPane();
                taskPane.setPadding(new Insets(10, 10, 10, 10));
                    newTaskButton = new Button("New Task");
                    taskListPane = new GridPane();
                    ScrollPane scroll = new ScrollPane();
                    scroll.setContent(taskListPane);
                    taskListPane.setHgap(10);
                    taskListPane.setVgap(10);
                taskPane.add(newTaskButton, 0, 0);
                taskPane.add(scroll, 0, 1);
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
    public GridPane getTaskPane() {
        return this.taskPane;
    }
    public Button getNewTaskButton() {
        return this.newTaskButton;
    }
    public GridPane getTaskListPane() {
        return this.taskListPane;
    }
    public FlowPane getContactPane() {
        return this.contactPane;
    }
    public Button getNewContactButton() {
        return this.newContactButton;
    }
    
    //ADJUST VARIABLES
    public FlowPane createAndGetTaskTile(Task task) {
        FlowPane taskTile = new FlowPane();
        Label title = new Label();
        Label datetime = new Label();
        Label contact = new Label();
        Label location = new Label();
        Label priority = new Label();
        Label desc = new Label();
        
        title.setText(task.getTitle());
        datetime.setText(task.getDateTime());
        contact.setText(task.getContact());
        location.setText(task.getLocation());
        priority.setText(task.getPriority());
        desc.setText(task.getDesc());
        taskTile.getChildren().addAll(title, datetime, contact, location, priority, desc);
        return taskTile;
    }
}
