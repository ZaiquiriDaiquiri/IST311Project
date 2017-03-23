
package ist311project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewTaskView extends Stage {
    private Scene newTaskScene;
    private GridPane newTaskPane;
    
    //Controls
    private Label titleLabel;
    private TextField titleField;
    
    private Label priorityLabel;
    private ObservableList<String> priorityList;
    private ComboBox priorityComboBox;
            
    private Label datetimeLabel;
    private TextField datetimeField;
    private CheckBox alldayCheckBox;
    private TextField dateField;
    
    private Label locationLabel;
    private TextField locationField;
    
    private Label contactLabel;
    private ObservableList<String> contactList;
    private ComboBox contactComboBox;
            
    private Label descLabel;
    private TextArea descArea;
    
    private Button createButton;
    private Button cancelButton;
    
    NewTaskView() {
        
        //Stage > Scene > Pane Setup
        this.setTitle("Create New Task");
                newTaskPane = new GridPane();
                newTaskPane.setAlignment(Pos.CENTER);
                newTaskPane.setHgap(10);
                newTaskPane.setVgap(10);
                newTaskPane.setPadding(new Insets(10, 10, 10, 10));
            newTaskScene = new Scene(newTaskPane);
        this.setScene(newTaskScene);
            
        //Pane Controls
        titleLabel = new Label("Title:");
        titleField = new TextField();
        
        priorityLabel = new Label("Priority Level:");
        priorityList = FXCollections.observableArrayList( "High", "Normal", "Low");
        priorityComboBox = new ComboBox(priorityList);
        priorityComboBox.setValue("Normal");
        
        datetimeLabel = new Label("Date & Time:");
        datetimeField = new TextField();
        alldayCheckBox = new CheckBox("All Day");
        dateField = new TextField();
        dateField.setDisable(true);
        
        locationLabel = new Label("Location:");
        locationField = new TextField();
        
        contactLabel = new Label("Contacts:");
        contactList = FXCollections.observableArrayList("", "Contact List");
        contactComboBox = new ComboBox(contactList);
        
        descLabel = new Label("Description:");
        descArea = new TextArea();
        descArea.setPrefRowCount(2);
        descArea.setWrapText(true);
        
        createButton = new Button("Create");
        cancelButton = new Button("Cancel");
        createButton.setPrefWidth(100);
        cancelButton.setPrefWidth(100);
        
        //Control Alignment
        GridPane.setHalignment(titleLabel, HPos.RIGHT);
        GridPane.setHalignment(priorityLabel, HPos.RIGHT);
        GridPane.setHalignment(datetimeLabel, HPos.RIGHT);
        GridPane.setHalignment(alldayCheckBox, HPos.CENTER);
        GridPane.setHalignment(locationLabel, HPos.RIGHT);
        GridPane.setHalignment(contactLabel, HPos.RIGHT);
        GridPane.setHalignment(descLabel, HPos.RIGHT);
        GridPane.setHalignment(createButton, HPos.RIGHT);
        GridPane.setHalignment(cancelButton, HPos.LEFT);
        
        //Control Placement
        //Row 1
        newTaskPane.add(titleLabel, 0, 0);
        newTaskPane.add(titleField, 1, 0);
        newTaskPane.add(priorityLabel, 2, 0);
        newTaskPane.add(priorityComboBox, 3, 0);
        //Row 2
        newTaskPane.add(datetimeLabel, 0, 1);
        newTaskPane.add(datetimeField, 1, 1);
        newTaskPane.add(alldayCheckBox, 2, 1);
        newTaskPane.add(dateField, 3, 1);
        //Row 3
        newTaskPane.add(locationLabel, 0, 2);
        newTaskPane.add(locationField, 1, 2);
        newTaskPane.add(contactLabel, 2, 2);
        newTaskPane.add(contactComboBox, 3, 2);
        //Row 4
        newTaskPane.add(descLabel, 0, 3);
        newTaskPane.add(descArea, 1, 3, 3, 1);
        //Row 5
        newTaskPane.add(createButton, 0, 4, 2, 1);
        newTaskPane.add(cancelButton, 2, 4, 2, 1);
    }
    
    //Get() Methods
    public TextField getTitleField() {
        return this.titleField;
    }
    public ComboBox getPriorityComboBox() {
        return this.priorityComboBox;
    }
    public TextField getDateTimeField() {
        return this.datetimeField;
    }
    public CheckBox getAllDayCheckBox() {
        return this.alldayCheckBox;
    }
    public TextField getDateField() {
        return this.dateField;
    }
    public TextField getLocationField() {
        return this.locationField;
    }
    public ComboBox getContactComboBox() {
        return this.contactComboBox;
    }
    public TextArea getDescArea() {
        return this.descArea;
    }
    public Button getCreateButton() {
        return this.createButton;
    }
    public Button getCancelButton() {
        return this.cancelButton;
    }
}
