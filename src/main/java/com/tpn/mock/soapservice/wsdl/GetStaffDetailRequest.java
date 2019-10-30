package com.tpn.mock.soapservice.wsdl;

import lombok.Data;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = ""
        , propOrder = {
                "userId", "passwordId"
        }
)
@XmlRootElement(name = "Get_staff_detail")
@Data
public class GetStaffDetailRequest {

    @XmlElement(name = "user_id", namespace = "", required = true)
    protected String userId;
    @XmlElement(name = "password_id", namespace = "", required = true)
    protected String passwordId;


}