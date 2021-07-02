package ru.liga.uploader;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

public class SignatureInfo implements Serializable {
    private Boolean signContent;
    private String signElement;

    public SignatureInfo() {
        super();
    }

    @XmlElement(name = "sign-content")
    public Boolean getSignContent() {
        return signContent;
    }

    public void setSignContent(Boolean signContent) {
        this.signContent = signContent;
    }

    public Boolean needSignContent() {
        return signContent == null ? false : signContent;
    }

    @XmlElement(name = "sign-element")
    public String getSignElement() {
        return signElement;
    }

    public void setSignElement(String signElement) {
        this.signElement = signElement;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
