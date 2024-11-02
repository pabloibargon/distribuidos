package es.uva.sockets;

public class ServidorJuego {
    // El juego consiste en encontrar un tesoro
    // en un mapa cuadriculado, cuando un jugador
    // se conecta aparece en un cuadrado aleatorio
    // no ocupado.
    // El _PROTOCOLO_ del cliente, la manera en que
    // se comunica con el servidor es el siguiente
    // MOVE UP|DOWN|LEFT|RIGHT
    // DIG
    // EL Servidor Verifica la validez de los movimientos
    // Los aplica sobre su estado y envía la actualización
    // A todos los jugadores.
    // EL _PROTOCOLO_ con el que el servidor comunica las
    // actualizaciones a los clientes es el siguiente
    // PLAYER JOIN <PLAYER-ID> <X> <Y>
    // MOVE UP|DOWN|LEFT|RIGHT <PLAYER-ID>
    // DIG <PLAYER-ID> <SUCCESS>
    // El delimitador de lo que constituye un mensaje es
    // un caracter de salto de linea

    private final Estado estado;
    // TODO atributos para gestionar las conexiones

    public ServidorJuego(int size){
        estado = new Estado(size);
    }
    public void iniciar(int puerto) {
        //TODO: Crear un serverSocket que acepte
        //conexiones de VARIOS clientes
        // Mantener todos los procesos necesarios hasta el final
        // de la partida (alguien encuentra el tesoro)
    }

    public void interpretarMensaje(String mensaje){
        // TODO: Esta función debe realizar distintas
        // Acciones según el mensaje recibido
        // Si el mensaje recibido no tiene el formato correcto
        // No ocurre nada
    }
}
