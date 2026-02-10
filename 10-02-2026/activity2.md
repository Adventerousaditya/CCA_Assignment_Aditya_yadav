--------------------------------------------------
2. Part 1 – Scenario Based Analysis
--------------------------------------------------

1. Real-time chat message storage  
Data Structure: LinkedList  
Reason: Messages are added frequently. Insertion is O(1).

2. Music playlist where songs are frequently reordered  
Data Structure: LinkedList  
Reason: Insertion and deletion in middle is easy. Time complexity is O(1) if position is known.

3. Student database with frequent searching by index  
Data Structure: ArrayList  
Reason: Direct access using index is fast. Time complexity is O(1).

4. Browser back and forward navigation  
Data Structure: LinkedList  
Reason: Easy navigation in both directions. Insertion and deletion are efficient.

5. Online exam system storing answers sequentially  
Data Structure: ArrayList  
Reason: Answers are stored one by one and accessed by index. Access time is O(1).

--------------------------------------------------
3. Part 2 – Coding Challenges
--------------------------------------------------

Task A – ArrayList Advanced

Program to store numbers, remove even numbers, find max and min, sort in descending order.

```java
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListAdvanced {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        list.removeIf(n -> n % 2 == 0);

        int max = Collections.max(list);
        int min = Collections.min(list);

        Collections.sort(list, Collections.reverseOrder());

        System.out.println("Final List: " + list);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }
}

```java
import java.util.LinkedList;

public class HospitalQueue {
    public static void main(String[] args) {

        LinkedList<String> queue = new LinkedList<>();

        queue.add("Patient 1");
        queue.add("Patient 2");
        queue.add("Patient 3");
        queue.add("Patient 4");
        queue.add("Patient 5");

        queue.addFirst("Emergency Patient");

        queue.remove();
        queue.remove();

        System.out.println("Current Queue: " + queue);
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

class SinglyLinkedList {

    Node head;

    void insertAtPosition(int data, int pos) {
        Node newNode = new Node(data);
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteByValue(int value) {
        if (head.data == value) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }
        if (temp.next != null)
            temp.next = temp.next.next;
    }

    int countNodes() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    void findMiddle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle Element: " + slow.data);
    }

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
}

-----------------------------------------
5. Bonus Challenge (For Top Performers)
// 
// Detect loop in linked list (Floyd’s Algorithm):
// Use slow and fast pointer. If both meet, loop exists.
// 
// Merge two sorted linked lists:
// Compare nodes of both lists and merge in sorted order.
// 
// Remove duplicates from linked list:
// Traverse list and remove node if next node has same value.

# Viva Questions

// What is amortized time complexity?
// It is the average time taken over multiple operations.
// 
// Why ArrayList resizing is expensive?
// Because a new array is created and elements are copied.
// a
// How LinkedList stores elements internally?
// It stores elements as nodes connected using pointers.
// 
// Difference between singly and doubly linked list?
// Singly has one pointer, doubly has two pointers.
// 
// What is space complexity of LinkedList?
// O(n) because extra memory is used for pointers.