/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck;

import net.interdon.domaincheck.exceptions.NoServersForTldException;

import java.util.Set;

public interface IServerPool {
    public String nextServer(String tld) throws NoServersForTldException;
    public boolean hasServerFor(String tld);
    public void addServer(String tld, String host);
    public void delServer(String tld, String host) throws NoServersForTldException;
    public Set<String> tldList();
}
