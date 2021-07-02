package ru.liga.uploader;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.util.List;

public class StatusInfo implements Serializable {
    private static final long serialVersionUID = -1623469154630067225L;

    private boolean isProcessed = false;
    private boolean isCompleted = false;

    private Long errorCode = 0L;
    private String errorMessage;

    private boolean isRejected = false;
    private String rejectFileName;
    private List<RejectInfo> rejectList;

    public StatusInfo() {
        super();
    }

    @XmlElement(name = "processed")
    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean isProcessed) {
        this.isProcessed = isProcessed;
    }

    @XmlElement(name = "completed")
    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public boolean hasErrors() {
        return this.getErrorCode() != 0L;
    }

    @XmlElement(name = "error-code")
    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    @XmlElement(name = "error-message")
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @XmlElement(name = "rejected")
    public boolean isRejected() {
        return isRejected;
    }

    public void setRejected(boolean isRejected) {
        this.isRejected = isRejected;
    }

    @XmlElement(name = "reject-file")
    public String getRejectFileName() {
        return rejectFileName;
    }

    public void setRejectFileName(String rejectFileName) {
        this.rejectFileName = rejectFileName;
    }

    @XmlElementWrapper(name = "reject-list")
    public List<RejectInfo> getRejectList() {
        return rejectList;
    }

    public void setRejectList(List<RejectInfo> rejectList) {
        this.rejectList = rejectList;
    }
}
