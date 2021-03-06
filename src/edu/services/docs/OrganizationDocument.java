package edu.services.docs;

import edu.clients.Requester;
import edu.services.orgs.PublicService;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by yurii.pyvovarenko on 3/4/14.
 */
public class OrganizationDocument extends Text {
    private static long lastDocumentId;

    protected DocumentLifecycle documentLifecycle;
    private long documentId;
    private String documentName;
    private long documentAuthorId;
    private GregorianCalendar documentCreationDate;
    private DocumentType documentType;
    private String documentNumber;
    private DocumentStatus documentStatus;
    private long orgId;
    private Requester author;
    private String text;

    public OrganizationDocument() {
        this.documentId = OrganizationDocument.lastDocumentId;
        OrganizationDocument.lastDocumentId++;
    }

    public OrganizationDocument(DocumentType documentType, Requester author, PublicService publicService) {
        this();
        this.author = author;
        this.orgId = publicService.getOrgId();
        this.documentType = documentType;
        this.documentNumber = documentType.getDocTypeShortName() + this.documentId;
        documentStatus = new DocumentStatus(documentType.getDocumentLifecycle());
        //TODO assign other fields
    }

    public long getDocumentId() {
        return documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        if (! isFinalized) {
            this.documentName = documentName;
        }
    }

    public long getDocumentAuthorId() {
        return documentAuthorId;
    }

    public void setDocumentAuthorId(long documentAuthorId) {
        if (! isFinalized) {
            this.documentAuthorId = documentAuthorId;
        }
    }

    public GregorianCalendar getDocumentCreationDate() {
        return documentCreationDate;
    }

    public void setDocumentCreationDate(GregorianCalendar documentCreationDate) {
        if (! isFinalized) {
            this.documentCreationDate = documentCreationDate;
        }
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    /*
     * I think we do not need to change document type after its creation
     *
     * public void setDocumentType(DocType documentType) {
     *   this.documentType = documentType;
     * }
    */

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        if (! isFinalized) {
            this.documentNumber = documentNumber;
        }
    }

    public DocumentStatus getDocumentStatus() {
        return documentStatus;
    }

    public String getDocumentStatusString() {
        return documentStatus.getCurrentDocumentStatus().toString();
    }


    public void setNextDocumentStatus() {
        if (! isFinalized) {
            this.documentStatus.setNextDocumentStatus();
        }
    }

    public void setPreviousDocumentStatus() {
        if (! isFinalized) {
            this.documentStatus.setPreviousDocumentStatus();
        }
    }

    public String getStatusesHistoryString() {
        return documentStatus.getDocumentStatusesHistoryString();
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        if (! isFinalized) {
            this.orgId = orgId;
        }
    }

    public Requester getAuthor() {
        return author;
    }

    public void setAuthor(Requester author) {
        if (! isFinalized) {
            this.author = author;
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (! isFinalized) {
            this.text = text;
        }
    }

    public String toString() {
        String result = documentType.getDocTypeName() + ": " +
            "\n    text: " + this.getText() +
            "\n    orgId: " + this.getOrgId() +
            "\n    DocumentNumber: " + this.getDocumentNumber() +
            "\n    DocumentStatusesHistory: " + this.getStatusesHistoryString();

        return result;
    }

    public String getDocumentTypeName() {
        return this.documentType.getDocTypeName();
    }

    public String getAuthorName() {
        return this.getAuthor().getRequesterName();
    }
}
