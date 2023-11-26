package LogIn;

import java.util.Date;

public class Customer {
    private static Customer instance;
    String username;
    String first_name;
    String last_name;
    String suffix;
    int age;
    Date birth_date;

    private Customer() {}

    public static Customer getInstance() {
        if (instance == null) {
            instance = new Customer();
        }
        return instance;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return this.last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return this.birth_date;
    }

    public void setBirthDate(Date birth_date) {
        this.birth_date = birth_date;
    }

    public void clear() {
        this.username = null;
        this.first_name = null;
        this.last_name = null;
        this.suffix = null;
        this.age = 0;
        this.birth_date = null;
    }
}
