package Controllers;

import Objects.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by NMSL-YingYi on 2016/10/13.
 */
public class TaskController {
    public static TaskController self = null;
    public static TaskController getInstance() {
        if (self == null) self =new TaskController();
        return self;
    }

    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<Task> finishTasks = new ArrayList<>();

    public TaskController() {
        if (!loadTasks()) System.err.println("load task error");
    }

    public Task getNextExecuteTask() {
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task task1, Task task2)
            {
                return task1.compareNextExcuteTime(task2);
            }
        });
        return tasks.get(0);
    }

    public void checkOutOfDateTask(Date date) {
        for (Task task : tasks) {
            if (task.getEndDate().before(date)) {
                tasks.remove(task);
                finishTasks.add(task);
            }
        }
    }

    private boolean loadTasks() {
        tasks.add(new Task(1, new Date(2016, 10, 13, 11, 10, 0), new Date(2016, 10, 13, 12, 10, 0)));
        tasks.add(new Task(2, new Date(2016, 10, 13, 10, 10, 0), new Date(2016, 10, 13, 12, 10, 0)));

        return true;
    }
}
