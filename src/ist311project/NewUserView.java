
package ist311project;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class NewUserView extends Stage {
    
    private Scene newUserScene;
    private GridPane newUserPane;
    
    private Label newUserLabel;
    
    private Label usernameLabel;
    private TextField usernameField;
    
    private Label passwordLabel;
    private PasswordField passwordField;
    
    private Label confirmLabel;
    private PasswordField confirmField;
    
    private Button createButton;
    private Button cancelButton;
    
    NewUserView() {
        
        this.setTitle("Create New User");
        newUserPane = new GridPane();
        newUserPane.setAlignment(Pos.CENTER);
        newUserPane.setHgap(10);
        newUserPane.setVgap(10);
        newUserPane.setPadding(new Insets(10, 10, 10, 10));
        newUserScene = new Scene(newUserPane);
        this.setScene(newUserScene);
        
        newUserLabel = new Label();
        newUserLabel.setTextFill(Color.RED);
        
        usernameLabel = new Label("Username: ");
        usernameField = new TextField();
        
        passwordLabel = new Label("Password: ");
        passwordField = new PasswordField();
        
        confirmLabel = new Label("Confirm Password: ");
        confirmField = new PasswordField();
        
        createButton = new Button("Create");
        cancelButton = new Button("Cancel");
        createButton.setPrefWidth(100);
        cancelButton.setPrefWidth(100);
        
        resetFields();
        
        GridPane.setHalignment(newUserLabel, HPos.CENTER);
        GridPane.setHalignment(createButton, HPos.RIGHT);
        GridPane.setHalignment(cancelButton, HPos.LEFT);
        
        newUserPane.add(newUserLabel, 0, 0, 2, 1);
        
        newUserPane.add(usernameLabel, 0, 1);
        newUserPane.add(usernameField, 1, 1);
        
        newUserPane.add(passwordLabel, 0, 2);
        newUserPane.add(passwordField, 1, 2);
        
        newUserPane.add(confirmLabel, 0, 3);
        newUserPane.add(confirmField, 1, 3);
        
        newUserPane.add(createButton, 0, 4);
        newUserPane.add(cancelButton, 1, 4);
    }

    public Label getNewUserLabel() {
        return newUserLabel;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public PasswordField getConfirmField() {
        return confirmField;
    }

    public Button getCreateButton() {
        return createButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }
    
    public void resetFields() {
        this.newUserLabel.setText("");
        this.usernameField.clear();
        this.passwordField.clear();
        this.confirmField.clear();
    }
    
}
