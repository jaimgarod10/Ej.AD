/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaime.productsStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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

        DataInputStream ent = null;
        File f = new File("productos.txt");
        Producto p1 = new Producto("cod1", "parafusos", 3.0);
        Producto p2 = new Producto("cod2", "cravos", 4.0);
        Producto p3 = new Producto();
        archivo.escribirArchivo(f, p1);
        archivo.agregarArchivo(f, p2);
        try {
            ent = new DataInputStream(new FileInputStream(f));
        } catch (IOException e) {
            System.out.println("Fallo al abrir el archivo. ");
        }
        System.out.println("Lista de productos: ");
        try {
            do {
                archivo.leerArchivo(ent, p3);
                System.out.println(p3.getCodigo() + ", " + p3.getDescripcion() + ", " + p3.getPrecio());
            } while (ent.available() != 0);
            if (ent.available() == 0) {
                ent.close();
            }
        } catch (IOException e2) {
            System.out.println("Fallo al operar con el archivo. ");

        }
    }
}
