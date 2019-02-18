
package es.javiergarciaescobedo.tresenraya.model;

public class TresEnRaya {
    int[][] matrizTablero = new int[3][3];
    
    public void mostrarTablero() {
        for(int y=0; y<3; y++) {
            for(int x=0; x<3; x++) {
                System.out.print(matrizTablero[x][y]);
            }
            System.out.println();
        }       
    }
    
    public void ponerFicha(int x, int y, int jugador) {
        matrizTablero[x][y] = jugador;
    }    
    
}
