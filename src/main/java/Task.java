/**
 * Represents a task with a description and completion status.
 */
public class Task {
    private final String description;
    protected boolean isDone;

    /**
     * Constructs a new task with the given description.
     * By default, the task is not done.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Constructs a new task with the given completion status and description.
     *
     * @param isDone The completion status of the task.
     * @param description The description of the task.
     */
    public Task(boolean isDone, String description) {
        this.isDone = isDone;
        this.description = description;
    }


    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        isDone = true;
    }


    /**
     * Marks the task as not done.
     */
    public void markAsNotDone() {
        isDone = false;
    }

    /**
     * Returns the status icon representing whether the task is done.
     *
     * @return "[X] " if the task is done, "[ ] " otherwise.
     */
    public String getStatusIcon() {
        return (isDone ? "[X] " : "[ ] ");
    }

    /**
     * Returns the completion status of the task as a string.
     *
     * @return "done" if the task is completed, "not done" otherwise.
     */
    public String getDoneStatus() {
        return (isDone ? "done" : "not done");
    }

    /**
     * Returns the description of the task.
     *
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

}

