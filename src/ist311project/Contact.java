
package ist311project;

import java.io.Serializable;

public class Contact implements Serializable{
    private String name;
    private String phone;
    private String email;
    private String address;
    private String contactType;

    Contact() {
        
    }
    
    Contact(String name, String phone, String email, String address, String contactType) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.contactType = contactType;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAddress() {
        return this.address;
    }

    public String getContactType() {
        return contactType;
    }

}
