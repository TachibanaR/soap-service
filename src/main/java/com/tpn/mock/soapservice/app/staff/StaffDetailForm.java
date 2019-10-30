package com.tpn.mock.soapservice.app.staff;

import lombok.Data;

import java.util.Date;

@Data
public class StaffDetailForm {

    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String licenseNumber;
    private String role;
    private String OrgID;
    private Date startDate;
    private Date endDate;

    private String statusCode;



}
