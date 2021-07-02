package ru.liga.uploader;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = 2585318003253295801L;

    private Long employeeId;
    private String login;
    private Long organizationId;

    @XmlElement(name = "employee-id")
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long userId) {
        this.employeeId = userId;
    }

    @XmlElement(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @XmlElement(name = "organization-id")
    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
