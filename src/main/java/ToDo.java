public class ToDo extends Task {
        public ToDo(boolean isDone, String description) {
            super(description);
            this.isDone = isDone;
            System.out.println("I have added this Todo: ");
            System.out.println(this);
        }
        @Override
        public String toString() {
            return "[T]" + getStatusIcon() + getDescription();
        }
    }

