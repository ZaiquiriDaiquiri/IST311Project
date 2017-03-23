
package ist311project;

public class AuthController {
    
    private AuthModel authModel;
    private AuthView authView;
    
    AuthController(AuthModel model, AuthView view) {
        this.authModel = model;
        this.authView = view;
    }
    
    public boolean authenticate(String inputUsername, String inputPassword) {
        if(authModel.getUserInfo().containsKey(inputUsername)) {
            if(inputPassword.equals(authModel.getUserInfo().get(inputUsername))) {
                return true;
            } else {
                authView.getAuthenticateLabel().setText("Invalid Credentials!");
                return false;
            }
        } else {
            authView.getAuthenticateLabel().setText("Invalid Credentials!");
            return false;
        }
    }
    
}
