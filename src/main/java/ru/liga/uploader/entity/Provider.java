package ru.liga.uploader.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(schema = "si", name = "providers")
public class Provider extends BusinessEntity<Long> {
    private String name;
    private String shortName;
    private String formName;

    @Id
    @Column(name = "provider_id")
    @Override
    public Long getId() {
        return super.getId();
    }

    @Column(name = "provider_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "form_name")
    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    @Column(name = "provider_short_name")
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
