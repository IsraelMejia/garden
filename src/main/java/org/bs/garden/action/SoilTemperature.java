package org.bs.garden.action;

import java.util.Map;
import org.bs.garden.Action;
import org.joda.time.base.BaseLocal;


/**
 *
 * @author bsneade
 */
public class SoilTemperature extends Temperature {

    public SoilTemperature() {
    }

    public SoilTemperature(String name) {
        super(name);
    }

    public SoilTemperature(String name, Double degrees, Direction direction) {
        super(name, degrees, direction);
    }

    @Override
    public BaseLocal nextEstimatedEvent(final Map<String, Object> context) {
        //get the user's zip code
        final String zipCode = (String) context.get(Action.CONTEXT_CURRENT_ZIPCODE);
        //figure out the zone
        //figure out what the ground temps are
        //find the next day that meets the temp.
        throw new UnsupportedOperationException("Not implemented");
    }

}
