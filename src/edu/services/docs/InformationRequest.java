package edu.services.docs;

import edu.clients.Requester;
import edu.services.orgs.PublicService;

/**
 * Created by Lena on 05.03.14.
 */
public final class InformationRequest extends IncomingDocument {
    private String addressForReply;
    private String emailForReply;

    public InformationRequest(DocumentType documentType, Requester author, PublicService publicService) {
        super(documentType, author, publicService);
    }

    public String getAddressForReply() {
        return addressForReply;
    }

    public void setAddressForReply(String addressForReply) {
        this.addressForReply = addressForReply;
    }

    public String getEmailForReply() {
        return emailForReply;
    }

    public void setEmailForReply(String emailForReply) {
        this.emailForReply = emailForReply;
    }
}
