package edu.services.docs;

import edu.clients.Requester;
import edu.services.orgs.PublicService;
import edu.services.servants.PublicServant;

/**
 * Created by yurii.pyvovarenko on 05.03.14.
 */

public class OutcomingDocument extends OrganizationDocument {
    private long initiatingDocId;
    private OrganizationDocument initiatingDocument;
    /* TODO implement reply sending via Email and Post */
    /*
    private Email outcomingDocSentEmail;
    private String outcomingDocSentAddress;
    private GregorianCalendar outcomingDocSentAddressDate;
    */

    public OutcomingDocument(DocumentType documentType, PublicServant publicServant, PublicService publicService) {
        super(documentType, publicServant, publicService);
    }

    public void publishToRequester(Requester requester) {
        this.isFinalized = true;
        requester.addResponse(this);
    }

    public long getInitiatingDocId() {
        return initiatingDocId;
    }

    public OrganizationDocument getInitiatingDocument() {
        return initiatingDocument;
    }

    public void setInitiatingDocument(OrganizationDocument initiatingDocument) {
        if (!isFinalized) {
            this.initiatingDocument = initiatingDocument;
            this.initiatingDocId = initiatingDocument.getDocumentId();
        }
    }

    /* IMPORTANT! Each setter (modifier method) body must be enclosed by "if (!isFinalized) {}" ! */
}
