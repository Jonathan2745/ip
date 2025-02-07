class Event extends Task {
    private final String from;
    private final String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
        System.out.println("I have added this event: ");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "[E]" + getStatusIcon() + getDescription() + " (from: " + from + " to: " + to + ")";
    }
}
