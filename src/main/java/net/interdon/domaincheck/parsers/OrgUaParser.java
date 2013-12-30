/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck.parsers;

import net.interdon.domaincheck.containers.Domain;

import java.util.regex.Pattern;

public class OrgUaParser extends AbstractParser {
    private static final String EXPIRATION_DATE_REGEXP = "\\bexpires\\b:{1}\\s*\\d{4}-{1}\\d{2}-{1}\\d{2}"; //matches "expires: YYYY-MM-DD"
    private static final Pattern expirationDatePattern = Pattern.compile(EXPIRATION_DATE_REGEXP);

    @Override
    public void parse(Domain sourceDomain) {
        if(sourceDomain.getWhoisResponce().isEmpty()) {
            return;
        }
        String value = getFieldValue(getMatchField(expirationDatePattern, sourceDomain.getWhoisResponce()), ":");
        if(!value.isEmpty()) {
            sourceDomain.setExpirationDate(value);
        }

    }
}
