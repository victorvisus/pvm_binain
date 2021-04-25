package com.cypherstudios.binain.modelo;

import com.cypherstudios.binain.interfaces.IDAOusuario;
import java.sql.*;

/**
 *
 * @author Victor
 */
public class UsuarioDAO extends Conexion implements IDAOusuario {

    //************************************* ACCIONES SOBRE LA BASE DE DATOS ****//
    @Override
    public boolean registrarUser(Usuario user) {
        PreparedStatement ps = null;

        Connection con = getConexion();

        String sql = "INSERT INTO usuarios(usuario, password, nombre, correo, id_tipo) VALUES (?,?,?,?,?);";

        try {
            /*
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getPassword());
            ps.setString(3, usr.getNombre());
            ps.setString(4, usr.getCorreo());
            ps.setInt(5, usr.getId_tipo());
             */

            ps.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    @Override
    public boolean iniciarSesion(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarDatos(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarUsuario(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
