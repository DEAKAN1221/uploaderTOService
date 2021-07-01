package ru.liga.uploader.entity;

import ru.liga.uploader.MessageType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = "si", name = "messages")
@SequenceGenerator(name = "messages_s", sequenceName = "si.messages_s", allocationSize = 1)
public class Message extends BusinessEntity<Long> {
    private MessageType messageType;
    private Event event;
    private String messageId;
    private String status;
    private String statusDesc;
    private String sender;
    private LocalDateTime sendingTime;
    private String recipient;
    private LocalDateTime deliveryTime;
    private String destination;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messages_s")
    @Column(name = "message_id", nullable = false)
    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "message_type")
    @Enumerated(value = EnumType.STRING)
    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType type) {
        this.messageType = type;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "event_id")
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Column(name = "external_message_id")
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "status_desc")
    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    @Column(name = "sender")
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Column(name = "sending_time")
    public LocalDateTime getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(LocalDateTime sendingTime) {
        this.sendingTime = sendingTime;
    }

    @Column(name = "recipient")
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Column(name = "delivery_time")
    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Column(name = "destination_name")
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
