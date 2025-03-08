import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Event extends Task {
    private final LocalDate eventFrom;
    private final LocalDate eventTo;
    private final DateTimeFormatter dateTimeOutputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public Event(boolean isDone, String description, LocalDate eventFrom, LocalDate eventTo) {
        super(description);
        this.isDone = isDone;
        this.eventFrom = eventFrom;
        this.eventTo = eventTo;
        System.out.println("I have added this event: ");
        System.out.println(this);
    }

    public String getEventFrom() {
        return eventFrom.format(dateTimeOutputFormat);
    }

    public String getEventTo() {
        return eventTo.format(dateTimeOutputFormat);
    }

    @Override
    public String toString() {
        return "[E]" + getStatusIcon() + getDescription() + " (from: " + eventFrom + " to: " + eventTo + ")";
    }
}
