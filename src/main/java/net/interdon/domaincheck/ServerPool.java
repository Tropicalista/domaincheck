/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck;

import java.util.List;

public class ServerPool implements IServerPool {
    public ServerPool(String pathToServerListXMLFile) {
    }

    @Override
    public String nextServer(String tld) {
        return null;
    }

    @Override
    public boolean hasServerFor(String tld) {
        return false;
    }

    @Override
    public void addServer(String tld, String host) {

    }

    @Override
    public void delServer(String tld, String host) {

    }

    @Override
    public List<String> tldList() {
        return null;
    }
}
