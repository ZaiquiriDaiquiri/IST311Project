
package ist311project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class MainController {
    
    private MainModel mModel;
    private MainView mView;
    
    private AuthView authView;
    private AuthModel authModel;
    private AuthController authController;
    private NavModel navModel;
    private NavView navView;
    private NavController navController;
    
    String[] userArray = new String[3];
    
    MainController(MainModel model, MainView view) {

        this.mModel = model;
        this.mView = view;
        
        authModel = new AuthModel();
        authView = new AuthView(authModel);
        authController = new AuthController(authModel, authView);
        navModel = new NavModel();
        navView = new NavView(navModel);
        navController = new NavController(navModel, navView);
        
        userArray[0] = "User1";
        userArray[1] = "User2";
        userArray[2] = "User3";
        
        //Sets initial Content Pane to Authentication
        mView.getContentPane().add(authView);
        
        //ActionListener inner class
        class actionListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                JButton clickSource = (JButton)e.getSource();
                
                //'Authenticate' button source
                if(clickSource == authView.getAuthenticateButton()) {
                    //Credential Check - [True] Content Pane is switched from Authentication to Navigation / [False] Display 'Invalid Credentials'
                    if(authView.getUsernameField().getText().equals(userArray[0]) || authView.getUsernameField().getText().equals(userArray[0]) || authView.getUsernameField().getText().equals(userArray[0]) ) {
                        mView.getContentPane().removeAll();
                        mView.getContentPane().add(navView);
                        mView.revalidate();
                        mView.repaint();
                    } else {
                        authView.getAuthenticateLabel().setText("Invalid Credentials");
                    }
                } else {}
                
            }
        }
        
        //Adds ActionListener to 'Authenticate' button
        authView.addActionListener(new actionListener());
        
    }

}
