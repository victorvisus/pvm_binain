package com.cypherstudios.binain.exception;

/**
 *
 * @author Victor
 */
public class RegistroUsuasrioException extends Exception {

    private int codigoError;

    /**
     *
     * @param codigoError
     */
    public RegistroUsuasrioException(int codigoError) {
        super();
        this.codigoError = codigoError;
    }

    /**
     * Dependiendo del número de error recibido lanza un mensaje u otro
     *
     * @return mensaje de error
     */
    public String getMessage() {
        String msjError = "";
        System.out.println(codigoError);
        switch (codigoError) {
            case 1:
                // Contraseña no-Valida
                msjError = "Las contraseñas introducidas no coinciden";
                break;
            case 2:
                msjError = "La contraseña no puede tener menos de 8 caracteres";
                break;
            case 3:
                msjError = "La contraseña debe incluir números, letras en mayúsculas y minúsculas y algún caracter especial ( !-_@#$%^&+= )";
                break;
            case 4:
                //e-mail no-Valido
                msjError = "La dirección de e-mail no es correcta";
                break;
            case 5:
                //RadioButton tiene que haber uno seleccionado
                msjError = "Debes elegir un tipo de usuario: Sala o Artista";
                break;
            case 6:
                //Campos del formulario vacios
                msjError = "Los campos Nick, Ciudad y el nombre de tu sala o de tu banda no pueden estar vacios";
                break;
            case 7:
                //Mail ya existe
                msjError = "La dirección de e-mail ya se encuentra en el sistema";
                break;
            case 8:
                //Usuario ya existe
                msjError = "El usuario ya existe";
                break;
        }

        return msjError;
    }

}
