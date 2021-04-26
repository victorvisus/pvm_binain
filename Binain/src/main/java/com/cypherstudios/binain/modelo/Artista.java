package com.cypherstudios.binain.modelo;

import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class Artista extends Usuario {

    ArrayList<Eventos> eventos;

    public Artista(String nickName, String password, String email,
            DatosPersonales datosPersonales) {
        super(nickName, password, email, datosPersonales);

    }

}
