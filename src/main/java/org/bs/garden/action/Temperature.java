package org.bs.garden.action;

import org.bs.garden.Action;
import org.joda.time.LocalTime;

/**
 * An action that needs to be taken at a specific temperature. 
 * @author bsneade
 */
public abstract class Temperature extends Action {
    
    /**
     * Degrees in Celsius.
     */
    private Double degrees;
    
    /**
     * How to interpret the degrees comparison.
     */
    private Direction direction;
    
    /**
     * Is there a specific time of day for this temperature.
     */
    private LocalTime timeOfDay;

    public Temperature() {
    }

    public Temperature(String name) {
        super(name);
    }

    public Temperature(String name, Double degrees, Direction direction) {
        super(name);
        this.degrees = degrees;
        this.direction = direction;
    }
    
    public Double getDegrees() {
        return degrees;
    }

    public void setDegrees(Double degrees) {
        this.degrees = degrees;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public LocalTime getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(LocalTime timeOfDay) {
        this.timeOfDay = timeOfDay;
    }
    
}
