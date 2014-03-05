package edu.services;

import edu.clients.Citizen;
import edu.communications.Address;
import edu.services.docs.InformationRequest;
import edu.services.docs.OrgDocStatus;
import edu.services.docs.OutcomingDocument;
import edu.services.orgs.PublicService;
import edu.services.servants.InformationResponsible;

import java.util.GregorianCalendar;

/**
 * Created by Lena on 05.03.14.
 */
public class PublicServiceDemo {
    public static void main (String[] args) {
        System.out.println("------------- PublicServiceDemo ------------- ");

        Citizen citizen = new Citizen("Petrenko","Taras","Ivanovych");
        citizen.setEmailAddress("citizen@gmail.com");
        citizen.setOfficialId("1234567890");

        Address tarasAppartment = new Address();
        tarasAppartment.setCountry("Ukraine");
        tarasAppartment.setCity("Kyiv");
        tarasAppartment.setStreet("Khreshchatyk");
        tarasAppartment.setBuilding("1A");
        tarasAppartment.setApartment("123H");

        citizen.setAddress(tarasAppartment);

        PublicService publicService = new PublicService("Improvements service");

        InformationRequest infoRequest = new InformationRequest(citizen, publicService);
        infoRequest.setDocumentText("What parks and streets improvements are planned for 2014 in Kyiv?");

        if (infoRequest != null) {
            citizen.addRequest(infoRequest);
            System.out.println("citizen: " + citizen.getFullNameString());
            System.out.println("publicService: " + publicService.getOrgName());
            System.out.println("infoRequest: ");
            System.out.println("    text: " + infoRequest.getDocumentText());
            System.out.println("    orgId: " + infoRequest.getOrgId());
            System.out.println("    DocumentNumber: " + infoRequest.getDocumentNumber());
            System.out.println("    DocumentStatus: " + infoRequest.getDocumentStatus());
            System.out.println("    DocumentStatusDate: " + infoRequest.getDocumentStatusDate());
        } else {
            System.out.println("infoRequest is NULL");
        }

        InformationResponsible informationResponsibleServant =
                new InformationResponsible(publicService, "Karpenko","Petro","Ivanovych");

        infoRequest.setIncomingDocResponsibleId(informationResponsibleServant.getPublicServantId());
        infoRequest.setDocumentStatus(OrgDocStatus.ASSIGNED.toString());
        infoRequest.setDocumentStatusDate(new GregorianCalendar());
        System.out.println("infoRequest status set to " + OrgDocStatus.ASSIGNED.toString() +
            " to " + informationResponsibleServant.getFullNameString());

        OutcomingDocument outcomingDocument =
                new OutcomingDocument(informationResponsibleServant, publicService);
        outcomingDocument.setDocumentText(informationResponsibleServant.getInformationForReply());

        infoRequest.setReactionDocumentId(outcomingDocument.getDocumentId());
        outcomingDocument.setInitiatingDocId(infoRequest.getDocumentId());
        outcomingDocument.publishToRequester(citizen);
        System.out.println("infoRequest status set to " + OrgDocStatus.REPLIED.toString() +
                " to " + citizen.getFullNameString());

    }
}
