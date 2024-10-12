## Ejemplos de hilos de las diapositivas

[Hay métodos para hacer todos estos pasos desde todos IDEs]

1. Clonamos el repositorio

`git clone https://github.com/pabloibargon/distribuidos.git`

2. Habiendo instalado maven (podemos comprobarlo con `mvn --version`)
Se compila y empaqueta:

`mvn package`

3. Se han generado `.class` y `.jar` en un nuevo directorio `target`. Podemos ejecutar ambos ejemplos especificando la clase principal.
(No hay ninguna que se llame Main, entonces intentando ejecutar directamente el `.jar` nos dará error.)

`java -cp target/ejemplos-hilos*.jar es.uva.hilos.Ejemplo1`

Se mostrará en consola algo similar a

```
Termina thread main
0 Pepe
1 Pepe
2 Pepe
3 Pepe
4 Pepe
5 Pepe
6 Pepe
7 Pepe
8 Pepe
9 Pepe
0 Juan
1 Juan
2 Juan
3 Juan
4 Juan
5 Juan
6 Juan
7 Juan
8 Juan
9 Juan
Termina thread Juan
Termina thread Pepe
```

Para ejecutar el siguiente ejemplo

`java -cp target/ejemplos-hilos*.jar es.uva.hilos.MainConsumidorProductor`

```
Productor. put: 0
Consumidor. get: 0
Productor. put: 1
Consumidor. get: 1
Productor. put: 2
Consumidor. get: 2
Productor. put: 3
Consumidor. get: 3
Productor. put: 4
Consumidor. get: 4
Productor. put: 5
Consumidor. get: 5
Productor. put: 6
Consumidor. get: 6
Productor. put: 7
Consumidor. get: 7
Productor. put: 8
Consumidor. get: 8
Productor. put: 9
Consumidor. get: 9
```
