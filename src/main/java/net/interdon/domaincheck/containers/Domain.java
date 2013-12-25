/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */
package net.interdon.domaincheck.containers;

public class Domain {
    private final String domainName;
    private String dateCreated;
    private String dateLastModifyed;
    private String expirationDate;
    private String whoisResponce;

    public Domain(String domainName) {
        this.domainName = domainName;
    }

    public String getTld() {
        return domainName.split(".", 1)[1];
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateLastModifyed() {
        return dateLastModifyed;
    }

    public void setDateLastModifyed(String dateLastModifyed) {
        this.dateLastModifyed = dateLastModifyed;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getWhoisResponce() {
        return whoisResponce;
    }

    public void setWhoisResponce(String whoisResponce) {
        this.whoisResponce = whoisResponce;
    }

    public String getDomainName() {
        return domainName;
    }
}
