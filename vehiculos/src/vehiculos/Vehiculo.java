/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculos;

/**
 *
 * @author gnord
 */
public class Vehiculo implements Acelerable{
    private String matricula;
    static int totalVehiculos;
    private float velocidad;
    private int taquimetro;
    private float posicionX;
    private float posicionY;
    private float posicionZ;
    private float capacidadDeposito;
    private float litrosDeposito;

    public float getLitrosDeposito() {
        return litrosDeposito;
    }

    public void setLitrosDeposito(float litrosDeposito) {
        this.litrosDeposito = litrosDeposito;
    }
    
    

    public float getCapacidadDeposito() {
        return capacidadDeposito;
    }

    public void setCapacidadDeposito(float capacidadDeposito) {
        this.capacidadDeposito = capacidadDeposito;
    }
    
    
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public static int getTotalVehiculos() {
        return totalVehiculos;
    }

    public static void setTotalVehiculos(int totalVehiculos) {
        Vehiculo.totalVehiculos = totalVehiculos;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    public int getTaquimetro() {
        return taquimetro;
    }

    public void setTaquimetro(int taquimetro) {
        this.taquimetro = taquimetro;
    }

    public double getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(float posicionX) {
        this.posicionX = posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(float posicionY) {
        this.posicionY = posicionY;
    }

    public double getPosicionZ() {
        return posicionZ;
    }

    public void setPosicionZ(float posicionZ) {
        this.posicionZ = posicionZ;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", velocidad=" + velocidad + ", posicionX=" + posicionX + ", posicionY=" + posicionY + ", posicionZ=" + posicionZ + '}';
    }

    @Override
    public void acelerar(float aceleracion) {
        this.setVelocidad(velocidad+aceleracion);
    }

    @Override
    public void decelerar(float aceleracion) {
      this.setVelocidad(velocidad-aceleracion);
    }

    
    
    
    
    
}
