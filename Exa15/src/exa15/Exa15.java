/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exa15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author oracle
 */
public class Exa15 {

    /**
     * @param args the command line arguments
     */
    public static Connection conexion = null;

    public static Connection getConexion() throws SQLException {
        String usuario = "hr";
        String password = "hr";
        String host = "localhost";
        String puerto = "1521";
        String sid = "orcl";
        String ulrjdbc = "jdbc:oracle:thin:" + usuario + "/" + password + "@" + host + ":" + puerto + ":" + sid;

        conexion = DriverManager.getConnection(ulrjdbc);
        return conexion;
    }

    public static void closeConexion() throws SQLException {
        conexion.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException, ClassNotFoundException, XMLStreamException {

        Platos plato;

        //declaramos la ruta del fichero platos
        String ruta = "/home/oracle/Desktop/compartido/Exa15/src/exa15/platoss";

        // declaraciones para leer el fichero
        FileInputStream fich = new FileInputStream(ruta);
        ObjectInputStream leer = new ObjectInputStream(fich);

        // lectura del fichero que se almacena en el objeto plato
        plato = (Platos) leer.readObject();

        //declaraciones para la lectura de la base de datos
        Statement st1;
        ResultSet res1;
        ResultSet res2;
        Statement st2;
        getConexion();
        st1 = conexion.createStatement();
        st2 = conexion.createStatement();

        // declaraciones para escritura de fichero xml
        XMLOutputFactory obx;
        XMLStreamWriter xml;
        FileWriter escribir;
        obx = XMLOutputFactory.newInstance();
        escribir = new FileWriter("/home/oracle/Desktop/compartido/Exa15/src/totalgraxas.xml");
        xml = obx.createXMLStreamWriter(escribir);
        xml.writeStartDocument("1.0");
        xml.writeStartElement("Productos");

        //inicializamos contador de grasa total
        int grasaTotal = 0;

        while (plato != null) {
            //guardamos codigo y nombre en las siguientes variables
            String codp = plato.getCodigop();
            String nomep = plato.getNomep();
            
            System.out.println("CODIGO DEL PLATO: " + codp);
            System.out.println("Nombre del plato: " + nomep);
            
            // consulta para obtener el codigo de los componetes del plato
            res1 = st1.executeQuery("SELECT * FROM composicion where CODP='" + codp + "'");
            while (res1.next()) {
                
                
                String codc = res1.getString("CODC");
                int peso = res1.getInt("PESO");
                //consulta para obtener las grasas de cada componente
                res2 = st2.executeQuery("SELECT * FROM componentes where CODC='" + codc + "'");
                while (res2.next()) {
                    System.out.println("Codigo del componente: " + res2.getString("CODC") + "-> " + "grasa por cada 100 gr= " + res2.getInt("GRAXA"));
                    String grasa = res2.getString("GRAXA");
                    float grasacomponente = (Float.parseFloat(grasa) * peso) / 100;
                    grasaTotal += grasacomponente;
                    System.out.println("peso: " + res1.getString("PESO"));
                    System.out.println("Total de grasa del componente: " + grasacomponente + "\n");
                }
            }
            System.out.println("TOTAL EN GRASA DEL PATO: "+ grasaTotal + "\n");
           
            
            //generamos fichero xml
            xml.writeStartElement("Platos");
            xml.writeStartElement("Plato");
            xml.writeAttribute("Codigop", codp);
            xml.writeStartElement("nombrep");
            xml.writeCharacters(nomep);
            xml.writeEndElement();
            xml.writeStartElement("grasaTotal");
            xml.writeCharacters(String.valueOf(grasaTotal));
            xml.writeEndElement();
            xml.writeEndElement();
            xml.writeEndElement();
            plato = (Platos) leer.readObject();

            //para poder leer los platos ponemos a cero la grasa total para el siguiente plato
            grasaTotal = 0;

        }
        //cerramos el fichero xml
        xml.writeEndElement();
        xml.writeEndDocument();
        xml.close();
        //cerrramos el fichero platoss
        leer.close();
        //cerramos la conexión a la base de datos
        closeConexion();

    }
}
