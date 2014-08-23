/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bs.garden.action;

import java.util.Map;
import org.joda.time.LocalDate;
import org.joda.time.MonthDay;
import org.joda.time.base.BaseLocal;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author bsneade
 */
public class FixedMonthDayTest {
    
    /**
     * Test of nextEstimatedEvent method, of class FixedMonthDay.
     * 
     * FIXME - this will break in December.
     */
    @Test
    public void testNextEstimatedEvent_monthNotPassed() {
        //set up test data
        final MonthDay todayMonthDay = MonthDay.now();
        final MonthDay futureMonthDay = todayMonthDay.plusMonths(1);
        
        //invoke method under test
        final FixedMonthDay fixedMonthDay = new FixedMonthDay("test", futureMonthDay);
        final BaseLocal resultBaseLocal = fixedMonthDay.nextEstimatedEvent(null);
        
        //assertions
        assertEquals(resultBaseLocal, LocalDate.now()
                .withMonthOfYear(futureMonthDay.getMonthOfYear())
                .withDayOfMonth(futureMonthDay.getDayOfMonth())); //the daymonth is in the future (for this year), so it should just be the next date for this year
    }
    
    @Test
    public void testNextEstimatedEvent_monthPassed() {
        //set up test data
        final MonthDay todayMonthDay = MonthDay.now();
        final MonthDay futureMonthDay = todayMonthDay.minusMonths(1);
        
        //invoke method under test
        final FixedMonthDay fixedMonthDay = new FixedMonthDay("test", futureMonthDay);
        final BaseLocal resultBaseLocal = fixedMonthDay.nextEstimatedEvent(null);
        
        //assertions
        assertEquals(resultBaseLocal, LocalDate.now().plusYears(1)
                .withMonthOfYear(futureMonthDay.getMonthOfYear())
                .withDayOfMonth(futureMonthDay.getDayOfMonth())); //the daymonth is in the future (for this year), so it should just be the next date for this year
    }
    
}
