package ru.liga.uploader;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

public class SenderInfo implements Serializable {
    private static final long serialVersionUID = 4644411149583194921L;

    public static final String MVD_SENDER_CODE = "MVDR11001";        // МВД. мнемоника ИС отправителя
    public static final String MVD_PARTICIPANT_CODE = "10000001197"; // МВД. код ФРГУ  ИС отправителя
    public static final String RGD_SENDER_CODE = "043P01_3T";        // РосГвардия. мнемоника ИС отправителя / test
//    public static final String RGD_SENDER_CODE = "043P01_3S";        // РосГвардия. мнемоника ИС отправителя / prod
    public static final String RGD_PARTICIPANT_CODE = "327708301";   // РосГвардия. код ФРГУ  ИС отправителя
//    public static final String RGD_PARTICIPANT_CODE = "00000000000000000000"; // РосГвардия. код ФРГУ ИС отправителя

    public static final String DEFAULT_SENDER_CODE = MVD_SENDER_CODE;

    private String senderCode = DEFAULT_SENDER_CODE;
    private String frguParticipantCode;

    public SenderInfo() {
        this(DEFAULT_SENDER_CODE);
    }

    public SenderInfo(String senderCode) {
        setSender(senderCode);
    }

    @XmlElement(name = "sender-code")
    public String getSenderCode() {
        return senderCode;
    }

    public void setSender(String code) {
        this.senderCode = code;

        if (MVD_SENDER_CODE.equals(getSenderCode())) {
            this.frguParticipantCode = MVD_PARTICIPANT_CODE;
        } else if (RGD_SENDER_CODE.equals(getSenderCode())) {
            this.frguParticipantCode = RGD_PARTICIPANT_CODE;
        } else {
            this.frguParticipantCode = null;
        }

    }

    @XmlElement(name = "frgu")
    public String getFrguParticipantCode() {
        return frguParticipantCode;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }

}
