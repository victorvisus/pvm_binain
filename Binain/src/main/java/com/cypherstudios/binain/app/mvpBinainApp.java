package com.cypherstudios.binain.app;

import com.cypherstudios.binain.controlador.CtrlInicio;
import com.cypherstudios.binain.controlador.CtrlLogin;
import com.cypherstudios.binain.controlador.CtrlPanelUsuario;
import com.cypherstudios.binain.controlador.CtrlRegistroUser;

/**
 *
 * @author Víctor Visús García
 */
public class mvpBinainApp {

    public static CtrlInicio ctrlInicio = new CtrlInicio();
    public static CtrlLogin ctrlLogin = new CtrlLogin();
    public static CtrlRegistroUser ctrlRegistro = new CtrlRegistroUser();
    public static CtrlPanelUsuario ctrlPanelUsuario = new CtrlPanelUsuario();

    public static void main(String[] args) {
        ctrlInicio.iniciarInicio();
    }

}
