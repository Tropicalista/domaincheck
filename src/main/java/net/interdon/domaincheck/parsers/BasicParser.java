/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck.parsers;

import net.interdon.domaincheck.containers.Domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicParser {
    private Pattern expirationDatePattern;

    public BasicParser(String expirationDateRegexp) {
        expirationDatePattern = Pattern.compile(expirationDateRegexp);
    }

    public Domain parse(Domain sourceDomain) {
        if(sourceDomain.getWhoisResponce().isEmpty()) {
            return sourceDomain;
        }
        Matcher matcher = expirationDatePattern.matcher(sourceDomain.getWhoisResponce());
        if(matcher.find()) {
            String value = getMatchString(matcher, sourceDomain.getWhoisResponce());
            sourceDomain.setExpirationDate(value.split(":")[1].trim());
            return sourceDomain;
        }
        return sourceDomain;
    }

    private static String getMatchString(Matcher matcher, String source) {
        return source.substring(matcher.start(), matcher.end());
    }
}
