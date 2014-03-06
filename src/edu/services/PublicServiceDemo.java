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

        String[] outcomingDocLifecycleString = {"Created", "Sent"};
        DocumentLifecycle outcomingDocLifecycle = new DocumentLifecycle(outcomingDocLifecycleString);
        outcomingDocLifecycle.setStartStatusIndex(0);
        outcomingDocLifecycle.setFinalStatusIndex(1);
        outcomingDocLifecycle.setFinalized(true);

        DocumentType outcomingDocType = new DocumentType("Outcoming_Document", "Out_",outcomingDocLifecycle);
        outcomingDocLifecycle.setListInUse(true);

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
            System.out.println("\npublicService: " + publicService.getOrgName() + "\n");
            System.out.println(infoRequest.toString());
        } else {
            System.out.println("infoRequest is NULL");
        }

        InformationResponsible informationResponsibleServant =
                new InformationResponsible(publicService, "Karpenko","Petro","Ivanovych");

        infoRequest.setIncomingDocResponsible(informationResponsibleServant);
        infoRequest.setNextDocumentStatus();
        System.out.println("\ninfoRequest status set to " + infoRequest.getDocumentStatusString() +
            " to " + informationResponsibleServant.getFullNameString());


        OutcomingDocument outcomingDocument =
                new OutcomingDocument(outcomingDocType, informationResponsibleServant, publicService);
        outcomingDocument.setText(informationResponsibleServant.getInformationForReply());

        infoRequest.setReactionDocument(outcomingDocument);
        outcomingDocument.setInitiatingDocument(infoRequest);
        outcomingDocument.publishToRequester(citizen);
        outcomingDocument.setNextDocumentStatus();
        infoRequest.setNextDocumentStatus();
        System.out.println("\ninfoRequest status set to " + infoRequest.getDocumentStatusString() +
                " to " + informationResponsibleServant.getFullNameString());
        System.out.println("\ninfoRequest statuses history: " + infoRequest.getStatusesHistory());
        System.out.println("\ncitizen got the next responses:\n   " + citizen.getResponsesString());
        //TODO: send by Email + send to Address
        //TODO: show infoRequest.resultingDoc and outcomingDoc.initiating doc
    }
}
