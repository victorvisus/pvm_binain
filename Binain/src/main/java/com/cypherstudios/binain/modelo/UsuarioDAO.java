package com.cypherstudios.binain.modelo;

import com.cypherstudios.binain.exception.*;
import java.sql.*;
import com.cypherstudios.binain.interfaces.IUsuarioDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class UsuarioDAO extends Conexion implements IUsuarioDAO {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection con = null;
    private String sql = "";

    private int idUsuario;

    //************************************* ACCIONES SOBRE LA BASE DE DATOS ****//
    /**
     * Realiza la insercción de los datos en MySQL
     *
     * @param usr
     * @return
     */
    @Override
    public void registrarUser(Usuario usr) throws SQLException {

        con = getConexion();

        sql = "INSERT INTO usuarios(nickName, password, email, idTipoUsr) VALUES (?,?,?,?);";

        /* Primero añado al usuario para poder obtener el idUsuario */
        //Con PreparedStatement.RETURN_GENERATED_KEYS le indico que estoy interesado en la clave autoincremental
        ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        ps.setString(1, usr.getNickName());
        ps.setString(2, usr.getPassword());
        ps.setString(3, usr.getEmail());
        ps.setInt(4, usr.getIdTipoUsr());

        ps.executeUpdate();

        //Obtengo la clave autogenerada y la guardo en la variable de clase: idUsuario
        rs = ps.getGeneratedKeys();
        while (rs.next()) {
            idUsuario = rs.getInt(1);
        }

        insertDatosPersonales(usr);

        con.close();
    }

    @Override
    public void insertDatosPersonales(Usuario usr) throws SQLException {

        sql = "INSERT INTO datospersonales(nombre, apellido, direccion, localidad, idUsuario)"
                + " VALUES (?, ?, ?, ?, ?)";

        ps = con.prepareStatement(sql);

        ps.setString(1, usr.getDatosPersonales().getNombre());
        ps.setString(2, usr.getDatosPersonales().getApellido());
        ps.setString(3, usr.getDatosPersonales().getDireccion());
        ps.setString(4, usr.getDatosPersonales().getLocalidad());
        ps.setInt(5, idUsuario);

        ps.executeUpdate();
    }

    @Override
    public void insertSala(Sala sala) throws SQLException {
        con = getConexion();

        sql = "INSERT INTO salas(nombreSala, idUsuario)"
                + " VALUES (?,?)";

        ps = con.prepareStatement(sql);
        ps.setString(1, sala.getNombreSala());
        ps.setInt(2, idUsuario);

        ps.executeUpdate();

        con.close();
    }

    @Override
    public void insertArtista(Artista artista) throws SQLException {
        con = getConexion();

        sql = "INSERT INTO artistas(nombreArtista, idUsuario)"
                + " VALUES (?,?)";

        ps = con.prepareStatement(sql);
        ps.setString(1, artista.getNombreArtista());
        ps.setInt(2, idUsuario);

        ps.executeUpdate();

        con.close();
    }

    public void existeUsuario(Usuario usr) throws RegistroUsuasrioException, SQLException {
        con = getConexion();

        sql = "SELECT count(nickName) AS numero FROM usuarios WHERE nickName = ?";

        ps = con.prepareStatement(sql);
        ps.setString(1, usr.getNickName());

        rs = ps.executeQuery();

        while (rs.next()) {

            int num = rs.getInt("numero");
            if (num > 0) {
                throw new RegistroUsuasrioException(8);
            }
        }

        con.close();
    }

    public void existeMail(Usuario usr) throws RegistroUsuasrioException, SQLException {
        con = getConexion();

        sql = "SELECT count(email) AS numero FROM usuarios WHERE email = ?";

        ps = con.prepareStatement(sql);
        ps.setString(1, usr.getEmail());
        rs = ps.executeQuery();

        while (rs.next()) {

            int num = rs.getInt("numero");
            if (num > 0) {
                throw new RegistroUsuasrioException(7);
            }
        }

        con.close();
    }

    /**
     * En caso de Exception desde la base de datos elimina cualquier rastro de
     * lo que se haya intentado registrar
     */
    public void deleteError() {
        con = getConexion();

        String sqlDel1 = "DELETE FROM usuarios WHERE (idUsuario = '" + idUsuario + "');";
        String sqlDel2 = "DELETE FROM datospersonales WHERE (idDatosPersonales = '" + idUsuario + "');";
        String sqlDel3 = "DELETE FROM salas WHERE (idUsuario = '" + idUsuario + "');";
        String sqlDel4 = "DELETE FROM artistas WHERE (idUsuario = '" + idUsuario + "');";

        try {
            ps = con.prepareStatement(sqlDel1);
            ps.executeUpdate();

            //Por lo que sea la base de datos no me borra el registro en esta tabla
            ps = con.prepareStatement(sqlDel2);
            ps.executeUpdate();

            ps = con.prepareStatement(sqlDel3);
            ps.executeUpdate();

            ps = con.prepareStatement(sqlDel4);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error al limppiar el rastro del usuario"
                    + "\nMensaje SQLException: " + ex.getMessage()
                    + "\nCódgio de error: " + ex.getErrorCode());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión con la BBDD"
                        + "\nMensaje SQLException: " + ex.getMessage()
                        + "\nCódgio de error: " + ex.getErrorCode());
            }

        }
    }

    @Override
    public boolean iniciarSesion(Usuario usr) {
        try {
            con = getConexion();

            sql = "SELECT idUsuario, nickName, password, idTipoUsr FROM usuarios WHERE nickName = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getNickName());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (usr.getPassword().equals(rs.getString(3))) {

                    //Le paso los datos al modelo Usuario para poder acceder a ellos
                    usr.setIdUsuario(rs.getInt(1));
                    usr.setNickName(rs.getString(2));
                    usr.setIdTipoUsr(rs.getInt(4));

                    return true;
                } else {
                    return false;
                }

            }

            con.close();
            return false;
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión con la BBDD"
                    + "\nMensaje SQLException: " + ex.getMessage()
                    + "\nCódgio de error: " + ex.getErrorCode());
            return false;
        }
    }

    @Override
    public boolean modificarDatos(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarUsuario(Usuario user) {

        //DELETE FROM `binain_mvp`.`usuarios` WHERE (`idUsuario` = '10');
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
