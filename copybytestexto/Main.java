/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaime.copybytestexto;

import java.io.File;

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
        
        File inputFile = new File(System.getProperty("user.dir")+"/src", "texto1.txt");
        File outputFile = new File(System.getProperty("user.dir")+"/src", "texto2.txt");

        CopyByTexto copybytexto = new CopyByTexto();
        copybytexto.copiarFichero(inputFile, outputFile, true);
        
    }
    
}
