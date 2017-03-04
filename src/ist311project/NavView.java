
package ist311project;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NavView extends JPanel{
    
    private NavModel navModel;
    
    private JButton newTaskButton;
    private JButton viewTaskButton;
    private JButton newContactButton;
    private JButton viewContactButton;
    
    NavView(NavModel model) {
        
        this.navModel = model;
        
        newTaskButton = new JButton("New Task");
        viewTaskButton = new JButton("View Tasks");
        newContactButton = new JButton("New Contact");
        viewContactButton = new JButton("View Contacts");
        
        this.add(newTaskButton);
        this.add(viewTaskButton);
        this.add(newContactButton);
        this.add(viewContactButton);
        
    }
    
}
