
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
            
    public void moverFicha(int xOrigen, int yOrigen, int xDestino, int yDestino) {
//        char jugador = matrizTablero[xOrigen][yOrigen];
//        matrizTablero[xDestino][yDestino] = jugador;   
        try {
            matrizTablero[xDestino][yDestino] = matrizTablero[xOrigen][yOrigen];
            matrizTablero[xOrigen][yOrigen] = '0';
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: No existe la posición indicada");
        } catch(Exception e) {
            System.out.println("ERROR desconocido");
        }
    }
        
    public boolean estaLibreCelda(int x, int y) {
        if(matrizTablero[x][y] == '0') {
            return true;
        } else {
            return false;
        }
    }
    
}
