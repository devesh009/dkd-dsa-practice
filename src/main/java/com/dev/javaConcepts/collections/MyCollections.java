package com.dev.javaConcepts.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created on 30/03/2025
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
public class MyCollections {

    public class Car{
        String color;
        String model;
        int year;
        int price;
        public Car(String color, String model, int year, int price) {
            this.color = color;
            this.model = model;
            this.year = year;
            this.price = price;
        }

    }

    public void queueExample() {

        // PriorityQueue is a data structure that stores elements in a sorted order.
        // It is implemented as a binary heap.
        // The elements in the PriorityQueue are ordered according to their natural ordering or by a Comparator provided at queue construction time.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(1);
        pq.add(5);
        pq.add(0);
        pq.add(100);
        pq.add(200);
        pq.add(-200);
        pq.forEach(System.out::println);
        pq.poll();
        pq.poll();
        System.out.println("After removing 2 elements");
        pq.forEach(System.out::println);

        // The PriorityQueue is a min-heap by default, which means that the smallest element is at the head of the queue.
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((Integer x, Integer y) -> y - x);
        pq1.add(10);
        pq1.add(1);
        pq1.add(5);
        pq1.add(0);
        pq1.add(100);
        pq1.add(200);
        pq1.add(-200);
        pq1.forEach(System.out::println);
    }

    public void sortingCollections(){
        // Sorting a collection using Comparator
        // The Comparator interface is used to define a custom ordering for the elements in a collection.
        // It is used to sort the elements in a specific order.
        // The Comparator interface has two methods: compare and equals.
        // The compare method is used to compare two elements and return an integer value.
        // The equals method is used to check if two elements are equal.
        // The compare method returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.

        List<Car> list = new ArrayList<>();

    }
}
