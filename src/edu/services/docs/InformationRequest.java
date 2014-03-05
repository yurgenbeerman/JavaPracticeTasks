package edu.services.docs;

/**
 * Created by Lena on 05.03.14.
 */
public class InformationRequest extends IncomingDocument {
    String informationRequestText;
    String addressForReply;
    String emailForReply;

    public String getInformationRequestText() {
        return informationRequestText;
    }

    public void setInformationRequestText(String informationRequestText) {
        this.informationRequestText = informationRequestText;
    }

}
