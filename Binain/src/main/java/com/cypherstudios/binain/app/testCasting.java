/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cypherstudios.binain.app;

import com.cypherstudios.binain.modelo.Artista;
import com.cypherstudios.binain.modelo.DatosPersonales;
import com.cypherstudios.binain.modelo.Sala;
import com.cypherstudios.binain.modelo.Usuario;

/**
 *
 * @author Victor
 */
public class testCasting {

    public static void main(String[] args) {

        DatosPersonales datPerson = new DatosPersonales("Zaragoza");

        Usuario usr = new Usuario("Vicho", "12234", "mail", datPerson);

        //usr = new Artista(usr.getNickName(), usr.getPassword(), usr.getEmail(), usr.getDatosPersonales(), "NombreArtis");
        usr = new Artista();

        imprimir(usr);
        determinarTipo(usr);
    }

    public static void imprimir(Usuario usr) {
        System.out.println(usr.toString());
    }

    public static void determinarTipo(Usuario usr) {
        if (usr instanceof Artista) {
            System.out.println("Es de tipo Artista" + usr.getClass());
            System.out.println(((Artista) usr).getNombreArtista());

            Artista artista = (Artista) usr;

            System.out.println(artista.toString() + " " + artista.getClass());

        } else if (usr instanceof Usuario) {
            System.out.println("Es de tipo Usuario" + usr.getClass());


        }
    }
}
