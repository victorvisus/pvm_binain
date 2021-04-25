package com.cypherstudios.binain.interfaces;

import com.cypherstudios.binain.modelo.Usuario;

/**
 * Esta clase gestiona todas las operaciones que puede realizar el usuario sobre
 * la base de datos
 *
 * @author Victor
 */
public interface IDAOusuario {

    /**
     * Registra un nuevo usuario en la base de datos
     *
     * @param user
     * @return
     */
    /*
     ESTE MÉTODO SE PUEDE USAR SIN INICIAR SESIÓN
     */
    public abstract boolean registrarUser(Usuario user);

    /**
     *
     * @param user : COMPROBAR QUE TIENE QUE RECIBIR
     * @return
     */
    /*
    SE TIENE QUE PODER ACCEDER SIN NECESIDAD
      DE INICIAR SESIÓN */
    public abstract boolean iniciarSesion(Usuario user);

    /**
     * Actualiza la información del usuario en la BBDD
     *
     * @param user
     * @return
     */
    public abstract boolean modificarDatos(Usuario user);

    /**
     * Elimina al usuario de la BBDD
     *
     * @param user
     * @return
     */
    public abstract boolean eliminarUsuario(Usuario user);

}
