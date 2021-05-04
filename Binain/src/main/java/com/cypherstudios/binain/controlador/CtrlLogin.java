/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cypherstudios.binain.controlador;

import com.cypherstudios.binain.modelo.*;
import com.cypherstudios.binain.vista.Login;
import com.cypherstudios.binain.vista.PanelRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Victor
 */
public class CtrlLogin implements ActionListener {

    //Objetos
    //private Usuario user;
    private DatosPersonales datPerson;
    private Sala sala;
    private Artista artista;

    //Operaciones DAO
    private UsuarioDAO userDao = new UsuarioDAO();

    //Vista
    private Login appLogin;

    public CtrlLogin(Login appLogin) {
        this.appLogin = appLogin;

        this.appLogin.btnAcceder.addActionListener(this);
        this.appLogin.btnRegistro.addActionListener(this);
        this.appLogin.btnSalir.addActionListener(this);

    }

    public void iniciarLogin() {
        appLogin.setVisible(true);

        appLogin.setTitle("Inicio de sesión");
        appLogin.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == appLogin.btnSalir) {
            //Cierra la aplicación
            System.exit(0);

            /*
            Luego esta ventana debera llevar a la de Login
             */
        }

        if (e.getSource() == appLogin.btnRegistro) {
            PanelRegistro appRegistro = new PanelRegistro();
            CtrlRegistroUser ctrlReg = new CtrlRegistroUser(appRegistro);

            appLogin.dispose();
            ctrlReg.iniciarRegistro();
        }
    }

}
