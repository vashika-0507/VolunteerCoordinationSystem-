public class Volunteer {
    int vid;
    String name;
    String plevel;
    int pvalue;
    String taskassigned;
    boolean assigned;
    public Volunteer(int volunteerId, String name, String priorityLevel) {
        this.vid = volunteerId;
        this.name = name;
        this.plevel = priorityLevel;
        this.taskassigned = "None";
        this.assigned = false;
        switch(priorityLevel.toLowerCase()) {
            case "high":
                this.pvalue = 3;
                break;
            case "medium":
                this.pvalue = 2;
                break;
            default:
                this.pvalue = 1;
                break;
        }
    }
    public void assignTask(String task) {
        this.taskassigned = task;
        this.assigned = true;
    }
    public void display() {
        String status = assigned ? "Assigned to " + taskassigned : "Waiting";
        System.out.println("ID: " + vid +" | Name: " + name +" | Priority: " + plevel +" | Status: " + status);
    }
}