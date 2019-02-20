
package es.javiergarciaescobedo.tresenraya.model;

public class TresEnRaya {
    
    public char[][] matrizTablero = new char[3][3];
    
    public TresEnRaya() {
        for(int y=0; y<3; y++) {
            for(int x=0; x<3; x++) {
                matrizTablero[x][y] = '0';
            }
        }
    }
    
    public void mostrarTablero() {
        for(int y=0; y<3; y++) {
            for(int x=0; x<3; x++) {
                System.out.print(matrizTablero[x][y]);
            }
            System.out.println();
        }       
    }
    
    public void ponerFicha(int x, int y, char jugador) {
        matrizTablero[x][y] = jugador;
    }    
    
}
