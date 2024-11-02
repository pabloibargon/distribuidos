package es.uva.sockets;

import java.util.ArrayList;

public class Estado {
    private final ArrayList<Jugador> jugadores;
    private final Coordenadas tesoro;
    private final ArrayList<Coordenadas> buscadas;
    private final int size;

    public Estado(int size){
        this.size = size;
        this.jugadores = new ArrayList<>();
        this.buscadas = new ArrayList<>();
        // TODO: Coordenadas aleatorias para el tesoro
        this.tesoro = new Coordenadas(0,0);
    }

    public void nuevoJugador(Jugador jugador){
        jugadores.add(jugador);
    }

    public void buscar(int id){
        //TODO busca el tesoro el jugador con este id
    }

    public void mover(int id, Direccion dir){
        //TODO mueve a el jugador id en la direccion dir
    }

    public void mostrar(){
        // Linea horizontal
        for (int col = 0; col < size; col++) {
            System.out.print("----");
        }
        for (int row = 0; row < size; row++) {
            // Columnas
            for (int col = 0; col < size; col++) {
                System.out.print("| "); // Cada celda representada por "|   |"
                // Si no hay nada imprimimos vacio
                char toPrint = ' ';
                // Si ya esta cavado imprimos una x
                for(Coordenadas coordenadas : buscadas){
                    if (coordenadas.equals(new Coordenadas(col, row))){
                        toPrint = 'x';
                    }
                }
                // Si hay un jugador imprimimos su representacion
                for(Jugador jugador : jugadores){
                    if (jugador.coordenadas.equals(new Coordenadas(col, row))){
                        toPrint = jugador.getChar();
                    }
                }
                System.out.print(toPrint);
                System.out.print("|");
            }
            System.out.println("|"); // End of row with a final column border
            
            // Print a row separator
            for (int col = 0; col < size; col++) {
                System.out.print("----");
            }
            System.out.println("-");
        }
    }
}
