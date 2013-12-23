/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class ServersPool implements IServersPool {
    private ArrayList<String> servers;
    private ListIterator<String> iterator;
    public ServersPool(String[] servers) {
        this.servers = new ArrayList<>(Arrays.asList(servers));
        this.iterator = this.servers.listIterator();
    }

    public ServersPool(String serversFilePath) throws IOException {
        String line;
        servers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(serversFilePath));
        while((line = reader.readLine()) != null) {
            servers.add(line);
        }
        reader.close();
        this.iterator = servers.listIterator();
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

    @Override
    public int size() {
        return servers.size();
    }
}
