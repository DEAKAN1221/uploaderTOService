package ru.liga.uploader.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ru.liga.uploader.EventDirection;
import ru.liga.uploader.EventStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(schema = "si", name = "events")
@SequenceGenerator(name = "events_s", sequenceName = "si.events_s", allocationSize = 1)
public class Event extends BusinessEntity<Long> {
    private LocalDateTime eventTime;
    private EventDirection direction;
    private RequestSubtype requestSubtype;
    private String externalMessageId;
    private EventStatus status;
    private String sourceEntity;
    private Long sourceEntityId;
    private Long organizationId;
    private Boolean rejected;
    private String transactionCode;
    private Long errorCode;
    private String errorDesc;
    private Long parentEventId;
    private String replyTo;
    private String nodeId;

    private List<Message> messages;
    private List<EventAnswer> answers;
    private List<EventFile> files;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "events_s")
    @Column(name = "event_id", nullable = false)
    @Override
    public Long getId() {
        return super.getId();
    }

    @Column(name = "event_time")
    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }

    @Column(name = "event_direction")
    @Enumerated(value = EnumType.STRING)
    public EventDirection getDirection() {
        return direction;
    }

    public void setDirection(EventDirection direction) {
        this.direction = direction;
    }

    @Column(name = "external_message_id")
    public String getExternalMessageId() {
        return externalMessageId;
    }

    public void setExternalMessageId(String externalMessageId) {
        this.externalMessageId = externalMessageId;
    }

    @Column(name = "transaction_code")
    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    @Column(name = "source_entity")
    public String getSourceEntity() {
        return sourceEntity;
    }

    public void setSourceEntity(String sourceEntity) {
        this.sourceEntity = sourceEntity;
    }

    @Column(name = "source_entity_id")
    public Long getSourceEntityId() {
        return sourceEntityId;
    }

    public void setSourceEntityId(Long sourceEntityId) {
        this.sourceEntityId = sourceEntityId;
    }

    @Column(name = "organization_id")
    public Long getOrganization() {
        return organizationId;
    }

    public void setOrganization(Long organizationId) {
        this.organizationId = organizationId;
    }

    @Column(name = "rejected_flag")
    public Boolean isRejected() {
        return rejected;
    }

    public void setRejected(Boolean rejected) {
        this.rejected = rejected;
    }

    @Column(name = "error_code")
    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    @Column(name = "error_desc")
    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    @Column(name = "parent_event_id")
    public Long getParentEventId() {
        return parentEventId;
    }

    public void setParentEventId(Long parentEventId) {
        this.parentEventId = parentEventId;
    }

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    @OrderBy("id")
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    @OrderBy("id")
    public List<EventAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<EventAnswer> answers) {
        this.answers = answers;
    }

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    public List<EventFile> getFiles() {
        return files;
    }

    public void setFiles(List<EventFile> files) {
        this.files = files;
    }

    @ManyToOne
    @JoinColumn(name = "request_subtype_id")
    public RequestSubtype getRequestSubtype() {
        return requestSubtype;
    }

    public void setRequestSubtype(RequestSubtype requestSubtype) {
        this.requestSubtype = requestSubtype;
    }

    @Column(name = "reply_to")
    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    @Column(name = "node_id")
    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }


}
