package com.dev.greedyAlgo.pojos;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {

    @Override
    public int compare(Item a, Item b) {
        double r1 = (double)(a.getValue()) / (double)(a.getWeight());
        double r2 = (double)(b.getValue()) / (double)(b.getWeight());
        if(r1 < r2) return 1;
        else if(r1 > r2) return -1;
        else return 0;
    }
}
