/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck.parsers;

import net.interdon.domaincheck.containers.Domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractParser implements IDomainParser {
    private Pattern expirationDatePattern;

    public AbstractParser(String expirationDateRegexp) {
        expirationDatePattern = Pattern.compile(expirationDateRegexp);
    }

    public abstract void parse(Domain sourceDomain);

    public static String getMatchString(Pattern pattern, String source) {
        Matcher matcher = pattern.matcher(source);
        if(matcher.find()) {
            return getMatchString(matcher, source);
        }
        return null;
    }

    private static String getMatchString(Matcher matcher, String source) {
        return source.substring(matcher.start(), matcher.end());
    }
}
