import java.util.Scanner;
// Node class to represent each element in the linked list
class Node<T> {
    T data; // The data stored within the node
    Node<T> next; // Reference to the next node in the list

    // Constructor to create a new node with specified data
    public Node(T data) {
        this.data = data;
        this.next = null; // Next is initially set to null
    }
}

// LinkedList class manages a list of nodes
class LinkedList<T> {
    private Node<T> head; // Reference to the first node in the list (head of the list)
    private Node<T> tail; // Reference to the last node in the list (tail of the list)

    // Method to check if the linked list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Method to calculate the number of nodes in the linked list
    public int size() {
        int size = 0;
        Node<T> current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
    // Method to reverse the linked list
    public void reverse() {
    Node<T> previous = null;
    Node<T> current = head;
    Node<T> next = null;
    while (current != null) {
        next = current.next; // Store next node
        current.next = previous; // Reverse the current node's pointer
        previous = current; // Move pointers one position ahead
        current = next;
    }
    head = previous; // Reset the head to the new front of the list
}
    
    // Method to find a node with a specific value and return it
    public Node<T> find(T data) {
        Node<T> current = head; // Start with the head node
        while (current != null) {
            if (current.data.equals(data)) {
                return current; // Return the node if data is found
            }
            current = current.next; // Move to the next node
        }
        return null; // Return null if data is not found in the list
    }

    // Method to add a new node with the given data at the end of the linked list
    public void append(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode; // If the list is empty, the new node becomes the head
        } else {
            tail.next = newNode; // The new node is appended after the tail
        }
        tail = newNode; // The new node becomes the new tail of the list
    }

    // Method to add a new node with the given data at the start of the linked list
    public void prepend(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            tail = newNode; // If the list is empty, the new node also becomes the tail
        }
        newNode.next = head; // The new node is placed before the current head
        head = newNode; // The new node becomes the new head of the list
    }

    // Method to remove a node with the specified value from the linked list
    public void remove(T data) {
        if (isEmpty()) return; // If the list is empty, there's nothing to remove

        if (head.data.equals(data)) {
            head = head.next; // If the head contains the data, move the head to the next node
            if (head == null) {
                tail = null; // If the list is now empty, tail is also set to null
            }
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next; // Bypass the node containing the data
                if (current.next == null) {
                    tail = current; // If the removed node was the tail, update the tail
                }
                return;
            }
            current = current.next;
        }
    }

    // Method to print all nodes in the linked list to the console
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
    
    // Other methods like insertAfter, find, etc., can be added here
    // ...
}

// Main class that contains the main method as the program entry point
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<?> list;
        System.out.println("Choose the type of Linked List:");
        System.out.println("1. Integer");
        System.out.println("2. String");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over

        if (choice == 1) {
            list = new LinkedList<Integer>();
        } else if (choice == 2) {
            list = new LinkedList<String>();
        } else {
            System.out.println("Invalid choice");
            return;
        }

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Append data to the list");
            System.out.println("2. Prepend data to the list");
            System.out.println("3. Remove data from the list");
            System.out.println("4. Find data in the list");
            System.out.println("5. Print the list");
            System.out.println("6. Reverse the list");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int action = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            if (action == 0) {
                break;
            }

            switch (action) {
                case 1:
                    System.out.print("Enter data to append: ");
                    if (choice == 1) {
                        ((LinkedList<Integer>)list).append(scanner.nextInt());
                        scanner.nextLine(); // Consume the newline
                    } else {
                        ((LinkedList<String>)list).append(scanner.nextLine());
                    }
                    break;
                case 2:
                    System.out.print("Enter data to prepend: ");
                    if (choice == 1) {
                        ((LinkedList<Integer>)list).prepend(scanner.nextInt());
                        scanner.nextLine(); // Consume the newline
                    } else {
                        ((LinkedList<String>)list).prepend(scanner.nextLine());
                    }
                    break;
                case 3:
                    System.out.print("Enter data to remove: ");
                    if (choice == 1) {
                        ((LinkedList<Integer>)list).remove(scanner.nextInt());
                        scanner.nextLine(); // Consume the newline
                    } else {
                        ((LinkedList<String>)list).remove(scanner.nextLine());
                    }
                    break;
                case 4:
                    System.out.print("Enter data to find: ");
                    if (choice == 1) {
                        int data = scanner.nextInt();
                        Node<Integer> foundNode = ((LinkedList<Integer>)list).find(data);
                        if (foundNode != null) {
                            System.out.println("Data found: " + foundNode.data);
                        } else {
                            System.out.println("Data not found.");
                        }
                        scanner.nextLine(); // Consume the newline
                    } else {
                        String data = scanner.nextLine();
                        Node<String> foundNode = ((LinkedList<String>)list).find(data);
                        if (foundNode != null) {
                            System.out.println("Data found: " + foundNode.data);
                        } else {
                            System.out.println("Data not found.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("The linked list contains:");
                    if (choice == 1) {
                        ((LinkedList<Integer>)list).printList();
                    } else {
                        ((LinkedList<String>)list).printList();
                    }
                    break;
                case 6:
                    System.out.println("Reversing the list...");
                    if (choice == 1) {
                        ((LinkedList<Integer>)list).reverse();
                    } else {
                        ((LinkedList<String>)list).reverse();
                    }
                    break;
                default:
                    System.out.println("Invalid action.");
                    break;
            }
        }

        scanner.close();
    }
}
