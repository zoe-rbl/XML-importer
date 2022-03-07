package com.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class fromXml {

    public static ArrayList<Person> fmXml() throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        //Creation of the array which will contains Person
        ArrayList<Person> list = new ArrayList<Person>();

        //File which will be parsed
        File inputFile = new File("myFile.xml");
        
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);

        doc.getDocumentElement().normalize();

        if(doc.getDocumentElement().getNodeName() == "Person"){

            //Creation of a list which take all childNode of "co-Worker"
            NodeList List = doc.getElementsByTagName("co-worker");
            
            for (int temp = 0; temp < List.getLength(); temp++) {


                Node node = List.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    //We take all properties from each person and add that in the ArrayList
                    int id = Integer.parseInt(element.getAttribute("id"));

                    String firstname = element.getElementsByTagName("name").item(0).getTextContent();
                    String lastname = element.getElementsByTagName("surname").item(0).getTextContent();
                    String function = element.getElementsByTagName("function").item(0).getTextContent();
                    list.add(new Person(id, firstname, lastname, function));
                }
            }
        }      
        return list;
    }


    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        System.out.print(fmXml());
    }

}
