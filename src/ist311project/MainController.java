
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
        
        //Action when 'Authenticate' is pressed
        authView.getAuthenticateButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(authController.authenticate(authView.getUsernameField().getText(), authView.getPasswordField().getText())) {
                    //Switches panes and clears credential fields
                    mainView.getChildren().remove(authView);
                    authView.getUsernameField().setText("");
                    authView.getPasswordField().setText("");
                    mainView.getChildren().add(navView);
                } else {}
            }
        });
        //Action when 'Logout' is pressed
        navView.getLogoutButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Switches panes
                mainView.getChildren().remove(navView);
                mainView.getChildren().add(authView);
            }
        });
    }

}
