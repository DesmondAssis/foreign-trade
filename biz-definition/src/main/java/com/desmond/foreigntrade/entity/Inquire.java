package com.desmond.foreigntrade.entity;

import java.util.Date;

public class Inquire {
    private Integer id;

    private String guestName;

    private String guestEmail;

    private String guestMessage;

    private String country;

    private String guestCompany;

    private String phoneCountryCode;

    private String phoneAreaCode;

    private String phoneTelNum;

    private String faxCountryCode;

    private String faxAreaCode;

    private String faxTelNum;

    private Boolean sendMail;

    private Date createTime;

    private Date updateTime;

    private Integer delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName == null ? null : guestName.trim();
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail == null ? null : guestEmail.trim();
    }

    public String getGuestMessage() {
        return guestMessage;
    }

    public void setGuestMessage(String guestMessage) {
        this.guestMessage = guestMessage == null ? null : guestMessage.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getGuestCompany() {
        return guestCompany;
    }

    public void setGuestCompany(String guestCompany) {
        this.guestCompany = guestCompany == null ? null : guestCompany.trim();
    }

    public String getPhoneCountryCode() {
        return phoneCountryCode;
    }

    public void setPhoneCountryCode(String phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode == null ? null : phoneCountryCode.trim();
    }

    public String getPhoneAreaCode() {
        return phoneAreaCode;
    }

    public void setPhoneAreaCode(String phoneAreaCode) {
        this.phoneAreaCode = phoneAreaCode == null ? null : phoneAreaCode.trim();
    }

    public String getPhoneTelNum() {
        return phoneTelNum;
    }

    public void setPhoneTelNum(String phoneTelNum) {
        this.phoneTelNum = phoneTelNum == null ? null : phoneTelNum.trim();
    }

    public String getFaxCountryCode() {
        return faxCountryCode;
    }

    public void setFaxCountryCode(String faxCountryCode) {
        this.faxCountryCode = faxCountryCode == null ? null : faxCountryCode.trim();
    }

    public String getFaxAreaCode() {
        return faxAreaCode;
    }

    public void setFaxAreaCode(String faxAreaCode) {
        this.faxAreaCode = faxAreaCode == null ? null : faxAreaCode.trim();
    }

    public String getFaxTelNum() {
        return faxTelNum;
    }

    public void setFaxTelNum(String faxTelNum) {
        this.faxTelNum = faxTelNum == null ? null : faxTelNum.trim();
    }

    public Boolean getSendMail() {
        return sendMail;
    }

    public void setSendMail(Boolean sendMail) {
        this.sendMail = sendMail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}