
package ist311project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

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
        ObservableList<String> contactList = FXCollections.observableArrayList("Contact List", "");
        ComboBox contactComboBox = new ComboBox(contactList);
        
        locationLabel = new Label("Location:");
        locationField = new TextField();
        
        priorityLabel = new Label("Priority Level:");
        ObservableList<String> priorityList = FXCollections.observableArrayList( "High", "Normal", "Low");
        ComboBox priorityComboBox = new ComboBox(priorityList);
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
        descField = new TextField();
        descField.setScaleY(2);
        
        createButton = new Button("Create");
        cancelButton = new Button("Cancel");

        newTaskPane.getChildren().addAll(titleLabel, titleField, 
                                         datetimeLabel, dateField, datetimeField, alldayCheckBox, 
                                         contactLabel, contactComboBox, 
                                         locationLabel, locationField, 
                                         priorityLabel, priorityComboBox, 
                                         descLabel, descField, 
                                         createButton, cancelButton);
        
    }
    
    public TextField getDateTimeField() {
        return this.datetimeField;
    }
    
    public CheckBox getAllDayCB() {
        return this.alldayCheckBox;
    }
    
    public Button getCreateButton() {
        return this.createButton;
    }
    
    public Button getCancelButton() {
        return this.cancelButton;
    }
    
}
