package ru.liga.uploader;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

public class SourceEntityInfo implements Serializable {
    private static final long serialVersionUID = -5392061358872372033L;

    private Long requestTypeId;
    private Long requestSubtypeId;
    private String sourceEntity;
    private Long sourceEntityId;
    private Long organizationId;

    public SourceEntityInfo() {
        super();
    }

    @XmlElement(name = "type-id")
    public Long getRequestTypeId() {
        return requestTypeId;
    }

    public void setRequestTypeId(Long requestTypeId) {
        this.requestTypeId = requestTypeId;
    }

    @XmlElement(name = "subtype-id")
    public Long getRequestSubtypeId() {
        return requestSubtypeId;
    }

    public void setRequestSubtypeId(Long requestSubtypeId) {
        this.requestSubtypeId = requestSubtypeId;
    }

    @XmlElement(name = "entity")
    public String getSourceEntity() {
        return sourceEntity;
    }

    public void setSourceEntity(String sourceEntity) {
        this.sourceEntity = sourceEntity;
    }

    @XmlElement(name = "entity-id")
    public Long getSourceEntityId() {
        return sourceEntityId;
    }

    public void setSourceEntityId(Long sourceEntityId) {
        this.sourceEntityId = sourceEntityId;
    }

    @XmlElement(name = "organization-id")
    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long objId) {
        this.organizationId = objId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
