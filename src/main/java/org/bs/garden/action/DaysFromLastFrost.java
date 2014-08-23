package org.bs.garden.action;

import org.bs.garden.Action;

/**
 * Represents the number days before or after the last frost.
 * @author bsneade
 */
public class DaysFromLastFrost extends Action {
    
    /**
     * This is the number of days from the last frost.  A negative value is before, while positive is after.
     */
    private Integer days;

    public DaysFromLastFrost() {
    }

    public DaysFromLastFrost(String name) {
        super(name);
    }

    public DaysFromLastFrost(String name, Integer days) {
        super(name);
        this.days = days;
    }
    
    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
    
}
