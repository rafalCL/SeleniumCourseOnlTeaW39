package pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern;

public class UserData {
    private String firstName;
    private String lastName;
    private String password;

// builder pattern / wzorzec budowniczego

    public String getFirstName() {
        return firstName;
    }

    public UserData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserData setPassword(String password) {
        this.password = password;
        return this;
    }
}
