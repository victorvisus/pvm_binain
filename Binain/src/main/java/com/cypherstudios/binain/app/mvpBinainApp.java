package com.cypherstudios.binain.app;

import com.cypherstudios.binain.controlador.CtrlInicio;
import com.cypherstudios.binain.controlador.CtrlLogin;
import com.cypherstudios.binain.controlador.CtrlPanelUsuario;
import com.cypherstudios.binain.controlador.CtrlRegistroUser;
import com.cypherstudios.binain.modelo.Artista;
import com.cypherstudios.binain.modelo.DatosPersonales;
import com.cypherstudios.binain.modelo.Sala;
import com.cypherstudios.binain.modelo.Usuario;

/**
 *
 * @author Víctor Visús García
 */
public class mvpBinainApp {

    //Controladores
    public static CtrlInicio ctrlInicio = new CtrlInicio();
    public static CtrlLogin ctrlLogin = new CtrlLogin();
    public static CtrlRegistroUser ctrlRegistro = new CtrlRegistroUser();
    //public static CtrlPanelUsuario ctrlPanelUsuario;

    //Objetos
//    public static Usuario usr = new Usuario();
//    public static Sala sala = new Sala();
//    public static Artista artista = new Artista();
//    public static DatosPersonales datPerson = new DatosPersonales();

    public static void main(String[] args) {
        ctrlInicio.iniciarInicio();
    }

}
