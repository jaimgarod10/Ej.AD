/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaime.productsStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
class archivo {

    public static void escribirArchivo(File ent, Producto p) {
        File f;
        DataOutputStream salir = null;
        try {
            salir = new DataOutputStream(new FileOutputStream(ent));
            salir.writeUTF(p.getCodigo());
            salir.writeUTF(p.getDescripcion());
            salir.writeDouble(p.getPrecio());
        } catch (IOException e) {
            System.out.println("Fallo al abrir el archivo. ");
        } finally {
            try {
                if (salir != null) {
                    salir.close();
                }
            } catch (IOException e2) {
                System.out.println("Fallo al cerrar el archivo. ");
            }
        }
    }

    public static void agregarArchivo(File ent, Producto p) {
        DataOutputStream salir = null;
        try {
            salir = new DataOutputStream(new FileOutputStream(ent, true));
            salir.writeUTF(p.getCodigo());
            salir.writeUTF(p.getDescripcion());
            salir.writeDouble(p.getPrecio());
        } catch (IOException e) {
            System.out.println("Fallo al abrir el archivo. ");
        } finally {
            try {
                if (salir != null) {
                    salir.close();
                }
            } catch (IOException e2) {
                System.out.println("Fallo al cerrar el archivo. ");
            }
        }
    }

    public static void leerArchivo(DataInputStream ent, Producto p) {
        try {
            if (ent.available() != 0) {
                p.setCodigo(ent.readUTF());
                p.setDescripcion(ent.readUTF());
                p.setPrecio(ent.readDouble());
            }
        } catch (IOException e) {
            System.out.println("Fallo al abrir el archivo. ");
        }
    }
}
