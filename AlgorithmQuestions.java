package LinkedList;

import java.util.HashMap;
import java.util.Map;

import LinkedList.LinkedList.Node;

public class AlgorithmQuestions {

    public static LinkedList removeDups(LinkedList list) {
        Node currNode = list.head;
        Node prev = null;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // count how many same values in nodes
        while (currNode != null) {
            if (hashMap.get(currNode.value) == null) {
                hashMap.put(currNode.value, 1);
                prev = currNode;
                currNode = currNode.next;
            } else {
                prev.next = currNode.next;
                currNode = currNode.next.next;
            }
        }

        return list;
    }

    public static LinkedList sendToEnd(LinkedList list, int index) {
        Node currNode = list.head;
        Node prev = null;
        int counter = 0;
        Node temp = null;

        while (currNode != null) {
            if (counter == index) {
                prev.next = currNode.next;
                temp = new Node(currNode.value);
                temp.next = null;
            }

            if (currNode.next == null) {
                currNode.next = temp;
                return list;
            }
            counter++;
            prev = currNode;
            currNode = currNode.next;
        }

        return list;
    }

    public static void main(String[] args) {
        LinkedList newlist = new LinkedList();
        newlist = LinkedList.insert(newlist, 3);
        newlist = LinkedList.insert(newlist, 7);
        newlist = LinkedList.insert(newlist, 9);
        newlist = LinkedList.insert(newlist, 7);
        newlist = LinkedList.insert(newlist, 2);
        LinkedList.printList(newlist);
        newlist = sendToEnd(newlist, 2);
        System.out.println("--------");
        LinkedList.printList(newlist);
    }

}
