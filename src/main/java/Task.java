public class Task {
    protected String description;
    protected boolean isDone;


    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() { //for tasks
        return (isDone ? "[X]" : "[ ]");
    }

    public void mark() {
        if (isDone == false) {
            isDone = true;
            System.out.println("Nice! I've marked this task as done:");
            displayTaskMark();
        } else {
            System.out.println("Haha nice going... This task is already done, bozo!");
        }

    }

    public void unmark() {
        if (isDone == true) {
            isDone = false;
            System.out.println("OK, I've marked this task as not done yet:");
            displayTaskMark();
        } else {
            System.out.println("Hey... this task was never done in the first place!");
        }

    }
    public String displayTask() { //for listing out tasks
        return "hey"; //what do i do here? maybe an exception? need to check if the try exception
        // is even corerect

    }

    public void addedTask() { //display message for added tasks!
    }

    public void displayTaskMark() {
    }



}
