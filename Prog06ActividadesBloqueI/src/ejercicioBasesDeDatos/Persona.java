/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioBasesDeDatos;

/**
 *
 * @author gnord
 */
public class Persona {
    private String apellido;
    private int emp_no;

    public Persona() {
    }

    public Persona(String apellido, int emp_no) {
        this.apellido = apellido;
        this.emp_no = emp_no;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    @Override
    public String toString() {
        return "Persona{" + "apellido=" + apellido + ", emp_no=" + emp_no + '}';
    }
    
}
