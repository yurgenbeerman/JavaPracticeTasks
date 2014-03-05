package edu.services.docs;

import edu.clients.Requester;
import edu.services.orgs.PublicService;
import edu.services.servants.PublicServant;

import java.util.GregorianCalendar;

/**
 * Created by Lena on 05.03.14.
 */

public class OutcomingDocument extends OrganizationDocument {
    private long initiatingDocId;
    /* TODO implement reply sending via Email and Post */
    /*
    private Email outcomingDocSentEmail;
    private String outcomingDocSentAddress;
    private GregorianCalendar outcomingDocSentAddressDate;
    */

    public OutcomingDocument(PublicServant informationResponsibleServant, PublicService publicService) {

    }

    public void publishToRequester(Requester requester) {

        OutcomingDocument response = this;//this.clone(); //TODO implement clone() for OutcomingDocument
        requester.addResponse(response);
    }

    public long getInitiatingDocId() {
        return initiatingDocId;
    }

    public void setInitiatingDocId(long initiatingDocId) {
        this.initiatingDocId = initiatingDocId;
    }
}
