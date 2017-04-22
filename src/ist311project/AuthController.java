package ist311project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class AuthController {

    //Authorization MVC

    private AuthModel authModel;
    private AuthView authView;

    AuthController(AuthModel model, AuthView view) {
        //Authorization MVC
        this.authModel = model;
        this.authView = view;

        loadAccountFile();

        //USER CREATION
        //When 'New User' is pressed
        authView.getNewUserButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showNewUserView();
            }
        });

        //When 'Create' is pressed
        authView.getNewUserView().getCreateButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (isValid()) {
                    createUser();
                    updateAccountFile();
                    closeNewUserView();
                } else {
                }
            }
        });

        //When 'Cancel' is pressed
        authView.getNewUserView().getCancelButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                closeNewUserView();
            }
        });
    }

    public boolean isAuthenticated() {
        String inputUsername = getInputUsername();
        String inputPassword = getInputPassword();

        if (isValidUsername(inputUsername)) {
            if (isValidPassword(inputUsername, inputPassword)) {
                return true;
            } else {
                showAuthError();
                return false;
            }
        } else {
            showAuthError();
            return false;
        }
    }

    private boolean isValidUsername(String username) {
        return authModel.getUserInfo().containsKey(username);
    }

    private boolean isValidPassword(String username, String password) {
        return password.equals(authModel.getUserInfo().get(username));
    }

    private void showAuthError() {
        authView.getAuthenticateLabel().setText("Invalid Credentials!");
    }

    //Validates new user fields and creates an account if they are valid
    public boolean isValid() {
        Label errorLabel = getNewErrorLabel();
        String username = getNewUsername();
        String password = getNewPassword();
        String confirmPassword = getNewConfirm();

        if (username.equals("")) {
            errorLabel.setText("Please enter a username!");
            return false;
        } else if (authModel.getUserInfo().containsKey(username)) {
            errorLabel.setText("Username already taken!");
            return false;
        } else {
            if (password.equals("")) {
                errorLabel.setText("Please enter a password!");
                return false;
            } else if (confirmPassword.equals("") || !confirmPassword.equals(password)) {
                errorLabel.setText("Passwords do not match!");
                return false;
            } else {
                return true;
            }
        }
    }

    private void createUser() {
        String username = getNewUsername();
        String password = getNewPassword();

        authModel.getUserInfo().put(username, password);
    }

    //Get() Methods
    private String getInputUsername() {
        return authView.getUsernameField().getText();
    }

    private String getInputPassword() {
        return authView.getPasswordField().getText();
    }

    private Label getNewErrorLabel() {
        return authView.getNewUserView().getNewUserLabel();
    }

    private String getNewUsername() {
        return authView.getNewUserView().getUsernameField().getText();
    }

    private String getNewPassword() {
        return authView.getNewUserView().getPasswordField().getText();
    }

    private String getNewConfirm() {
        return authView.getNewUserView().getConfirmField().getText();
    }

    public void showNewUserView() {
        authView.getNewUserView().resetFields();
        authView.getNewUserView().show();
    }

    public void closeNewUserView() {
        authView.getNewUserView().close();
    }

    public void loadAccountFile() {

        authModel.getUserInfo().clear();

        final String ACCOUNTFILENAME = "src/ist311project/user_accounts.txt";

        File file = new File(ACCOUNTFILENAME);

        try {
            if (!file.exists()) {
                System.out.println("file does not exist");
            }

            FileReader inputFile = new FileReader(file);
            BufferedReader bufferReader = new BufferedReader(inputFile);

            String line;

            while ((line = bufferReader.readLine()) != null) {
                String[] split = line.split(",");
                authModel.getUserInfo().put(split[0], split[1]);
            }

            bufferReader.close();
            inputFile.close();

        } catch (Exception e) {
            System.out.println("Error loading user accounts - " + e.getMessage());
        }
    }

    private void updateAccountFile() {
        final String ACCOUNTFILENAME = "src/ist311project/user_accounts.txt";

        String username = getNewUsername();
        String password = getNewPassword();

        String accountString = "\n" + username + "," + password;

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            File accountFile = new File(ACCOUNTFILENAME);

            if (!accountFile.exists()) {
                accountFile.createNewFile();
            }

            fw = new FileWriter(accountFile.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);

            bw.write(accountString);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
