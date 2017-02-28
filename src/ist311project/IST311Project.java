
package ist311project;

public class IST311Project {

    public static void main(String[] args) {
        
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
        
        view.setVisible(true);
        
    }
    
}
