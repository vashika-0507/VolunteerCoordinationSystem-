public class Stack {
    Node top;
    public void push(Action action) {
        Node newNode = new Node(action);
        newNode.next = top;
        top = newNode;
    }
    public Action pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        Action action = (Action) top.data;
        top = top.next;
        return action;
    }
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Undo stack is empty");
            return;
        }
        Node temp = top;
        while (temp != null) {
            Action action = (Action) temp.data;
            System.out.println("Action: " + action.actionType +" | Volunteer: " + action.volunteer.name);
            temp = temp.next;
        }
    }
    public boolean isEmpty() {
        return top == null;}
}

