# LinkedList DSA Assignment (Java)

This repository contains solutions to all 9 questions in the supplied Data Structure - LinkedList assignment.

## Requirements
- Java JDK 8 or later
- Any Java IDE or terminal

## How to run
Open a terminal in the required problem folder and run:

```bash
javac StudentManagement.java
java StudentManagement
```

Replace the filename and class name with the corresponding problem:

| No. | Problem | Java file |
|---|---|---|
| 1 | Singly Linked List - Student Record Management | `StudentManagement.java` |
| 2 | Doubly Linked List - Movie Management | `MovieManagement.java` |
| 3 | Circular Linked List - Task Scheduler | `TaskScheduler.java` |
| 4 | Singly Linked List - Inventory Management | `InventoryManagement.java` |
| 5 | Doubly Linked List - Library Management | `LibraryManagement.java` |
| 6 | Circular Linked List - Round Robin Scheduling | `RoundRobinScheduling.java` |
| 7 | Singly Linked List - Social Media Friend Connections | `SocialMediaFriends.java` |
| 8 | Doubly Linked List - Text Editor Undo/Redo | `TextEditorUndoRedo.java` |
| 9 | Circular Linked List - Ticket Reservation | `TicketReservation.java` |

## Implementation notes
- Positions are **1-based** in insertion methods.
- Each problem is an independent Java program with its own `main` method and sample demonstration.
- Methods are kept separate so they can be tested or connected to a menu-driven interface.
- The social-media example stores friend IDs in a `LinkedHashSet` for uniqueness and quick membership checks.
- The inventory example sorts by swapping item data while preserving the linked-list node links.
- The round-robin example uses a circular linked list and a fixed time quantum.

## Suggested GitHub repository description
`Java implementations of Singly, Doubly and Circular Linked List problems for a Data Structures assignment.`

## Suggested commit
`Add Java solutions for 9 linked list assignment problems`
