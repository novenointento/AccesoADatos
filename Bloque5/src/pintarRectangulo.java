/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class pintarRectangulo {

    public static void main(String[] args) {
        // TODO code application logic here
        int base = 8;
        int altura = 4;

        //bucle que pinta altura
        for (int h = 1; h <= altura; h++) {
            //bucle que pinta base
            for (int b = 1; b <= base; b++) {
                if((h==1)||(b==1)||(b==base)||(h==altura)){
                System.out.print("*");
            }else{
            System.out.print(" ");}

        }
            System.out.println("");
    }
    }
}
