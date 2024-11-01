package es.uva.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Servidor TCP en espera de conexiones...");
            
            try (
                Socket clienteSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()))
            ) {
                String mensaje = in.readLine();
                System.out.println("Cliente: " + mensaje);
                out.println("Hola, cliente!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}