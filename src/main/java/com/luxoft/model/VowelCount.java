package com.luxoft.model;

/**
 * The VowelCount class represents a utility for counting and computing the average of integers.
 */
public class VowelCount {

    private int count = 0; // the number of integers added to this VowelCount instance
    private int total = 0; // the sum of all the integers added to this VowelCount instance

    public int getCount() {
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }

    public void setTotal(int total){
        this.total = total;
    }

    /**
     Adds a new integer to this VowelCount instance and updates the count and total accordingly.
     @param n the integer to be added
     */
    public void addCount(int n) {
        count++;
        total += n;
    }

    /**
     Computes and returns the average of the integers added to this VowelCount instance.
     @return the average of the integers added to this VowelCount instance
     */
    public double getAverage() {
        return (double) total / count;
    }
}
