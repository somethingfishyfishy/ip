public class AddCommand extends Command {
    private final String action;
    private final String desc;

    public AddCommand(String action, String desc) {
        this.action = action;
        this.desc = desc.stripLeading();
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) {
        if (this.desc == "") {
            try {
                throw new EmptyDescException();
            } catch (EmptyDescException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        if (action.equals("todo")) {
            try {
                Task t = new ToDoTask(desc);
                taskList.addTask(t);
                System.out.println("added:\n" + t);
                System.out.println("You have " + taskList.size() + " tasks in list");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (action.equals("deadline")) {
            try {
                String[] arr = desc.split("/by");
                Task t;
                try {
                    t = new Deadline(arr[0].strip(), arr[1].strip());
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("missing /by");
                    return;
                }
                taskList.addTask(t);
                System.out.println("added:\n" + t);
                System.out.println("You have " + taskList.size() + " tasks in list");
            } catch (EmptyDescException e) {
                System.out.println(e);
            }
        } else if (action.equals("event")) {
            String[] arr = desc.split("/from");
            String[] arr2;
            try {
                arr2 = arr[1].split("/to");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("missing /from");
                return;
            }
            Task t = null;
            try {
                try {
                    t = new Event(arr[0].strip(), arr2[0].strip(), arr2[1].strip());
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("missing /to");
                    return;
                }
                taskList.addTask(t);
                System.out.println("added:\n" + t);
                System.out.println("You have " + taskList.size() + " tasks in list");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
