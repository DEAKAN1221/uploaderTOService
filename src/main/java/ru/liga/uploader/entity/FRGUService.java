package ru.liga.uploader.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(schema = "si", name = "frgu_service")
@SequenceGenerator(schema = "si", name = "frgu_service_s", sequenceName = "si.frgu_service_s", allocationSize = 1)
public class FRGUService extends CoreEntity<Long> {

    private Long currentSsn;
    private Long psPassportId;
    private Long ssn;
    private String fullTitle;
    private Boolean isFunction;
    private String organizationId;
    private LocalDate creationDate;
    private LocalDate startPublishedDate;
    private String administrativeLevel;
    private String fileName;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "frgu_service_s")
    @Column(name = "frgu_service_id", nullable = false)
    @Override
    public Long getId() {
        return super.getId();
    }

    @Column(name = "current_ssn")
    public Long getCurrentSsn() {
        return currentSsn;
    }

    public void setCurrentSsn(Long currentSsn) {
        this.currentSsn = currentSsn;
    }

    @Column(name = "ps_passport_id")
    public Long getPsPassportId() {
        return psPassportId;
    }

    public void setPsPassportId(Long psPassportId) {
        this.psPassportId = psPassportId;
    }

    @Column(name = "ssn")
    public Long getSsn() {
        return ssn;
    }

    public void setSsn(Long ssn) {
        this.ssn = ssn;
    }

    @Column(name = "full_title")
    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    @Column(name = "is_function")
    public Boolean getFunction() {
        return isFunction;
    }

    public void setFunction(Boolean function) {
        isFunction = function;
    }

    @Column(name = "organization_id")
    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    @Column(name = "creation_date")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "start_published_date")
    public LocalDate getStartPublishedDate() {
        return startPublishedDate;
    }

    public void setStartPublishedDate(LocalDate startPublishedDate) {
        this.startPublishedDate = startPublishedDate;
    }

    @Column(name = "administrative_level")
    public String getAdministrativeLevel() {
        return administrativeLevel;
    }

    public void setAdministrativeLevel(String administrativeLevel) {
        this.administrativeLevel = administrativeLevel;
    }

    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
