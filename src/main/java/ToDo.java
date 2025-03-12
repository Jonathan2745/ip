/**
 * The ToDo class represents a simple task without a specific deadline or event period.
 */
public class ToDo extends Task {
    /**
     * Constructs a ToDo task with a description and completion status.
     *
     * @param isDone The completion status of the task.
     * @param description The description of the task.
     */
    public ToDo(boolean isDone, String description) {
        super(description);
        this.isDone = isDone;
        System.out.println("I have added this Todo: ");
        System.out.println(this);
    }

    /**
     * Returns a string representation of the ToDo task.
     *
     * @return The formatted string representation of the task.
     */
    @Override
    public String toString() {
        return "[T]" + getStatusIcon() + getDescription();
    }
    }

