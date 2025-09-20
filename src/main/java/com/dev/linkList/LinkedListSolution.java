package com.dev.linkList;

/**
 * Created on 10/01/2025
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
public class LinkedListSolution {

    /**
     * Reverse the linked list using recursive approach
     *
     * @param head
     * @return
     */
    static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHeadNode = reverse(head.next);
        // change references for middle chain
        head.next.next = head;
        head.next = null;
        // send back new head node in every recursion
        return newHeadNode;
    }

    /**
     * Reverse the linked list using iterative approach
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * Detect cycle in the linked list
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;

    }

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        int pos = -1;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                pos = 0;
                break;
            }
        }

        if (pos != 0) {
            System.out.println("no cycle");
            return null;
        } else {

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
                pos += 1;
            }
            System.out.println("tail connect to node index " + pos);
            return slow;

        }
    }

    /**
     * Function to find the length of a loop in the linked list.
     * Count the nodes in the loop
     *
     * @param head
     * @return
     */
    public int countNodesInLoop(ListNode head) {

        int pos = 0;
        if (head == null || head.next == null) return pos;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                pos = 1;
                break;
            }
        }

        if (pos != 0) {
            while (fast.next != slow) {
                pos += 1;
                fast = fast.next;
            }
        }
        return pos;
    }

    /**
     * Here is a solution to segregate odd and even indexed nodes in a linked list in Java:
     * Traverse the linked list and separate the nodes into two lists: one for odd indexed nodes and one for even indexed nodes.
     * Merge the two lists, with the odd indexed nodes coming first.
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode oddHead = new ListNode(0); // Dummy head for odd indexed nodes
        ListNode evenHead = new ListNode(0); // Dummy head for even indexed nodes
        ListNode odd = oddHead, even = evenHead;
        ListNode current = head;
        int index = 1;

        while (current != null) {
            if (index % 2 != 0) {
                odd.next = current;
                odd = odd.next;
            } else {
                even.next = current;
                even = even.next;
            }
            current = current.next;
            index++;
        }

        even.next = null; // End the even list
        odd.next = evenHead.next; // Append even list to the end of odd list

        return oddHead.next; // Return the head of the new list
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Traverse both lists
        while (pointerA != pointerB) {
            // If pointerA reaches the end, switch to headB
            pointerA = (pointerA == null) ? headB : pointerA.next;
            // If pointerB reaches the end, switch to headA
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // Either both pointers are null (no intersection) or they meet at the intersection node
        return pointerA;
    }

    public ListNode getOddIndexesList(ListNode head) {
        ListNode dummyHead = new ListNode(0); // Dummy node for new list
        ListNode newList = dummyHead;

        while (head != null) {
            ListNode prev = null;
            ListNode curr = head;
            boolean isOdd = true; // Odd index nodes

            while (curr != null) {
                if (isOdd) {
                    newList.next = new ListNode(curr.val); // Append to new list
                    newList = newList.next;

                    if (prev != null) {
                        prev.next = curr.next; // Remove from original list
                    } else {
                        head = curr.next; // Move head if first node is removed
                    }
                }
                prev = curr;
                curr = curr.next;
                isOdd = !isOdd;
            }
        }
        return dummyHead.next;
    }

    private void arrangeList(ListNode oldList, ListNode newList) {
        if (oldList == null) return;
        ListNode newOldList = null;
        ListNode newHeadOldList = null;


        for (int i = 1; oldList != null; i++) {
            if (i % 2 != 0) {
                newList = new ListNode(oldList.val);
                newList = newList.next;
            } else {
                newOldList = new ListNode(oldList.val);
                if (i == 1) {
                    newHeadOldList = newOldList;
                }
                newOldList = newOldList.next;
            }
            oldList = oldList.next;
        }
        arrangeList(newHeadOldList, newList);
    }

    /**
     * Get the middle of the linked list
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode node = head;
        return getMiddle(node);
    }

    /**
     * Get the middle of the linked list
     *
     * @param head
     * @return
     */
    private ListNode getMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Function to reverse nodes in groups of K
    static ListNode kReverse(ListNode head, int k) {
        // Initialize a temporary
        // node to traverse the list
        ListNode temp = head;

        // Initialize a pointer to track the
        // last node of the previous group
        ListNode prevLast = null;

        // Traverse through the linked list
        while (temp != null) {

            // Get the Kth node of the current group
            ListNode kThNode = getKthNode(temp, k);

            // If the Kth node is NULL
            // (not a complete group)
            if (kThNode == null) {

                // If there was a previous group,
                // link the last node to the current node
                if (prevLast != null) {
                    prevLast.next = temp;
                }

                // Exit the loop
                break;
            }

            // Store the next node
            // after the Kth node
            ListNode nextNode = kThNode.next;

            // Disconnect the Kth node
            // to prepare for reversal
            kThNode.next = null;

            // Reverse the nodes from
            // temp to the Kth node
            reverseLinkedList(temp);

            // Adjust the head if the reversal
            // starts from the head
            if (temp == head) {
                head = kThNode;
            } else {
                // Link the last node of the previous
                // group to the reversed group
                prevLast.next = kThNode;
            }

            // Update the pointer to the
            // last node of the previous group
            prevLast = temp;

            // Move to the next group
            temp = nextNode;
        }

        // Return the head of the
        // modified linked list
        return head;
    }
    // Function to reverse a linked list
    // using the 3-pointer approach
    static ListNode reverseLinkedList(ListNode head) {
        // Initialize'temp' at
        // head of linked list
        ListNode temp = head;

        // Initialize pointer 'prev' to NULL,
        // representing the previous node
        ListNode prev = null;

        // Traverse the list, continue till
        // 'temp' reaches the end (NULL)
        while(temp != null){
            // Store the next node in
            // 'front' to preserve the reference
            ListNode front = temp.next;

            // Reverse the direction of the
            // current node's 'next' pointer
            // to point to 'prev'
            temp.next = prev;

            // Move 'prev' to the current
            // node for the next iteration
            prev = temp;

            // Move 'temp' to the 'front' node
            // advancing the traversal
            temp = front;
        }

        // Return the new head of
        // the reversed linked list
        return prev;

    }

    // Function to get the Kth node from
    // a given position in the linked list
    static ListNode getKthNode(ListNode temp, int k) {
        // Decrement K as we already
        // start from the 1st node
        k -= 1;

        // Decrement K until it reaches
        // the desired position
        while (temp != null && k > 0) {
            // Decrement k as temp progresses
            k--;

            // Move to the next node
            temp = temp.next;
        }

        // Return the Kth node
        return temp;
    }


}
