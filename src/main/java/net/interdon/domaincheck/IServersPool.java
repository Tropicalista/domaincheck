/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck;

import java.util.List;

public interface IServersPool {
    String nextServer();
    int size();
}
