/**
 * Handles user interface interactions by displaying messages and formatting output.
 */
class UI {

    /**
     * Displays the welcome message along with ASCII art of BobChungus.
     */
    public void showWelcome() {
        System.out.println("____________________________________________________________");
        ASCII_Art.printArt();
        System.out.println(" Hello! I'm BobChungus ");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays the goodbye message when exiting the program.
     */
    public void showGoodbye() {
        System.out.println("____________________________________________________________");
        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a header for the task list output.
     */
    public void showList() {
        System.out.println("____________________________________________________________");
        System.out.println(" Here are the tasks in your list:");
    }

    /**
     * Displays a message indicating a task has been deleted.
     *
     * @param deleteIndex The index of the task that was deleted.
     */
    public void deletedTask(int deleteIndex){
        System.out.println("____________________________________________________________");
        System.out.println("Okay, deleted Task " + (deleteIndex + 1));
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a message indicating a task has been marked as completed.
     *
     * @param markIndex The index of the task that was marked as done.
     */
    public void markedTask(int markIndex){
        System.out.println("____________________________________________________________");
        System.out.println("Okay, marked Task " + (markIndex + 1));
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a message indicating a task has been unmarked as completed.
     *
     * @param unmarkIndex The index of the task that was unmarked.
     */
    public void unmarkedTask(int unmarkIndex){
        System.out.println("____________________________________________________________");
        System.out.println("Okay, unmarked Task " + (unmarkIndex + 1));
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a message indicating that a search for tasks has begun.
     */
    public void printFindingTask(){
        System.out.println("____________________________________________________________");
        System.out.println("Here are the matching tasks in your list:");
    }

    /**
     * Displays a message when no matching tasks are found during a search.
     */
    public void printNoTaskFound(){
        printLine();
        System.out.println("No task with matching keyword found");
    }

    /**
     * Displays a found task from a search result.
     *
     * @param position The position of the task in the list.
     * @param task The task object that was found.
     */
    public void printFoundTask(int position, Task task){
        printLine();
        System.out.println( position + "." + " " + task.toString() );
    }

    /**
     * Prints a horizontal line for formatting output.
     */
    public void printLine() {
        System.out.println("____________________________________________________________");
    }

}
