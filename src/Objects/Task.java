package Objects;

import java.util.Date;

/**
 * Created by NMSL-YingYi on 2016/10/13.
 */
public class Task {
    private long id;
    private Date startTime;
    private Date endTime;
    private Date nextExecuteTime;

    public Task(long id, Date start, Date end) {
        this.id = id;
        this.startTime = start;
        this.endTime = end;
        this.nextExecuteTime = start;
    }

    public int compareNextExcuteTime(Task t) {
        return this.getNextExecuteTime().compareTo(t.getNextExecuteTime());
    }

    public String toString() {
        return "Task id:" + id;
    }

    public Date getNextExecuteTime() {
        return this.nextExecuteTime;
    }

    public void setNextExecuteTime(Date d) {
        this.nextExecuteTime = d;
    }

}
