package com.example.gio.agregarcontactos;

import java.io.Serializable;

/**
 * Created by mario on 05/09/2017.
 */

public class Contacto implements Serializable{
    private static final long serialVersionUID=1L;
    String Usuario;
    String Email;
    String Twitter;
    String Telefono;
    String Fecha;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setTwitter(String twitter) {
        Twitter = twitter;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getEmail() {
        return Email;
    }

    public String getTwitter() {
        return Twitter;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getFecha() {
        return Fecha;
    }
}


