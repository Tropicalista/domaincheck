/*
 * Copyright (c) 2013. Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck.parsers;

import net.interdon.domaincheck.containers.Domain;

public abstract class AbstractParser {
    protected Domain domain;
    protected String dateCreated;
    protected String dateLastModifyed;
    protected String expirationDate;
    protected String responce;
    public abstract Domain parse();

    protected AbstractParser(Domain domain) {
        this.domain = domain;
        this.responce = domain.getWhoisResponce();
    }

    public void stripComments() {
        StringBuilder sb = new StringBuilder();
    }

    public void updateDomain() {
        domain.setDateCreated(dateCreated);
        domain.setDateLastModifyed(dateLastModifyed);
        domain.setExpirationDate(expirationDate);
    }
}
