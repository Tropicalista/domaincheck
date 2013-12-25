/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck;

import net.interdon.domaincheck.exceptions.NoServersForTldException;
import net.interdon.domaincheck.parsers.ServerPoolConfigParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ServerPool implements IServerPool {
    private HashMap<String, String> servers;
    public ServerPool(String pathToServerListXMLFile) throws ParserConfigurationException, SAXException, IOException,
            XPathExpressionException {
        servers = new HashMap<>();
        loadServersList(pathToServerListXMLFile);
    }

    @Override
    public String nextServer(String tld) throws NoServersForTldException {
        if(!servers.containsKey(tld)) {
            throw new NoServersForTldException(tld);
        }
        return servers.get(tld);
    }

    @Override
    public boolean hasServerFor(String tld) {
        return servers.containsKey(tld);
    }

    @Override
    public void addServer(String tld, String host) {
        servers.put(tld, host);
    }

    @Override
    public void delServer(String tld, String host) {
        servers.remove(tld);
    }

    @Override
    public List<String> tldList() {
        return null;
    }

    private void loadServersList(String xmlFilePath) throws ParserConfigurationException, SAXException, IOException,
            XPathExpressionException{
        ServerPoolConfigParser cfgParser = new ServerPoolConfigParser(xmlFilePath);
        if(cfgParser.tldCount() > 0) {
            List<String> tldList = cfgParser.getTldList();
            for(String tld: tldList) {
                servers.put(tld, cfgParser.getServer(tld));
            }
        }

    }
}
