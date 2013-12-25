/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck.parsers;

public class OrgUaParser extends BasicParser {
    private static final String EXPIRATION_DATE_REGEXP = "\\bexpires\\b:{1}\\s*\\d{4}-{1}\\d{2}-{1}\\d{2}"; //matches "expires: YYYY-MM-DD"
    public OrgUaParser() {
        super(EXPIRATION_DATE_REGEXP);
    }
}
