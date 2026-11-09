# Smart Event Volunteer Coordination System

A console-based Java application for managing event volunteers. Volunteers are registered with a priority level, placed in a waiting queue, and assigned to tasks in priority order, with an undo feature for mistakes.

The main goal of this project is to practise data structures: every structure is **implemented from scratch** (no `ArrayList`, `LinkedList`, `Queue` or `Stack` from the Java library).

## Features

- Register volunteers with an ID, name and priority level (High / Medium / Low)
- Assign tasks to the highest-priority waiting volunteer
- Undo the last action (an assignment or a removal)
- Search for a volunteer by ID or name
- View all volunteers, volunteers sorted by priority, or one priority group
- Remove a volunteer by ID
- View the waiting queue and the undo history

## Data structures used

| Structure | Used for | Why |
|---|---|---|
| **Singly linked list** (`Linkedlist`) | Master list of all registered volunteers | Volunteers are added and removed often, with no fixed size |
| **Priority queue** (`Queue`, a linked list kept sorted by priority) | Waiting volunteers | The highest-priority volunteer is always at the front; volunteers with equal priority are served first come, first served |
| **Stack** (`Stack`) | Undo history | The most recent action is undone first (last in, first out) |
| **Array + bubble sort** | "Sorted by priority" view | The list is copied into an array and sorted without changing the original order |

### Time complexity

| Operation | Complexity |
|---|---|
| Assign task (dequeue) | O(1) |
| Push / pop undo action | O(1) |
| Register volunteer | O(n) |
| Search / remove volunteer | O(n) |
| Undo an assignment (re-enqueue by priority) | O(n) |
| View sorted by priority (bubble sort) | O(n²) |

## How it works

1. **Register:** the volunteer is added to the linked list and inserted into the waiting queue at the position that matches their priority.
2. **Assign:** the volunteer at the front of the queue is removed and given the task. The action is pushed onto the undo stack.
3. **Undo:** the latest action is popped. An undone assignment puts the volunteer back in the queue; an undone removal restores them to the list and the queue.

## Project structure

```
src/
├── Main.java             # menu and user input
├── VolunteerSystem.java  # ties the list, queue and stack together
├── Volunteer.java        # volunteer data and priority value
├── Action.java           # one undoable action (volunteer + type)
├── Node.java             # node shared by all three structures
├── Linkedlist.java       # custom singly linked list
├── Queue.java            # custom priority queue
└── Stack.java            # custom stack
```

## How to run

**IntelliJ IDEA:** open the project folder and run `Main`.

**Command line** (needs a JDK):

```bash
cd src
javac *.java
java Main
```

## Possible improvements

- Validate input so a non-numeric ID does not crash the program
- Reject unknown priority levels instead of treating them as Low
- Keep a tail pointer in the linked list to make adding a volunteer O(1)
- Replace bubble sort with merge sort (O(n log n))
- Save volunteers to a file so data persists between runs

## Technologies

Java, object-oriented programming, data structures (linked list, queue, stack), sorting

## Author

**Vashika Maheswaran**, BSc (Hons) Artificial Intelligence with Data Science, Robert Gordon University (delivered by IIT, Colombo)
[GitHub](https://github.com/vashika-0507) · [LinkedIn](https://www.linkedin.com/in/vashika-maheswaran-71a17738b)
