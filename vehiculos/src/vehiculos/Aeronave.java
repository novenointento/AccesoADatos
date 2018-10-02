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
public class Aeronave extends Vehiculo implements Repostable,Acelerable,Volable {

    private float alturaVuelo;
    private float capacidadDeposito;
    private String tipoCombustible;
     private float litrosDeposito;

    public float getAlturaVuelo() {
        return alturaVuelo;
    }

    public void setAlturaVuelo(float alturaVuelo) {
        this.alturaVuelo = alturaVuelo;
    }

    public float getCapacidadDeposito() {
        return capacidadDeposito;
    }

    public void setCapacidadDeposito(float capacidadDeposito) {
        this.capacidadDeposito = capacidadDeposito;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public float getLitrosDeposito() {
        return litrosDeposito;
    }

    public void setLitrosDeposito(float litrosDeposito) {
        this.litrosDeposito = litrosDeposito;
    }

    /**
     *
     * @param litrosARepostar
     * @param combustibleARepostar
     * @return
     * @throws MisExcepciones
     */
    @Override
    public boolean repostar( float litrosARepostar,String combustibleARepostar) {
        boolean repostar=true;
       
        if (this.capacidadDeposito - this.litrosDeposito > litrosARepostar && this.getTipoCombustible().equalsIgnoreCase(combustibleARepostar)) {
            litrosDeposito = litrosDeposito + litrosARepostar;
            repostar = true;
        } else {
            repostar = false;
        }
        return repostar;

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Float.floatToIntBits(this.alturaVuelo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aeronave other = (Aeronave) obj;
        if (!super.getMatricula().equalsIgnoreCase( super.getMatricula())) {
            return false;
        }
        return true;
    }

}
