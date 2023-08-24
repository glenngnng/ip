import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;
public class Gman {
    public static String userInput;
    public static Task taskList[] = new Task[100];
    //public static ArrayList<Task> taskList = new ArrayList<>();
    public static void main(String[] args) throws GmanIncorrectKeywordException {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Hello! I'm Gman! \nWhat can I do for you?");
        String exitWord = "bye";
        userInput = myScanner.nextLine();
        //String keyword = userInput.split(" ")[0];

        int counter = 0;
        //possible exceptions: nothing is given after keyword,
        //list when there is nothing
        //marked unmarked something that is already marked unmarked
        //
        while (!userInput.equals(exitWord) && counter < 100) {
            if (userInput.equals("list") && counter != 0) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < counter; i++) {
                    (taskList[i]).displayTask();
                }
            } else if (userInput.contains("unmark") && counter != 0) {
                String words[] = userInput.split(" ");
                int number = Integer.valueOf(words[1]) - 1;
                taskList[number].unmark();
            } else if (userInput.contains("mark") && counter != 0) {
                String words[] = userInput.split(" ");
                int number = Integer.valueOf(words[1]) - 1;
                taskList[number].mark();
            } else if (userInput.contains("todo")) {
                //String words[] = userInput.split(" ");
                try {
                    if (userInput.substring(4).isEmpty()) {
                        throw new GmanEmptyException("OOOOPS! The description of a todo cannot be empty!");
                    }
                    taskList[counter] = new Todo(userInput.substring(4), counter + 1);
                    taskList[counter].addedTask();
                    counter++;
                } catch (GmanEmptyException e) {
                    System.out.println(e.getMessage());
                }
            } else if (userInput.contains("deadline")) {
                String words[] = userInput.substring(8).split("/");
                taskList[counter] = new Deadline(words[0], counter + 1, words[1].substring(3));
                taskList[counter].addedTask();
                counter++;
            } else if (userInput.contains("event")) {
                String words[] = userInput.substring(5).split("/");
                taskList[counter] = new Event(words[0], counter + 1,
                        words[1].substring(5), words[2].substring(3));
                taskList[counter].addedTask();
                counter++;
            }
            else {
                /*taskList[counter] = new GenericTask( " " + userInput, counter + 1);
                taskList[counter].addedTask();
                counter++;*/
                try {
                    throw new GmanIncorrectKeywordException("OOPS! I'm sorry, I don't know what that means! Please start " +
                            "with keywords: todo, deadline, or event!");
                } catch (GmanIncorrectKeywordException e) {
                    System.out.println(e.getMessage());
                }
            }
            userInput = myScanner.nextLine();
        }
        System.out.println("    Bye. Hope to see you again soon!");
    }
}