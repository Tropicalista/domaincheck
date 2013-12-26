package net.interdon.domaincheck.parsers;

public class ParserFactory {
    public IDomainParser newParser(String tld) {
        switch (tld) {
            case "org.ua":
                return new OrgUaParser();
            case "dn.ua":
                return new OrgUaParser();
            case "lg.ua":
                return new OrgUaParser();
            default:
                return new DummyParser();
        }
    }
}
