package edu.services.docs;

import edu.clients.Requester;
import edu.services.orgs.PublicService;
import edu.services.servants.PublicServant;

/**
 * Created by Yuri Pyvovarenko on 05.03.14.
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
        this.isFinalized = true;
        requester.addResponse(this);
    }

    public long getInitiatingDocId() {
        return initiatingDocId;
    }

    public void setInitiatingDocId(long initiatingDocId) {
        if (!isFinalized) {
            this.initiatingDocId = initiatingDocId;
        }
    }

    /* IMPORTANT! Each setter (modifier method) body must be enclosed by "if (!isFinalized) {}" ! */
}
