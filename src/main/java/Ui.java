
class UI {

    public void showWelcome() {
        System.out.println("____________________________________________________________");
        ASCII_Art.printArt();
        System.out.println(" Hello! I'm BobChungus ");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    public void showGoodbye() {
        System.out.println("____________________________________________________________");
        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }

    public void showList() {
        System.out.println("____________________________________________________________");
        System.out.println(" Here are the tasks in your list:");
    }

    public void deletedTask(int deleteIndex){
        System.out.println("____________________________________________________________");
        System.out.println("Okay, deleted Task " + (deleteIndex + 1));
        System.out.println("____________________________________________________________");
    }

    public void markedTask(int markIndex){
        System.out.println("____________________________________________________________");
        System.out.println("Okay, marked Task " + (markIndex + 1));
        System.out.println("____________________________________________________________");
    }

    public void unmarkedTask(int unmarkIndex){
        System.out.println("____________________________________________________________");
        System.out.println("Okay, unmarked Task " + (unmarkIndex + 1));
        System.out.println("____________________________________________________________");
    }

    public void printLine() {
        System.out.println("____________________________________________________________");
    }

}
