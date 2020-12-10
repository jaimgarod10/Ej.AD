/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaime.aleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;

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

        String a = null;
        String[] codes = {"p1", "p2", "p3"};
        String[] descricion = {"parafusos", "cravos ", "tachas"};
        int[] prices = {3, 4, 5};

        char susti;
        String codigo = "", descrip = "";
        int p;
        try {
            RandomAccessFile escribir = new RandomAccessFile("C:\\Users\\Usuario\\OneDrive\\Documentos\\NetBeansProjects\\aleatorio\\aleatorio.txt", "rw");

            for (int i = 0; i < codes.length; i++) {
                a = String.format("%-3s", codes[i]).replace(' ', '+');
                escribir.writeChars(a);
                a = String.format("%-10s", descricion[i]).replace(' ', '+');
                escribir.writeChars(a);
                escribir.writeInt(prices[i]);
            }
            escribir.seek((2 - 1) * 30);
            for (int i = 0; i < 3; i++) {
                susti = escribir.readChar();
                codigo = codigo + susti;
            }
            for (int i = 0; i < 10; i++) {
                susti = escribir.readChar();
                descrip = descrip + susti;
            }
            codigo = codigo.replace('+', ' ');
            System.out.println(codigo);
            descrip = descrip.replace('+', ' ');
            System.out.println(descrip);
            p = escribir.readInt();
            System.out.println(p);
        } catch (IOException ex) {
            System.out.println("Error 1");
        }

    }

}
