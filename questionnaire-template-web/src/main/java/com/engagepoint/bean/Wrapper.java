package com.engagepoint.bean;

import javax.xml.bind.annotation.XmlAnyElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for wrapping root element.
 * With this class we needn't create separate class for root element
 *
 * @param <T> class to wrap
 */
public class Wrapper<T> {
    private List<T> items;

    public Wrapper() {
        items = new ArrayList<T>();
    }

    public Wrapper(List<T> items) {
        this.items = items;
    }

    /**
     * @return List of type T elements
     */
    @XmlAnyElement(lax = true)
    public List<T> getItems() {
        return items;
    }
}
