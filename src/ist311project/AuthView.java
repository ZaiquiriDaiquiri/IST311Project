
package ist311project;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class AuthView extends FlowPane {
    
    private AuthModel authModel;
    
    private Text usernameLabel;
    private TextField usernameField;
    private Text passwordLabel;
    private PasswordField passwordField;
    private Button authenticateButton;
    private Text authenticateLabel;
    
    AuthView(AuthModel model) {
        
        this.authModel = model;
        
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        
        usernameLabel = new Text("Username:");
        usernameField = new TextField();
        passwordLabel = new Text("Password:");
        passwordField = new PasswordField();
        authenticateButton = new Button("Authenticate");
        authenticateLabel = new Text("");
        
        this.getChildren().add(usernameLabel);
        this.getChildren().add(usernameField);
        this.getChildren().add(passwordLabel);
        this.getChildren().add(passwordField);
        this.getChildren().add(authenticateButton);
        this.getChildren().add(authenticateLabel);
        
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
    
    public Text getAuthenticateLabel() {
        return this.authenticateLabel;
    }
    
}
