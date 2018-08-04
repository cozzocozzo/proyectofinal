
package modelo;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;


public class ProbarOrdenamientos {
    public static void main(String[] args) {
        //Un arreglo que no acepta duplicados
        //Agregamos los imports para ambos
        Set<Integer> enteros = new LinkedHashSet<>();
       
        while(enteros.size()<4){
        Random r = new Random();
        int valor=r.nextInt(4);
        enteros.add(valor);
        }
        for (Integer i: enteros){
        
        }
    }
    
}
