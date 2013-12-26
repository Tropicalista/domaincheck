package net.interdon.domaincheck;

import net.interdon.domaincheck.containers.Domain;

import java.util.List;

public class Worker extends Thread {
    private List<Domain> domains;
    private IServerPool serverPool;
    private int waitTime = 3000;

    public Worker(List<Domain> domains, IServerPool serverPool) {
        this.domains = domains;
        this.serverPool = serverPool;
    }

    public Worker(List<Domain> domains, IServerPool serverPool, int waitTime) {
        this(domains, serverPool);
        this.waitTime = waitTime;
    }

    @Override
    public void run() {

    }
}
