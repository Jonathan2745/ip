import Errors.InputExceptions;

 class Parser {
    public static void parseCommand(String input, TaskList taskList, Storage storage, UI ui) throws InputExceptions {
        String[] inputParts = input.split(" ", 2);
        String command = inputParts[0].toLowerCase();
        String arguments = (inputParts.length > 1) ? inputParts[1] : "";

        switch (command) {
            case "bye":
                ui.showGoodbye();
                storage.saveTasks(taskList.getTasks());
                System.exit(0);
                break;
            case "list":
                ui.showList();
                if (taskList.size() == 0) {
                    System.out.println("No tasks added yet.");
                } else {
                    for (int i = 0; i < taskList.size(); i++) {
                        System.out.println((i + 1) + ". " + taskList.getTask(i));
                    }
                }
                ui.printLine();
                break;

            case "todo":
                if (arguments.isEmpty()) {
                    throw new InputExceptions.MissingTodoArgumentException("todo");
                }
                taskList.addTask(new ToDo(arguments));
                break;

            case "deadline":
                String[] parts = arguments.split(" /by ", 2);
                if (parts.length < 2) throw new InputExceptions.MissingDeadlineArgumentException("deadline");
                taskList.addTask(new Deadline(parts[0], parts[1]));
                break;

            case "event":
                String[] eventParts = arguments.split(" /from ", 2);
                if (eventParts.length < 2) {
                    throw new InputExceptions.MissingEventArgumentException("event");
                }
                String[] timeParts = eventParts[1].split(" /to ", 2);

                if (timeParts.length < 2) {
                    throw new InputExceptions.MissingEventArgumentException("event");
                }
                taskList.addTask(new Event(eventParts[0], timeParts[0], timeParts[1]));
                break;

            case "delete":
                int deleteIndex = Integer.parseInt(arguments) - 1;
                taskList.removeTask(deleteIndex);
                break;
            default:
                throw new InputExceptions.InvalidCommandException();
        }
    }
}