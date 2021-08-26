package com.example.finnkinoapp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class TheatreInfo {
    ArrayList<String> theatreInfo = new ArrayList<String>();
    private String Title;
    private String Time;

    public void request(String URL) {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(URL);
            doc.getDocumentElement().normalize();
            System.out.println("ROOT ELEMENT: " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getDocumentElement().getElementsByTagName("Show");
            for (int i = 0; i < nList.getLength(); i++) {

                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Title = element.getElementsByTagName("Title").item(0).getTextContent();
                    Time = element.getElementsByTagName("dttmShowStart").item(0)
                            .getTextContent().replace("T", " ");
                    theatreInfo.add(Title +" "+ Time);
                }

            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            }
        }
    public ArrayList<String> getList(String URL) {
        request(URL);
        return theatreInfo;
    }
}