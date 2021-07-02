package ru.liga.uploader;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "request")
public class ExchangeClientRequest implements Serializable {
    private static final long serialVersionUID = -7080018022142867462L;

    private Long id;

    private UserInfo userInfo;
    private SourceEntityInfo sourceEntityInfo;

    private SenderInfo senderInfo;
    private TransactionInfo trxInfo;

    private BusinessProcessMetaData businessProcessMetaData;

    private MessageIdentityInfo miInfo;

    private SignatureInfo signatureInfo;

    private String mpcFileName;
    private List<String> attachFileNameList = new ArrayList<>();

    private boolean ftp = false;
    private boolean mtom = false;

    public ExchangeClientRequest() {
        super();
    }

    @XmlElement(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "user")
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @XmlElement(name = "source")
    public SourceEntityInfo getSourceEntityInfo() {
        return sourceEntityInfo;
    }

    public void setSourceEntityInfo(SourceEntityInfo sourceEntityInfo) {
        this.sourceEntityInfo = sourceEntityInfo;
    }

    @XmlElement(name = "identity")
    public MessageIdentityInfo getMessageIdentityInfo() {
        return miInfo;
    }

    public void setMessageIdentityInfo(MessageIdentityInfo miInfo) {
        this.miInfo = miInfo;
    }

    @XmlElement(name = "sender")
    public SenderInfo getSenderInfo() {
        return senderInfo;
    }

    public void setSenderInfo(SenderInfo senderInfo) {
        this.senderInfo = senderInfo;
    }

    @XmlElement(name = "transaction")
    public TransactionInfo getTransactionInfo() {
        return trxInfo;
    }

    public void setTransactionInfo(TransactionInfo trxInfo) {
        this.trxInfo = trxInfo;
    }

    @XmlElement(name = "business-process-metadata")
    public BusinessProcessMetaData getBusinessProcessMetaData() {
        return businessProcessMetaData;
    }

    public void setBusinessProcessMetaData(BusinessProcessMetaData businessProcessMetaData) {
        this.businessProcessMetaData = businessProcessMetaData;
    }

    @XmlElement(name = "signature")
    public SignatureInfo getSignatureInfo() {
        return signatureInfo;
    }

    public void setSignatureInfo(SignatureInfo signatureInfo) {
        this.signatureInfo = signatureInfo;
    }

    @XmlElement(name = "content")
    public String getContentFileName() {
        return mpcFileName;
    }

    public void setContentFileName(String mpcFileName) {
        this.mpcFileName = mpcFileName;
    }

    @XmlElementWrapper(name = "attachments")
    @XmlElement(name = "attachment")
    public List<String> getAttachFileNameList() {
        return attachFileNameList;
    }

    public void setAttachFileNameList(List<String> attachFileNameList) {
        this.attachFileNameList = attachFileNameList;
    }

    public boolean hasContent() {
        return (this.getContentFileName() != null && !"".equals(this.getContentFileName().trim()) ? true : false);
    }

    public Boolean hasAttachments() {
        return (this.getAttachFileNameList() != null && !this.getAttachFileNameList().isEmpty());
    }

    @XmlElement(name = "ftp-attach")
    public boolean isFtp() {
        return ftp;
    }

    public void setFtp(boolean ftp) {
        this.mtom = false;
        this.ftp = ftp;
    }

    @XmlElement(name = "mtom-attach")
    public boolean isMtom() {
        this.ftp = false;
        return mtom;
    }

    public void setMtom(boolean mtom) {
        this.mtom = mtom;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}