
package ist311project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewContactView extends Stage {
    
    private Scene newContactScene;
    private GridPane newContactPane;
    
    //Controls
    private Label nameLabel;
    private TextField nameField;
    
    private Label contactTypeLabel;
    private ObservableList<String> contactTypeList;
    private ComboBox contactTypeComboBox;
        
    private Label mPhoneLabel;
    private TextField mPhoneField;
    
    private Label wPhoneLabel;
    private TextField wPhoneField;
    
    private Label hPhoneLabel;
    private TextField hPhoneField;
    
    private Label emailLabel;
    private TextField emailField;
            
    private Label addressLabel;
    private TextField addressField;
    
    private Label compLabel;
    private TextField compField;
    
    private Label compTitleLabel;
    private TextField compTitleField;
    
    private Label nicknameLabel;
    private TextField nicknameField;
    
    private Button createButton;
    private Button cancelButton;
    
    NewContactView() {
        
        //Stage > Scene > Pane Setup
        this.setTitle("Create New Contact");
                newContactPane = new GridPane();
                newContactPane.setAlignment(Pos.CENTER);
                newContactPane.setHgap(10);
                newContactPane.setVgap(10);
                newContactPane.setPadding(new Insets(10, 10, 10, 10));
            newContactScene = new Scene(newContactPane);
        this.setScene(newContactScene);
            
        
        //Pane Controls
        nameLabel = new Label("Name:");
        nameField = new TextField();
        
        contactTypeLabel = new Label("Contact Type:");
        contactTypeList = FXCollections.observableArrayList("General", "Professional", "Personal");
        contactTypeComboBox = new ComboBox(contactTypeList);
        contactTypeComboBox.setValue("General");
        
        mPhoneLabel = new Label("Mobile Phone:");
        mPhoneField = new TextField();
        hPhoneLabel = new Label("Home Phone:");
        hPhoneField = new TextField();
        wPhoneLabel = new Label("Work Phone:");
        wPhoneField = new TextField();
        
        emailLabel = new Label("Email:");
        emailField = new TextField();
        
        addressLabel = new Label("Address:");
        addressField = new TextField();
        
        nicknameLabel = new Label("Nickname:");
        nicknameField = new TextField();
        
        compLabel = new Label("Company:");
        compField = new TextField();
        
        compTitleLabel = new Label("Company Title:");
        compTitleField = new TextField();
        
        createButton = new Button("Create");
        cancelButton = new Button("Cancel");
        createButton.setPrefWidth(100);
        cancelButton.setPrefWidth(100);
        
        //Control Alignment
        GridPane.setHalignment(nameLabel, HPos.RIGHT);
        GridPane.setHalignment(contactTypeLabel, HPos.RIGHT);
        GridPane.setHalignment(mPhoneLabel, HPos.RIGHT);
        GridPane.setHalignment(wPhoneLabel, HPos.RIGHT);
        GridPane.setHalignment(hPhoneLabel, HPos.RIGHT);
        GridPane.setHalignment(emailLabel, HPos.RIGHT);
        GridPane.setHalignment(addressLabel, HPos.RIGHT);
        GridPane.setHalignment(compLabel, HPos.RIGHT);
        GridPane.setHalignment(compTitleLabel, HPos.RIGHT);
        GridPane.setHalignment(nicknameLabel, HPos.RIGHT);
        GridPane.setHalignment(createButton, HPos.RIGHT);
        GridPane.setHalignment(cancelButton, HPos.LEFT);

        //Control Placement
        //Row 1
        newContactPane.add(nameLabel, 0, 0);
        newContactPane.add(nameField, 1, 0);
        newContactPane.add(contactTypeLabel, 2, 0);
        newContactPane.add(contactTypeComboBox, 3, 0);
        //Row 2
        newContactPane.add(mPhoneLabel, 0, 1);
        newContactPane.add(mPhoneField, 1, 1);
        newContactPane.add(wPhoneLabel, 2, 1);
        newContactPane.add(wPhoneField, 3, 1);
        //Row 3
        newContactPane.add(hPhoneLabel, 0, 2);
        newContactPane.add(hPhoneField, 1, 2);
        newContactPane.add(emailLabel, 2, 2);
        newContactPane.add(emailField, 3, 2);
        //Row 4
        newContactPane.add(addressLabel, 0, 3);
        newContactPane.add(addressField, 1, 3, 3, 1);
        //Row 5
        newContactPane.add(compLabel, 0, 4);
        newContactPane.add(compField, 1, 4);
        newContactPane.add(compTitleLabel, 2, 4);
        newContactPane.add(compTitleField, 3, 4);
        //Row 6
        newContactPane.add(nicknameLabel, 0, 5);
        newContactPane.add(nicknameField, 1, 5);
        //Row 7
        newContactPane.add(createButton, 0, 6, 2, 1);
        newContactPane.add(cancelButton, 2, 6, 2, 1);
    }
    
    //Get() Methods
    public TextField getNameField() {
        return this.nameField;
    }
    public ComboBox getContactTypeComboBox() {
        return this.contactTypeComboBox;
    }
    public TextField getMPhoneField() {
        return this.mPhoneField;
    }
    public TextField getWPhoneField() {
        return this.wPhoneField;
    }
    public TextField getHPhoneField() {
        return this.hPhoneField;
    }
    public TextField getEmailField() {
        return this.emailField;
    }
    public TextField getAddressField() {
        return this.addressField;
    }
    public TextField getCompField() {
        return this.compField;
    }
    public TextField getCompTitleField() {
        return this.compTitleField;
    }
    public TextField getNicknameField() {
        return this.nicknameField;
    }
    public Button getCreateButton() {
        return this.createButton;
    }
    public Button getCancelButton() {
        return this.cancelButton;
    }
}
