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
        final String zipCode = context.get(Action.CONTEXT_CURRENT_ZIPCODE);
    }

}
