public class ToDo extends Task {
        public ToDo(String description) {
            super(description);
            System.out.println("I have added this Todo: ");
            System.out.println(this);
        }
        @Override
        public String toString() {
            return "[T]" + getStatusIcon() + getDescription();
        }
    }

