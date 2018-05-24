package com.example.Twilio.TwilioApp.dto;

import javax.validation.constraints.NotNull;

public class SmsDTO {

    @NotNull(message = "Please provide phone number")
    String phoneNumber;

    @NotNull(message = "Please provide message")
    String msg;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
