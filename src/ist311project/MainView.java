
package ist311project;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView extends JFrame{
    
    private MainModel mModel;
    
    MainView(MainModel model) {
        
        this.mModel = model;
        
        this.setSize(700, 400);
        this.setTitle("IST 311 Program");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
    }
    
}
