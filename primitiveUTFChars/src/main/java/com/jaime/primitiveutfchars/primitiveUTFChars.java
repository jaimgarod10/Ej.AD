/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaime.primitiveutfchars;

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
public class primitiveUTFChars {

    public static void escribirUTFChars() {
        
        File directorioArchivo;
        String cadena = "Está en casa";
        DataOutputStream salida = null;
        directorioArchivo = new File("texto6.dat");
        
        try {
            
            salida = new DataOutputStream(new FileOutputStream(directorioArchivo));
            System.out.println("writeUTF escribiendo: " + cadena);
            
            salida.writeUTF(cadena);
            System.out.println("Total bytes escritos: " + salida.size() + " Bytes");
            System.out.println("writeChars escribiendo: " + cadena);
            
            salida.writeChars(cadena);
            System.out.println("Total bytes escritos: " + salida.size() + " Bytes");
            System.out.println("writeUTF escribiendo: " + cadena);
            
            salida.writeUTF(cadena);
            System.out.println("Total bytes escritos: " + salida.size() + " Bytes");
            
        } catch (IOException e) {
            System.out.println("Error al operar con el archivo. ");
        } finally {
            
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e1) {
                    System.out.println("Error al cerrar el archivo. ");
                }
            }
        }
    }

    public static void leerUTFChars() {
        
        File directorioArchivo;
        DataInputStream entrada=null;
        String cadena="";
        directorioArchivo=new File("texto6.dat");
        
        try{
            
            entrada=new DataInputStream(new FileInputStream(directorioArchivo));
            
            while(entrada.available()!=0){
                
                System.out.println("Numero de Bytes por leer: " + entrada.available() + " Bytes");
                System.out.println("Primera cadena leida con readUTF: " + entrada.readUTF());
                
                for(int i=0;i<12;i++){
                    cadena=cadena+entrada.readChar();
                }
                System.out.println("Segunda cadena leida con readChar(): " + cadena);
                System.out.println("Numero de Bytes por leer: " + entrada.available() + " Bytes");
                System.out.println("Tercera cadena leida con readUTF: " + entrada.readUTF());
                System.out.println("Numero de Bytes por leer: " + entrada.available() + " Bytes");
                cadena="";
            }
        }catch(IOException e){
            System.out.println("Error al operar con el archivo. ");
        }finally{
            
            if(entrada != null){
                try{
                    entrada.close();
                }catch(IOException e2){
                    System.out.println("Error al cerrar el archivo. ");
                }
            }
        }
    }
}
