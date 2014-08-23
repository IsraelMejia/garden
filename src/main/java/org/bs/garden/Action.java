package org.bs.garden;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.List;
import java.util.Map;
import org.joda.time.base.BaseLocal;

/**
 *
 * @author bsneade
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, visible = true)
public abstract class Action {
    
    public static final String CONTEXT_CURRENT_ZONE = "context.current.zone";
    
    public static final String CONTEXT_CURRENT_ZIPCODE = "context.current.zipcode";
    
    private String name;
    
    private String description;
    
    public Action() { }

    public Action(String name) {
        this.name = name;
    }
    
    /**
     * What zones does this action apply to?  See {@link http://planthardiness.ars.usda.gov/PHZMWeb/} for more info on Zones.
     * An empty list implies all zones.
     */
    private List<String> zones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getZones() {
        return zones;
    }

    public void setZones(List<String> zones) {
        this.zones = zones;
    }
    
    /**
     * Calculate the next event for this action.
     * @param context
     * @return 
     */
    public abstract BaseLocal nextEstimatedEvent(Map<String, Object> context);
    
}
