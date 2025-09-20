package com.dev.linkList;

/**
 * Created on 11/05/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
  public class RemoveNNode {

  public ListNode removeNthFromEnd(ListNode head, int k) {
    int n = 1;
    ListNode newHead = head;
    while(newHead != null && newHead.next != null){
      n++;
      newHead = newHead.next;
    }
    if(k>n || k==0 ) return head;
    if(n == 1 && k == 1) return  null;
    int end = n-k;
    int start = 1;
    newHead = head;

    while(start<end){
      newHead = newHead.next;
      start++;
    }
    if(newHead.next != null){
      if(end == 0){
        head = head.next;
      }else{
        newHead.next = newHead.next.next;
      }

    }else{
      newHead.next = null;
    }
    return head;
  }

  }
