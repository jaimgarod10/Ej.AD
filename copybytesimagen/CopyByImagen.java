/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaime.copybytesimagen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class CopyByImagen {
    
public void copiarImagen(String nombre){    
    File name;
        FileInputStream org = null;
        FileOutputStream copia=null;
        name=new File(nombre);

        int contenido;
        try {
            org=new FileInputStream(name);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CopyByImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            copia=new FileOutputStream("foto2.jpg",true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CopyByImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while((contenido=org.read()) != -1){
                copia.write(contenido);
            }
        } catch (IOException ex) {
            Logger.getLogger(CopyByImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            if(org != null){
                org.close();
            }
            if(copia != null){
                copia.close();
            }
        }catch(IOException e2){
            System.out.println("Hubo un error al cerrar los archivos");
        }
    }    
}