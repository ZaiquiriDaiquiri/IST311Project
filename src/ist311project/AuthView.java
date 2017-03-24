
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
    //Authorization MVC
    private AuthModel authModel;
    
    //Controls
    private Label authenticateLabel;
    private Label usernameLabel;
    private TextField usernameField;
    private Label passwordLabel;
    private PasswordField passwordField;
    private Button authenticateButton;
    
    AuthView(AuthModel model) {
        //Authorization MVC
        this.authModel = model;
        
        //Alignment & Spacing
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        
        //Control Initialization
        authenticateLabel = new Label("");
            authenticateLabel.setTextFill(Color.RED);
        usernameLabel = new Label("Username:");
        usernameField = new TextField();
        passwordLabel = new Label("Password:");
        passwordField = new PasswordField();
        authenticateButton = new Button("Authenticate");
            authenticateButton.setPrefWidth(150);
        
        //Control Placement
        //Row 1
        this.add(authenticateLabel, 0, 0, 2, 1);
        //Row 2
        this.add(usernameLabel, 0, 1);
        this.add(usernameField, 1, 1);
        //Row 3
        this.add(passwordLabel, 0, 2);
        this.add(passwordField, 1, 2);
        //Row 4
        this.add(authenticateButton, 0, 3, 2, 1);
        
        //Control Alignment
        GridPane.setHalignment(authenticateLabel, HPos.CENTER);
        GridPane.setHalignment(authenticateButton, HPos.CENTER);
    }
    
    //Get() Methods
    public Label getAuthenticateLabel() {
        return this.authenticateLabel;
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
}
