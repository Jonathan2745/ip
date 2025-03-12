import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The Deadline class represents a task with a specific due date.
 */
class Deadline extends Task {
    private final LocalDate deadlineBy;
    private final DateTimeFormatter dateTimeOutputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Constructs a Deadline task with a description, completion status, and due date.
     *
     * @param isDone The completion status of the deadline task.
     * @param description The description of the task.
     * @param deadlineBy The due date of the task.
     */
    public Deadline(boolean isDone, String description, LocalDate deadlineBy) {
        super(description);
        this.isDone = isDone;
        this.deadlineBy = deadlineBy;
        System.out.println("I have added this deadline: ");
        System.out.println(this);
    }

    /**
     * Gets the formatted due date of the deadline task.
     *
     * @return The formatted due date.
     */
    public String getDeadlineBy() {
        return deadlineBy.format(dateTimeOutputFormat);
    }

    /**
     * Returns a string representation of the Deadline task.
     *
     * @return The formatted string representation of the deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + getStatusIcon() + getDescription() + " (by: " + deadlineBy + ")";
    }
}
