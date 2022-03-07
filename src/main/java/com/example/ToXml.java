package com.example;

import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class ToXml {
    

    public static void CreateDocument(ArrayList<Person> list) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document file = docBuilder.newDocument();
        Element rootElement = file.createElement("Person");
        file.appendChild(rootElement);

        //Create each Person with Elements Id, name, surname and function with a loop
        for (Person p : list) {

        //Create root elements
        Element coWorker = file.createElement("co-worker");
        rootElement.appendChild(coWorker);
        coWorker.setAttribute("id", p.getMatrikelNummer()+"");


        Element name = file.createElement("name");
        name.setTextContent(p.getName());
        coWorker.appendChild(name);

        Element surname = file.createElement("surname");
        surname.setTextContent(p.getSurname());
        coWorker.appendChild(surname);

        Element function = file.createElement("function");
        function.setTextContent(p.getFunction());
        coWorker.appendChild(function);


        }
        

        // Write the content into xml file wich name is myFile.xml and is located in the same file as the programm
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        //For a prettier xml code
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(file);
        StreamResult resultat = new StreamResult(new File("myFile.xml"));
        
        //Transform into xml format
        transformer.transform(source, resultat);

    }





   
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
       
       // Create some Person into a array list, like a Läger of Person
        ArrayList<Person> list = new ArrayList<Person>();
        
        list.add(new Person(1254, "Riebel", "Zoe", "Trainee"));
        list.add(new Person(4589, "Borgers", "Joel", "Trainee"));
        list.add(new Person(7854, "Rheinert", "Pascal", "Director"));
        System.out.print(list.toString());

        CreateDocument(list);
    }
}
