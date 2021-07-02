package ru.liga.uploader;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

public class TransactionInfo implements Serializable {
    private static final long serialVersionUID = -900919884082356956L;

    private String transactionCode;
    private String frguServiceCode;
    private String frguServiceDesc;
    private String frguRecipientDesc;

    public TransactionInfo() {
        super();
    }

    @XmlElement(name = "transaction-code")
    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    @XmlElement(name = "frgu-service-code")
    public String getFrguServiceCode() {
        return frguServiceCode;
    }

    public void setFrguServiceCode(String frguServiceCode) {
        this.frguServiceCode = frguServiceCode;
    }

    @XmlElement(name = "frgu-service-desc")
    public String getFrguServiceDesc() {
        return frguServiceDesc;
    }

    public void setFrguServiceDesc(String frguServiceDesc) {
        this.frguServiceDesc = frguServiceDesc;
    }

    @XmlElement(name = "frgu-recipient-desc")
    public String getFrguRecipientDesc() {
        return frguRecipientDesc;
    }

    public void setFrguRecipientDesc(String frguRecipientDesc) {
        this.frguRecipientDesc = frguRecipientDesc;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
