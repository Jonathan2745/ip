import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Deadline extends Task {
    private final LocalDate deadlineBy;
    private final DateTimeFormatter dateTimeOutputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Deadline(boolean isDone, String description, LocalDate deadlineBy) {
        super(description);
        this.isDone = isDone;
        this.deadlineBy = deadlineBy;
        System.out.println("I have added this deadline: ");
        System.out.println(this);
    }

    public String getDeadlineBy() {
        return deadlineBy.format(dateTimeOutputFormat);
    }

    @Override
    public String toString() {
        return "[D]" + getStatusIcon() + getDescription() + " (by: " + deadlineBy + ")";
    }
}
