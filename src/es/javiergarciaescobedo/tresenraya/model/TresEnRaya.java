
package es.javiergarciaescobedo.tresenraya.model;

public class TresEnRaya {
    int[][] matrizTablero = new int[3][3];
    
    public void mostrarTablero() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                System.out.print(matrizTablero[i][j]);
            }
            System.out.println();
        }       
    }
    
    public void ponerFicha() {
        matrizTablero[1][1] = 1;
        matrizTablero[2][1] = 2;
    }
    
    
}
