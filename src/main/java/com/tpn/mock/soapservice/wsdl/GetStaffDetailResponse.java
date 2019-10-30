package com.tpn.mock.soapservice.wsdl;

import lombok.Data;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = ""
        , propOrder = {"Result"}
)
@XmlRootElement(name = "Get_staff_detailResponse")
@Data
public class GetStaffDetailResponse {

    @XmlElement(required = true)
    protected String Result;


}