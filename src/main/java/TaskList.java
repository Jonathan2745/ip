import Errors.InputExceptions;
import java.util.ArrayList;

class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task getTask(int index) throws InputExceptions {
        if (index < 0 || index >= tasks.size()) {
            throw new InputExceptions.InvalidIndexException();
        }
        return tasks.get(index);
    }

    public ArrayList<Task> getListOfTasks() {
        return tasks;
    }

    public int size() {
        return tasks.size();
    }

    public void removeTask(int index) throws InputExceptions {
        if (index < 0 || index >= tasks.size()) {
            throw new InputExceptions.InvalidIndexException();
        }
        tasks.remove(index);
    }
}
