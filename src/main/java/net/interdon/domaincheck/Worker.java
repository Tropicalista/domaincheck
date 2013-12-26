package net.interdon.domaincheck;

import net.interdon.domaincheck.containers.Domain;
import net.interdon.domaincheck.exceptions.NoServersForTldException;
import org.apache.commons.net.whois.WhoisClient;

import java.io.IOException;
import java.util.List;
import java.util.Queue;

public class Worker extends Thread {
    private List<Domain> domains;
    private IServerPool serverPool;
    private int waitTime = 3000;
    private WhoisClient whoisClient;
    private Queue<Domain> resultsQueue;

    public Worker(List<Domain> domains, IServerPool serverPool, Queue<Domain> resultsQueue) {
        this.domains = domains;
        this.serverPool = serverPool;
        this.resultsQueue = resultsQueue;
        whoisClient = new WhoisClient();
    }

    public Worker(List<Domain> domains, IServerPool serverPool, Queue<Domain> resultsQueue, int waitTime) {
        this(domains, serverPool, resultsQueue);
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        for(Domain domain: domains) {
            query(domain);
            try {
                this.sleep(waitTime);
            } catch (InterruptedException e) {
                this.interrupt();
            }
        }
    }

    private void query(Domain domain) {
        String host;
        try {
            host = serverPool.nextServer(domain.getTld());
        } catch (NoServersForTldException e) {
            host = WhoisClient.DEFAULT_HOST;
        }
        try {
            whoisClient.connect(WhoisClient.DEFAULT_HOST);
            domain.setWhoisResponce(whoisClient.query(domain.getDomainName()));
            whoisClient.disconnect();
        } catch (IOException e) {
            domain.setWhoisResponce("");
            return;
        }
        resultsQueue.add(domain);
    }
}
