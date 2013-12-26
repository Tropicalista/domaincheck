package net.interdon.domaincheck.parsers;

import net.interdon.domaincheck.containers.Domain;

/*
 This parser actually do nothing.
 For not implemented tld`s.
* */
public class DummyParser implements IDomainParser {
    @Override
    public void parse(Domain domain) {}
}
