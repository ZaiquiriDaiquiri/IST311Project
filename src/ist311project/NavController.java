
package ist311project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class NavController {
    private NavModel navModel;
    private NavView navView;
    
    NavController(NavModel model, NavView view) {
        this.navModel = model;
        this.navView = view;
        
        //Task Creation Event Handlers
        //Action when 'Create Task' is pressed
        navView.getNewTaskButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Opens the creation dialog
                navView.getNewTaskView().show();
            }
        });
        
            //Action when 'All Day' is checked
            navView.getNewTaskView().getAllDayCheckBox().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //Disables other date/datetime field
                    navView.getNewTaskView().getDateTimeField().setDisable(navView.getNewTaskView().getAllDayCheckBox().isSelected());
                    navView.getNewTaskView().getDateField().setDisable(!navView.getNewTaskView().getAllDayCheckBox().isSelected());
                }
            });
            //Action when 'Create' is pressed
            navView.getNewTaskView().getCreateButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //TASK CREATION
                    navView.createTask(navView.getNewTaskView(), navModel.getTempTaskArray());
                    navView.getTaskPane().getChildren().add(new Label("Task"));
                }
            });
            //Action when 'Cancel' is pressed
            navView.getNewTaskView().getCancelButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //Closes the creation dialog
                    navView.getNewTaskView().close();
                }
            });
        
        //Contact Creation Event Handlers
        //Action when 'Create Contact' is pressed
        navView.getNewContactButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Opens the creation dialog
                navView.getNewContactView().show();
            }
        });
        
            //Action when 'Contact Type' is changed
            navView.getNewContactView().getContactTypeComboBox().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(navView.getNewContactView().getContactTypeComboBox().equals("Professional")) {
                        //Disables non-professional fields
                        navView.getNewContactView().getNicknameField().setDisable(true);
                    } else if(navView.getNewContactView().getContactTypeComboBox().equals("Professional")) {
                        //Disables non-personal fields
                        navView.getNewContactView().getCompField().setDisable(true);
                        navView.getNewContactView().getCompTitleField().setDisable(true);
                    } else {}
                }
            });
            //Action when 'Create' is pressed
            navView.getNewContactView().getCreateButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //CONTACT CREATION
                }
            });
            //Action when 'Cancel' is pressed
            navView.getNewContactView().getCancelButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //Closes the creation dialog
                    navView.getNewContactView().close();
                }
            });
    }
}
