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
public class Coche extends Vehiculo implements Repostable {

    private float litrosDeposito;
    private float capacidadDeposito;
    private String matricula;
    private String tipoCombustible;

    public Coche(float capacidadDeposito, String matricula, String tipoCombustible) {
        this.capacidadDeposito = capacidadDeposito;
        this.matricula = matricula;
        this.tipoCombustible = tipoCombustible;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public String toString() {
        return "Coche{" + "litrosDeposito=" + litrosDeposito + ", capacidadDeposito=" + capacidadDeposito + ", matricula=" + matricula + ", tipoCombustible=" + tipoCombustible + '}';
    }

    
    
    
    
    
    public float getLitrosDeposito() {
        return litrosDeposito;
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

    public String getCombustible() {
        return tipoCombustible;
    }

    public void setCombustible(String combustible) {
        this.tipoCombustible = combustible;
    }

    @Override
    public boolean repostar( float litrosARepostar,String combustibleARepostar) throws MisExcepciones.ErrorRepostaje{
        boolean repostar=true;
       
        if (this.capacidadDeposito - this.litrosDeposito > litrosARepostar && this.getTipoCombustible().equalsIgnoreCase(combustibleARepostar)) {
            litrosDeposito = litrosDeposito + litrosARepostar;
            repostar = true;
        } else {
             repostar = false;
            throw new MisExcepciones.ErrorRepostaje(litrosDeposito, litrosARepostar);
            
        }
        return repostar;

    }

}
