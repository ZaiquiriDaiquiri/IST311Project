
package ist311project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IST311Project extends Application {
    @Override
    public void start(Stage mainStage) {
        mainStage.setTitle("IST311 Project");
        
        //Main MVC
        MainModel mainModel = new MainModel();
        MainView mainView = new MainView(mainModel);
        MainController mainController = new MainController(mainModel, mainView);
        
        //Stage > Scene > View(Pane) Setup
        Scene mainScene = new Scene(mainView, 700, 400);
        mainView.prefWidthProperty().bind(mainScene.widthProperty());
        mainView.prefHeightProperty().bind(mainScene.heightProperty());
        mainStage.setScene(mainScene);
        mainStage.show();
        mainStage.setResizable(true);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
