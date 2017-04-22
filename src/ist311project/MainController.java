package ist311project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
            if (authController.isAuthenticated()) {
                switchToNavView();
            } else {
            }
        });

        //Action when 'Save' is pressed
        navView.getSaveButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    FileOutputStream fileOut = new FileOutputStream("src/ist311project/" + authModel.getCurrentUser() + "_tasks.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    
                    out.writeObject(navModel.getTempTaskArray());
                    
                    out.close();
                    fileOut.close();
                } catch (IOException i)
                {
                    i.printStackTrace();
                }
                
                try {
                    FileOutputStream fileOut = new FileOutputStream("src/ist311project/" + authModel.getCurrentUser() + "_contacts.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    
                    out.writeObject(navModel.getTempContactArray());
                    
                    out.close();
                    fileOut.close();
                } catch (IOException i)
                {
                    i.printStackTrace();
                }

            }
        });

        //Action when 'Load' is pressed
        navView.getLoadButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                try
                {
                    FileInputStream fileIn = new FileInputStream("src/ist311project/" + authModel.getCurrentUser() + "_tasks.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    
                    navModel.getTempTaskArray().clear();
                    
                    ArrayList<Task> newTaskArray = (ArrayList<Task>)in.readObject();
                    
                    
                    navModel.getTempTaskArray().addAll(newTaskArray);
                    
                    
                    in.close();
                    fileIn.close();
                } catch (IOException i)
                {
                    i.printStackTrace();
                    return;
                } catch (ClassNotFoundException c)
                {
                    System.out.println("Error");
                    c.printStackTrace();
                    return;
                }
                
                try
                {
                    FileInputStream fileIn = new FileInputStream("src/ist311project/" + authModel.getCurrentUser() + "_contacts.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    
                    navModel.getTempContactArray().clear();
                    
                    ArrayList<Contact> newContactArray = (ArrayList<Contact>)in.readObject();
                    
                    
                    navModel.getTempContactArray().addAll(newContactArray);
                    
                    
                    in.close();
                    fileIn.close();
                } catch (IOException i)
                {
                    i.printStackTrace();
                    return;
                } catch (ClassNotFoundException c)
                {
                    System.out.println("Error");
                    c.printStackTrace();
                    return;
                }

                navController.clearTasks();
                navController.displayTasks(navModel.getTempTaskArray());
                navController.clearContacts();
                navController.displayContacts(navModel.getTempContactArray());
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
        authModel.setCurrentUser(authView.getUsernameField().getText());
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
