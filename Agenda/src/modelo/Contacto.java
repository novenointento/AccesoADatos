/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author gnord
 */
public class Contacto implements Serializable {

    private Persona p;
    private String correo;
    private ArrayList telefonos;

    public Persona getP() {
        return p;
    }

    public void setP(Persona p) {
        this.p = p;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ArrayList getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList telefonos) {
        this.telefonos = telefonos;
    }
    

    public void crearContacto(String nombre,String apellido, String mail, String telefono) {
        p = new Persona();
        telefonos=new ArrayList();
        p.setNombre(nombre);
        p.setApellidos(apellido);
        telefonos.add(telefono);
        
        correo = mail;

    }

    @Override
    public String toString() {
        return "Contacto{" +  p + ", correo= " + correo + ", telefonos= " + telefonos + '}';
    }
    
}
