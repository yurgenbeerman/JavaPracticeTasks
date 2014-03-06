package edu.services.docs;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Lena on 06.03.14.
 */
public class OrgDocStatusesHistory {
    private ArrayList<String> documentStatusesHistory;
    private ArrayList<GregorianCalendar> documentStatusesDates;

    public OrgDocStatusesHistory(OrganizationDocument organizationDocument){
        documentStatusesHistory = organizationDocument.getDocumentStatus().getDocumentStatusesHistory();
        documentStatusesDates = organizationDocument.getDocumentStatus().getDocumentStatusesDates();
    }

    public ArrayList<String> getDocumentStatusesHistory() {
        return documentStatusesHistory;
    }

    public ArrayList<GregorianCalendar> getDocumentStatusesDates() {
        return documentStatusesDates;
    }

    public String toString() {
        String result = "";
        String date = null;
        for (int i = 0; i < documentStatusesHistory.size(); i++) {
            GregorianCalendar calendar = documentStatusesDates.get(i);
            date = calendar.get(Calendar.HOUR_OF_DAY) + ":" +
                    calendar.get(Calendar.MINUTE) + ", " +
                    calendar.get(Calendar.DAY_OF_MONTH) + "." +
                    calendar.get(Calendar.MONTH) + "." +
                    calendar.get(Calendar.YEAR);
            result = result + "Status '" + documentStatusesHistory.get(i) +
                    "' was assigned at " + date +
                    ". ";
        }
        return result;
    }
}
