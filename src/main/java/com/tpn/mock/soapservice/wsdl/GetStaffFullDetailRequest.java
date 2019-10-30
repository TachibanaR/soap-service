package com.tpn.mock.soapservice.wsdl;

import lombok.Data;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = ""
        , propOrder = {
                "sCode"
        }
)
@XmlRootElement(name = "Get_staff_fulldetail")
@Data
public class GetStaffFullDetailRequest {

    @XmlElement(name = "sCode", namespace = "", required = true)
    protected String sCode;


}