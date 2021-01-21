package com.mongodb.starter.dtos;

import java.util.Objects;

/**
 *
 * @author unzalu.jon
 */
public class AverageAgeDTO {

    private double averageAge;

    /**
     *
     * @return
     */
    public double getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(double averageAge) {
        this.averageAge = averageAge;
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
        AverageAgeDTO that = (AverageAgeDTO) o;
        return Double.compare(that.averageAge, averageAge) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(averageAge);
    }
}
