package findr.projectfindr.response;

public class UserResponse {

    private String name;

    private String email;

    private String phoneContact;

    private String country;

    private String state;

    private String city;

    public UserResponse(String name, String email, String phoneContact, String country, String state, String city) {
        this.name = name;
        this.email = email;
        this.phoneContact = phoneContact;
        this.country = country;
        this.state = state;
        this.city = city;
    }

    public UserResponse() {

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneContact() {
        return phoneContact;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}
