package com.cypherstudios.binain.modelo;

import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class Sala extends Usuario {

    ArrayList<Eventos> eventos;

    public Sala(String nickName, String password, String email,
            DatosPersonales datosPersonales) {
        super(nickName, password, email, datosPersonales);

    }
}
