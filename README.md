# Buscaminas en consola

## Descripción
El objetivo del juego es despejar un campo de minas sin detonar ninguna.

## ¿Cómo jugar?
El usuario deberá ir ingresando por consola las diferentes ubiraciones, 
donde este quiera despejar una casilla, las diferentes coordenadas en 
`Y(Filas)`, seguido de una `x` y `X(Columnas)`.

**Por ejemplo**

Si el usuario 2x3 esto corresponde a la fila 2 y la columna 3

### Comandos

Por ahora el juego cuenta con un solo con el comando de `-mark` que
lo que hace es marcar una casilla en rojo para que nos ayude a
recordar donde creemos que haya una mina. Esto no quiere decir 
que en el lugar que marquemos haya una mina obligatoriamente.

#### Uso de `-mark`:
```text
2x2 -mark
```
Esto marcaría la celda en la fila 2 y columna 2.
Si por alguna razón queremos desmarcar la celda simplemente
volvemos a escribir las coordenadas sin el `-mark`