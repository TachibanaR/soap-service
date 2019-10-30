package com.tpn.mock.soapservice.domain.repository;


import com.tpn.mock.soapservice.app.staff.StaffDetailForm;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class ActiveDirectoryUserRepository {

    private static final Map<String, StaffDetailForm> staffDetailFormMap = new HashMap<>();


    @PostConstruct
    public void initData() {
        StaffDetailForm staffDetailForm = new StaffDetailForm();
        staffDetailForm.setUsername("test");
        staffDetailForm.setPassword("1234");
        staffDetailForm.setFirstName("User");
        staffDetailForm.setLastName("TestName");
        staffDetailForm.setRole("S");
        staffDetailForm.setLicenseNumber("xxxx");
        staffDetailForm.setOrgID("1");
        staffDetailForm.setStatusCode("1");
        staffDetailForm.setStartDate(new Date());
        staffDetailForm.setEndDate(new Date());
        this.staffDetailFormMap.put(staffDetailForm.getUsername(), staffDetailForm);

        staffDetailForm = new StaffDetailForm();
        staffDetailForm.setUsername("0001");
        staffDetailForm.setPassword("1234");
        staffDetailForm.setFirstName("สมจ๋า");
        staffDetailForm.setLastName("ใจดี");
        staffDetailForm.setRole("S");
        staffDetailForm.setLicenseNumber("xxxx");
        staffDetailForm.setOrgID("1");
        staffDetailForm.setStatusCode("1");
        staffDetailForm.setStartDate(new Date());
        staffDetailForm.setEndDate(new Date());
        this.staffDetailFormMap.put(staffDetailForm.getUsername(), staffDetailForm);

        staffDetailForm = new StaffDetailForm();
        staffDetailForm.setUsername("0002");
        staffDetailForm.setPassword("1234");
        staffDetailForm.setFirstName("สมทิ้ว");
        staffDetailForm.setLastName("ดีใจ");
        staffDetailForm.setRole("S");
        staffDetailForm.setLicenseNumber("xxxx");
        staffDetailForm.setOrgID("1");
        staffDetailForm.setStatusCode("1");
        staffDetailForm.setStartDate(new Date());
        staffDetailForm.setEndDate(new Date());
        this.staffDetailFormMap.put(staffDetailForm.getUsername(), staffDetailForm);

        staffDetailForm = new StaffDetailForm();
        staffDetailForm.setUsername("0003");
        staffDetailForm.setPassword("1234");
        staffDetailForm.setFirstName("สมบอส");
        staffDetailForm.setLastName("ใจมาก");
        staffDetailForm.setRole("S");
        staffDetailForm.setLicenseNumber("xxxx");
        staffDetailForm.setOrgID("1");
        staffDetailForm.setStatusCode("1");
        staffDetailForm.setStartDate(new Date());
        staffDetailForm.setEndDate(new Date());
        this.staffDetailFormMap.put(staffDetailForm.getUsername(), staffDetailForm);

        staffDetailForm = new StaffDetailForm();
        staffDetailForm.setUsername("0004");
        staffDetailForm.setPassword("1234");
        staffDetailForm.setFirstName("สมบอย");
        staffDetailForm.setLastName("ใจมั่น");
        staffDetailForm.setRole("S");
        staffDetailForm.setLicenseNumber("xxxx");
        staffDetailForm.setOrgID("1");
        staffDetailForm.setStatusCode("1");
        staffDetailForm.setStartDate(new Date());
        staffDetailForm.setEndDate(new Date());
        this.staffDetailFormMap.put(staffDetailForm.getUsername(), staffDetailForm);

        staffDetailForm = new StaffDetailForm();
        staffDetailForm.setUsername("0005");
        staffDetailForm.setPassword("1234");
        staffDetailForm.setFirstName("สมจูน");
        staffDetailForm.setLastName("มั่นใจ");
        staffDetailForm.setRole("S");
        staffDetailForm.setLicenseNumber("xxxx");
        staffDetailForm.setOrgID("1");
        staffDetailForm.setStatusCode("1");
        staffDetailForm.setStartDate(new Date());
        staffDetailForm.setEndDate(new Date());
        this.staffDetailFormMap.put(staffDetailForm.getUsername(), staffDetailForm);
    }

    public StaffDetailForm obtainStaffDetailFormByUsername(String username) {
        StaffDetailForm staffDetailForm = this.staffDetailFormMap.get(username);
        return staffDetailForm;
    }

    public StaffDetailForm obtainStaffDetailForm(String username, String password) {
        StaffDetailForm staffDetailForm = this.staffDetailFormMap.get(username);
        StaffDetailForm clonedStaffDetailForm;

        if (password != null && staffDetailForm != null && staffDetailForm.getPassword() != null && password.equals(staffDetailForm.getPassword())) {
            clonedStaffDetailForm = new StaffDetailForm();

            clonedStaffDetailForm.setUsername(staffDetailForm.getUsername());
            clonedStaffDetailForm.setPassword("[ʕ•̫͡•ʕ•̫͡•ʔ•̫͡•ʔ ~ PROTECTED ~ ʕ•̫͡•ʕ•̫͡•ʔ•̫͡•ʔ]");
            clonedStaffDetailForm.setFirstName(staffDetailForm.getFirstName());
            clonedStaffDetailForm.setLastName(staffDetailForm.getLastName());
        } else {
            clonedStaffDetailForm = null;
        }

        return clonedStaffDetailForm;
    }

}