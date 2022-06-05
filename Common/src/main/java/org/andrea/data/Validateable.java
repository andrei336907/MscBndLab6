package org.andrea.data;

public interface Validateable {
    /**
     * validaters all fields after json deserialization
     */

    public boolean validate();
}
