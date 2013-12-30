/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */
package net.interdon.domaincheck.containers;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Domain {
    private final String domainName;
    private String dateCreated = "";
    private String dateLastModifyed = "";
    private long expirationDate = 0;
    private String whoisResponce = "";

    public Domain(String domainName) {
        this.domainName = domainName;
    }

    public String getTld() {
        return domainName.split("\\.", 2)[1];
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

    public long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setExpirationDate(String date) { //format YYYY-MM-DD
        Matcher matcher = Pattern.compile("^\\d{4}-{1}\\d{2}-{1}\\d{2}$").matcher(date);
        String value = date;
        if(matcher.matches()) {
            value = date+" 00:00:00";
        }
        setExpirationDate(Timestamp.valueOf(value).getTime());
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
