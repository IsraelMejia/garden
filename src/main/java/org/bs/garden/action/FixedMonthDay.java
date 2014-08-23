package org.bs.garden.action;

import java.util.Map;
import org.bs.garden.Action;
import org.joda.time.LocalDate;
import org.joda.time.MonthDay;
import org.joda.time.Years;
import org.joda.time.base.BaseLocal;

/**
 * A fixed date for something to occur.
 * @author bsneade
 */
public class FixedMonthDay extends Action {
    
    private MonthDay monthDay;

    public FixedMonthDay() {
    }

    public FixedMonthDay(String name) {
        super(name);
    }

    public FixedMonthDay(String name, MonthDay monthDay) {
        super(name);
        this.monthDay = monthDay;
    }

    public MonthDay getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(MonthDay monthDay) {
        this.monthDay = monthDay;
    }

    @Override
    public BaseLocal nextEstimatedEvent(final Map<String, Object> context) {
        int year = LocalDate.now().getYear();
        if (MonthDay.now().isAfter(monthDay)) {
            //we have passed the requested month
            year++; //advance to next year
        }
        return new LocalDate(year, monthDay.getMonthOfYear(), monthDay.getDayOfMonth());
    }
    
}
