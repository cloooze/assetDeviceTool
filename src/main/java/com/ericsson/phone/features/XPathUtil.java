package com.ericsson.phone.features;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathUtil {
	
    public static String getValueAsString(String filePath, String value) throws ParserConfigurationException, SAXException, IOException {
        String id = null;
        XPathFactory xpathFactory = XPathFactory.newInstance();
      	XPath xpath = xpathFactory.newXPath();
        try {
            XPathExpression expr =
                xpath.compile(value);
            id = (String) expr.evaluate(getDoc(filePath), XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return id;
    }
    
    public static NodeList getValueAsNodes(String filePath, String value) throws ParserConfigurationException, SAXException, IOException {
        NodeList nodeList = null;
        XPathFactory xpathFactory = XPathFactory.newInstance();
      	XPath xpath = xpathFactory.newXPath();
        try {
            XPathExpression expr =
                xpath.compile(value);
            nodeList = (NodeList) expr.evaluate(getDoc(filePath), XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return nodeList;
    }
    
    private static Document getDoc(String filePath) throws ParserConfigurationException, SAXException, IOException {
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = null;
        XPathFactory xpathFactory = XPathFactory.newInstance();
    	XPath xpath = xpathFactory.newXPath();
		builder = factory.newDocumentBuilder();
        Document doc = builder.parse(filePath);
        
        return doc;
    }
    

}
