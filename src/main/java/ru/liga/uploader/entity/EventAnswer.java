package ru.liga.uploader.entity;

import ru.liga.uploader.AnswerStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = "si", name = "event_answers")
@SequenceGenerator(name = "event_answers_s", sequenceName = "si.event_answers_s", allocationSize = 1)
public class EventAnswer extends BusinessEntity<Long> {
    private Event event;
    private String sourceEntity;
    private Long sourceEntityId;
    private String messageId;
    private RequestSubtype requestSubtype;
    private LocalDateTime statusDate;
    private AnswerStatus status;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_answers_s")
    @Column(name = "event_answer_id", nullable = false)
    @Override
    public Long getId() {
        return super.getId();
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "event_id")
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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

    @Column(name = "external_message_id")
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @ManyToOne
    @JoinColumn(name = "request_subtype_id")
    public RequestSubtype getRequestSubtype() {
        return requestSubtype;
    }

    public void setRequestSubtype(RequestSubtype requestSubtype) {
        this.requestSubtype = requestSubtype;
    }

    @Column(name = "status_date")
    public LocalDateTime getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(LocalDateTime statusDate) {
        this.statusDate = statusDate;
    }

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    public AnswerStatus getStatus() {
        return status;
    }

    public void setStatus(AnswerStatus status) {
        this.status = status;
    }
}
