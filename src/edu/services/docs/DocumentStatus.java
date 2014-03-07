package edu.services.docs;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by yurii.pyvovarenko on 06.03.14.
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
            documentLifecycle.setLifecycleInUse(true);
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

    public String getDocumentStatusesHistoryString() {
        String result = "";
        String date = null;
        for (int i = 0; i < documentStatusesHistory.size(); i++) {
            GregorianCalendar calendar = documentStatusesDates.get(i);
            date = calendar.get(Calendar.HOUR_OF_DAY) + ":" +
                    calendar.get(Calendar.MINUTE) + ", " +
                    calendar.get(Calendar.DAY_OF_MONTH) + "." +
                    calendar.get(Calendar.MONTH) + "." +
                    calendar.get(Calendar.YEAR);
            result = "Status " + documentStatusesHistory.get(i) +
                    " was assigned on " + date +
                    ". ";
        }
        return result;
    }

    private void addDocStatusesAndDatesHistory() {
        documentStatusesHistory.add(getCurrentDocumentStatus());
        documentStatusesDates.add(new GregorianCalendar());
    }

    public int getCurrentStatusIndex() {
        return currentStatusIndex;
    }
}
