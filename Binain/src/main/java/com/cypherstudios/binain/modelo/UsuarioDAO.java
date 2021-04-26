package com.cypherstudios.binain.modelo;

import java.sql.*;
import com.cypherstudios.binain.interfaces.IUsuarioDAO;

/**
 *
 * @author Victor
 */
public class UsuarioDAO extends Conexion implements IUsuarioDAO {

    //************************************* ACCIONES SOBRE LA BASE DE DATOS ****//
    @Override
    public boolean registrarUser(Usuario usr) {
        PreparedStatement psUsuarios = null;
        PreparedStatement psIdUsuario = null;
        PreparedStatement psDatosPersonales = null;
        PreparedStatement psSala = null;
        PreparedStatement psArtista = null;

        ResultSet rs = null;

        Connection con = getConexion();

        String sqlUsuarios = "INSERT INTO usuarios(nickName, password, email, idTipoUsr) VALUES (?,?,?,?);";
        String sqlDatosPersonales = "INSERT INTO datos_personales(nombre, apellido, direccion, localidad) VALUES (?,?,?,?);";
        String sqlSala = "INSERT INTO salas(nickName, password, email, idTipoUsr) VALUES (?,?,?,?);";
        String sqlArtista = "INSERT INTO usuarios(nickName, password, email, idTipoUsr) VALUES (?,?,?,?);";

        String sqlIdUsuario = "SELECT idUsuario FROM usuarios WHERE email = ?";
        try {

            /* Primero añado al usuario para poder obtener, después, el idUsuario
             */
            psUsuarios = con.prepareStatement(sqlUsuarios);

            psUsuarios.setString(1, usr.getNickName());
            psUsuarios.setString(2, Hash.sha1(usr.getPassword()));
            psUsuarios.setString(3, usr.getEmail());
            psUsuarios.setInt(4, usr.getIdTipoUsr());

            psUsuarios.executeUpdate();

            /* Extraigo el idUsuario generado en la base de datos */
            int idUsuario = getIdUsr(usr.getEmail(), sqlIdUsuario, psIdUsuario, rs);

            /*
            A PARTIR DE AQUI HAY QUE AÑADIR A LA BASE DE DATOS, A LAS TABLAS

            datos_personales : los datos personales del usuario. En el método getIdUsr
            se ha extraido el id.
            y Si es Artista => Artistas
            si es Sala => Salas

            VER LA MANERA DE COMPROBAR SI FUNCIONA.
             */
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

    /**
     * Ejecuta la consulta para extraer el idUsuario
     *
     * @param email
     * @param sqlIdUsuario
     * @param psIdUsuario
     * @param rs
     * @return
     * @throws SQLException : Devuelve un error si no se encuentra al usuario.
     */
    private int getIdUsr(String email, String sqlIdUsuario, PreparedStatement psIdUsuario, ResultSet rs) throws SQLException {
        int idUsuario;

        psIdUsuario = con.prepareStatement(sqlIdUsuario);

        psIdUsuario.setString(1, email);

        rs = psIdUsuario.executeQuery();
        if (rs.next()) {
            idUsuario = rs.getInt("idUsuario");
        } else {
            throw new SQLException("No se ha encontrado el usuario");
        }

        return idUsuario;
    }
}
