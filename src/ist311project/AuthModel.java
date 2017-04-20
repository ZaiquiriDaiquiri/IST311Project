package ist311project;

import java.util.HashMap;

public class AuthModel {
    private HashMap<String, String> userInfo;
    private String currentUser;

    AuthModel() {
        userInfo = new HashMap<>();
        userInfo.put("user1", "pass");
        userInfo.put("user2", "pass");
    }
    
    protected HashMap<String, String> getUserInfo() {
        return this.userInfo;
    }

    public String getCurrentUser() {
        return currentUser;
    }
    
    public void setCurrentUser(String currUser) {
        this.currentUser = currUser;
    }
}
