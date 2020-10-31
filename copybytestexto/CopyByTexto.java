/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaime.copybytestexto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class CopyByTexto {
    
    public void copiarFichero(File file1, File file2) {
        try {
            FileInputStream inputFile = new FileInputStream(file1);
            try (FileOutputStream outputFile = new FileOutputStream(file2)) {
                outputFile.write(inputFile.readAllBytes());
            }
            System.out.println("El fichero fue copiado. ");
        } catch (IOException e) {
        }
    }

    public void copiarFichero(File file1, File file2, Boolean append) {
        try {
            FileInputStream inputFile = new FileInputStream(file1);
            try (FileOutputStream outputFile = new FileOutputStream(file2, append)) {
                outputFile.write(inputFile.readAllBytes());
            }
            System.out.println("El fichero fue copiado.");
        } catch (IOException e) {
        }
    }
    
}
