
package ist311project;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    private Label phoneLabel;
    private TextField phoneField;
    
    private Label emailLabel;
    private TextField emailField;
            
    private Label addressLabel;
    private TextField addressField;
    
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
        
        phoneLabel = new Label("Phone:");
        phoneField = new TextField();
        
        emailLabel = new Label("Email:");
        emailField = new TextField();
        
        addressLabel = new Label("Address:");
        addressField = new TextField();
        
        createButton = new Button("Create");
        cancelButton = new Button("Cancel");
        createButton.setPrefWidth(100);
        cancelButton.setPrefWidth(100);
        
        //Control Alignment
        GridPane.setHalignment(createButton, HPos.RIGHT);
        GridPane.setHalignment(cancelButton, HPos.LEFT);

        //Control Placement
        //Row 1
        newContactPane.add(nameLabel, 0, 0);
        newContactPane.add(nameField, 1, 0);
        //Row 2
        newContactPane.add(phoneLabel, 0, 1);
        newContactPane.add(phoneField, 1, 1);
        //Row 3
        newContactPane.add(emailLabel, 0, 2);
        newContactPane.add(emailField, 1, 2);
        //Row 4
        newContactPane.add(addressLabel, 0, 3);
        newContactPane.add(addressField, 1, 3);
        //Row 5
        newContactPane.add(createButton, 0, 4);
        newContactPane.add(cancelButton, 1, 4);
    }
    
    //Get() Methods

    public TextField getNameField() {
        return this.nameField;
    }

    public TextField getPhoneField() {
        return this.phoneField;
    }

    public TextField getEmailField() {
        return this.emailField;
    }

    public TextField getAddressField() {
        return this.addressField;
    }

    public Button getCreateButton() {
        return this.createButton;
    }

    public Button getCancelButton() {
        return this.cancelButton;
    }
    
    public void resetFields() {
        this.nameField.setText("");
        this.phoneField.setText("");
        this.emailField.setText("");
        this.addressField.setText("");
    }

}
