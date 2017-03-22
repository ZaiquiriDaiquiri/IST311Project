
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
                System.out.println("Authenticated");
                System.out.println("Logging in...");
                return true;
            } else {
                System.out.println("Not Authenticated: Invalid Password");
                authView.getAuthenticateLabel().setText("Invalid Credentials!");
                return false;
            }
        } else {
            System.out.println("Not Authenticated: Invalid Username");
            authView.getAuthenticateLabel().setText("Invalid Credentials!");
            return false;
        }
    }
    
}
