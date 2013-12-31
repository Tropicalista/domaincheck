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
    private long dateCreated = 0;
    private long dateLastModifyed = 0;
    private long expirationDate = 0;
    private String whoisResponce = "";

    public Domain(String domainName) {
        this.domainName = domainName;
    }

    public String getTld() {
        return domainName.split("\\.", 2)[1];
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateCreated(String date) {
        setDateCreated(dateToTimestamp(date));
    }

    public long getDateLastModifyed() {
        return dateLastModifyed;
    }

    public void setDateLastModifyed(long dateLastModifyed) {
        this.dateLastModifyed = dateLastModifyed;
    }

    public void setDateLastModifyed(String date) {
        setDateLastModifyed(dateToTimestamp(date));
    }

    public long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setExpirationDate(String date) { //format YYYY-MM-DD
        setExpirationDate(dateToTimestamp(date));
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

    private long dateToTimestamp(String date) {
        Matcher matcher = Pattern.compile("^\\d{4}-{1}\\d{2}-{1}\\d{2}$").matcher(date);
        String value = date;
        if(matcher.matches()) {
            value = date+" 00:00:00";
        }
        return Timestamp.valueOf(value).getTime();
    }
}
