package es.uva.hilos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.TimeUnit;

public class Empleado {
	// Los empleados atenderán llamadas
	// En un orden de prioridad, si algún empleado de
	// prioridad más baja está disponible, este tendrá
	// que atender la llamada.
	
	private final int prioridad;
	private final String nombre;

	// Un logger es una mejor manera de hacer prints!
	private final static Logger logger = LoggerFactory.gerLogger(Empleado.class);

	public Empleado(int prioridad, String nombre){
		this.prioridad = prioridad;
		this.nombre = nombre;
	}

	// Simulamos que atender la llamad es algo esperando un tiempo
	public atenderLlamada(Llamada llamada){
		logger.info(nombre + "está atendiendo la llamada " + llamada.getId() + "...");
		TimeUnit.SECONDS.sleep(llamada.getDuracion());
		logger.info(nombre + "atendió la llamada "+ llamada.getId());
	}

}
