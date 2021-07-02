package ru.liga.uploader;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "service-request")
public class ExchangeServiceRequest implements Serializable {
    private static final long serialVersionUID = -4567811234359846864L;

    private Long id;
    private Long requestTypeId;
    private Long requestSubtypeId;

    private MessageIdentityInfo miInfo;
    private TransactionInfo trxInfo;

    private XMLGregorianCalendar requestDate;

    private BusinessProcessMetaData businessProcessMetaData;

    private String contentFileName;
    private List<String> attachFileNameList = new ArrayList<>();

    private boolean ownService;

    public ExchangeServiceRequest() {
        super();
    }

    @XmlElement(name = "event-id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "request-type-id")
    public Long getRequestTypeId() {
        return requestTypeId;
    }

    public void setRequestTypeId(Long requestTypeId) {
        this.requestTypeId = requestTypeId;
    }

    @XmlElement(name = "request-subtype-id")
    public Long getRequestSubtypeId() {
        return requestSubtypeId;
    }

    public void setRequestSubtypeId(Long requestSubtypeId) {
        this.requestSubtypeId = requestSubtypeId;
    }

    @XmlElement(name = "identity")
    public MessageIdentityInfo getMessageIdentityInfo() {
        return miInfo;
    }

    public void setMessageIdentityInfo(MessageIdentityInfo miInfo) {
        this.miInfo = miInfo;
    }

    @XmlElement(name = "transaction")
    public TransactionInfo getTransactionInfo() {
        return trxInfo;
    }

    public void setTransactionInfo(TransactionInfo trxInfo) {
        this.trxInfo = trxInfo;
    }

    @XmlElement(name = "content")
    public String getContentFileName() {
        return contentFileName;
    }

    public void setContentFileName(String contentFileName) {
        this.contentFileName = contentFileName;
    }

    public boolean hasAttachments() {
        return (this.getAttachFileNameList() != null && !this.getAttachFileNameList().isEmpty());
    }

    @XmlElement(name = "request-date")
    public XMLGregorianCalendar getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(XMLGregorianCalendar requestDate) {
        this.requestDate = requestDate;
    }

    @XmlElement(name = "business-process-metadata")
    public BusinessProcessMetaData getBusinessProcessMetaData() {
        return businessProcessMetaData;
    }

    public void setBusinessProcessMetaData(BusinessProcessMetaData businessProcessMetaData) {
        this.businessProcessMetaData = businessProcessMetaData;
    }

    @XmlElementWrapper(name = "attachments")
    @XmlElement(name = "attachment")
    public List<String> getAttachFileNameList() {
        return attachFileNameList;
    }

    public void setAttachFileNameList(List<String> attachFileNameList) {
        this.attachFileNameList = attachFileNameList;
    }

    @XmlElement(name = "own-service")
    public boolean isOwnService() {
        return ownService;
    }

    public void setOwnService(boolean ownService) {
        this.ownService = ownService;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
