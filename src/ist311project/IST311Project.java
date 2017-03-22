
package ist311project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IST311Project extends Application{

    @Override
    public void start(Stage mainStage) {
        mainStage.setTitle("IST311 Project");
        
        //Main MVC
        MainModel mainModel = new MainModel();
        MainView mainView = new MainView(mainModel);
        MainController mainController = new MainController(mainModel, mainView);
        
        Scene mainScene = new Scene(mainView, 700, 400);
        mainStage.setScene(mainScene);
        mainStage.show();
        mainStage.setResizable(false);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
