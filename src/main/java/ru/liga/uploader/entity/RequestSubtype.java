package ru.liga.uploader.entity;

import javax.persistence.*;

@Entity
@Table(schema = "si", name = "request_subtypes")
public class RequestSubtype extends BusinessEntity<Long> {
    private Long requestTypeId;
    private String name;
    private String shortName;
    private Boolean showOnForm;
    private Provider provider;

    @Id
    @Column(name = "request_subtype_id", nullable = false)
    @Override
    public Long getId() {
        return super.getId();
    }

    @Column(name = "request_type_id", nullable = false)
    public Long getRequestTypeId() {
        return requestTypeId;
    }

    public void setRequestTypeId(Long requestTypeId) {
        this.requestTypeId = requestTypeId;
    }

    @Column(name = "request_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "request_short_name", nullable = false)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Column(name = "show_on_form_flag")
    public Boolean isShowOnForm() {
        return showOnForm;
    }

    public void setShowOnForm(Boolean showOnForm) {
        this.showOnForm = showOnForm;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
