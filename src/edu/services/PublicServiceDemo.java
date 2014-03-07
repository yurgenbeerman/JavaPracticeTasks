package edu.services;

import edu.clients.Citizen;
import edu.communications.Address;
import edu.services.docs.*;
import edu.services.orgs.PublicService;
import edu.services.servants.InformationResponsible;

/**
 * Created by yurii.pyvovarenko on 05.03.14.
 *
 * Implements main workfllow of the Public Service System
 */
public class PublicServiceDemo {
    static int statusNumber = 0;
    public static void main (String[] args) {
        System.out.println("------------- PublicServiceDemo ------------- ");

        /* INITIALIZATION start */
        String[] infoRequestLifecycleString = {"Created", "Assigned", "Replied"};
        DocumentLifecycle infoRequestLifecycle = new DocumentLifecycle(infoRequestLifecycleString);
        infoRequestLifecycle.setStartStatusIndex(0);
        infoRequestLifecycle.setFinalStatusIndex(2);
        infoRequestLifecycle.setFinalized(true);

        DocumentType infoRequestDocType = new DocumentType("Information_Request", "InfoReq_",infoRequestLifecycle);
        infoRequestLifecycle.setLifecycleInUse(true);

        String[] outcomingDocLifecycleString = {"Created", "Passed_for_sending", "Sent"};
        DocumentLifecycle outcomingDocLifecycle = new DocumentLifecycle(outcomingDocLifecycleString);
        outcomingDocLifecycle.setStartStatusIndex(0);
        outcomingDocLifecycle.setFinalStatusIndex(2);
        outcomingDocLifecycle.setFinalized(true);

        DocumentType outcomingDocType = new DocumentType("Outcoming_Document", "Out_",outcomingDocLifecycle);
        outcomingDocLifecycle.setLifecycleInUse(true);

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

        /* Assume a user (Citizen wants to create s Request */
        if (( citizen.getRequesterOfficialId() != null) && (citizen.getRequesterOfficialId() != "")) {
            if ( citizen.getRequesterOfficialId().length() != 10 ) {
                System.out.println("RequesterOfficialId is wrong: " + citizen.getRequesterOfficialId() + ". We can not allow to create a request. You still may email to us.");
                System.exit(2);
            }
        } else {
            System.out.println("There's no RequesterOfficialId: " + citizen.getRequesterOfficialId() + ". We can not allow to create a request. You still may email to us.");
            System.exit(1);
        }

        InformationRequest infoRequest =
                new InformationRequest(infoRequestDocType, citizen, publicService);
        infoRequestDocType.setDocTypeInUse(true);
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

        /* The user can modify the Request data until it isReceivedByPublicService */
        infoRequest.setReceivedByPublicService(true);
        InformationResponsible informationResponsibleServant =
                new InformationResponsible(publicService, "Karpenko","Petro","Ivanovych");

        infoRequest.setIncomingDocResponsible(informationResponsibleServant);
        infoRequest.setNextDocumentStatus();

        printStatusAndAssignee(infoRequest, infoRequest.getIncomingDocResponsibleName());


        OutcomingDocument outcomingDocument =
                new OutcomingDocument(outcomingDocType, informationResponsibleServant, publicService);
        outcomingDocType.setDocTypeInUse(true);
        outcomingDocument.setText(informationResponsibleServant.getInformationForReply());
        infoRequest.setReactionDocument(outcomingDocument);
        outcomingDocument.setInitiatingDocument(infoRequest);
        outcomingDocument.setNextDocumentStatus();

        outcomingDocument.publishToRequester(citizen);
        outcomingDocument.setNextDocumentStatus();
        outcomingDocument.setFinalized(true);
        infoRequest.setNextDocumentStatus();
        infoRequest.setFinalized(true);

        printStatusAndAssignee(infoRequest, infoRequest.getAuthorName());

        System.out.println("\ninfoRequest statuses history: " + infoRequest.getStatusesHistoryString());
        System.out.println("\ncitizen got the next responses:\n   " + citizen.getResponsesString());
        //TODO: outcomingDocument.setNextDocumentStatus(); send by Email + send to Address
        //TODO: show infoRequest.resultingDoc and outcomingDoc.initiating doc
    }

    static void printStatusAndAssignee(OrganizationDocument orgDocument, String assigneeName) {
        System.out.println("\n" + statusNumber + ". " + orgDocument.getDocumentTypeName() + " status set to " + orgDocument.getDocumentStatusString() +
                " to " + assigneeName);
        statusNumber++;
    }
}
