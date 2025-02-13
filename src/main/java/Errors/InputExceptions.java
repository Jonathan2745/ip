package Errors;

public class InputExceptions extends Exception {
    public InputExceptions(String message) {
        super(message);
    }

    public static class MissingArgumentException extends InputExceptions {
        public MissingArgumentException(String command) {
            super(command + " must have arguments.");
        }
    }

    public static class InvalidIndexException extends InputExceptions {
        public InvalidIndexException() {
            super("Invalid task number.");
        }
    }

    public static class InvalidCommandException extends InputExceptions {
        public InvalidCommandException() {
            super("Invalid command. Please try again.");
        }
    }

    public static class NumberFormatException extends InputExceptions {
        public NumberFormatException() {
            super("Error: Please enter a valid number.");
        }
    }
}