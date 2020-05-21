package ru.liga.uploader.entity;


import javax.persistence.*;

@Entity
@Table(schema = "migration", name = "weapons_tmp")
@SequenceGenerator(schema = "migration", name = "weapons_tmp_s", sequenceName = "migration.weapons_tmp_s", allocationSize = 1)
public class WeaponEntity {

    private Long id;
    private String weaponsName;
    private String series;
    private String weaponNumber;
    private String makeYear;
    private String category;
    private String storagePlace;
    private String organizationName;
    private String ownerRank;
    private String ownerName;
    private String safe;
    private String cell;
    private String note;
    private String receiptCategory;
    private String senderOrganization;
    private String documentKind;
    private String documentNumber;
    private String documentDate;
    private String koActNumber;
    private Long organizationId;
    private String sectionType;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "weapons_tmp_s")
    @Column(name = "id", nullable = false, columnDefinition = "serial")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "weapons_name")
    public String getWeaponsName() {
        return weaponsName;
    }

    public void setWeaponsName(String weaponsName) {
        this.weaponsName = weaponsName;
    }

    @Column(name = "series", nullable = true)
    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Column(name = "weapon_number", nullable = true)
    public String getWeaponNumber() {
        return weaponNumber;
    }

    public void setWeaponNumber(String weaponNumber) {
        this.weaponNumber = weaponNumber;
    }

    @Column(name = "make_year", nullable = true)
    public String getMakeYear() {
        return makeYear;
    }

    public void setMakeYear(String makeYear) {
        this.makeYear = makeYear;
    }

    @Column(name = "category", nullable = true)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name = "storage_place", nullable = true)
    public String getStoragePlace() {
        return storagePlace;
    }

    public void setStoragePlace(String storagePlace) {
        this.storagePlace = storagePlace;
    }

    @Column(name = "organization_name", nullable = true)
    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    @Column(name = "owner_rank", nullable = true)
    public String getOwnerRank() {
        return ownerRank;
    }

    public void setOwnerRank(String ownerRank) {
        this.ownerRank = ownerRank;
    }

    @Column(name = "owner_name", nullable = true)
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Column(name = "safe", nullable = true)
    public String getSafe() {
        return safe;
    }

    public void setSafe(String safe) {
        this.safe = safe;
    }

    @Column(name = "cell", nullable = true)
    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    @Column(name = "note", nullable = true)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "receiptCategory", nullable = true)
    public String getReceiptCategory() {
        return receiptCategory;
    }

    public void setReceiptCategory(String receiptCategory) {
        this.receiptCategory = receiptCategory;
    }

    @Column(name = "sender_organization", nullable = true)
    public String getSenderOrganization() {
        return senderOrganization;
    }


    public void setSenderOrganization(String senderOrganization) {
        this.senderOrganization = senderOrganization;
    }

    @Column(name = "document_kind", nullable = true)
    public String getDocumentKind() {
        return documentKind;
    }

    public void setDocumentKind(String documentKind) {
        this.documentKind = documentKind;
    }

    @Column(name = "document_number", nullable = true)
    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Column(name = "document_date", nullable = true)
    public String getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;
    }

    @Column(name = "ko_act_number", nullable = true)
    public String getKoActNumber() {
        return koActNumber;
    }

    public void setKoActNumber(String koActNumber) {
        this.koActNumber = koActNumber;
    }

    @Column(name = "organization_id", nullable = false)
    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    @Column(name = "section_type", nullable = false)
    public String getSectionType() {
        return sectionType;
    }

    public void setSectionType(String sectionType) {
        this.sectionType = sectionType;
    }

}
