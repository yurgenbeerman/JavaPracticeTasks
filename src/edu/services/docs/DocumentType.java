package edu.services.docs;

import java.util.ArrayList;

/**
 * Created by Lena on 06.03.14.
 */
public class DocumentType {
    private String docTypeName; //INFORMATION_REQUEST, COMPLIANT, THANKS;
    private String docTypeShortName; //"IN_IR_", "IN_C_", "IN_T_"
    private DocumentLifecycle documentLifecycle;

    public DocumentType(String docTypeName, String docTypeShortName, DocumentLifecycle documentLifecycle) {
        this.docTypeName = docTypeName;
        this.docTypeShortName = docTypeShortName;
        this.documentLifecycle = documentLifecycle;
    }

    public String getDocTypeName() {
        return docTypeName;
    }

    public void setDocTypeName(String docTypeName) {
        this.docTypeName = docTypeName;
    }

    public String getDocTypeShortName() {
        return docTypeShortName;
    }

    public void setDocTypeShortName(String docTypeShortName) {
        this.docTypeShortName = docTypeShortName;
    }

    public DocumentLifecycle getDocumentLifecycle() {
        return documentLifecycle;
    }

    public void setDocumentLifecycle(DocumentLifecycle documentLifecycle) {
        this.documentLifecycle = documentLifecycle;
    }
}
