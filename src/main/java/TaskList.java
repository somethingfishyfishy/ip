import java.util.ArrayList;

/** TaskList serves the purpose of where all the Task is being stored
 * @param tasks - there are previous tasks stored in ./data and is retreived.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    void addTask(Task task) {
        this.tasks.add(task);
    }

    /** Create String object for storing back into file in Storage class */
    public String getTaskCommands() {
        String s = "";
        for (Task t : this.tasks) {
            s += t.getOriginalCommand() + "\n";
        }
        return s;
    }

    int size() {
        return this.tasks.size();
    }
}
