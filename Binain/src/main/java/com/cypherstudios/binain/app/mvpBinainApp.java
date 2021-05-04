package com.cypherstudios.binain.app;

import com.cypherstudios.binain.controlador.CtrlLogin;
import com.cypherstudios.binain.controlador.CtrlRegistroUser;
import com.cypherstudios.binain.vista.Login;
import com.cypherstudios.binain.vista.PanelRegistro;
import javax.swing.JOptionPane;

/**
 *
 * @author Víctor Visús García
 */
public class mvpBinainApp {

    public static void main(String[] args) {

        //Vista
//        PanelRegistro appRegistro = new PanelRegistro();
//
//        CtrlRegistroUser ctrlReg = new CtrlRegistroUser(appRegistro);
//
//        ctrlReg.iniciarRegistro();

        Login appLogin = new Login();
        CtrlLogin ctrlLogin = new CtrlLogin(appLogin);
        ctrlLogin.iniciarLogin();
    }

}
