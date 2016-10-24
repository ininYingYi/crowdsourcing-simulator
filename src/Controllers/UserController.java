package Controllers;

import Objects.User;

import java.util.ArrayList;

/**
 * Created by NMSL-YingYi on 2016/10/13.
 */
public class UserController {
    private static UserController self = null;
    public static UserController getInstance() {
        if (self == null) self =new UserController();
        return self;
    }

    private ArrayList<User> users = new ArrayList<User>();
}
