package com.example.sharedperfdemo;

import java.io.Serializable;

public class Contacts implements Serializable {
    private String cName;
    private String cEmail;

    public Contacts(String cName, String cEmail, String cPhoneNo) {
        this.cName = cName;
        this.cEmail = cEmail;
        this.cPhoneNo = cPhoneNo;
    }

    private String cPhoneNo;


    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcPhoneNo() {
        return cPhoneNo;
    }

    public void setcPhoneNo(String cPhoneNo) {
        this.cPhoneNo = cPhoneNo;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "cName='" + cName + '\'' +
                ", cEmail='" + cEmail + '\'' +
                ", cPhoneNo='" + cPhoneNo + '\'' +
                '}';
    }
}
