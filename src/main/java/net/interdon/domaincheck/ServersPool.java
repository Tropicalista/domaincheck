/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck;

public class ServersPool implements IServersPool {
    public ServersPool(String[] servers) {

    }

    public ServersPool(String serversFilePath) {
    }

    @Override
    public String nextServer() {
        return null;
    }
}
