
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
    
    private Label titleLabel;
    private TextField titleField;
            
    private Label datetimeLabel;        
    private TextField dateField;
    private TextField datetimeField;        
    private CheckBox alldayCheckBox;
    
    private Label contactLabel;
    private ObservableList<String> contactList;
    private ComboBox contactComboBox;
            
    private Label locationLabel;
    private TextField locationField;
            
    private Label priorityLabel;
    private ObservableList<String> priorityList;
    private ComboBox priorityComboBox;
        
    private Label descLabel;
    private TextArea descArea;
    
    private Button createButton;
    private Button cancelButton;
    
    NewTaskView() {
        
        this.setTitle("Create New Task");
        newTaskPane = new GridPane();
        newTaskPane.setAlignment(Pos.CENTER);
        newTaskScene = new Scene(newTaskPane);
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
        contactList = FXCollections.observableArrayList("", "Contact List");
        contactComboBox = new ComboBox(contactList);
        
        locationLabel = new Label("Location:");
        locationField = new TextField();
        
        priorityLabel = new Label("Priority Level:");
        priorityList = FXCollections.observableArrayList( "High", "Normal", "Low");
        priorityComboBox = new ComboBox(priorityList);
        priorityComboBox.setValue("Normal");
        
        /*
        priorityComboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override public ListCell<String> call(ListView<String> param) {
                final ListCell<String> cell = new ListCell<String>() {
                    {
                        super.setPrefWidth(100);
                    }    
                    @Override public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);    
                            if (item.equals("High")) {
                                setTextFill(Color.RED);
                            }
                            else if (item.equals("Low")){
                                setTextFill(Color.GREEN);
                            }
                            else {
                                setTextFill(Color.BLACK);
                            }
                        }
                        else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        });
        */
                
        descLabel = new Label("Description:");
        descArea = new TextArea();
        descArea.setPrefRowCount(2);
        descArea.setWrapText(true);
        
        createButton = new Button("Create");
        cancelButton = new Button("Cancel");
        createButton.setPrefWidth(100);
        cancelButton.setPrefWidth(100);
        
        GridPane.setHalignment(titleLabel, HPos.RIGHT);
        GridPane.setHalignment(priorityLabel, HPos.RIGHT);
        GridPane.setHalignment(datetimeLabel, HPos.RIGHT);
        GridPane.setHalignment(alldayCheckBox, HPos.CENTER);
        GridPane.setHalignment(locationLabel, HPos.RIGHT);
        GridPane.setHalignment(contactLabel, HPos.RIGHT);
        GridPane.setHalignment(descLabel, HPos.RIGHT);
        GridPane.setHalignment(createButton, HPos.RIGHT);
        GridPane.setHalignment(cancelButton, HPos.LEFT);
        
        newTaskPane.add(titleLabel, 0, 0);
        newTaskPane.add(titleField, 1, 0);
        newTaskPane.add(priorityLabel, 2, 0);
        newTaskPane.add(priorityComboBox, 3, 0);
        
        newTaskPane.add(datetimeLabel, 0, 1);
        newTaskPane.add(datetimeField, 1, 1);
        newTaskPane.add(alldayCheckBox, 2, 1);
        newTaskPane.add(dateField, 3, 1);
        
        newTaskPane.add(locationLabel, 0, 2);
        newTaskPane.add(locationField, 1, 2);
        newTaskPane.add(contactLabel, 2, 2);
        newTaskPane.add(contactComboBox, 3, 2);
        
        newTaskPane.add(descLabel, 0, 3);
        newTaskPane.add(descArea, 1, 3, 3, 1);
        
        newTaskPane.add(createButton, 0, 4, 2, 1);
        newTaskPane.add(cancelButton, 2, 4, 2, 1);
        
        //this.newTaskPane.setGridLinesVisible(true);
        
    }
    
    public TextField getDateTimeField() {
        return this.datetimeField;
    }
    
    public CheckBox getAllDayCheckBox() {
        return this.alldayCheckBox;
    }
    
    public Button getCreateButton() {
        return this.createButton;
    }
    
    public Button getCancelButton() {
        return this.cancelButton;
    }
    
}
