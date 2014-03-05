package edu.services.docs;

import edu.clients.Citizen;
import edu.clients.Requester;
import edu.services.orgs.PublicService;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by yurii.pyvovarenko on 3/4/14.
 */
public class OrganizationDocument {

    private static long lastDocumentId;

    private long documentId;
    private String documentName;
    private long documentAuthorId;
    private GregorianCalendar documentCreationDate;
    private DocType documentType;
    private String documentNumber;
    private ArrayList<String> documentStatus;
    private ArrayList<GregorianCalendar> documentStatusDate;
    private long orgId;
    private Requester author;
    private String documentText;

    public OrganizationDocument() {
        this.documentId = OrganizationDocument.lastDocumentId;
        OrganizationDocument.lastDocumentId++;
    }

    public OrganizationDocument(DocType documentType, Requester author, PublicService publicService) {
        this.documentId = OrganizationDocument.lastDocumentId;
        OrganizationDocument.lastDocumentId++;

        this.author = author;
        this.orgId = publicService.getOrgId();
        this.documentType = documentType;

        this.documentNumber = DocType.getShortCode(documentType) + this.documentId;

        //TODO refactor to OrgDocStatus object + OrgDocStatuses enum
        documentStatus = new ArrayList<String>();
        documentStatus.add(OrgDocStatus.CREATED.toString());
        documentStatusDate = new ArrayList<GregorianCalendar>();
        documentStatusDate.add(new GregorianCalendar());

        //TODO assign other fields
    }

    public long getDocumentId() {
        return documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public long getDocumentAuthorId() {
        return documentAuthorId;
    }

    public void setDocumentAuthorId(long documentAuthorId) {
        this.documentAuthorId = documentAuthorId;
    }

    public GregorianCalendar getDocumentCreationDate() {
        return documentCreationDate;
    }

    public void setDocumentCreationDate(GregorianCalendar documentCreationDate) {
        this.documentCreationDate = documentCreationDate;
    }

    public DocType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocType documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentStatus() {
        return documentStatus.get(documentStatus.size()-1);
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus.add(documentStatus);
    }

    public GregorianCalendar getDocumentStatusDate() {
        return documentStatusDate.get(documentStatusDate.size()-1);
    }

    public void setDocumentStatusDate(GregorianCalendar documentStatusDate) {
        this.documentStatusDate.add(documentStatusDate);
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public Requester getAuthor() {
        return author;
    }

    public void setAuthor(Requester author) {
        this.author = author;
    }

    public String getDocumentText() {
        return documentText;
    }

    public void setDocumentText(String documentText) {
        this.documentText = documentText;
    }
}
