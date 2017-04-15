
package ist311project;

import javafx.event.ActionEvent;

public class MainController {
    //Main MVC
    private MainModel mainModel;
    private MainView mainView;
    
    //Authorization MVC
    private AuthModel authModel;
    private AuthView authView;
    private AuthController authController;
    
    //Navigation MVC
    private NavModel navModel;
    private NavView navView;
    private NavController navController;
    
    MainController(MainModel model, MainView view) {
        //Main MVC
        this.mainModel = model;
        this.mainView = view;
        
        //Authorization MVC
        authModel = new AuthModel();
        authView = new AuthView(authModel);
        authView.prefWidthProperty().bind(mainView.widthProperty());
        authView.prefHeightProperty().bind(mainView.heightProperty());
        authController = new AuthController(authModel, authView);
        
        //Navigation MVC
        navModel = new NavModel();
        navView = new NavView(navModel);
        navView.prefWidthProperty().bind(mainView.widthProperty());
        navView.prefHeightProperty().bind(mainView.heightProperty());
        navController = new NavController(navModel, navView);
        
        //Shows AuthUI at launch
        mainView.getChildren().add(authView);
        
        //Action when 'Authenticate' is pressed
        authView.getAuthenticateButton().setOnAction((ActionEvent event) -> {
            if(authController.isAuthenticated()) {
                switchToNavView();
            } else {}
        });
        
        //Action when 'Logout' is pressed
        navView.getLogoutButton().setOnAction((ActionEvent event) -> {
            switchToAuthView();
        });
    }
    
    //Removes AuthUI, Clears Credential/Error Fields, Shows NavUI
    private void switchToNavView() {
        mainView.getChildren().remove(authView);
        authView.getAuthenticateLabel().setText("");
        authView.getUsernameField().setText("");
        authView.getPasswordField().setText("");
        mainView.getChildren().add(navView);
    }
    
    //Removes NavUI & Shows AuthUI
    private void switchToAuthView() {
        mainView.getChildren().remove(navView);
        mainView.getChildren().add(authView);
    }
}
