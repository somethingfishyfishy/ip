public class MarkCommand extends Command {
    private final int index;
    public MarkCommand(int i) {
        this.index = i;
    }

    void execute(TaskList taskList, Ui ui, Storage storage) {
        if (this.index > taskList.size()) {
            System.out.println("index out of range");
            return;
        }
        Task t = taskList.getTask(this.index).markAsDone();
        System.out.println("I've marked as done:\n" + t);
    }
}
