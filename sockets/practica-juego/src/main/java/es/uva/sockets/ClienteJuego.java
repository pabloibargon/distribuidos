package es.uva.sockets;

public class ClienteJuego {
    // La clase cliente tiene las siguientes responsabilidades
    // Unirse al juego conectandose al servidor
    // Mantener un estado de juego actualizado interpretando los
    // mensajes del servidor (y mostrar el estado)
    // Convertir input del jugador en un mensaje que enviar al servidor

    private final Estado estado;

    public ClienteJuego(int size){
        // [OPCIONAL] TODO: Extiende el protocolo de comunicacion para
        // que el servidor envie el tamaño del mapa tras la conexion
        // de manera que el estado no se instancie hasta entonces
        // y conocer este parametro a priori no sea necesario.
        estado = new Estado(size);
    }

    public void iniciar(String host, int puerto){
        // TODO: iniciar la conexion con el servidor,
        // Mantener todos los procesos necesarios
        // hasta el final de la partida (alguien encuentra el tesoro)
    }

    public String interpretarInput(char tecla){
        // TODO: WASD para moverse, Q para buscar
        // Este metodo debe devolver el comando necesario
        // Que enviar al servidor
        return "";
    }

    public void interpretarMensaje(String mensaje){
        // TODO: interpretar los mensajes del servidor actualizando el estado
    }
}
