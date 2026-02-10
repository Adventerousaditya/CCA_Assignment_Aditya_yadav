# Part 1 – Concept Analysis

Comparison between ArrayList and LinkedList:

Feature | ArrayList | LinkedList  
Internal Structure | Dynamic Array | Doubly Linked List  
Access Time | O(1) | O(n)  
Insertion Time | O(n) | O(1)  
Deletion Time | O(n) | O(1)  
Memory Usage | Less | More  

Choosing correct data structure:

1. Student Record System  
ArrayList is used because it provides fast access using index.

2. Browser History  
LinkedList is used because forward and backward navigation is easy.

3. Online Shopping Cart  
ArrayList is used because items are accessed frequently.

4. Undo / Redo Feature  
LinkedList is used because insertion and deletion is fast.

--------------------------------------------------

# Part 2 – Coding Task

Task A – ArrayList Program

Program to add student marks, insert a mark, remove lowest mark and display final list.

```java
import java.util.ArrayList;
import java.util.Collections;

public class StudentMarks {
    public static void main(String[] args) {

        ArrayList<Integer> marks = new ArrayList<>();

        marks.add(78);
        marks.add(85);
        marks.add(69);
        marks.add(90);
        marks.add(75);

        marks.add(2, 80);

        int min = Collections.min(marks);
        marks.remove(Integer.valueOf(min));

        System.out.println("Final Marks List: " + marks);
    }
}


```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {

    Node head;

    // Insert at beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
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

    // Traverse list
    void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Search element
    boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key)
                return true;
            temp = temp.next;
        }
        return false;
    }

    // Reverse linked list (Challenge)
    void reverse() {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtBeginning(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        list.traverse();
        list.reverse();
        list.traverse();
    }
}

# 5. Viva Questions

// 1. Why is ArrayList access faster?
// ArrayList allows direct index-based access using an array giving O(1) time complexity.

// 2. Why does LinkedList consume more memory?
// Each node stores data and extra pointer increasing memory usage.

// 3. What is the time complexity of insertion at beginning in SLL?
// O(1)

// 4. Difference between singly and doubly linked list?
// Singly linked list has one pointer while doubly linked list has two pointers.

// 5. What is RandomAccess interface?
// It is a marker interface used by ArrayList to indicate fast random access.


