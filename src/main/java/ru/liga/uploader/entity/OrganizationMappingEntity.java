package ru.liga.uploader.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "migration", name = "organization_mapping")
public class OrganizationMappingEntity {
    private Long oldOrganizationId;
    private String shortName;
    private Long organizationId;



    @Column(name = "old_organization_id", nullable = false)
    public Long getOldOrganizationId() {
        return oldOrganizationId;
    }

    public void setOldOrganizationId(Long oldOrganizationId) {
        this.oldOrganizationId = oldOrganizationId;
    }

    @Column(name = "short_name", nullable = false)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Id
    @Column(name = "organization_id", nullable = false)
    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
