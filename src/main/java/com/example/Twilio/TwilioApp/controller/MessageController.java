package com.example.Twilio.TwilioApp.controller;

import com.example.Twilio.TwilioApp.dto.SmsDTO;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MessageController {

    public static final String ACCOUNT_SID = "account-sid";
    public static final String AUTH_TOKEN = "authtoken";

    @RequestMapping(value ="/sendSms" ,method = RequestMethod.POST)
    public void sendSms(@Validated SmsDTO smsDto, BindingResult bindingResults){
        if(bindingResults.hasErrors()){
            System.out.println("Exception is ==>"+bindingResults.toString());
        }
        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                    new PhoneNumber(smsDto.getPhoneNumber()),  // To number
                    new PhoneNumber("+XXXXXXXX"),  // From number
                    smsDto.getMsg()                    // SMS body
            ).create();
            System.out.println("Message sent successfully");
        }catch (Exception ex){
            System.out.println("Error in sending message is=="+ex.getMessage());
        }
    }

}
