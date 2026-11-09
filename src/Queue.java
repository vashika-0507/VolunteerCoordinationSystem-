public class Queue {
    Node front;
    Node rear;
    public void enqueue(Volunteer v) {
        Node newNode = new Node(v);
        if (front == null || v.pvalue > ((Volunteer) front.data).pvalue) {
            newNode.next = front;
            front = newNode;
            if (rear == null) rear = newNode;
            return;
        }
        Node current = front;
        while (current.next != null && ((Volunteer) current.next.data).pvalue >= v.pvalue) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        if (newNode.next == null) rear = newNode;
    }
    public Volunteer dequeue() {
        if (isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        Volunteer v = (Volunteer) front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return v;
    }
    public void removeFromQueue(int id) {
        if (isEmpty()) return;

        if (((Volunteer) front.data).vid == id) {
            front = front.next;
            if (front == null) rear = null;
            return;
        }
        Node current = front;
        while (current.next != null) {
            Volunteer v = (Volunteer) current.next.data;
            if (v.vid == id) {
                current.next = current.next.next;
                if (current.next == null){
                    rear = current;
                }
                return;
            }
            current = current.next;
        }
    }
    public void displayQueue() {
        if (front == null) {
            System.out.println("No volunteers are currently waiting in the queue.");
            return;
        }
        Node temp = front;
        while (temp != null) {
            ((Volunteer) temp.data).display();
            temp = temp.next;
        }
    }
    public boolean isEmpty() {
        return front == null;
    }
}

