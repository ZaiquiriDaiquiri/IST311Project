
package ist311project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
        
        navView.getSaveButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BufferedWriter bw = null;
                FileWriter fw = null;

                try {
                    fw = new FileWriter(authModel.currentUser + "_tasks.txt");
                    bw = new BufferedWriter(fw);
                    bw.write(navModel.getTempTaskArray().toString());

                    System.out.println("Done");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (bw != null) {
                            bw.close();
                        }
                        if (fw != null) {
                            fw.close();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                
                try {
                    fw = new FileWriter(authModel.currentUser + "_contacts.txt");
                    bw = new BufferedWriter(fw);
                    bw.write(navModel.getTempContactArray().toString());

                    System.out.println("Done");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (bw != null) {
                            bw.close();
                        }
                        if (fw != null) {
                            fw.close();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        //Action when 'Logout' is pressed
        navView.getLogoutButton().setOnAction((ActionEvent event) -> {
            switchToAuthView();
            navController.clearContacts();
            navController.clearTasks();
            navModel.getTempTaskArray().clear();
            navModel.getTempContactArray().clear();
        });
    }
    
    //Removes AuthUI, Clears Credential/Error Fields, Shows NavUI
    private void switchToNavView() {
        mainView.getChildren().remove(authView);
        authView.getAuthenticateLabel().setText("");
        authModel.currentUser = authView.getUsernameField().getText();
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
