/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck;

import java.util.List;

public class DomainCheck {
    private IServersPool servers;
    private List domains;

    public DomainCheck(IServersPool servers, List domains) {
        this.servers = servers;
        this.domains = domains;
    }
}
