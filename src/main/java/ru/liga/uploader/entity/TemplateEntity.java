package ru.liga.uploader.entity;



import javax.persistence.*;

@Entity
@Table(schema = "migration", name = "template_settings_tmp")
@SequenceGenerator(schema = "migration", name = "template_settings_tmp_s", sequenceName = "migration.template_settings_tmp_s", allocationSize = 1)
public class TemplateEntity {

    private Long id;
    private String shortName;
    private Long count;
    private Long organizationId;

    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "template_settings_tmp_s")
    @Column(name = "id", nullable = false, columnDefinition = "serial")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "short_name", nullable = false)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Column(name = "count", nullable = false, columnDefinition = "int4")
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Column(name = "organization_id")
    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
