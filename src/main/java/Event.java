class Event extends Task {
    private final String eventFrom;
    private final String eventTo;

    public Event(String description, String eventFrom, String eventTo) {
        super(description);
        this.eventFrom = eventFrom;
        this.eventTo = eventTo;
        System.out.println("I have added this event: ");
        System.out.println(this);
    }

    public String getEventFrom() {
        return eventFrom;
    }

    public String getEventTo() {
        return eventTo;
    }

    @Override
    public String toString() {
        return "[E]" + getStatusIcon() + getDescription() + " (from: " + eventFrom + " to: " + eventTo + ")";
    }
}
