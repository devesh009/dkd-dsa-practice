package com.dev.linkList;

/**
 * Created on 04/02/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public class EasySolutions {

    public static class Node{
        public Node next;
        public int data;
    }
    public static class LinkedList{
        public Node head = new Node();
        public Node tail = new Node();
        public int size;

        void addLast(int value){
            if(size == 0){
                Node temp = new Node();
                temp.data = value;
                temp.next = null;
                head.next = tail.next = temp;
                size++;
            }else {
                Node last = head.next;
                while(last.next != null){
                    last = last.next;
                }
                Node temp = new Node();
                temp.data = value;
                temp.next = null;
                last.next = tail.next = temp;
                size++;
            }
        }

        void printLinkList(){
            Node start = head.next;
            while(start != null){
                System.out.println(start.data);
                start = start.next;
            }
        }

        void findMidElement(){
            Node indica = head.next;
            Node farrari = head.next;
            int order = 1;
            while(farrari.next != null){
                indica = indica.next;
                farrari = farrari.next.next;
                System.out.println(order++);
            }
            System.out.println("Indica data -> "+indica.data);

        }

        private Node left = head.next;
        public void reverseByRecursion() {
            Node right = head.next;
            int position = 1;
            reverseList(left, right, position);



        }

        private void reverseList(Node left, Node right, int position) {
            if(right == null) return;
            reverseList(left,right.next,position++);
            if(position>size/2){
                int temp = right.data;
                right.data = left.data;
                left.data = temp;
            }
        }
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(40);
        list.addLast(60);
        list.addLast(70);

        System.out.println("list size : "+list.size);
        System.out.println("List before reversing");
        list.printLinkList();
        //list.findMidElement();
        list.reverseByRecursion();

    }

    void deleteRightGreater(Node head){

        Node prev = head;
        Node curr = prev.next;
        int smallest = prev.data;

        while(curr != null){
        if(curr.data > smallest){
            prev.next = curr.next;

            curr = curr.next;
        }else{
            smallest = curr.data;
            prev = prev.next;
            curr = curr.next;
        }

        }
    }

}
