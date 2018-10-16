package escrituraFicheroBinarios;

import deteccionTipoFichero.LeerTeclado;



public class Pruebalectura {

    public static void main(String[] args) {
  
            char c, ult='\0';
            //while ((c = (char) System.in.read()) != '\n') {
            while ((c = LeerTeclado.leerCaracter())!='\n'){
                System.out.println(c);
                ult = c;
            }
            System.out.println(ult);
       
    }

}
