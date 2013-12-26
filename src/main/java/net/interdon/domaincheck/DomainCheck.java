/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck;

import net.interdon.domaincheck.containers.Domain;
import net.interdon.domaincheck.parsers.IDomainParser;
import net.interdon.domaincheck.parsers.ParserFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DomainCheck {
    private List<Domain> domainsToCheck;
    private Queue<Domain> parsingQueue;
    private IServerPool servers;

    public DomainCheck(String[] domainsToCheck, IServerPool servers) {
        setServerPool(servers);
        buildDomainsList(domainsToCheck);
        parsingQueue = new ConcurrentLinkedQueue<>();
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

    public void start() {
        Worker worker = new Worker(domainsToCheck, servers, parsingQueue);
        ParserFactory factory = new ParserFactory();
        HashMap<String, IDomainParser> parserPool = new HashMap<>();
        Domain tmp;
        while (!worker.isInterrupted()) {
            if(!parsingQueue.isEmpty()) {
                tmp = parsingQueue.poll();
                if(!parserPool.containsKey(tmp.getTld())) {
                    parserPool.put(tmp.getTld(), factory.newParser(tmp.getTld()));
                }
                parserPool.get(tmp.getTld()).parse(tmp);
            }
        }
    }
}
