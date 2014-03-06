package edu.services.servants;

import edu.clients.FullName;
import edu.services.docs.IncomingDocument;
import edu.services.orgs.PublicService;

import java.util.ArrayList;

/**
 * Created by yurii.pyvovarenko on 3/4/14.
 */
public class InformationResponsible extends PublicServant {
    String informationForReply = "The plan of improvements for 2014 is next... Sincerely, InformationResponsible.";

    public InformationResponsible(PublicService organization, String surname, String name, String secondName) {
        super(organization, surname, name, secondName);
    }

    public String getInformationForReply() {
        return informationForReply;
    }
}
