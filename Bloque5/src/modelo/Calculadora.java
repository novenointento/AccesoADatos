package modelo;

/**
 *Creamos una clase con la palabra reservada class y un prefijo que le da
 * la accesibilidad(son opcionales) , abrimos { y cerramos }.
 * 
 */
public class Calculadora {
    // atributos

    private float num1;
    private float num2;


    //metodos
    /*
    *metodo para que nos devuelva el atributo, no hay entrada.
    *@getnum1()
    */
    public float getNum1() {
        return num1;

    }
// no hay entrada(parentesis vacio), solo devuelve el valor del numero 1. como devuleve algo lleva delante el mismo tipo de valor que X

    /**
     * permite asignar un valor que se pasa en el parametro al atributo numero 1
     *
     * @param param1
     */
    public void setNum1(float param1) {
        num1 = param1;
        //no hay salida, por eso ponemos void y se mete entre el parentesis los valores que queremos meter
    }

    //repito
        public float getNum2() {
        return num2;

    }

    public void setNum2(float param2) {
        num2 = param2;

    }
    //metodos especificos

    public float sumar() {
        float rtdo;
        rtdo = num1 + num2;
        return rtdo;
    }

    /**
     *
     * @return
     */
    public float resta() {
        float rtdo;
        rtdo = num1 - num2;
        return rtdo;
    }

    public float multi() {
        float rtdo;
        rtdo = num1 * num2;
        return rtdo;
    }

    public float div() {
        float rtdo;
        rtdo = num1 / num2;
        return rtdo;
    }

    /**
     *inicializa metiendole los valores pore teclado
     * @param num1
     * @param num2
     */
    public Calculadora(float num1, float num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    
    /**
     *inicializa por defecto a cero
     */
    public Calculadora() {
       num1 = 0;
        num2 = 0;
    }

    @Override
    public String toString() {
        return "Calculadora{" + "num1=" + num1 + ", num2=" + num2 + '}';
    }
    
    
    
}
