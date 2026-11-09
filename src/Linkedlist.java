public class Linkedlist {
    Node head;
    public void addVolunteer(Volunteer v) {
        Node newNode = new Node(v);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public void removeVolunteer(int id) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (((Volunteer) head.data).vid == id){
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            if (((Volunteer) temp.next.data).vid == id) {
                temp.next = temp.next.next;
                return;}
            temp = temp.next;}
        System.out.println("Volunteer not found");
    }
    public Volunteer[] toArray() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        Volunteer[] array = new Volunteer[count];
        temp = head;
        for (int i = 0; i < count; i++) {
            array[i] = (Volunteer) temp.data;
            temp = temp.next;
        }
        return array;
    }
    public void VolunteersSortedByPriority() {
        if (head == null) {
            System.out.println("The list is currently empty.");
            return;
        }
        Volunteer[] volunteerArray = toArray();
        int n = volunteerArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (volunteerArray[j].pvalue < volunteerArray[j + 1].pvalue) {
                    Volunteer temp = volunteerArray[j];
                    volunteerArray[j] = volunteerArray[j + 1];
                    volunteerArray[j + 1] = temp;
                }
            }
        }
        System.out.println("All Volunteers Sorted by Priority");
        for (Volunteer v : volunteerArray) {
            v.display();
        }
    }
    public Volunteer searchVolunteer(String sv) {
        Node temp = head;
        while (temp != null) {
            Volunteer v = (Volunteer) temp.data;
            if (String.valueOf(v.vid).equals(sv) || v.name.equalsIgnoreCase(sv)){
                return v;
            }
            temp = temp.next;
        }
        return null;
    }
    public void displayByPriority(String level) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            Volunteer v = (Volunteer) temp.data;
            if (v.plevel.equalsIgnoreCase(level)) {
                v.display();
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No volunteers found with priority: " + level);
    }
    public void displayVolunteers() {
        Node temp = head;
        if (temp == null) {
            System.out.println("The list is currently empty.");
            return;
        }
        while (temp != null) {
            ((Volunteer) temp.data).display();
            temp = temp.next;
        }
    }

}