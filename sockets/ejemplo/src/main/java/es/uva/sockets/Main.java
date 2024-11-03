package es.uva.sockets;

public class Main {
    public static void main(String[] args){
        Thread servidor = new Thread(()-> ServidorTCP.main(args));
        Thread cliente = new Thread(()-> ClienteTCP.main(args));
        servidor.start();
        cliente.start();
    }
}
