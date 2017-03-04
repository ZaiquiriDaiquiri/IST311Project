
package ist311project;

public class AuthController {
    
    private AuthModel authModel;
    private AuthView authView;
    
    AuthController(AuthModel model, AuthView view) {
        
        this.authModel = model;
        this.authView = view;
        
    }
    
}
