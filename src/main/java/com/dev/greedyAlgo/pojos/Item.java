package com.dev.greedyAlgo.pojos;

import java.util.Comparator;

/**
 * Created on 27/12/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public class Item {
    private int value;
    private int weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }
}

