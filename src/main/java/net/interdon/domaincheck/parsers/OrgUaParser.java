/*
 * Copyright (c) 2013. Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck.parsers;

import net.interdon.domaincheck.containers.Domain;

public class OrgUaParser extends AbstractParser {

    public OrgUaParser(Domain domain) {
        this.domain = domain;
    }

    @Override
    public Domain parse() {
        return domain;
    }
}
