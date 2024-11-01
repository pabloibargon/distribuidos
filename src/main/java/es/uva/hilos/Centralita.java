package es.uva.hilos;

import java.util.ArrayList;

public class Centralita {
	// Desde a la centralita pueden llegar llamadas que despues
	// se asignan a los empleados disponibles según prioridad
	
	// TODO: Harán falta más atriubutos ...
	private final ArrayList<Empleado> empleados = new ArrayList<>();
	
	public void conEmpleado(Empleado e) {
		empleados.add(e);
	}

	public Runnable atenderLlamadaConEmpleado(Empleado empleado, Llamada llamada){
		// TODO: Obligatorio devolver un Runnable. Se recomienda utilzar
		// funciones lambda.
	}

	public void atenderLlamada(Llamada llamada){
		// TODO: Este método debería seleccionar un empleado disponible según prioridad
		// y correr en un nuevo hilo atenderLlamadaConEmpleado.
		// Este método no bloquea la ejecución si hay empleados disponibles para atender la llamada
		// si no hay empleados disponibles tendremos que esperar a que haya uno.
	}
}
