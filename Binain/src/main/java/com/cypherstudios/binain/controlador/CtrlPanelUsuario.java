package com.cypherstudios.binain.controlador;

import com.cypherstudios.binain.modelo.Artista;
import com.cypherstudios.binain.modelo.Sala;
import com.cypherstudios.binain.modelo.Usuario;
import com.cypherstudios.binain.modelo.UsuarioDAO;
import com.cypherstudios.binain.vista.PanelUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlPanelUsuario implements ActionListener {

    //Objetos
    private Usuario user;
    private Sala sala;
    private Artista artista;

    //Operaciones DAO
    private UsuarioDAO userDao = new UsuarioDAO();

    //Vista
    private PanelUsuario appPanUsuario;

    public CtrlPanelUsuario(Sala sala) {
        this.sala = sala;

        this.appPanUsuario = new PanelUsuario(this.sala);
        this.botones();
    }

    public CtrlPanelUsuario(Artista artista) {
        this.artista = artista;

        this.appPanUsuario = new PanelUsuario(this.artista);
        this.botones();
    }

    public void botones() {
        this.appPanUsuario.btnSalir.addActionListener(this);
        this.appPanUsuario.btnImprimeUsr.addActionListener(this);

        this.appPanUsuario.menuArtista.addActionListener(this);
        this.appPanUsuario.menuSala.addActionListener(this);
        this.appPanUsuario.menuMiCuenta.addActionListener(this);
    }

    public void iniciarPanelUsuarioSalas() {
        appPanUsuario.setVisible(true);

        appPanUsuario.setTitle("Binain - Panel de Opciones" + " " + sala.getNombreSala());
        appPanUsuario.setLocationRelativeTo(null);

        appPanUsuario.lblNombre.setText(sala.getNickName());
        appPanUsuario.lblRol.setText(sala.getNombre_tipo());
        appPanUsuario.lblNombreMarca.setText(sala.getNombreSala());

        appPanUsuario.menuArtista.setVisible(false);
    }

    public void iniciarPanelUsuarioArtistas() {
        appPanUsuario.setVisible(true);

        appPanUsuario.setTitle("Binain - Panel de Opciones" + " " + artista.getNombreArtista());
        appPanUsuario.setLocationRelativeTo(null);

        appPanUsuario.lblNombre.setText(artista.getNickName());
        appPanUsuario.lblRol.setText(artista.getNombre_tipo());
        appPanUsuario.lblNombreMarca.setText(artista.getNombreArtista());

        appPanUsuario.menuSala.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == appPanUsuario.btnSalir) {
            //Cierra la aplicación
            System.exit(0);
        }

        if (e.getSource() == appPanUsuario.btnImprimeUsr) {
            if (sala != null) {
                String datos = "Usuario: " + sala.toString() + "\nUsuario tipo: "
                        + sala.getNombre_tipo() + "\nClase usr: " + sala.getClass();
                JOptionPane.showMessageDialog(null, datos, "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE);

            } else if (artista != null) {
                String datos = "Usuario: " + artista.toString()
                        + "\nUsuario tipo: " + artista.getNombre_tipo() + "\nClase usr: " + artista.getClass();
                JOptionPane.showMessageDialog(null, datos, "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "No hay usuario logeado", "Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
            }

        }

    }
}
