package edu.services.docs;

import edu.services.servants.InformationResponsible;

/**
 * Created by yurii.pyvovarenko on 3/4/14.
 */
public class IncomingDocument extends OrganizationDocument {
    long incomingDocResponsibleId;
    long reactionDocumentId;
    InformationResponsible informationResponsible;

    public long getIncomingDocResponsibleId() {
        return incomingDocResponsibleId;
    }

    public String getIncomingDocResponsibleName() {
        return informationResponsible.getFullName();
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
