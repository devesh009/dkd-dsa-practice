package com.dev.greedyAlgo.pojos;

import java.util.Comparator;

/**
 * Created on 28/12/2024
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
public class MeetingComparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting o1, Meeting o2) {
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if(o1.pos < o2.pos)
            return -1;
        return 1;
    }
}
