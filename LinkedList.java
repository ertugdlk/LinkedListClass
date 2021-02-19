package LinkedList;

public class LinkedList {
    Node head;

    static class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

    }

    public static LinkedList insert(LinkedList list, int value) {
        // create new node with insertion value
        Node newNode = new Node(value);
        newNode.next = null;

        // check list head is exist or not
        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;

            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }

        return list;
    }

    public static LinkedList delete(LinkedList list, int value) {
        Node currNode = list.head;
        Node prev = null;

        if (currNode != null && currNode.value == value) {
            list.head = currNode.next;
            System.out.println("Success delete operation");
            return list;
        }

        while (currNode != null && currNode.value != value) {

            prev = currNode;
            currNode = currNode.next;

            if (currNode.value == value) {
                prev.next = currNode.next;
                System.out.println("Success delete operation");
            }
        }
        return list;

    }

    public static LinkedList deletebyIndex(LinkedList list, int index) {
        Node currNode = list.head;
        Node prev = null;
        int counter = 0;

        if (index == 0) {
            list.head = currNode.next;
        }

        while (currNode != null) {
            if (counter == index) {
                prev.next = currNode.next;
                return list;
            } else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        return list;

    }

    public static LinkedList reverse(LinkedList list) {
        Node currnNode = list.head;
        Node prev = null;
        Node next = currnNode.next;

        while (currnNode != null) {
            next = currnNode.next;
            currnNode.next = prev;
            prev = currnNode;
            currnNode = next;
        }
        list.head = prev;
        return list;

    }

    public static void printList(LinkedList list) {
        Node currNode = list.head;
        System.out.println(currNode.value);
        while (currNode.next != null) {
            currNode = currNode.next;
            System.out.println(currNode.value);
        }
    }

    public static void main(String[] args) {
        LinkedList newlist = new LinkedList();
        newlist = insert(newlist, 3);
        newlist = insert(newlist, 7);
        newlist = insert(newlist, 9);
        newlist = insert(newlist, 2);
        newlist = deletebyIndex(newlist, 2);
        // printList(newlist);
        // printList(newlist);
        newlist = reverse(newlist);
        printList(newlist);

    }
}
