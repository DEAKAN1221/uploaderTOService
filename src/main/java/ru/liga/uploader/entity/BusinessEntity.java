package ru.liga.uploader.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BusinessEntity<Id extends Serializable> extends CoreEntity<Id> {
    private final static String DEFAULT_USER = "wcsuser";

    private String createdBy;
    private LocalDateTime creationDate;
    private String lastUpdatedBy;
    private LocalDateTime lastUpdateDate;

    @Column(name = "created_by")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "creation_date")
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "last_updated_by")
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Column(name = "last_update_date")
    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

//    @PrePersist
//    public void prePersist() {
//        this.creationDate = LocalDateTime.now();
//        this.lastUpdateDate = this.creationDate;
//
//        this.createdBy = findCurrentUser();
//        this.lastUpdatedBy = this.createdBy;
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        this.lastUpdateDate = LocalDateTime.now();
//        this.lastUpdatedBy = findCurrentUser();
//    }

//    private String findCurrentUser() {
//        String user = null;
//        if (SecurityContextHolder.getContext().getAuthentication() != null) {
//            UserDetails userDetails = null;
//            if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails) {
//                userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            }
//            user = userDetails != null ? userDetails.getUsername() : null;
//        }
//        return user == null ? DEFAULT_USER : user;
//    }
}
