# Trabajo Práctico N3

## Situación problemática

El algoritmo de Huffman se desarrolló en el año 1952 y, hasta hoy, tiene vigencia para dar entrada a la explicación de diversos métodos de compresión de archivos. Se hace imprescindible el estudio de este algoritmo para desarrollar competencias en el uso de estructuras de datos y métodos de codificación.

Para cumplir los objetivos de este trabajo práctico se ha propuesto la siguiente situación problemática:

En la guerra del Golfo Pérsico, desarrollada al principio de los años 90, existía la necesidad de mandar mensajes codificados para solucionar dos problemas: primero, para hacer mucho más rápida la transmisión debido a la poca capacidad de transmisión de los equipos de cómputos utilizados en esa época, y segundo, el enemigo debía entender el mensaje con la codificación que tenía. Para ello, la solución consistía en
implementar algoritmos de compresión de datos para poder llevar a cabo la comunicación entre los diferentes sectores aliados de ataque.

## Consigna

Implementar, en el lenguaje de programación Java, el algoritmo de Huffman, teniendo en cuenta que:

a) El programa debe permitir leer un texto de longitud de caracteres variables. 

b) Se debe utilizar una estructura de datos tipo “lista” para agregar nodos nuevos según la longitud de la cadena de caracteres introducida.

c) El programa debe mostrar la codificación obtenida, junto con el mensaje original después de aplicar el algoritmo de Huffman. Ejemplo: 

“estamos bien” 

--------------- 

111000111010001101

## Notas

a) El programa recibe texto desde un archivo \<archivo\>.txt, lo codifica y devuelve un archivo \<archivo\>.huff con una tabla de hash con el codigo Huffman y una cadena binaria con el texto codificado.

b) En lugar de una lista se utilizó una tabla de hash.

c) El programa muesta la tabla de hash con una representación del código Huffman, y una cadena con el texto codificado.

### Bugs

Originalmente, la aplicación guardaba la cadena resultante en formato **String**, generando un byte por cada 0 o 1. Esto generaba un archivo .huff mucho mayor que el .txt original.

Se decidió convertir la cadena de 0 y 1 en un **BitSet**, pero aparentemente, esto genera bit adicionales al final de la cadena. Por esta razón, el bucle **while** queda buscando un código inexistente.

Esto no ha podido ser resuelto aún.
