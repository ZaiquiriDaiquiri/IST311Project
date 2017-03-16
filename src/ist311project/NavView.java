
package ist311project;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NavView extends JPanel{
    
    private NavModel navModel;
    
    private JButton newTaskButton;
    private JButton viewTaskButton;
    private JButton newContactButton;
    private JButton viewContactButton;
    private JButton loadButton;
    private JButton saveButton;
        
    NavView(NavModel model) {
        
        this.navModel = model;
        
        newTaskButton = new JButton("New Task");
        viewTaskButton = new JButton("View Tasks");
        newContactButton = new JButton("New Contact");
        viewContactButton = new JButton("View Contacts");
        loadButton = new JButton("Load Data");
        saveButton = new JButton("Save Data");
                        
        this.add(newTaskButton);
        this.add(viewTaskButton);
        this.add(newContactButton);
        this.add(viewContactButton);
        this.add(loadButton);
        this.add(saveButton);
        
    }
    
    public JButton getNewTaskButton() {
        return this.newTaskButton;
    }
    
    public JButton getViewTaskButton() {
        return this.viewTaskButton;
    }
    
    public JButton getNewContactButton() {
        return this.newContactButton;
    }
    
    public JButton getViewContactButton() {
        return this.viewContactButton;
    }
    
    public JButton getLoadButton() {
        return this.loadButton;
    }
    
    public JButton getSaveButton() {
        return this.saveButton;
    }
    
    public void addActionListener(ActionListener al) {
        this.newTaskButton.addActionListener(al);
        this.viewTaskButton.addActionListener(al);
        this.newContactButton.addActionListener(al);
        this.viewContactButton.addActionListener(al);
        this.loadButton.addActionListener(al);
        this.saveButton.addActionListener(al);
    }
    
}
