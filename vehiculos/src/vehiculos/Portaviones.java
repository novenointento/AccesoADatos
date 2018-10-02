/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculos;

import java.util.List;



/**
 *
 * @author gnord
 */
public class Portaviones extends Vehiculo implements flotable {
    private int manga;
    private int eslora;
    private List<Aeronave> aviones;

    public int getManga() {
        return manga;
    }

    public void setManga(int manga) {
        this.manga = manga;
    }

    public int getEslora() {
        return eslora;
    }

    public void setEslora(int eslora) {
        this.eslora = eslora;
    }

    public List<Aeronave> getAviones() {
        return aviones;
    }

    public void setAviones(List<Aeronave> aviones) {
        this.aviones = aviones;
    }
    
    
   public Aeronave anadirAeronave(Aeronave n) {
   
   this.aviones.add(n);
   return n;
   
   }
   
   public Aeronave borrarAeronave(Aeronave n){
   this.aviones.remove(n);
   
   return n;
   }
    
}
