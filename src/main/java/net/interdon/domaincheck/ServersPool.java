/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class ServersPool implements IServersPool {
    private LinkedList<String> servers;
    private ListIterator<String> iterator;
    public ServersPool(String[] servers) {
        this.servers = new LinkedList<String>(Arrays.asList(servers));
        this.iterator = this.servers.listIterator();
    }

    public ServersPool(String serversFilePath) {
    }

    @Override
    public String nextServer() {
        if(servers.size() == 1) {
            return servers.get(0);
        }
        if(!iterator.hasNext()) {
            iterator = servers.listIterator();
        }
        return iterator.next();
    }
}
