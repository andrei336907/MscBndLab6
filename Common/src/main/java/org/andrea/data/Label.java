package org.andrea.data;

import java.io.Serializable;

/**
 * label class
 */
public class Label implements Validateable, Serializable {
    private String name;

    /**
     * constructor for Label class
     *
     * @param name
     */
    public Label(String name) {
        this.name = name;
    }

    /**
     * @return label's name
     */
    public String getLabelName() {
        return name;
    }

    /**
     * @return String
     */

    @Override
    public String toString() {
        String s = "";
        s += "\"nameOfLabel\" : " + "\"" + getLabelName() + "\"" + "}";
        return s;
    }

    @Override
    public boolean validate() {
        return true;
    }
}
