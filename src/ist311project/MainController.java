
package ist311project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MainController {
    
    private MainModel mainModel;
    private MainView mainView;
    
    private AuthModel authModel;
    private AuthView authView;
    private AuthController authController;
    
    private NavModel navModel;
    private NavView navView;
    private NavController navController;
    
    MainController(MainModel model, MainView view) {

        this.mainModel = model;
        this.mainView = view;
        
        authModel = new AuthModel();
        authView = new AuthView(authModel);
        authController = new AuthController(authModel, authView);
        
        navModel = new NavModel();
        navView = new NavView(navModel);
        navController = new NavController(navModel, navView);
        
        //Sets the initial pane to AuthUI
        mainView.getChildren().add(authView);
        
        //Actions when 'Authenticate' is pressed
        authView.getAuthenticateButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Authenticating...");
                if(authController.authenticate(authView.getUsernameField().getText(), authView.getPasswordField().getText())) {
                    System.out.println("Removing AuthUI...");
                    mainView.getChildren().remove(authView);
                    System.out.println("Adding NavUI...");
                    mainView.getChildren().add(navView);
                } else {}
            }
        });
        
    }

}
