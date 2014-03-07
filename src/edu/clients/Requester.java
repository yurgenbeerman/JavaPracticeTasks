package edu.clients;

import edu.services.docs.IncomingDocument;
import edu.services.docs.OutcomingDocument;

/**
 * Created by yurii.pyvovarenko on 05.03.14.
 */
public interface Requester {
    public String getRequesterOfficialId();
    public String getRequesterName();
    public String getRequesterAddress();

    public void addRequest(IncomingDocument request);
    public void addResponse(OutcomingDocument response);
}
