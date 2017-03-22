
package ist311project;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;

public class NavView extends FlowPane{
    
    private NavModel navModel;
    
    private Button newTaskButton;
    private Button newContactButton;
    private Button loadButton;
    private Button saveButton;
    private Button logoutButton;
        
    NavView(NavModel model) {
        
        this.navModel = model;
        
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        
        newTaskButton = new Button("New Task");
        newContactButton = new Button("New Contact");
        loadButton = new Button("Load Data");
        saveButton = new Button("Save Data");
        logoutButton = new Button("Logout");
        
        TabPane tabPane = new TabPane();
        tabPane.setMinSize(400, 400);
        
        Tab taskTab = new Tab();
        taskTab.setText("Tasks");
        taskTab.setContent(newTaskButton);
        taskTab.setClosable(false);
        
        Tab contactTab = new Tab();
        contactTab.setText("Contacts");
        contactTab.setContent(newContactButton);
        contactTab.setClosable(false);
        
        tabPane.getTabs().add(taskTab);
        tabPane.getTabs().add(contactTab);
                        
        this.getChildren().add(tabPane);
        this.getChildren().add(loadButton);
        this.getChildren().add(saveButton);
        this.getChildren().add(logoutButton);
        
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
