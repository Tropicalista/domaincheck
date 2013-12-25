/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck;

import java.util.List;

public interface IServerPool {
    public String nextServer(String tld);
    public boolean hasServerFor(String tld);
    public void addServer(String tld, String host);
    public void delServer(String tld, String host);
    public List<String> tldList();
}
