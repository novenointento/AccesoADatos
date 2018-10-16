/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioBasesDeDatos;

import java.util.GregorianCalendar;

/**
 *
 * @author gnord
 */
public class Empleado {

    private Persona persona;
    private String oficio;
    private int jefe;
    private int salario;
    private int comision;
    private Departamento dept;
    private GregorianCalendar fechaAlt;

    public Empleado(Persona persona, String oficio, int jefe, int salario, int comision, Departamento dept,GregorianCalendar fechaAlt) {
        this.persona = persona;
        this.oficio = oficio;
        this.jefe = jefe;
        this.salario = salario;
        this.comision = comision;
        this.dept = dept;
        this.fechaAlt=fechaAlt;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getJefe() {
        return jefe;
    }

    public void setJefe(int jefe) {
        this.jefe = jefe;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public Departamento getDept() {
        return dept;
    }

    public void setDept(Departamento dept) {
        this.dept = dept;
    }

    public int calcularSueldo() {
        int sueldo = 0;
        sueldo = salario + comision;

        return sueldo;
    }

    public void mostrarEmpleado() {

        System.out.println(this.getDept().getDetp_no() + "\t" + persona.getEmp_no() + "\t" + persona.getApellido() +"\t"+this.getOficio()+ "\t" + this.getJefe() + "\t" + this.getSalario() + "\t" + this.getComision() + "\t" + this.calcularSueldo());

    }
}
