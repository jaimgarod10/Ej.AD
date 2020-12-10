/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaime.serializacion2;

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
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ObjectOutputStream out;
        ObjectInputStream in;
        String[] descs = {"parafusos", "cravos", "tachas"};
        String[] cods = {"p1", "p2", "p3"};
        double[] precios = {3, 4, 5};
        Product[] prod = new Product[3];
        Product p = null;
        Object obj;

        for (int i = 0; i < 3; ++i) {
            prod[i] = new Product(cods[i], descs[i], precios[i]);
        }
        try {
            out = new ObjectOutputStream(new FileOutputStream("serial"));
            for (int i = 0; i < 3; i++) {
                out.writeObject(prod[i]);
            }
            out.writeObject(p);
            out.close();
        } catch (IOException e) {
            System.out.println("No se pudo abrir el archivo. ");
        }

        try {
            in = new ObjectInputStream(new FileInputStream("serial"));
            while ((obj = in.readObject()) != null) {
                p = (Product) obj;
                System.out.println(obj);
            }
        } catch (IOException e2) {
            System.out.println("Error al abrir el archivo. ");
        } catch (ClassNotFoundException e3) {
            System.out.println("Clase no encontrada. ");
        }

    }

}
