package net.interdon.domaincheck.parsers;

import net.interdon.domaincheck.containers.Domain;

import java.util.regex.Pattern;

public class NetParser extends AbstractParser {
    private static final String EXPIRATION_DATE_REGEXP = "\\bExpiration Date\\b:\\s*\\d{2}-[a-z]{3}-\\d{4}"; //matches "Expiration Date: DD-Month-YYYY"
    private static final String MODIFIED_DATE_REGEXP = "\\bUpdated Date\\b:\\s*\\d{2}-[a-z]{3}-\\d{4}";
    private static final String CREATED_DATE_REGEXP = "\\bCreation Date\\b:\\s*\\d{2}-[a-z]{3}-\\d{4}";
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
