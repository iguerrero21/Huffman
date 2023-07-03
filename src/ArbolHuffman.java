/**************************************************************
 * Asignatura: Taller de Algoritmos y Estructuras de Datos II
 * Año: 2023
 * Nombre: Ignacio Guerrero
 * Legajo: VINF 012729
 *************************************************************/

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class ArbolHuffman {

    /**
     * Utilisa una tabla de Hash para ordenar los elementos de mayor a menor,
     * para cargarlos luego en una cola de prioridad. 
     * 
     * @param text
     * @return Nodo con las frecuencias de los simbolos.
     */
    public static PriorityQueue<Nodo> obtenerFrecuenciaSimbolos(String text) {
        HashMap<Integer, Integer> ordenFrecuencias = new HashMap<>();
        for (char elemento : text.toCharArray()) {
            ordenFrecuencias.put(
                    (int) elemento,
                    ordenFrecuencias.getOrDefault((int) elemento, 0) + 1);
        }
        PriorityQueue<Nodo> frecuencias = new PriorityQueue<>();
        for (Entry<Integer, Integer> elemento : ordenFrecuencias.entrySet()) {
            frecuencias.offer(new Nodo(elemento.getKey(), elemento.getValue()));
        }

        return frecuencias;
    }

    /**
     * Toma los dos primeros nodos (aquellos de menor frecuencia) de la cola de prioridad 
     * y los añade como hijos de un nuevo nodo. Agrega el nuevo nodo a la cola de prioridad.
     * Reitera hasta que sólo queda un nodo (arbol de Huffman) en la cola.
     * @param text El texto a codificar.
     * @return Un árbol de Huffman.
     */
    public static Nodo crearArbolHuffman(String text) {
        PriorityQueue<Nodo> frecuencias = obtenerFrecuenciaSimbolos(text);
        // HashMap<Integer, Integer> frecuencias = obtenerFrecuenciaSimbolos(text);
        
        while (frecuencias.size() > 1) {
            Nodo nodoMin = frecuencias.poll();
            Nodo nodoAux = frecuencias.poll();

            Nodo padre = new Nodo(nodoMin, nodoAux);
            padre.establecerFrecuencia(nodoMin.obtenerFrecuencia() + nodoAux.obtenerFrecuencia());
            frecuencias.add(padre);
            }
        
        return frecuencias.poll();
    }
    
    /**
     * Determina el código correspondiente a cada nodo (símbolo) del árbol Huffman.
     * @param nodo Árbol Huffman
     * @param digitos Inicializado a digitos = "".
     * @return Una tabla de hash con los cádigos correspondientes a cada símbolo.
     */
    public static HashMap<Character, String> obtenerCodigoHuffman(Nodo nodo, String digitos) {
        HashMap<Character, String> codigos = new HashMap<>();
        Nodo nodoIzq = nodo.obtenerHijoIzq();
        Nodo nodoDer = nodo.obtenerHijoDer();
        if (nodoIzq == null && nodoDer == null) {
            codigos.put((char) nodo.obtenerData().intValue(), digitos);
        } 
        
        if (nodoIzq != null) {
            codigos.putAll(obtenerCodigoHuffman(nodoIzq, digitos + "0"));
        } 
        
        if (nodoDer != null) {
            codigos.putAll(obtenerCodigoHuffman(nodoDer, digitos + "1"));
        } 
        return codigos;
    }
    
    /**
     * Reemplaza cada símbolo del texto por su cádigo Huffman.
     * @param text El texto a codificar
     * @return Un objeto de tipo HuffmanFile con la tabla de hash de cádigos y el texto codificado.
     */
    public static HuffmanFile codificar(String text) {
        Nodo arbolHuffman = crearArbolHuffman(text);
        HashMap<Character, String> codigoHuffman = obtenerCodigoHuffman(
                arbolHuffman, "");
        
        // System.out.println(codigoHuffman);
               
        String codigo = "";
        for (char elemento : text.toCharArray()) {
            codigo += codigoHuffman.get(elemento);
        }

        HuffmanFile archivo = new HuffmanFile(codigoHuffman, codigo);
        return archivo;
    }

    /**
     * Decodifica el texto codificado.
     * @param archivo Objeto HuffmanFile con la tabla de hash de cádigos y el texto codificado.
     * @return Una cadena con el texto decodificado.
     */
    public static String decodificar(HuffmanFile archivo) {
        String texto = "";
        HashMap<Character, String> codigoHuffman = archivo.codigo;
        String codigo = HuffmanFile.bit2String(archivo.texto);
        while (!codigo.isEmpty()) {
            for (Entry<Character, String> elemento : codigoHuffman.entrySet()) {
                if (codigo.startsWith(elemento.getValue())) {
                    texto += elemento.getKey();
                    codigo = codigo.substring(elemento.getValue().length());
                    break;
                }
            }
        }
        return texto;
    }    
}
