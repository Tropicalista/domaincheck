/*
 * Copyright (c) 2013. Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck.exceptions;

public class NoServersForTldException extends Exception {
    public NoServersForTldException(String message) {
        super("No servers for tld:" + message);
    }
}
