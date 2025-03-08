package Errors;

import java.util.Objects;

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
                    "Please use: \"deadline\" \"task\" /by \"deadline\" indead");
        }
    }

    public static class MissingEventArgumentException extends InputExceptions {
        public MissingEventArgumentException(String command) {
            super(command + " must have arguments." + "\n" +
                    "Please use: \"event\" \"task\" /from \"eventfrom\" /to \"eventto\" instead");
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


}