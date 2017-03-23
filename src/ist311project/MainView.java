
package ist311project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;

public class MainView extends FlowPane{
    private MainModel mainModel;
    
    MainView(MainModel model) {
        this.mainModel = model;
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(10, 10, 10, 10));
    }
}
