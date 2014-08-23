package org.bs.garden.action;

import java.util.Map;
import org.bs.garden.Action;
import org.joda.time.base.BaseLocal;

/**
 * Represents the number days before or after the first frost.
 * @author bsneade
 */
public class DaysFromFirstFrost extends Action {
    
    /**
     * This is the number of days from the first frost.  A negative value is before, while positive is after.
     */
    private Integer days;

    public DaysFromFirstFrost() {
    }

    public DaysFromFirstFrost(String name) {
        super(name);
    }

    public DaysFromFirstFrost(String name, Integer days) {
        super(name);
        this.days = days;
    }
    
    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Override
    public BaseLocal nextEstimatedEvent(Map<String, Object> context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
