package edu.services.docs;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by Lena on 06.03.14.
 */
public class DocumentStatus {
    private DocumentLifecycle documentLifecycle;
    private ArrayList<String> documentStatusesHistory;
    private ArrayList<GregorianCalendar> documentStatusesDates;
    private int currentStatusIndex;
    private int previousStatusIndex;


    public DocumentStatus(DocumentLifecycle statusesList) {
        if (null != statusesList) {
            documentLifecycle = statusesList;
            documentLifecycle.setListInUse(true);
            currentStatusIndex = documentLifecycle.getStartStatusIndex();
            previousStatusIndex = documentLifecycle.getStartStatusIndex();
            documentStatusesHistory = new ArrayList<String>();
            documentStatusesDates = new ArrayList<GregorianCalendar>();
            addDocStatusesAndDatesHistory();
        }
    }

    public String getCurrentDocumentStatus() {
        return documentLifecycle.get(currentStatusIndex);
    }

    public void setNextDocumentStatus() {
        previousStatusIndex = currentStatusIndex;
        currentStatusIndex = documentLifecycle.getNextStatusIndex(currentStatusIndex);
        addDocStatusesAndDatesHistory();
    }

    public void setPreviousDocumentStatus() {
        int status = currentStatusIndex;
        currentStatusIndex = previousStatusIndex;
        previousStatusIndex = status;
        addDocStatusesAndDatesHistory();
    }

    public ArrayList<GregorianCalendar> getDocumentStatusesDates() {
        return this.documentStatusesDates;
    }

    public ArrayList<String> getDocumentStatusesHistory() {
        return documentStatusesHistory;
    }

    private void addDocStatusesAndDatesHistory() {
        documentStatusesHistory.add(getCurrentDocumentStatus());
        documentStatusesDates.add(new GregorianCalendar());
    }
}
