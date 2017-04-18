package ist311project;

import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
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

    private Label locationLabel;
    private TextField locationField;

    private Label contactLabel;
    private ObservableList<String> contactList;
    private ComboBox contactComboBox;

    private Label descLabel;
    private TextArea descArea;

    private CheckBox timeSensCheckBox;
    
    private Label timeLabel;
    private Label divLabel;

    private ObservableList<String> hourList;
    private ObservableList<String> minuteList;
    private ObservableList<String> amPmList;
    
    private ComboBox hourComboBox;
    private ComboBox minuteComboBox;
    private ComboBox amPmComboBox;

    private FlowPane timePane;

    private Label dateLabel;
    private DatePicker dateField;

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
        priorityList = FXCollections.observableArrayList("High", "Normal", "Low");
        priorityComboBox = new ComboBox(priorityList);

        locationLabel = new Label("Location:");
        locationField = new TextField();

        contactLabel = new Label("Contacts:");
        contactList = FXCollections.observableArrayList("None");
        contactComboBox = new ComboBox(contactList);

        descLabel = new Label("Description:");
        descArea = new TextArea();
        descArea.setPrefRowCount(2);
        descArea.setWrapText(true);

        timeSensCheckBox = new CheckBox("Time Sensitive");

        dateLabel = new Label("Date:");
        dateField = new DatePicker();
        
        timeLabel = new Label("Time:");
        divLabel = new Label(" : ");
        
        hourList = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        minuteList = FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", 
                                                       "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", 
                                                       "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", 
                                                       "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", 
                                                       "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", 
                                                       "50", "51", "52", "53", "54", "55", "56", "57", "58", "59");
        amPmList = FXCollections.observableArrayList("AM", "PM");
        
        hourComboBox = new ComboBox(hourList);
        minuteComboBox = new ComboBox(minuteList);
        amPmComboBox = new ComboBox(amPmList);
        
        timePane = new FlowPane();
        timePane.setHgap(10);
        timePane.getChildren().addAll(timeLabel, hourComboBox, divLabel, minuteComboBox, amPmComboBox);

        createButton = new Button("Create");
        cancelButton = new Button("Cancel");
        createButton.setPrefWidth(100);
        cancelButton.setPrefWidth(100);
        
        resetFields();

        //Control Alignment
        GridPane.setHalignment(createButton, HPos.RIGHT);
        GridPane.setHalignment(cancelButton, HPos.LEFT);

        //Control Placement
        
        newTaskPane.add(titleLabel, 0, 0);
        newTaskPane.add(titleField, 1, 0);

        newTaskPane.add(priorityLabel, 0, 1);
        newTaskPane.add(priorityComboBox, 1, 1);
        
        newTaskPane.add(locationLabel, 0, 2);
        newTaskPane.add(locationField, 1, 2);

        newTaskPane.add(contactLabel, 0, 3);
        newTaskPane.add(contactComboBox, 1, 3);
        
        newTaskPane.add(descLabel, 0, 4);
        newTaskPane.add(descArea, 1, 4);

        newTaskPane.add(timeSensCheckBox, 0, 5, 2, 1);

        newTaskPane.add(dateLabel, 0, 6);
        newTaskPane.add(dateField, 1, 6);

        newTaskPane.add(timeLabel, 0, 7);
        newTaskPane.add(timePane, 1, 7);
        
        newTaskPane.add(createButton, 0, 8);
        newTaskPane.add(cancelButton, 1, 8);
    }

    //Get() Methods
    public TextField getTitleField() {
        return titleField;
    }

    public ObservableList<String> getPriorityList() {
        return priorityList;
    }

    public ComboBox getPriorityComboBox() {
        return priorityComboBox;
    }

    public TextField getLocationField() {
        return locationField;
    }

    public ObservableList<String> getContactList() {
        return contactList;
    }

    public ComboBox getContactComboBox() {
        return contactComboBox;
    }

    public TextArea getDescArea() {
        return descArea;
    }

    public CheckBox getTimeSensCheckBox() {
        return timeSensCheckBox;
    }
    
    public DatePicker getDateField() {
        return dateField;
    }

    public ObservableList<String> getHourList() {
        return hourList;
    }

    public ObservableList<String> getMinuteList() {
        return minuteList;
    }

    public ObservableList<String> getAmPmList() {
        return amPmList;
    }

    public ComboBox getHourComboBox() {
        return hourComboBox;
    }

    public ComboBox getMinuteComboBox() {
        return minuteComboBox;
    }

    public ComboBox getAmPmComboBox() {
        return amPmComboBox;
    }

    
    public Button getCreateButton() {
        return createButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }
    
    public void resetFields() {
        this.titleField.setText("");
        this.priorityComboBox.setValue("Normal");
        this.locationField.setText("");
        this.contactComboBox.setValue("Choose Contact");
        this.descArea.setText("");
        this.timeSensCheckBox.setSelected(false);
        this.dateField.setValue(LocalDate.now());
        this.dateField.setDisable(true);
        this.hourComboBox.setValue("12");
        this.minuteComboBox.setValue("00");
        this.amPmComboBox.setValue("AM");
        this.hourComboBox.setDisable(true);
        this.minuteComboBox.setDisable(true);
        this.amPmComboBox.setDisable(true);
    }

}
