
package ist311project;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame{
    
    private Model model;
    private final JPanel mPanel = new JPanel();
    
    View(Model model) {
        
        this.setContentPane(mPanel);
        this.setSize(800, 600);
        this.setTitle("IST 311 Program");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
    }
    
}
