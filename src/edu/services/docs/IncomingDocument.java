package edu.services.docs;

import edu.clients.Requester;
import edu.services.orgs.PublicService;
import edu.services.servants.InformationResponsible;

/**
 * Created by yurii.pyvovarenko on 3/4/14.
 */
public class IncomingDocument extends OrganizationDocument {
    private long incomingDocResponsibleId;
    private long reactionDocumentId;
    private InformationResponsible informationResponsible;

    public IncomingDocument(DocumentType documentType, Requester author, PublicService publicService) {
        super(documentType, author, publicService);
    }

    public long getIncomingDocResponsibleId() {
        return incomingDocResponsibleId;
    }

    public String getIncomingDocResponsibleName() {
        return informationResponsible.getFullNameString();
    }

    public void setIncomingDocResponsibleId(long incomingDocResponsibleId) {
        this.incomingDocResponsibleId = incomingDocResponsibleId;
    }

    public long getReactionDocumentId() {
        return reactionDocumentId;
    }

    public void setReactionDocumentId(long reactionDocumentId) {
        this.reactionDocumentId = reactionDocumentId;
    }



}
