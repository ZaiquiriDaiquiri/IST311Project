
package ist311project;

public class IST311Project {

    public static void main(String[] args) {
        
        MainModel mModel = new MainModel();
        MainView mView = new MainView(mModel);
        MainController mController = new MainController(mModel, mView);
        
        mView.setVisible(true);
        
    }
    
}
