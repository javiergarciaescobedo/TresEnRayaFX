
package es.javiergarciaescobedo.tresenraya.model;


public class NewMain {

    public static void main(String[] args) {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.mostrarTablero();
        System.out.println("");

        tresEnRaya.ponerFicha(1, 2, '1');
        tresEnRaya.ponerFicha(0, 1, '2');
        tresEnRaya.ponerFicha(2, 2, '1');
        tresEnRaya.mostrarTablero();
    }
    
            
            
}
