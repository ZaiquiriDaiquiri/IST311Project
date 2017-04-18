package ist311project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AuthController {
    //Authorization MVC
    private AuthModel authModel;
    private AuthView authView;
    
    AuthController(AuthModel model, AuthView view) {
        //Authorization MVC
        this.authModel = model;
        this.authView = view;
        
        authView.getNewUserButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showNewUserView();
            }
        });
        
        authView.getNewUserView().getCreateButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if(isValidCreateUser(authView.getNewUserView().getUsernameField().getText(), authView.getNewUserView().getPasswordField().getText(), authView.getNewUserView().getConfirmField().getText())) {
                    closeNewUserView();
                } else {}
            }
        });
        
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
    
    public boolean isValidCreateUser(String username, String password, String confirmPassword) {
        if(username.equals("")) {
            authView.getNewUserView().getNewUserLabel().setText("Please enter a username!");
            return false;
        } else if(authModel.getUserInfo().containsKey(username)) {
            authView.getNewUserView().getNewUserLabel().setText("Username already taken!");
            return false;
        } else {
            if(password.equals("")) {
                authView.getNewUserView().getNewUserLabel().setText("Please enter a password!");
                return false;
            } else if(confirmPassword.equals("") || !confirmPassword.equals(password)) {
                authView.getNewUserView().getNewUserLabel().setText("Passwords do not match!");
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
    
    public void showNewUserView() {
        authView.getNewUserView().resetFields();
        authView.getNewUserView().show();
    }
    
    public void closeNewUserView() {
        authView.getNewUserView().close();
    }
}
