package ru.liga.uploader;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDateTime;

public class MessageIdentityInfo implements Serializable {
    private static final long serialVersionUID = -6511012183983913708L;

    private String messageID;
    private String referenceMessageID;
    private String originalMessageId;

    private LocalDateTime eol;
    private boolean testMessage = false;

    private MessageType messageType = MessageType.REQUEST;
    private String nodeId;

    private String replyTo;

    public MessageIdentityInfo() {
        super();
    }

    public MessageIdentityInfo(MessageType messageType) {
        setMessageType(messageType);
    }

    @XmlElement(name = "message-id")
    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    @XmlElement(name = "reference-message-id")
    public String getReferenceMessageID() {
        return referenceMessageID;
    }

    public void setReferenceMessageID(String referenceMessageID) {
        this.referenceMessageID = referenceMessageID;
    }

    @XmlElement(name = "original-message-id")
    public String getOriginalMessageId() {
        return originalMessageId;
    }

    public void setOriginalMessageId(String originalMessageId) {
        this.originalMessageId = originalMessageId;
    }

    @XmlElement(name = "eol")
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    public LocalDateTime getEol() {
        return eol;
    }

    public void setEol(LocalDateTime eol) {
        this.eol = eol;
    }

    @XmlElement(name = "test-message")
    public boolean isTestMessage() {
        return testMessage;
    }

    public void setTestMessage(boolean testMessage) {
        this.testMessage = testMessage;
    }

    @XmlElement(name = "message-type")
    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType type) {
        messageType = type;
    }

    @XmlElement(name = "node")
    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    @XmlElement(name = "reply-to")
    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
