package BarajaModelos;

public class Carta{

// ATRIBUTOS    
    private String tipo;
    private String palo;
    private int valor;

// METODOS
    public Carta(String tipo, String palo, int valor) {
        this.tipo = tipo;
        this.palo = palo;
        this.valor = valor;
    }

    public Carta() {
    }

    @Override
    public String toString() {
        return "Carta{" + "tipo=" + tipo + ", palo=" + palo + ", valor=" + valor + '}';
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public String getPalo() {
        return palo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
