/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck;

import net.interdon.domaincheck.containers.Domain;
import net.interdon.domaincheck.exceptions.NoServersForTldException;
import org.apache.commons.net.whois.WhoisClient;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DomainCheck {
    private List<Domain> domains;
    private IServerPool servers;
    WhoisClient whoisClient;

    public DomainCheck(String[] domainsToCheck, IServerPool servers) {
        setServerPool(servers);
        buildDomainsList(domainsToCheck);
        whoisClient = new WhoisClient();
    }

    public void setServerPool(IServerPool servers) {
        this.servers = servers;
    }

    public Domain query(Domain domain) {
        String host;
        try {
            host = servers.nextServer(domain.getTld());
        } catch (NoServersForTldException e) {
            host = WhoisClient.DEFAULT_HOST;
        }
        try {
            whoisClient.connect(WhoisClient.DEFAULT_HOST);
            domain.setWhoisResponce(whoisClient.query(domain.getDomainName()));
            whoisClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return domain;
    }

    private void buildDomainsList(String[] domainsToCheck) {
        domains = new LinkedList<>();
        for(String item: domainsToCheck) {
            domains.add(new Domain(item));
        }
    }

}
