
package ist311project;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AuthView extends JPanel {
    
    private AuthModel authModel;
    
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton authenticateButton;
    private JLabel authenticateLabel;
    
    AuthView(AuthModel model) {
        
        this.authModel = model;
        
        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(10);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(10);
        authenticateButton = new JButton("Authenticate");
        authenticateLabel = new JLabel("");
        
        this.add(usernameLabel);
        this.add(usernameField);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(authenticateButton);
        this.add(authenticateLabel);
        
    }
    
    public JTextField getUsernameField() {
        return this.usernameField;
    }
    
    public JButton getAuthenticateButton() {
        return this.authenticateButton;
    }
    
    public JLabel getAuthenticateLabel() {
        return this.authenticateLabel;
    }
    
    public void addActionListener(ActionListener al) {
        this.authenticateButton.addActionListener(al);
    }
    
}
