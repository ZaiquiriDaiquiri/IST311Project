
package ist311project;

import java.util.HashMap;

public class AuthModel {
    private HashMap<String, String> userInfo;
    String currentUser;

    AuthModel() {
        userInfo = new HashMap<>();
        userInfo.put("user1", "pass");
        userInfo.put("user2", "pass");
    }
    
    protected HashMap<String, String> getUserInfo() {
        return this.userInfo;
    }
}
