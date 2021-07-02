package ru.liga.uploader;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "service-response")
public class ExchangeServiceResponse extends ExchangeClientRequest {
    private static final long serialVersionUID = -6796388956092695529L;

    private Long parentEventId;
    private String rejectFileName;

    public ExchangeServiceResponse() {
        super();
    }

    @XmlElement(name = "parent-event-id")
    public Long getParentEventId() {
        return parentEventId;
    }

    public void setParentEventId(Long parentEventId) {
        this.parentEventId = parentEventId;
    }

    public boolean isRejected() {
        return !StringUtils.isEmpty(this.getRejectFileName());
    }

    @XmlElement(name = "reject-file")
    public String getRejectFileName() {
        return rejectFileName;
    }

    public void setRejectFileName(String rejectFileName) {
        this.rejectFileName = rejectFileName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
