package edu.services;

import edu.clients.Citizen;
import edu.communications.Address;
import edu.services.docs.*;
import edu.services.orgs.PublicService;
import edu.services.servants.InformationResponsible;

import java.util.GregorianCalendar;

/**
 * Created by Lena on 05.03.14.
 */
public class PublicServiceDemo {
    public static void main (String[] args) {
        System.out.println("------------- PublicServiceDemo ------------- ");

        /* INITIALIZATION start */
        String[] infoRequestLifecycleString = {"Created", "Assigned", "Replied"};
        DocumentLifecycle infoRequestLifecycle = new DocumentLifecycle(infoRequestLifecycleString);
        infoRequestLifecycle.setStartStatusIndex(0);
        infoRequestLifecycle.setFinalStatusIndex(2);
        infoRequestLifecycle.setFinalized(true);

        DocumentType infoRequestDocType = new DocumentType("Information_Request", "InfoReq_",infoRequestLifecycle);
        infoRequestLifecycle.setListInUse(true);

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
        /* INITIALIZATION end */

        InformationRequest infoRequest =
                new InformationRequest(infoRequestDocType, citizen, publicService);
        infoRequest.setText("What parks and streets improvements are planned for 2014 in Kyiv?");
        infoRequest.setAddressForReply(citizen.getAddressString());
        infoRequest.setEmailForReply(citizen.getEmailAddress());

        if (infoRequest != null) {
            citizen.addRequest(infoRequest);
            System.out.println("citizen: " + citizen.getFullNameString());
            System.out.println("publicService: " + publicService.getOrgName());
            System.out.println(infoRequest.toString());
        } else {
            System.out.println("infoRequest is NULL");
        }

        InformationResponsible informationResponsibleServant =
                new InformationResponsible(publicService, "Karpenko","Petro","Ivanovych");

        infoRequest.setIncomingDocResponsibleId(informationResponsibleServant.getPublicServantId());
        infoRequest.setNextDocumentStatus();
        System.out.println("infoRequest status set to " + infoRequest.getDocumentStatusString() +
            " to " + informationResponsibleServant.getFullNameString());

        OutcomingDocument outcomingDocument =
                new OutcomingDocument(informationResponsibleServant, publicService);
        outcomingDocument.setText(informationResponsibleServant.getInformationForReply());

        infoRequest.setReactionDocumentId(outcomingDocument.getDocumentId());
        outcomingDocument.setInitiatingDocId(infoRequest.getDocumentId());
        outcomingDocument.publishToRequester(citizen);
        infoRequest.setNextDocumentStatus();
        System.out.println("infoRequest status set to " + infoRequest.getDocumentStatusString() +
                " to " + informationResponsibleServant.getFullNameString());

    }
}
