/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaime.xmlprueba2;

import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author Usuario
 */
public class xmlManager {

    public static void leerXML() {
        XMLInputFactory ireader = XMLInputFactory.newInstance();
        int i = 0;
        int contautores = 0;
        try {
            XMLStreamReader reader = ireader.createXMLStreamReader(new FileInputStream("prueba.xml"));
            while (reader.hasNext()) {
                i = reader.next();
                switch (i) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (reader.getLocalName().equals("autores")) {
                            System.out.println("----Comienzo de elemento compuesto----");
                        }
                        if (reader.getLocalName().equals("autor")) {
                            contautores++;
                            System.out.println(reader.getLocalName() + ": " + contautores);
                        } else {
                            if (reader.getLocalName().equals("nombre")) {
                                System.out.println(reader.getLocalName() + ": " + reader.getElementText());
                            } else {
                                if (reader.getLocalName().equals("titulo")) {
                                    System.out.println(reader.getLocalName() + ": " + reader.getElementText());
                                }
                            }
                        }
                        break;
                    case XMLStreamConstants.ATTRIBUTE:
                        System.out.println(reader.getAttributeLocalName(0) + "=" + reader.getAttributeValue(0));
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (reader.getLocalName().equals("autor")) {
                            System.out.println("---Fin de autor---");
                        }
                        if (reader.getLocalName().equals("autores")) {
                            System.out.println("----Fin de elemento compuesto----");
                        }
                        break;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo");
        } catch (XMLStreamException e2) {
            System.out.println("Error al abrir el archivo XML");
        }
    }
}    
