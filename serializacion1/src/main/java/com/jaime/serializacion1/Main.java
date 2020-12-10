/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaime.serializacion1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        
        MClase objeto1 = new MClase("ola", -7, 2.7E10);
        MClase objeto2 = new MClase();
        
        try {

            ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Usuario\\OneDrive\\Documentos\\NetBeansProjects\\serializacion1\\serial.txt"));
            ObjectInputStream ler = new ObjectInputStream(new FileInputStream("C:\\Users\\Usuario\\OneDrive\\Documentos\\NetBeansProjects\\serializacion1\\serial.txt"));

            escribir.writeObject(objeto1);

            escribir.close();

            objeto2 = (MClase) ler.readObject();

            System.out.println(objeto2.getNombre());
            System.out.println(objeto2.getNumero1());
            System.out.println(objeto2.getNumero2());

            ler.close();

        } catch (IOException ex) {
            System.out.println("Error 1");
        }
    }
}
