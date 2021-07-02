package ru.liga.uploader;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "business-process-metadata")
public class BusinessProcessMetaData {
    private String caseNumber;
    private ServiceOrFunctionType serviceOrFunction;
    private String serviceOrFunctionCode;

    @XmlElement(name = "case-number")
    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    @XmlElement(name = "service-or-function")
    public ServiceOrFunctionType getServiceOrFunction() {
        return serviceOrFunction;
    }

    public void setServiceOrFunction(ServiceOrFunctionType serviceOrFunction) {
        this.serviceOrFunction = serviceOrFunction;
    }

    @XmlElement(name = "service-or-function-code")
    public String getServiceOrFunctionCode() {
        return serviceOrFunctionCode;
    }

    public void setServiceOrFunctionCode(String serviceOrFunctionCode) {
        this.serviceOrFunctionCode = serviceOrFunctionCode;
    }
}
