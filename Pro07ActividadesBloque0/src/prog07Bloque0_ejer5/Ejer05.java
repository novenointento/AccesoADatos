
package prog07Bloque0_ejer5;

public class Ejer05 {

    public static void main(String[] args) {
       String[] arrayNombres={"Juan","Maria","Ana","Pedro","Pablo","Casimiro","Dolores"};
    
        System.out.println("Forma uno con un for each");
       for(String elemento: arrayNombres){
           System.out.println(elemento);
       }
       
       //tambien podriamos hacer
        System.out.println("\nForma dos usando la longitud y posicion del array con un for normal");
       for (int pos=0; pos < arrayNombres.length; pos++){
           System.out.println(arrayNombres[pos]);
       }
    }
    
}
