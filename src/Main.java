import Controllers.TaskController;
import Objects.Task;

import java.util.Date;

/**
 * Created by NMSL-YingYi on 2016/10/13.
 */
public class Main {
        public static void main(String[] args) {
                while (true) {
                        Task task = TaskController.getInstance().getNextExecuteTask();
                        System.out.println(task.toString());
                        task.setNextExecuteTime(getNextExecuteTime() + new Date(10));
                }
        }
}
