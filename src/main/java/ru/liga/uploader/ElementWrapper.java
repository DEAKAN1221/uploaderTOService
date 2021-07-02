package ru.liga.uploader;

import javax.xml.bind.annotation.XmlAnyElement;
import java.util.ArrayList;
import java.util.List;

public class ElementWrapper<T> {
    private List<T> items;

    public ElementWrapper() {
        items = new ArrayList<T>();
    }

    public ElementWrapper(List<T> items) {
        this.items = items;
    }

    @XmlAnyElement(lax = true)
    public List<T> getItems() {
        return items;
    }
}
