package com.desmond.foreigntrade.dto;

import lombok.Data;

/**
 * @author presleyli
 * @date 2018/12/31 8:36 PM
 */
@Data
public class FeedbackDTO {
    private String guestName;
    private String guestEmail;
    private String products;
    private String guestMessage;

    private String country;
    private String guestCompany;

    private String phoneCountryCode;
    private String phoneAreaCode;
    private String phoneTelNum;

    private String faxCountryCode;
    private String faxAreaCode;
    private String faxTelNum;
}
