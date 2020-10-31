/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaime.archivos;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Archivos a = new Archivos();
        
        //Ej. 1
        System.out.println("*************");
        System.out.println(" Ejercicio 1 ");
        System.out.println("*************");
        System.out.println("\n");
        String ruta = "C:\\Users\\Usuario\\OneDrive\\Documentos\\NetBeansProjects\\archivos";
        File f = new File(ruta , "archivosdir");
        if(!f.exists()){
            a.creaDirectorio(ruta + "\\archivosdir");
        }
        a.eDirectorio(ruta + " \\archivosdir");
        
        //Ej. 2

        System.out.println("*************");
        System.out.println(" Ejercicio 2 ");
        System.out.println("*************");
        System.out.println("\n");
        String ruta1 = "C:\\Users\\Usuario\\OneDrive\\Documentos\\NetBeansProjects\\archivos\\archivosdir";
        File f1 = new File(ruta1, "Products1.txt");
        if(!f1.exists()){
            a.creaFichero(ruta1 , "Products1.txt");
        }
        a.eFichero(ruta1 + " Products1.txt");
        
        //Ej. 3
        
        System.out.println("*************");
        System.out.println(" Ejercicio 3 ");
        System.out.println("*************");
        System.out.println("\n");
        File f2 = new File(ruta1 , "subdir");
        if(!f2.exists()){
            a.creaDirectorio(ruta1 + "\\subdir");
        }
        //a.eDirectorio(ruta1 + " \\subdir");
        
        String ruta3 = "C:\\Users\\Usuario\\OneDrive\\Documentos\\NetBeansProjects\\archivos\\archivosdir\\subdir";
        File f3 = new File(ruta3, "Products2.txt");
        if(!f3.exists()){
            a.creaFichero(ruta3 , "Products2.txt");
        }
        //a.eFichero(ruta3 + " Products2.txt");
        
        //Ej. 4
        
        System.out.println("*************");
        System.out.println(" Ejercicio 4 ");
        System.out.println("*************");
        System.out.println("\n");
        a.mContenido(ruta1);
        
        //Ej. 5
        
        System.out.println("*************");
        System.out.println(" Ejercicio 5 ");
        System.out.println("*************");
        System.out.println("\n");
        a.modoAcceso(ruta1 , "\\Products1.txt");
        
        //Ej. 6
        
        System.out.println("*************");
        System.out.println(" Ejercicio 6 ");
        System.out.println("*************");
        System.out.println("\n");
        a.mLectura(ruta1, "\\Products1.txt");
        
        //Ej. 7
        
        System.out.println("*************");
        System.out.println(" Ejercicio 7 ");
        System.out.println("*************");
        System.out.println("\n");
        a.mEscritura(ruta1, "\\Products1.txt");
        
        //Ej. 8
        
        System.out.println("*************");
        System.out.println(" Ejercicio 8 ");
        System.out.println("*************");
        System.out.println("\n");
        a.borraFichero(ruta1, "\\Products1.txt");
        
        //Ej. 9
        
        System.out.println("*************");
        System.out.println(" Ejercicio 9 ");
        System.out.println("*************");
        System.out.println("\n");
        a.eliminarDirectorio("archivosdir");
        
    }
    
}
