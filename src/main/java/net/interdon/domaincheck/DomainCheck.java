/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck;

import net.interdon.domaincheck.containers.Domain;

import java.util.LinkedList;
import java.util.List;

public class DomainCheck {
    private List<Domain> domainsToCheck;
    private IServerPool servers;

    public DomainCheck(String[] domainsToCheck, IServerPool servers) {
        setServerPool(servers);
        buildDomainsList(domainsToCheck);
    }

    public void setServerPool(IServerPool servers) {
        this.servers = servers;
    }

    private void buildDomainsList(String[] domainsToCheck) {
        this.domainsToCheck = new LinkedList<>();
        for(String item: domainsToCheck) {
            this.domainsToCheck.add(new Domain(item));
        }
    }

}
