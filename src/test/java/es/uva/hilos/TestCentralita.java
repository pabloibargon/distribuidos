package es.uva.hilos.messenger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.org.lidalia.slf4jtest.LoggingEvent;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static uk.org.lidalia.slf4jtest.LoggingEvent.info;

public class LoggerExampleTest {

    private TestLogger testLogger;
    private Centralita centralita;

    @BeforeEach
    public void setUp() {
        testLogger = TestLoggerFactory.getTestLogger(LoggerExample.class);
        centralita = new Centralita();
    }

    @Test
    public void testUnEmpleadoAsincrono() throws InterruptedException {
        Empleado e1 = new Empleado(0, "Alberto");
        centralita.conEmpleado(e1);

        centralita.atenderLlamada(new Llamada(1, 101));

        TimeUnit.SECONDS.sleep(2); // Damos tiempo para que la llamada se procese

        List<LoggingEvent> events = testLogger.getLoggingEvents();
        assertEquals(2, events.size());

        // Verificamos que los logs existen, pero no en un orden específico
        assertTrue(events.stream().anyMatch(event -> event.getMessage().equals("Alberto atendió la llamada 101")));
    }

    @Test
    public void testPrioridadEmpleados() throws InterruptedException {
        Empleado e1 = new Empleado(1, "Carlos");
        Empleado e2 = new Empleado(0, "Alberto");
        centralita.conEmpleado(e1);
        centralita.conEmpleado(e2);

        centralita.atenderLlamada(new Llamada(1, 102)); // Debería elegir a Alberto

        TimeUnit.SECONDS.sleep(2); // Damos tiempo para que la llamada se procese

        List<LoggingEvent> events = testLogger.getLoggingEvents();
        assertEquals(2, events.size());

        // Verificamos que los logs existen sin exigir un orden específico
        assertTrue(events.stream().anyMatch(event -> event.getMessage().equals("Alberto atendió la llamada 102")));
    }

    @Test
    public void testLlamadasMultiplesSimultaneas() throws InterruptedException {
        Empleado e1 = new Empleado(0, "Alberto");
        Empleado e2 = new Empleado(1, "Carlos");
        centralita.conEmpleado(e1);
        centralita.conEmpleado(e2);

        centralita.atenderLlamada(new Llamada(2, 103)); // Debería asignarse a Alberto
        centralita.atenderLlamada(new Llamada(2, 104)); // Carlos debería atender esta

        TimeUnit.SECONDS.sleep(3); // Esperamos que ambas llamadas se completen

        List<LoggingEvent> events = testLogger.getLoggingEvents();
        assertEquals(4, events.size()); // Dos logs por cada llamada

        // Verificamos que los logs existen, no importa el orden
        assertTrue(events.stream().anyMatch(event -> event.getMessage().equals("Alberto atendió la llamada 103")));
        assertTrue(events.stream().anyMatch(event -> event.getMessage().equals("Carlos atendió la llamada 104")));
    }

    @Test
    public void testTodosEmpleadosOcupados() throws InterruptedException {
        Empleado e1 = new Empleado(0, "Alberto");
        Empleado e2 = new Empleado(1, "Carlos");
        centralita.conEmpleado(e1);
        centralita.conEmpleado(e2);

        centralita.atenderLlamada(new Llamada(4, 105)); // Alberto atiende
        centralita.atenderLlamada(new Llamada(5, 106)); // Carlos atiende

        TimeUnit.SECONDS.sleep(1); // Esperamos para que las llamadas estén en curso

        centralita.atenderLlamada(new Llamada(1, 107)); // La tercera llamada espera a que Alberto quede libre

        TimeUnit.SECONDS.sleep(6); // Esperamos lo suficiente para que la tercera llamada se procese

        List<LoggingEvent> events = testLogger.getLoggingEvents();
        assertEquals(6, events.size());

        // Verificamos que los logs existen sin orden estricto
        assertTrue(events.stream().anyMatch(event -> event.getMessage().equals("Alberto atendió la llamada 105")));
        assertTrue(events.stream().anyMatch(event -> event.getMessage().equals("Carlos atendió la llamada 106")));
        assertTrue(events.stream().anyMatch(event -> event.getMessage().equals("Alberto atendió la llamada 107"))); // La tercera llamada
    }

    @Test
    public void testLlamadaDuracionCero() throws InterruptedException {
        Empleado e1 = new Empleado(0, "Alberto");
        centralita.conEmpleado(e1);

        centralita.atenderLlamada(new Llamada(0, 108)); // La llamada no debería bloquearse


        List<LoggingEvent> events = testLogger.getLoggingEvents();
        assertEquals(2, events.size());
        assertTrue(events.stream().anyMatch(event -> event.getMessage().equals("Alberto atendió la llamada 108")));
    }
}
