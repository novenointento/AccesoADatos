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
class Departamento {
    private int detp_no;
    private String dnombre;
    private String localizacion;

    public Departamento() {
    }

    public Departamento(int detp_no, String dnombre, String localizacion) {
        this.detp_no = detp_no;
        this.dnombre = dnombre;
        this.localizacion = localizacion;
    }

    public int getDetp_no() {
        return detp_no;
    }

    public void setDetp_no(int detp_no) {
        this.detp_no = detp_no;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public String toString() {
        return "Departamento{" + "detp_no=" + detp_no + ", dnombre=" + dnombre + ", localizacion=" + localizacion + '}';
    }
    
    
}
