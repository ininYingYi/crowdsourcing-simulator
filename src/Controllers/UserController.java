package Controllers;

import Objects.Task;
import Objects.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

/**
 * Created by NMSL-YingYi on 2016/10/13.
 */
public class UserController {
    private static UserController self = null;
    public static UserController getInstance() {
        if (self == null) self =new UserController();
        return self;
    }
    private ArrayList<User> users = new ArrayList<>();
    private TreeMap<Double, User> selectRank = new TreeMap<>();

    public User findBestUser(Task task) {
        selectRank = new TreeMap<>();
        for (User user : users) {
            double rank = user.getRankOfWorkingTask(task);
            selectRank.put(rank, user);
        }
        return selectRank.firstEntry().getValue();
    }

    public void updateUserState(Date date) {
        for (User user : users) {
            user.updateState(date);
        }
    }

}
