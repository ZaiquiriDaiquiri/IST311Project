
package ist311project;

public class AuthController {
    //Authorization MVC
    private AuthModel authModel;
    private AuthView authView;
    
    AuthController(AuthModel model, AuthView view) {
        //Authorization MVC
        this.authModel = model;
        this.authView = view;
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
    
    //Get() Methods
    private String getInputUsername() {
        return authView.getUsernameField().getText();
    }
    
    private String getInputPassword() {
        return authView.getPasswordField().getText();
    }
}
