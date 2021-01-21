/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb.starter.dtos;

import java.util.Objects;

/**
 *
 * @author unzalu.jon
 */
public class AveragePageBOOK {
    
    private double averagePages;

    /**
     *
     * @return
     */
    public double getAveragePages() {
        return averagePages;
    }

    /**
     *
     * @param averagePages
     */
    public void setAveragePages(double averagePages) {
        this.averagePages = averagePages;
    }

    /**
     *
     * @param o
     * @return
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
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(averagePages);
    }
}
