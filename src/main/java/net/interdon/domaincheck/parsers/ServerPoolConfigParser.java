/*
 * Copyright (c) 2013 Evgeniy Dolgikh <marcon@atsy.org.ua>
 * See the file LICENSE for copying permission.
 */

package net.interdon.domaincheck.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerPoolConfigParser {
    private static final String XML_TAG_TLD = "tld";
    private static final String XML_TAG_SERVER = "server";
    private static final String XML_TLD_NAME_ATTRIBUTE = "name";
    private NodeList tldList;
    private final Document doc;
    private final XPathFactory xPathFactory;
    public ServerPoolConfigParser(String pathToConfigXML) throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File(pathToConfigXML);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        doc = documentBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        tldList = doc.getElementsByTagName(XML_TAG_TLD);
        xPathFactory = XPathFactory.newInstance();
    }

    public int tldCount() {
        return tldList.getLength();
    }

    public List<String> getTldList() {
        List<String> result = new ArrayList<>();
        NamedNodeMap attributes;
        for(int i=0; i<tldCount(); i++) {
            if((attributes = tldList.item(i).getAttributes()) != null) {
                result.add(attributes.getNamedItem(XML_TLD_NAME_ATTRIBUTE).getTextContent());
            }
        }
        return result;
    }

    public String getServer(String tld) throws XPathExpressionException {
        XPathExpression expr = xPathFactory.newXPath().compile(String.format("/whois-servers/%s[@%s='%s']/%s/text()",
                XML_TAG_TLD, XML_TLD_NAME_ATTRIBUTE, tld, XML_TAG_SERVER));
        return expr.evaluate(doc);
    }
}
