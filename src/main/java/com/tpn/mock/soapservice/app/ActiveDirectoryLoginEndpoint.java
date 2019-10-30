package com.tpn.mock.soapservice.app;

import com.tpn.mock.soapservice.app.staff.StaffDetailForm;
import com.tpn.mock.soapservice.domain.repository.ActiveDirectoryUserRepository;
import com.tpn.mock.soapservice.wsdl.GetStaffDetailRequest;
import com.tpn.mock.soapservice.wsdl.GetStaffDetailResponse;
import com.tpn.mock.soapservice.wsdl.GetStaffFullDetailRequest;
import com.tpn.mock.soapservice.wsdl.GetStaffFullDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

@Endpoint
public class ActiveDirectoryLoginEndpoint {
    private static final String NAMESPACE_URI = "http://tempuri.org/patientservice/wsdl/";

    private ActiveDirectoryUserRepository activeDirectoryUserRepository;

    @Autowired
    public ActiveDirectoryLoginEndpoint(ActiveDirectoryUserRepository activeDirectoryUserRepository) {
        this.activeDirectoryUserRepository = activeDirectoryUserRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Get_staff_detail")
    @ResponsePayload
    public GetStaffDetailResponse getActiveDirectoryUser(
            @RequestPayload GetStaffDetailRequest request
    ) throws ParserConfigurationException, TransformerException {
        GetStaffDetailResponse response = new GetStaffDetailResponse();

        StaffDetailForm staffDetailForm = this.activeDirectoryUserRepository.obtainStaffDetailForm(
                request.getUserId(),
                request.getPasswordId()
        );


        /*
                <staff_detail>
                    <name>User TestName</name>
                    <role>S</role>
                </staff_detail>
        */

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("staff_detail");

        Element name = document.createElement("name");
        name.appendChild(document.createTextNode(staffDetailForm.getFirstName() + " " + staffDetailForm.getLastName()));

        Element role = document.createElement("role");
        role.appendChild(document.createTextNode("S"));

        root.appendChild(name);
        root.appendChild(role);


        document.appendChild(root);


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(writer));

        response.setResult(
                writer.getBuffer().toString()
        );

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Get_staff_fulldetail")
    @ResponsePayload
    public GetStaffFullDetailResponse getActiveDirectoryUserFull(
            @RequestPayload GetStaffFullDetailRequest request
    ) throws ParserConfigurationException, TransformerException {
        GetStaffFullDetailResponse response = new GetStaffFullDetailResponse();

        StaffDetailForm staffDetailForm = this.activeDirectoryUserRepository.obtainStaffDetailFormByUsername(
                request.getSCode().toString()
        );

        /*
            <stafffulldetail>
                <staff_id>990011</staff_id>
                <name>IPD User Test</name>
                <role>EXTN</role>
                <firstname>IPD User Test</firstname>
                <lastname/>
                <licencenumber/>
                <orgid>50000094</orgid>
                <pid>990011</pid>
                <startdate>2008-01-01</startdate>
                <enddate>9999-10-01</enddate>
                <statuscode>active</statuscode>
            </stafffulldetail>
*/

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();


        Element root = document.createElement("stafffulldetail");
        Element staffId = document.createElement("staff_id");
        staffId.appendChild(document.createTextNode(staffDetailForm.getUsername()));
        root.appendChild(staffId);

        Element name = document.createElement("name");
        name.appendChild(document.createTextNode(staffDetailForm.getFirstName() + " " + staffDetailForm.getLastName()));
        root.appendChild(name);

        Element role = document.createElement("role");
        role.appendChild(document.createTextNode(staffDetailForm.getRole()));
        root.appendChild(role);

        Element fName = document.createElement("firstname");
        fName.appendChild(document.createTextNode(staffDetailForm.getFirstName()));
        root.appendChild(fName);

        Element lName = document.createElement("lastname");
        lName.appendChild(document.createTextNode(staffDetailForm.getLastName()));
        root.appendChild(lName);

        Element license = document.createElement("licencenumber");
        license.appendChild(document.createTextNode(staffDetailForm.getLicenseNumber()));
        root.appendChild(license);

        Element orgId = document.createElement("orgid");
        orgId.appendChild(document.createTextNode(staffDetailForm.getOrgID()));
        root.appendChild(orgId);

        Element pId = document.createElement("pid");
        pId.appendChild(document.createTextNode(staffDetailForm.getUsername()));
        root.appendChild(pId);

        Element startDate = document.createElement("startdate");
        startDate.appendChild(document.createTextNode(staffDetailForm.getStartDate().toString()));
        root.appendChild(startDate);

        Element endDate = document.createElement("enddate");
        endDate.appendChild(document.createTextNode(staffDetailForm.getEndDate().toString()));
        root.appendChild(endDate);

        Element statusCode = document.createElement("statuscode");
        endDate.appendChild(document.createTextNode(staffDetailForm.getStatusCode()));
        root.appendChild(statusCode);


        document.appendChild(root);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(writer));

        response.setResult(
                writer.getBuffer().toString()
        );

        return response;

    }

}
