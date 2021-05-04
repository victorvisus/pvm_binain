package com.cypherstudios.binain.controlador;

import com.cypherstudios.binain.modelo.Artista;
import com.cypherstudios.binain.modelo.Sala;
import com.cypherstudios.binain.modelo.Usuario;
import com.cypherstudios.binain.modelo.UsuarioDAO;
import com.cypherstudios.binain.vista.PanelUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlPanelUsuario implements ActionListener {

    //Objetos
    private Usuario user;
    private Sala sala;
    private Artista artista;

    //Operaciones DAO
    private UsuarioDAO userDao = new UsuarioDAO();

    //Vista
    private PanelUsuario appPanUsuario = new PanelUsuario();

    public CtrlPanelUsuario() {
        this.appPanUsuario.btnSalir.addActionListener(this);
    }

    public void iniciarPanelUsuario() {
        appPanUsuario.setVisible(true);

        appPanUsuario.setTitle("Binain - Panel de Opciones");
        appPanUsuario.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == appPanUsuario.btnSalir) {
            //Cierra la aplicación
            System.exit(0);
        }
    }
}
