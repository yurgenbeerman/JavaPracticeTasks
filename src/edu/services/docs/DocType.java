package edu.services.docs;

/**
 * Created by Lena on 05.03.14.
 */
public enum DocType {
    INFORMATION_REQUEST, COMPLIANT, THANKS;

    private static final String[] shortCodes = {"IN_IR_", "IN_C_", "IN_T_"};
    public static String getShortCode(DocType docType) {
        return shortCodes[docType.ordinal()];
    }
}
