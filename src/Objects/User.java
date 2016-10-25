package Objects;

import java.util.Date;

/**
 * Created by NMSL-YingYi on 2016/10/13.
 */
public class User {
    public enum State {
        FREE,
        WORKING
    }
    private Location currentLocation;
    private State state = State.FREE;
    private Date workingToDate;

    public void updateState(Date date) {
        if (date.before(workingToDate)) {
            state = State.FREE;
        }
    }

    public void workOnTask(Date currentDate, Task task) {
        state = State.WORKING;
        workingToDate = new Date(currentDate.getTime() + 10);
        task.setNextExecuteTime(workingToDate);
        task.updateState();
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public double getRankOfWorkingTask(Task task) {
        //TODO　Other select algorithm maybe implement in the future.
        return this.getCurrentLocation().distanceWith(task.getLocation());
    }
}
