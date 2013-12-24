/*
 * Copyright (c) 2013. Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck.parsers;

import net.interdon.domaincheck.containers.Domain;

public class OrgUaParser extends AbstractParser {
    public OrgUaParser(String expirationRegexp, String modifyedRegexp, String createdRegexp) {
        super(expirationRegexp, modifyedRegexp, createdRegexp);
    }

    @Override
    public Domain parse(Domain domain) {
        return domain;
    }
}
