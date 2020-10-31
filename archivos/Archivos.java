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
public class Archivos {

    public void eDirectorio(String cadena) {
        
        File d = new File(cadena);
        if(d.isDirectory()){
            System.out.println("Es un directorio");
        }else
            System.out.println("No es un directorio"); 
    }
    
    public void eFichero(String cadena) {
        
        File f = new File(cadena);
        if(f.isFile()){
            System.out.println("Es un fichero");
        }else
            System.out.println("No es un fichero");
    }
    
    public void creaDirectorio(String cadena){
        
        File d = new File(cadena);
        if(!d.exists()){
          d.mkdir();
            System.out.println("Directorio creado.");
        }    
    }
    
    public void creaFichero(String dirName,String fileName) throws IOException{
        
        File f = new File(dirName, fileName);
        if(!f.exists()){
          f.createNewFile();
            System.out.println("Fichero creado. ");
        }
    }
    
    public void modoAcceso(String dirName,String fileName){
        
        File f = new File(dirName, fileName);
        
        if(f.canRead()){
            System.out.println("Lectura si. ");
        }
        if(!f.canRead()){
            System.out.println("Lectura no. ");
        }
        if(f.canWrite()){
            System.out.println("Escritura si. ");
        }
        if(!f.canWrite()){
            System.out.println("Escritura no. ");
        }
        
    }     
    
    public void calcularLongitud(String dirName,String fileName){
        
        File f = new File(dirName, fileName);
        System.out.println("La longitud es: " + f.length() + "bytes. " );
        
    }
    
    public void mLectura(String dirName,String fileName){
        
        File f = new File(dirName, fileName);
        f.setReadOnly();
        System.out.println("Solo lectura. ");

    }
    
    public void mEscritura(String dirName,String fileName){
        
        File f = new File(dirName, fileName);
        f.setWritable(true);
        System.out.println("Solo escritura. ");

    }
    
    public void borraFichero(String dirName,String fileName){
        
        File f = new File(dirName, fileName);
        if(f.exists()){
            f.delete();
            System.out.println("Fichero borrado. ");
        }else
            System.out.println("El fichero no existe. ");
    }
    
    public void borrarDirectorio(String dirName){
        
        File f = new File(dirName);
        if(f.exists()){
            f.delete();
            System.out.println("Directorio borrado. ");
        }else
            System.out.println("Ruta inexistente. ");
    }
    
    public void mContenido(String dirName){
        
        File f = new File(dirName);
        String lista[] = f.list();
        if(lista!=null){
            for (String fichero : lista) {
                System.out.println("\n " + fichero);
            }
        }else{
            System.out.println("No hay ningún fichero en el directorio. ");
        }
    }
    
    public void borrarTodo(File file) {
 
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
             borrarTodo(f);
            }
        }
        file.delete();
    }
    
    public void eliminarDirectorio(String dirName){
        //Elimina un directorio con ficheros y directorios dentro
        File f = new File(dirName);
        borrarTodo(f);
        System.out.println("Todo ha sido borrado. ");
    }  
 
}
