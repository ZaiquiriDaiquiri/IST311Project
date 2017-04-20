package ist311project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class AuthController {
    //Authorization MVC
    private AuthModel authModel;
    private AuthView authView;
    
    AuthController(AuthModel model, AuthView view) {
        //Authorization MVC
        this.authModel = model;
        this.authView = view;
        
        //USER CREATION
        //When 'New User' is pressed
        authView.getNewUserButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showNewUserView();
            }
        });
        
        //When 'Create' is pressed
        authView.getNewUserView().getCreateButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isValidCreateUser()) {
                    closeNewUserView();
                } else {}
            }
        });
        
        //When 'Cancel' is pressed
        authView.getNewUserView().getCancelButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                closeNewUserView();
            }
        });
    }
    
    public boolean isAuthenticated() {
        String inputUsername = getInputUsername();
        String inputPassword = getInputPassword();
        
        if(isValidUsername(inputUsername)) {
            if(isValidPassword(inputUsername, inputPassword)) {
                return true;
            } else {
                showAuthError();
                return false;
            }
        } else {
            showAuthError();
            return false;
        }
    }
    
    private boolean isValidUsername(String username) {
        return authModel.getUserInfo().containsKey(username);
    }
    
    private boolean isValidPassword(String username, String password) {
        return password.equals(authModel.getUserInfo().get(username));
    }
    
    private void showAuthError() {
        authView.getAuthenticateLabel().setText("Invalid Credentials!");
    }
    
    //Validates new user fields and creates an account if they are valid
    public boolean isValidCreateUser() {
        Label errorLabel = getNewErrorLabel();
        String username = getNewUsername();
        String password = getNewPassword();
        String confirmPassword = getNewConfirm();

        if(username.equals("")) {
            errorLabel.setText("Please enter a username!");
            return false;
        } else if(authModel.getUserInfo().containsKey(username)) {
            errorLabel.setText("Username already taken!");
            return false;
        } else {
            if(password.equals("")) {
                errorLabel.setText("Please enter a password!");
                return false;
            } else if(confirmPassword.equals("") || !confirmPassword.equals(password)) {
                errorLabel.setText("Passwords do not match!");
                return false;
            } else {
                authModel.getUserInfo().put(username, password);
                return true;
            }
        }
    }
    
    //Get() Methods
    private String getInputUsername() {
        return authView.getUsernameField().getText();
    }
    
    private String getInputPassword() {
        return authView.getPasswordField().getText();
    }

    private Label getNewErrorLabel() {
        return authView.getNewUserView().getNewUserLabel();
    }

    private String getNewUsername() {
        return authView.getNewUserView().getUsernameField().getText();
    }

    private String getNewPassword() {
        return authView.getNewUserView().getPasswordField().getText();
    }

    private String getNewConfirm() {
        return authView.getNewUserView().getConfirmField().getText();
    }
    
    public void showNewUserView() {
        authView.getNewUserView().resetFields();
        authView.getNewUserView().show();
    }
    
    public void closeNewUserView() {
        authView.getNewUserView().close();
    }
}
