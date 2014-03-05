package edu.services.docs;

import edu.services.servants.InformationResponsible;

import java.util.Date;

/**
 * Created by yurii.pyvovarenko on 3/4/14.
 */
public class OrganizationDocument {
    long documentId;
    String documentName;
    long documentAuthorId;
    Date documentCreationDate;
    DocType documentType;
    String documentNumber;
    String[] documentStatus;
    Date[] documentStatusDate;
    long orgId;

    Object Author;

}

Enum DocType {"Information Request", "Compliant","Thanks"}
