package com.dev.linkList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created on 24/01/2025
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
class LinkedListSolutionTest {

    private LinkedListSolution linkedListSolution = new LinkedListSolution();

    @Test
    void reverse() {
    }

    @Test
    void reverseList() {
    }

    @Test
    void mergeTwoLists() {
    }

    @Test
    void getIntersectionNode() {
    }

    @Test
    void getOddIndexesList() {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        // 1, 3, 5, 7, 2, 6, 4


            ListNode newList = linkedListSolution.getOddIndexesList(head);
            System.out.println("Extracted List:");
            printList(newList);

    }

    private void printList(ListNode newList) {
      ListNode list =  newList;
      while (list != null) {
          System.out.print(list.val + " ");
          list = list.next;
      }
    }
}