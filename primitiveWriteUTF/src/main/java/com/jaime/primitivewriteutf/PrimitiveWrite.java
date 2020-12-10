/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaime.primitivewriteutf;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class PrimitiveWrite {

    public static void escribirCadena() {
        String cadena = "El tiempo está frío. ";
        File archDir;
        DataOutputStream salida = null;
        archDir = new File("texto3.txt");
        try {
            salida = new DataOutputStream(new FileOutputStream(archDir));
            for (int i = 0; i < 3; ++i) {
                System.out.println("Escribiendo la cadena: " + cadena);
                salida.writeUTF(cadena);
                System.out.println("tamaño del archivo: " + salida.size() + " Bytes");
            }
            System.out.println("Tamaño final del archivo: " + salida.size() + " Bytes");
        } catch (IOException e) {
            System.out.println("Error al operar con el archivo. ");
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e2) {
                    System.out.println("No se pudo cerrar el archivo. ");
                }
            }
        }
    }

    public static void leerArchivo() {
        File dirArch;
        DataInputStream entrada = null;
        dirArch = new File("texto3.txt");
        try {
            entrada = new DataInputStream(new FileInputStream(dirArch));
            while (entrada.available() != 0) {
                System.out.println("Quedan: " + entrada.available() + " Bytes por leer. ");
                System.out.println("cadena: " + entrada.readUTF());
            }
            if (entrada.available() == 0) {
                System.out.println("Ya no queda nada por leer. ");
            }
        } catch (IOException e) {
            System.out.println("Error al operar con el archivo. ");
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e2) {
                    System.out.println("No se puedo cerrar el archivo. ");
                }
            }
        }
    }

}
