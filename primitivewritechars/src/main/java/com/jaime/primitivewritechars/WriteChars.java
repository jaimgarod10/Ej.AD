/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaime.primitivewritechars;

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
public class WriteChars {

    public static void escribirChars() {
        File dirArchivo;
        String cadena = "El tiempo está frío. ";
        DataOutputStream salida = null;
        dirArchivo = new File("texto4.txt");
        try {
            salida = new DataOutputStream(new FileOutputStream(dirArchivo));
            for (int i = 0; i < 2; ++i) {
                System.out.println("Escribiendo: " + cadena);
                salida.writeChars(cadena);
                System.out.println("La longitud de la cadena es de: " + cadena.length() + " caracteres");
                System.out.println("Se escribieron: " + salida.size() + " Bytes");
            }

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
    public static void leerChars(){
        File dirArchivo;
        String cadena = "";
        DataInputStream entrada = null;
        dirArchivo = new File("texto4.txt");
        
        try{
            entrada = new DataInputStream(new FileInputStream(dirArchivo));
            while (entrada.available()!=0 ) {
                for(int i =0; i<19;i++){
                    cadena = cadena + entrada.readChar();                    
                }
                System.out.println("Leemos la primera cadena: " + cadena);
                System.out.println("Quedan por leer: " + entrada.available() + " Bytes. ");
            }   
        }catch(IOException e){
            System.out.println("No se pudo operar con el archivo. ");
        }finally{
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e2) {
                    System.out.println("No se pudo cerrar el archivo. ");
                }
            }
        }
    }
}