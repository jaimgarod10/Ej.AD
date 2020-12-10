/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaime.textodelimitado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author Usuario
 */
public class textodelimitado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        
        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos", "tachas"};
        Double[] precio = {3.0, 4.0, 5.0};
        
         try{

            PrintWriter escribir = new PrintWriter(new BufferedWriter(new FileWriter(new File("C:\\Users\\Usuario\\OneDrive\\Documentos\\NetBeansProjects\\textodelimitado\\productos.txt"))));

            BufferedReader leer = new BufferedReader(new FileReader(new File("C:\\Users\\Usuario\\OneDrive\\Documentos\\NetBeansProjects\\textodelimitado\\productos.txt")));

            for (int i = 0; i < cod.length; i++) {
                escribir.println(cod[i] + "\t" + desc[i] + "\t" + precio[i]);
            }
            escribir.close();

            String cadena = leer.readLine();
            String[] valor = cadena.split("\t");
            Producto1 p = new Producto1();

            p.setCodigo(valor[0]);
            p.setDescripcion(valor[1]);
            p.setPrecio(Double.parseDouble(valor[2]));

            System.out.println(p.toString());

            cadena = leer.readLine();
            valor = cadena.split("\t");

            p.setCodigo(valor[0]);
            p.setDescripcion(valor[1]);
            p.setPrecio(Double.parseDouble(valor[2]));
            
            System.out.println(p.toString());

            cadena = leer.readLine();
            valor = cadena.split("\t");

            p.setCodigo(valor[0]);
            p.setDescripcion(valor[1]);
            p.setPrecio(Double.parseDouble(valor[2]));

            System.out.println(p.toString());

        } catch (IOException ex) {
            System.out.println("Error ");
         }
    }
    
}
