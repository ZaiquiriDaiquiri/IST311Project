
package ist311project;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class NewContactView extends Stage {
    
    private Scene newContactScene;
    private FlowPane newContactPane;
    
    private Label nameLabel;
    private TextField nameField;
    
    private Label contactTypeLabel;
    private ToggleGroup contactTypeGroup;
        private RadioButton professionalButton;
        private RadioButton personalButton;
        
    private Label mPhoneLabel;
    private TextField mPhoneField;
    private Label hPhoneLabel;
    private TextField hPhoneField;
    private Label wPhoneLabel;
    private TextField wPhoneField;
    
    private Label emailLabel;
    private TextField emailField;
            
    private Label addressLabel;
    private TextField addressField;
            
    private Label nicknameLabel;
    private TextField nicknameField;
    
    private Label compLabel;
    private TextField compField;
    
    private Label compTitleLabel;
    private TextField compTitleField;
    
    private Button createButton;
    private Button cancelButton;
    
    NewContactView() {
        
        this.setTitle("Create New Contact");
        newContactPane = new FlowPane();
        newContactScene = new Scene(newContactPane, 500, 400);
        this.setScene(newContactScene);
        
        newContactPane.setHgap(10);
        newContactPane.setVgap(10);
        newContactPane.setPadding(new Insets(10, 10, 10, 10));
        
        nameLabel = new Label("Name:");
        nameField = new TextField();
        
        contactTypeLabel = new Label("Contact Type:");
        contactTypeGroup = new ToggleGroup();
            professionalButton = new RadioButton("Professional");
                professionalButton.setToggleGroup(contactTypeGroup);
            personalButton = new RadioButton("Personal");
                personalButton.setToggleGroup(contactTypeGroup);
        
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

        newContactPane.getChildren().addAll(nameLabel, nameField, 
                                            contactTypeLabel, professionalButton, personalButton, 
                                            mPhoneLabel, mPhoneField, 
                                            hPhoneLabel, hPhoneField, 
                                            wPhoneLabel, wPhoneField, 
                                            emailLabel, emailField, 
                                            addressLabel, addressField, 
                                            nicknameLabel, nicknameField, 
                                            compLabel, compField, 
                                            compTitleLabel, compTitleField, 
                                            createButton, cancelButton);
        
    }
    
    public Button getCreateButton() {
        return this.createButton;
    }
    
    public Button getCancelButton() {
        return this.cancelButton;
    }
    
}
