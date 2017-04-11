
package ist311project;

public class Contact {
    private String name;
    private String phone;
    private String email;
    private String address;

    Contact(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public void printContact() {
        System.out.print("Name: ");
        System.out.println(this.name);
        System.out.print("Phone: ");
        System.out.println(this.phone);
        System.out.print("Email: ");
        System.out.println(this.email);
        System.out.print("Address: ");
        System.out.println(this.address);
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

}
