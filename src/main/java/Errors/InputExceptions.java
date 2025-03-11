package Errors;

public class InputExceptions extends Exception {
    public InputExceptions(String message) {
        super(message);
    }

    public static class MissingTodoArgumentException extends InputExceptions {
        public MissingTodoArgumentException(String command) {
            super(command + " must have arguments." + "\n" +
                    "Please use: \"todo\"  \"task\" instead");
        }
    }

    public static class MissingDeadlineArgumentException extends InputExceptions {
        public MissingDeadlineArgumentException(String command) {
            super(command + " must have arguments." + "\n" +
                    "Please use: \"deadline\" \"task\" /by \"deadline\" instead");
        }
    }

    public static class MissingEventArgumentException extends InputExceptions {
        public MissingEventArgumentException(String command) {
            super(command + " must have arguments." + "\n" +
                    "Please use: \"event\" \"task\" /from \"eventfrom\" /to \"eventto\" instead");
        }
    }

    public static class MissingFindArgumentException extends InputExceptions {
        public MissingFindArgumentException(String command) {
            super(command + " must contain 1 argument." + "\n" +
                    "Please use: \"find\" \"description\" instead");
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

    public static class InvalidDateFormatException extends InputExceptions {
        public InvalidDateFormatException() {
            super("Invalid date format. Please use dd-MM-yyyy.");
        }
    }

}