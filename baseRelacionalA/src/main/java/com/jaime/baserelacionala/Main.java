/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaime.baserelacionala;

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
        
        Producto[] p = new Producto[3];
        String[] cods = {"p1","p2","p3"};
        String[] desc = {"parafusos","cravos","tachas"};
        int[] precios = {3,4,5};
        baseDeDatos bd;
        for(int i=0;i<3;i++){
            p[i]=new Producto(cods[i],desc[i],precios[i]);
        }
        bd = new baseDeDatos();
        //System.out.println("Mostrar productos");
        bd.mostrarProducto("p2");
        //System.out.println("Listar productos");
        bd.listarProductos();
        //System.out.println("Borrar Productos");
        bd.borrarProducto("p1");
        bd.listarProductos();
        bd.closeConnection();
        
    }
    
}
