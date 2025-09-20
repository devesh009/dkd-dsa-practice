package com.dev.greedyAlgo.pojos;

/**
 * Created on 28/12/2024
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
public class Meeting {
    int start;
    int end;
    int pos;

    public Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getPos() {
        return pos;
    }
}
