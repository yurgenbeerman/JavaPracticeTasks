package edu.services.orgs;

import edu.communications.Address;
import edu.communications.Emailable;

/**
 * Created by yurii.pyvovarenko on 3/4/14.
 */
public class PublicService implements Emailable {
    private static long lastOrgId;

    private long orgId;
    private Address address;
    private String orgName;
    private int hierarchyLevel;
    private long parentOrgId;
    private String emailAddress;

    public PublicService(String orgName) {
        this.orgId = PublicService.lastOrgId;
        PublicService.lastOrgId++;
        this.orgName = orgName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getHierarchyLevel() {
        return hierarchyLevel;
    }

    public void setHierarchyLevel(int hierarchyLevel) {
        this.hierarchyLevel = hierarchyLevel;
    }

    public Long getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(Long parentOrgId) {
        this.parentOrgId = parentOrgId;
    }
}
