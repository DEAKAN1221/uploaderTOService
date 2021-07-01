package ru.liga.uploader.entity;

import ru.liga.uploader.ContentType;
import ru.liga.uploader.MessageType;

import javax.persistence.*;


@Entity
@Table(schema = "si", name = "files")
@SequenceGenerator(name = "files_s", sequenceName = "si.files_s", allocationSize = 1)
public class EventFile extends BusinessEntity<Long> {
    private Event event;
    private MessageType messageType;
    private ContentType contentType;
    private String fileName;
    private Long number;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "files_s")
    @Column(name = "file_id", nullable = false)
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

    @Column(name = "message_type")
    @Enumerated(value = EnumType.STRING)
    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    @Column(name = "content_type")
    @Enumerated(value = EnumType.STRING)
    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Column(name = "seq_num")
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
