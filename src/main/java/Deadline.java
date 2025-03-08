
class Deadline extends Task {
    private final String deadlineBy;
    public Deadline(String description, String deadlineBy) {
        super(description);
        this.deadlineBy = deadlineBy;
        System.out.println("I have added this deadline: ");
        System.out.println(this);
    }

    public String getDeadlineBy() {
        return deadlineBy;
    }

    @Override
    public String toString() {
        return "[D]" + getStatusIcon() + getDescription() + " (by: " + deadlineBy + ")";
    }
}
