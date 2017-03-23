
package ist311project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    -Move some code into NavController (EventHandlers mostly)
    -Work on figuring out TabWidth, BorderPane's prefSize

    FUTURE TODO
    -Turn tabs into classes
*/

public class NavView extends BorderPane {
    
    private NavModel navModel;
        private NewTaskView newTaskView;
        private NewContactView newContactView;
        
    private Button loadButton;
    private Button saveButton;
    private Button logoutButton;
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
            newTaskView = new NewTaskView();
            newContactView = new NewContactView();
        
        loadButton = new Button("Load Data");
        saveButton = new Button("Save Data");
        logoutButton = new Button("Logout");
        
        //ToolBar
        HBox leftToolBar = new HBox(loadButton, saveButton);
        HBox rightToolBar = new HBox(logoutButton);
        leftToolBar.setSpacing(10);
        HBox.setHgrow(leftToolBar, Priority.ALWAYS);
        HBox.setHgrow(rightToolBar, Priority.ALWAYS);
        leftToolBar.setAlignment(Pos.CENTER_LEFT);
        rightToolBar.setAlignment(Pos.CENTER_RIGHT);
        toolBar = new ToolBar(leftToolBar, rightToolBar);
        
        
        //TabPane
        tabPane = new TabPane();
        tabPane.setTabMinWidth(330);
            //Task Tab
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
            //Contact Tab
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
        tabPane.getTabs().add(taskTab);
        tabPane.getTabs().add(contactTab);
        
        this.setTop(toolBar);
        this.setCenter(tabPane);
        this.setPrefSize(710, 410);
        
        //Action when 'Create Task' is pressed
        newTaskButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newTaskView.show(); //Opens the creation dialog
                
                
                
                //Action when 'Create' is pressed
                newTaskView.getCreateButton().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        //Creation of the Task goes here
                    }
                });
                
                //Action when 'Cancel' is pressed
                newTaskView.getCancelButton().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        newTaskView.close(); //Closes the creation dialog
                    }
                });
            }
        });
        
        //Action when 'All Day' is checked
        newTaskView.getAllDayCB().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newTaskView.getDateTimeField().setDisable(newTaskView.getAllDayCB().isSelected());
            }
        });
        
        //Action when 'Create Contact' is pressed
        newContactButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newContactView.show(); //Opens the creation dialog
                
                //Action when 'Create' is pressed
                newContactView.getCreateButton().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        //Creation of the Contact goes here
                    }
                });
                
                //Action when 'Cancel' is pressed
                newContactView.getCancelButton().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        newContactView.close();  //Closes the creation dialog
                    }
                });
            }
        });
        
    }
    
    public Button getNewTaskButton() {
        return this.newTaskButton;
    }
    
    public Button getNewContactButton() {
        return this.newContactButton;
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
    
}
