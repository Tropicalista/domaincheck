package net.interdon.domaincheck.parsers;

import net.interdon.domaincheck.containers.Domain;

import java.util.regex.Pattern;

public class DnUaParser extends AbstractParser {
    private static final String EXPIRATION_DATE_REGEXP = "\\bexpires\\b:\\s*\\d{4}-\\d{2}-\\d{2}"; //matches "expires: YYYY-MM-DD"
    private static final String MODIFIED_DATE_REGEXP = "\\bupdated\\b:\\s*\\d{4}-\\d{2}-\\d{2}";
    private static final String CREATED_DATE_REGEXP = "\\bregistered\\b:\\s*\\d{4}-\\d{2}-\\d{2}";
    private static final Pattern expirationDatePattern = Pattern.compile(EXPIRATION_DATE_REGEXP);
    private static final Pattern modifiedDatePattern = Pattern.compile(MODIFIED_DATE_REGEXP);
    private static final Pattern createdDatePattern = Pattern.compile(CREATED_DATE_REGEXP);

    @Override
    public void parse(Domain sourceDomain) {
        if(sourceDomain.getWhoisResponce().isEmpty()) {
            return;
        }
        String value = getFieldValue(getMatchField(expirationDatePattern, sourceDomain.getWhoisResponce()), ":");
        if(!value.isEmpty()) {
            sourceDomain.setExpirationDate(value);
        }
        value = getFieldValue(getMatchField(modifiedDatePattern, sourceDomain.getWhoisResponce()), ":");
        if(!value.isEmpty()) {
            sourceDomain.setDateLastModifyed(value);
        }
        value = getFieldValue(getMatchField(createdDatePattern, sourceDomain.getWhoisResponce()), ":");
        if(!value.isEmpty()) {
            sourceDomain.setDateCreated(value);
        }
    }
}
