Binary Search Tree (BST)
Elements Inserted:

50, 30, 70, 20, 40, 60, 80

BST Structure:
        50
       /  \
     30    70
    /  \   /  \
  20   40 60   80

🔹 Operations Performed
1. Insert

Elements are inserted following BST property:

Left child < Root

Right child > Root

2. Traversals

Inorder (LNR):
20 30 40 50 60 70 80

Preorder (NLR):
50 30 20 40 70 60 80

Postorder (LRN):
20 40 30 60 80 70 50

3. Search

Search 40 → Found
Search 100 → Not Found

🧱 Min-Heap (PriorityQueue)

Implemented using Java PriorityQueue

Inserted 10 random numbers

Printed in sorted (ascending) order

Example Output:
1 3 10 12 25 34 45 56 78 89

⏱ Time Complexity Analysis
BST

Insert → O(log n) average, O(n) worst
Search → O(log n) average, O(n) worst
Traversal → O(n)

Worst case occurs when tree becomes skewed.

Min-Heap

Insert → O(log n)
Remove → O(log n)
Peek → O(1)