package net.interdon.domaincheck.parsers;

public class ParserFactory {
    public IDomainParser newParser(String tld) {
        switch (tld) {
            case "org.ua":
                return new OrgUaParser();
            case "dn.ua":
                return new DnUaParser();
            case "donetsk.ua":
                return new DnUaParser();
            case "lg.ua":
                return new DnUaParser();
            case "com.ua":
                return new OrgUaParser();
            case "net":
                return new NetParser();
            default:
                return new DummyParser();
        }
    }
}
