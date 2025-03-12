import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The Event class represents a task with a start and end date.
 */
class Event extends Task {
    private final LocalDate eventFrom;
    private final LocalDate eventTo;
    private final DateTimeFormatter dateTimeOutputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Constructs an Event task with a description, completion status, start date, and end date.
     *
     * @param isDone The completion status of the event.
     * @param description The description of the event.
     * @param eventFrom The start date of the event.
     * @param eventTo The end date of the event.
     */
    public Event(boolean isDone, String description, LocalDate eventFrom, LocalDate eventTo) {
        super(description);
        this.isDone = isDone;
        this.eventFrom = eventFrom;
        this.eventTo = eventTo;
        System.out.println("I have added this event: ");
        System.out.println(this);
    }

    /**
     * Gets the formatted start date of the event.
     *
     * @return The formatted start date.
     */
    public String getEventFrom() {
        return eventFrom.format(dateTimeOutputFormat);
    }

    /**
     * Gets the formatted end date of the event.
     *
     * @return The formatted end date.
     */
    public String getEventTo() {
        return eventTo.format(dateTimeOutputFormat);
    }


    /**
     * Returns a string representation of the Event task.
     *
     * @return The formatted string representation of the event.
     */
    @Override
    public String toString() {
        return "[E]" + getStatusIcon() + getDescription() + " (from: " + eventFrom + " to: " + eventTo + ")";
    }
}
