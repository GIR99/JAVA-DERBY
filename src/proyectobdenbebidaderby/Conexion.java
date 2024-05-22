/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobdenbebidaderby;

import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author GIR_J
 */
public class Conexion {
    
    //clase que creara la bd en el proyecto
    public Connection CrearDB() throws SQLException{
        Connection con;
        //RUTA DE DONDE SE UBICARA LA BD
        String barra = File.separator;
        String proyecto= System.getProperty("user.dir")+barra+"Registros";
        //GUARDANDO LA RUTA PARA LA CREACION DE UN NUEVO ARCHIVO
        File url = new File(proyecto);
        if(url.exists()){
        System.out.println("Base de datos ya existe");
        }else {
            try {
                //creacion de la base de datos
                //LIBRERIA
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                //ESPECIFICACION DE RUTA
                String db = "jdbc:derby:"+proyecto+";create=true";
                //CREACION DE BASE DE DATOS
                con = DriverManager.getConnection(db);
                
                String tabla = "CREATE TABLE usuario (idUsuarios int,Nombre varchar(20),Pass varchar(50),Privilegios int)";
                try (PreparedStatement ps = con.prepareStatement(tabla)) {
                    ps.execute();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return null;
    }
    
    public Connection CargarDB(){

        Connection con;
        //RUTA DE DONDE SE UBICARA LA BD
        String barra = File.separator;
        String proyecto= System.getProperty("user.dir")+barra+"Registros";
        
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String db="jdbc:derby:"+proyecto;
            con= DriverManager.getConnection(db);
            
            System.out.println(" BASE DE DATOS CORRECTAMENTE CARGADA");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
               System.out.println(" Error:"+ex);
        }
        return null;

}
    
}
