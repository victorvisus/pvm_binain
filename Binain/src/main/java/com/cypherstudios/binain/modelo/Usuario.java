package com.cypherstudios.binain.modelo;

import com.cypherstudios.binain.interfaces.IOperacionesUsuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Clase Usuario, de esta clase heredan las clases Artista y Sala. Implementa a
 * las intefaces IDAOusuario y IOperacionesUsuario
 *
 * @author Victor
 */
public class Usuario implements IOperacionesUsuario {

    ArrayList<Estilos> estilos;

    /**
     * Método para almacenar los estilos del usuario en el ArrayList
     *
     * Se tiene que ejecutar cuando se inicie la sesión
     *
     * @return
     *
     */
    //************************************ INTERACCIONES CON OTROS USUARIOS ****//
    @Override
    public List<Usuario> listarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario infoUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
