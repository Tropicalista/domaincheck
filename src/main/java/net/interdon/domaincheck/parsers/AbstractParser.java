/*
 * Copyright (c) 2013. Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck.parsers;

import net.interdon.domaincheck.containers.Domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class AbstractParser {
    protected Domain domain;
    protected String dateCreated;
    protected String dateLastModifyed;
    protected String expirationDate;
    protected List<String> responce;
    protected Pattern expirationPattern;
    protected Pattern modifyedPattern;
    protected Pattern createdPattern;
    public AbstractParser(String expirationRegexp, String modifyedRegexp, String createdRegexp) {
        expirationPattern = Pattern.compile(expirationRegexp);
        modifyedPattern = Pattern.compile(modifyedRegexp);
        createdPattern = Pattern.compile(createdRegexp);
        responce = new LinkedList<>();
    }
    public abstract Domain parse(Domain domain);

    protected void splitResponce() {
        if(domain.getWhoisResponce().isEmpty()) {
            return;
        }
        responce.addAll(Arrays.asList(domain.getWhoisResponce().split("\n")));
    }

    public void updateDomain() {
        domain.setDateCreated(dateCreated);
        domain.setDateLastModifyed(dateLastModifyed);
        domain.setExpirationDate(expirationDate);
    }
}
