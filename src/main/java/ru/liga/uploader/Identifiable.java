package ru.liga.uploader;

import java.io.Serializable;

public interface Identifiable<Id extends Serializable> extends Serializable {
    Id getId();

    void setId(Id id);
}
