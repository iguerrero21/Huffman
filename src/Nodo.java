/**************************************************************
 * Asignatura: Taller de Algoritmos y Estructuras de Datos II
 * Año: 2023
 * Nombre: Ignacio Guerrero
 * Legajo: VINF 012729
 *************************************************************/

/**
 * Nodo adaptado a un árbol binario Huffman.
 * Almacena un dato, su frecuencia y dos nodos hijos.
 * El valor dato almacena un Integer que proviene de un Character.
 */
 public class Nodo implements Comparable<Nodo> {

    private Integer data;
    private Integer frecuencia = 0;
    private Nodo hijoIzq = null;
    private Nodo hijoDer = null;

    // Constructor Nodo
    public Nodo() {
    }

    // Inicializa hoja con valores de data y frecuencia.
    public Nodo(Integer data, Integer frecuencia) {
        this.data = data;
        this.frecuencia = frecuencia;
    }

    // Inicializa padre a partir de sus hijos.
    public Nodo(Nodo hijoIzq, Nodo hijoDer) {
        this.data = hijoIzq.frecuencia + hijoDer.frecuencia;

        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
    }

    /**
     * Sobreescritura del método compareTo para ordenar nodos por frecuencia.
     */
    @Override
    public int compareTo(Nodo n) {
        if (this.obtenerFrecuencia() < n.obtenerFrecuencia()) {
            return -1;
        } else if (this.obtenerFrecuencia() > n.obtenerFrecuencia()) {
            return 1;
        } else {
            return 0;
        }
    }

    
    /** 
     * @return Integer
     */
    /*----------------------------------------
                Getters y Setters
    ------------------------------------------*/

    public Integer obtenerData() {
        return data;
    }

    
    /** 
     * @param data
     * @param frecuencia
     */
    public void establecerData(Integer data, Integer frecuencia) {
        this.data = data;
        this.frecuencia = frecuencia;
    }

    public Integer obtenerFrecuencia() {
        return frecuencia;
    }

    public void establecerFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Nodo obtenerHijoIzq() {
        return hijoIzq;
    }

    public void establecerHijoIzq(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public Nodo obtenerHijoDer() {
        return hijoDer;
    }

    public void establecerHijoDer(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }
}
