/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb.starter.dtos;

import java.util.Objects;

/**
 *
 * This is the starter for the average of books
 */
public class AveragePageBOOK {
    
    private double averagePages;

    /**
     *
     * This is the getter for average of pages
     */
    public double getAveragePages() {
        return averagePages;
    }

    /**
     *
     * This is the setter for average of pages 
     */
    public void setAveragePages(double averagePages) {
        this.averagePages = averagePages;
    }

    /**
     *
     * This is the equals
     * 
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AveragePageBOOK that = (AveragePageBOOK) o;
        return Double.compare(that.averagePages, averagePages) == 0;
    }

    /**
     *
     * This is the hashCode of the starter. Hash code returns an int, that is used to compare if two objects are equal. If two objects are equal they must return the same hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(averagePages);
    }
}
