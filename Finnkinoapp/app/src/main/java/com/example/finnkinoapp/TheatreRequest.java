package com.example.finnkinoapp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class TheatreRequest {
    ArrayList<String> theatreId = new ArrayList<String>();
    ArrayList<String> theatreInfo = new ArrayList<String>();
    private String ID;
    private String Name;

    public TheatreRequest() {
    }
    public void request () {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String URL = "https://www.finnkino.fi/xml/TheatreAreas/";
            Document doc = builder.parse(URL);
            doc.getDocumentElement().normalize();
            System.out.println("ROOT ELEMENT: " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getDocumentElement().getElementsByTagName("TheatreArea");
            for (int i = 0; i < nList.getLength(); i++) {


                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    ID = element.getElementsByTagName("ID").item(0).getTextContent();
                    System.out.println(ID);
                    Name = element.getElementsByTagName("Name").item(0).getTextContent();
                    theatreInfo(Name, ID);
                }

            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
    public void theatreInfo(String Name, String ID) {
        this.ID = ID;
        this.Name = Name;
        //System.out.println(this.Name);
        theatreInfo.add (this.Name);
        theatreId.add(this.ID);
        System.out.println("NAME: " + this.Name + "ID: " +this.ID);
    }

    public ArrayList<String> getTheatreInfo() {
        request();
        return theatreInfo;
    }

    public ArrayList<String> getTheatreId() {
        return theatreId;
    }
}