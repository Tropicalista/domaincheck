/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck.parsers;

import net.interdon.domaincheck.containers.Domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractParser implements IDomainParser {

    public abstract void parse(Domain sourceDomain);

    public static String getMatchField(Pattern pattern, String source) {
        Matcher matcher = pattern.matcher(source);
        if(matcher.find()) {
            return getMatchString(matcher, source);
        }
        return null;
    }

    public static String getFieldValue(String source, String delimiter) {
        if(source == null || source.isEmpty()) {
            return "";
        }
        return source.split(delimiter, 2)[1].trim();
    }

    private static String getMatchString(Matcher matcher, String source) {
        return source.substring(matcher.start(), matcher.end());
    }
}
