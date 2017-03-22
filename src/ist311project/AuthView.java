
package ist311project;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class AuthView extends GridPane {
    
    private AuthModel authModel;
    
    private Label usernameLabel;
    private TextField usernameField;
    private Label passwordLabel;
    private PasswordField passwordField;
    private Button authenticateButton;
    private Label authenticateLabel;
    
    AuthView(AuthModel model) {
        
        this.authModel = model;
        
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        
        authenticateLabel = new Label("");
        authenticateLabel.setTextFill(Color.RED);
        
        usernameLabel = new Label("Username:");
        usernameField = new TextField();
        
        passwordLabel = new Label("Password:");
        passwordField = new PasswordField();
        
        authenticateButton = new Button("Authenticate");
        authenticateButton.setPrefWidth(150);
        
        this.add(authenticateLabel, 0, 0, 2, 1);
        GridPane.setHalignment(authenticateLabel, HPos.CENTER);
        this.add(usernameLabel, 0, 1);
        this.add(usernameField, 1, 1);
        this.add(passwordLabel, 0, 2);
        this.add(passwordField, 1, 2);
        this.add(authenticateButton, 0, 3, 2, 1);
        GridPane.setHalignment(authenticateButton, HPos.CENTER);
        
    }
    
    public TextField getUsernameField() {
        return this.usernameField;
    }
    
    public PasswordField getPasswordField() {
        return this.passwordField;
    }
    
    public Button getAuthenticateButton() {
        return this.authenticateButton;
    }
    
    public Label getAuthenticateLabel() {
        return this.authenticateLabel;
    }
    
}
