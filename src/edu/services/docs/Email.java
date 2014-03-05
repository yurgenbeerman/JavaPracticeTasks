package edu.services.docs;

/**
 * Created by Lena on 05.03.14.
 */
public class Email {
    String emailFromAddress;
    String emailToAddresses;
    String emailCCAddresses;
    String emailBCCAddresses;
    String emailText;
    String emailSendDate;

    public String getEmailFromAddress() {
        return emailFromAddress;
    }

    public void setEmailFromAddress(String emailFromAddress) {
        this.emailFromAddress = emailFromAddress;
    }

    public String getEmailToAddresses() {
        return emailToAddresses;
    }

    public void setEmailToAddresses(String emailToAddresses) {
        this.emailToAddresses = emailToAddresses;
    }

    public String getEmailCCAddresses() {
        return emailCCAddresses;
    }

    public void setEmailCCAddresses(String emailCCAddresses) {
        this.emailCCAddresses = emailCCAddresses;
    }

    public String getEmailBCCAddresses() {
        return emailBCCAddresses;
    }

    public void setEmailBCCAddresses(String emailBCCAddresses) {
        this.emailBCCAddresses = emailBCCAddresses;
    }

    public String getEmailText() {
        return emailText;
    }

    public void setEmailText(String emailText) {
        this.emailText = emailText;
    }

    public String getEmailSendDate() {
        return emailSendDate;
    }

    public void setEmailSendDate(String emailSendDate) {
        this.emailSendDate = emailSendDate;
    }
}
