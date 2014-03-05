package edu.services.docs;

import edu.clients.Requester;
import edu.services.orgs.PublicService;

/**
 * Created by Lena on 05.03.14.
 */
public class InformationRequest extends IncomingDocument {

    private String addressForReply;
    private String emailForReply;
    //private final DocType DOC_TYPE;

    public InformationRequest(Requester author, PublicService publicService) {
        super(DocType.INFORMATION_REQUEST, author, publicService);
    }



}
