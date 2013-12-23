/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck;

import net.interdon.domaincheck.containers.Domain;
import org.apache.commons.net.whois.WhoisClient;

import java.io.IOException;
import java.util.List;

public class DomainCheck {
    private IServersPool servers;
    private List domains;
    private int currentDomain = 0;
    WhoisClient whoisClient;

    public DomainCheck(IServersPool servers, List domains) {
        this.servers = servers;
        this.domains = domains;
        whoisClient = new WhoisClient();
    }

    public Domain query(Domain domain) {
        try {
            whoisClient.connect(servers.nextServer());
            domain.setWhoisResponce(whoisClient.query(domain.getDomainName()));
            whoisClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return domain;
    }

}
