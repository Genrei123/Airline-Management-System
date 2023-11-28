package LogIn;

import java.util.Date;

public class Admin {
    private static Admin instance;
    String username;
    private static Date login_date;

    private Admin() {

    }

    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin();
            login_date = new Date();
        }
        return instance;
    }

    public String getUsername() {
        return this.username;
    }

    public Date getLoginDate() {
        return login_date;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
