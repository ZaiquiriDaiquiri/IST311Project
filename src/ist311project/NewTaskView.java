
package ist311project;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class NewTaskView extends Stage {
    
    private Scene newTaskScene;
    private FlowPane newTaskPane;
    
    private Label titleLabel;
    private TextField titleField;
            
    private Label datetimeLabel;        
    private TextField dateField;
    private TextField datetimeField;        
    private CheckBox alldayCheckBox;
    
    private Label contactLabel;
    private TextField contactField;
            
    private Label locationLabel;
    private TextField locationField;
            
    private Label priorityLabel;
    private ToggleGroup priorityGroup;
        private RadioButton highRadioButton;
        private RadioButton medRadioButton;
        private RadioButton lowRadioButton;
        
    private Label descLabel;
    private TextField descField;
    
    private Button createButton;
    private Button cancelButton;
    
    NewTaskView() {
        
        this.setTitle("Create New Task");
        newTaskPane = new FlowPane();
        newTaskScene = new Scene(newTaskPane, 500, 400);
        this.setScene(newTaskScene);
        
        newTaskPane.setHgap(10);
        newTaskPane.setVgap(10);
        newTaskPane.setPadding(new Insets(10, 10, 10, 10));
        
        titleLabel = new Label("Title:");
        titleField = new TextField();
        
        datetimeLabel = new Label("Date & Time:");
        dateField = new TextField();
        datetimeField = new TextField();
        alldayCheckBox = new CheckBox("All Day");
        
        contactLabel = new Label("Contacts:");
        contactField = new TextField();
        
        locationLabel = new Label("Location:");
        locationField = new TextField();
        
        priorityLabel = new Label("Priority Level:");
        priorityGroup = new ToggleGroup();
            highRadioButton = new RadioButton("High");
                highRadioButton.setToggleGroup(priorityGroup);
            medRadioButton = new RadioButton("Medium");
                medRadioButton.setToggleGroup(priorityGroup);
            lowRadioButton = new RadioButton("Low");
                lowRadioButton.setToggleGroup(priorityGroup);
                
        descLabel = new Label("Description:");
        descField = new TextField();
        
        createButton = new Button("Create");
        cancelButton = new Button("Cancel");

        newTaskPane.getChildren().addAll(titleLabel, titleField, 
                                         datetimeLabel, dateField, datetimeField, alldayCheckBox, 
                                         contactLabel, contactField, 
                                         locationLabel, locationField, 
                                         priorityLabel, highRadioButton, medRadioButton, lowRadioButton, 
                                         descLabel, descField, 
                                         createButton, cancelButton);
        
    }
    
    public Button getCreateButton() {
        return this.createButton;
    }
    
    public Button getCancelButton() {
        return this.cancelButton;
    }
    
}
