
package ist311project;

import java.util.HashMap;

public class AuthModel {

    private HashMap<String, String> userInfo;

    AuthModel() {
        userInfo = new HashMap<>();
        userInfo.put("User", "password");
    }
    
    public HashMap<String, String> getUserInfo() {
        return this.userInfo;
    }
    
}
