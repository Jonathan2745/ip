import Errors.InputExceptions;
import java.util.ArrayList;

/**
 * The TaskList class manages a collection of tasks.
 * It provides methods to add, retrieve, remove, and get the size of the task list.
 */
class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * Constructs a TaskList with an existing list of tasks.
     *
     * @param tasks The list of tasks to manage.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a new task to the list.
     *
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Retrieves a task at a specific index.
     *
     * @param index The index of the task.
     * @return The task at the specified index.
     * @throws InputExceptions If the index is out of bounds.
     */
    public Task getTask(int index) throws InputExceptions {
        if (index < 0 || index >= tasks.size()) {
            throw new InputExceptions.InvalidIndexException();
        }
        return tasks.get(index);
    }

    /**
     * Returns the list of all tasks.
     *
     * @return An ArrayList of tasks.
     */
    public ArrayList<Task> getListOfTasks() {
        return tasks;
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The size of the task list.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Removes a task at a specified index.
     *
     * @param index The index of the task to be removed.
     * @throws InputExceptions If the index is out of bounds.
     */
    public void removeTask(int index) throws InputExceptions {
        if (index < 0 || index >= tasks.size()) {
            throw new InputExceptions.InvalidIndexException();
        }
        tasks.remove(index);
    }
}
