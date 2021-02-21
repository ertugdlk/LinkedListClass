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

    // Not optimal solution
    public static LinkedList sumReverseLists(LinkedList list1, LinkedList list2) {
        list1 = LinkedList.reverse(list1); // O(N)
        list2 = LinkedList.reverse(list2); // O(N)
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        Node currNode1 = list1.head;
        Node currNode2 = list2.head;

        // O(N)
        while (currNode1 != null && currNode2 != null) {
            s1.append(currNode1.value);
            s2.append(currNode2.value);
            currNode1 = currNode1.next;
            currNode2 = currNode2.next;
        }
        Integer sum = Integer.parseInt(s1.toString()) + Integer.parseInt(s2.toString());
        String result = sum.toString();
        char[] chararray = result.toCharArray();

        LinkedList list3 = new LinkedList();
        for (int i = result.length() - 1; i >= 0; i--) {
            int value = Character.getNumericValue(chararray[i]);
            list3 = list3.insert(list3, value);
        }

        return list3;
    }

    public static void main(String[] args) {
        LinkedList newlist = new LinkedList();
        newlist = LinkedList.insert(newlist, 1);
        newlist = LinkedList.insert(newlist, 1);
        newlist = LinkedList.insert(newlist, 1);
        LinkedList newlist2 = new LinkedList();
        newlist2 = LinkedList.insert(newlist2, 1);
        newlist2 = LinkedList.insert(newlist2, 1);
        newlist2 = LinkedList.insert(newlist2, 1);

        LinkedList list = sumLists(newlist, newlist2);
        LinkedList.printList(list);
    }

}
