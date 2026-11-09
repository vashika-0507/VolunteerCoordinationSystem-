public class VolunteerSystem {
    Linkedlist volunteerList = new Linkedlist();
    Queue waitingQueue = new Queue();
    Stack undoStack = new Stack();
    public void registerVolunteer(int id, String name, String priority) {
        if (volunteerList.searchVolunteer(String.valueOf(id)) != null) {
            System.out.println("Volunteer ID already exists!");
            return;
        }
        Volunteer v = new Volunteer(id, name, priority);
        volunteerList.addVolunteer(v);
        waitingQueue.enqueue(v);
        System.out.println("Volunteer '" + name + "' registered successfully.");
    }
    public void displayVolunteers() {
        volunteerList.displayVolunteers();
    }
    public void displaySorted() {
        volunteerList.VolunteersSortedByPriority();
    }
    public void viewPriorityGroup(String level) {
        volunteerList.displayByPriority(level);
    }
    public void assignTask(String task) {
        Volunteer v = waitingQueue.dequeue();
        if (v == null) {
            System.out.println("No volunteers waiting.");
            return;
        }
        v.assignTask(task);
        undoStack.push(new Action(v, "assign"));
        System.out.println(v.name + " (Priority: " + v.plevel + ") assigned to " + task);
    }
    public void undoLastAction() {
        Action action = undoStack.pop();
        if (action == null) {
            System.out.println("Nothing to undo.");
            return;
        }
        Volunteer v = action.volunteer;
        if (action.actionType.equals("assign")) {
            v.assigned = false;
            v.taskassigned = "None";
            waitingQueue.enqueue(v);
            System.out.println("Undo assignment for " + v.name);
        }
        else if (action.actionType.equals("remove")) {
            volunteerList.addVolunteer(v);
            waitingQueue.enqueue(v);
            System.out.println("Undo removal for " + v.name);
        }
    }
    public void searchVolunteer(String query) {
        Volunteer v = volunteerList.searchVolunteer(query);
        if (v != null) {
            v.display();
        } else {
            System.out.println("Volunteer '" + query + "' not found.");
        }
    }
    public void removeVolunteer(int id) {
        Volunteer v = volunteerList.searchVolunteer(String.valueOf(id));
        if (v == null) {
            System.out.println("Volunteer not found");
            return;
        }
        volunteerList.removeVolunteer(id);
        waitingQueue.removeFromQueue(id);
        undoStack.push(new Action(v, "remove"));
        System.out.println("Volunteer removed.");
    }
    public void displayUndoStack() {
        undoStack.displayStack();
    }
    public void displayWaitingQueue() {
        waitingQueue.displayQueue();
    }
}