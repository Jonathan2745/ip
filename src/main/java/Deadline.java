
class Deadline extends Task {
    private final String by;
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        System.out.println("I have added this deadline: ");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "[D]" + getStatusIcon() + getDescription() + " (by: " + by + ")";
    }
}
