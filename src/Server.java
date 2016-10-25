import Controllers.TaskController;
import Controllers.UserController;
import Objects.Task;
import Objects.User;

import java.util.Date;

/**
 * Created by YingYi on 2016/10/24.
 */
public class Server {
    Date currentTime;
    TaskController taskController = TaskController.getInstance();
    UserController userController = UserController.getInstance();

    public void run() {
        while (true) {
            Task task = taskController.getNextExecuteTask();
            System.out.println(task.toString());
            currentTime = task.getNextExecuteTime();
            // check out of date task
            taskController.checkOutOfDateTask(currentTime);
            User worker = userController.findBestUser(task);
            worker.workOnTask(currentTime, task);
        }
    }
}
