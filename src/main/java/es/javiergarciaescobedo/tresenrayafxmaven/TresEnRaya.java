
package es.javiergarciaescobedo.tresenrayafxmaven;

public class TresEnRaya {
    
    private char[][] matrizTablero = new char[3][3];
    private char jugador = '1';
    private byte[] contFichasRestan = {3, 3};
    
    public static final char JUGADOR_1 = '1';
    public static final char JUGADOR_2 = '2';
    public static final char JUGADOR_NO = '0';
            
    public TresEnRaya() {
        for(int y=0; y<3; y++) {
            for(int x=0; x<3; x++) {
                matrizTablero[x][y] = JUGADOR_NO;
            }
        }
    }
    
    public char getJugadorEnCelda(int x, int y) {
        return matrizTablero[x][y];
    }
    
    public char getJugadorActual() {
        return jugador;
    }
    
    public byte[] getContFichasRestan() {
        return contFichasRestan;
    }
    
    public void mostrarTablero() {
        for(int y=0; y<3; y++) {
            for(int x=0; x<3; x++) {
                System.out.print(matrizTablero[x][y]);
            }
            System.out.println();
        }       
    }
    
    public boolean ponerFicha(int x, int y) {
        // Comprobar si al jugador actual le quedan fichas por poner
        if(contFichasRestan[jugador-JUGADOR_1] > 0) {
            matrizTablero[x][y] = jugador;
            // Descontar la ficha colocada de las restantes por poner
            contFichasRestan[jugador-JUGADOR_1]--;
            cambiarTurnoJugador();
            return true;
        } else  {
            System.out.println("El jugador " + jugador
                    + " no tiene fichas para colocar");
            return false;
        }
    } 
            
    public void moverFicha(int xOrigen, int yOrigen, int xDestino, int yDestino) {
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
    
    public char cambiarTurnoJugador() {
        if(jugador == JUGADOR_1) {
            jugador = JUGADOR_2;
        } else {
            jugador = JUGADOR_1;
        }
        return jugador;
    }
    
    public char getGanador() {
        // Primera fila
        if(matrizTablero[0][0] == matrizTablero[1][0] && 
                matrizTablero[0][0] == matrizTablero[2][0]) {
            return matrizTablero[0][0];
        // Segunda fila
        } else if(matrizTablero[0][1] == matrizTablero[1][1] && 
                matrizTablero[0][1] == matrizTablero[2][1]) {
            return matrizTablero[0][1];
        // Tercera fila
        } else if(matrizTablero[0][2] == matrizTablero[1][2] && 
                matrizTablero[0][2] == matrizTablero[2][2]) {
            return matrizTablero[0][2];
        // Primera columna 
        } else if(matrizTablero[0][0] == matrizTablero[0][1] && 
                matrizTablero[0][0] == matrizTablero[0][2]) {
            return matrizTablero[0][0];
        // Segunda columna
        } else if(matrizTablero[1][0] == matrizTablero[1][1] && 
                matrizTablero[1][0] == matrizTablero[1][2]) {
            return matrizTablero[1][0];
        // Tercera columna
        } else if(matrizTablero[2][0] == matrizTablero[2][1] && 
                matrizTablero[2][0] == matrizTablero[2][2]) {
            return matrizTablero[2][0];
        // Primera diagonal
        } else if(matrizTablero[0][0] == matrizTablero[1][1] && 
                matrizTablero[0][0] == matrizTablero[2][2]) {
            return matrizTablero[0][0];
        // Segunda diagonal
        } else if(matrizTablero[2][0] == matrizTablero[1][1] && 
                matrizTablero[2][0] == matrizTablero[0][2]) {
            return matrizTablero[2][0];
        } else {
            return JUGADOR_NO; 
        }
    }
    
}
