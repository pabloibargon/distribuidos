package es.uva.hilos;

public class Ejemplo1 extends Thread {
    public Ejemplo1(String str) {
        super(str);
    }
    public void run() {
        for (int i = 0; i < 10 ; i++)
        System.out.println(i + " " + getName());
        System.out.println("Termina thread "+getName());
    }
    public static void main (String [] args) {
        new Ejemplo1("Pepe").start();
        new Ejemplo1("Juan").start();
        System.out.println("Termina thread main");
    }
}
