package org.bs.garden;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This represents a plant that gets planted in your garden.
 * 
 * @author bsneade
 */
@JsonIgnoreProperties({"actions"})
public class Plant {
    
    private String name;
    
    private Set<Action> actions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }
    
    public void addAction(final Action action) {
        if (actions == null) {
            actions = new HashSet<>();
        }
        actions.add(action);
    }
   
    /**
     * For the benefit of polymorphic json mapping.  Note that this clears the
     * underlying {@link #actions}.
     * @param actionArray to set.
     */
    public void setActionArray(final Action[] actionArray) {
        actions.clear();
        actions.addAll(Arrays.asList(actionArray));
    }
    
    /**
     * For the benefit of polymorphic json mapping.  Note that this clears the
     * underlying {@link #actions}.
     * @return the Array representation of {@link #actions}.
     */
    public Action[] getActionArray() {
        return actions.toArray(new Action[] {});
    }
}
