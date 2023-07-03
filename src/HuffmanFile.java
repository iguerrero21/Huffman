/**************************************************************
 * Asignatura: Taller de Algoritmos y Estructuras de Datos II
 * Año: 2023
 * Nombre: Ignacio Guerrero
 * Legajo: VINF 012729
 *************************************************************/

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;

/**
 * Es un objeto que se utiliza para almacenar el texto codificado
 * y su respectivo código (para poder decodificarlo) en un archivo.
 */
public class HuffmanFile implements Serializable {

    HashMap<Character, String> codigo;
    BitSet texto;

    // Constructor
    public HuffmanFile(HashMap<Character, String> codigo, String texto) {
        this.codigo = codigo;
        this.texto = string2Bit(texto);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "HuffmanFile [codigo=" + codigo + ", texto=" + bit2String(texto) + "]";
    }

    
    /** 
     * @param encoded
     * @return BitSet
     */
    public static BitSet string2Bit(String encoded) {
        BitSet bitSet = new BitSet(encoded.length());
        int bitcounter = 0;
        for (Character c : encoded.toCharArray()) {
            if (c.equals('1')) {
                bitSet.set(bitcounter);
            }
            bitcounter++;
        }
        return bitSet;
    }

    
    /** 
     * @param bitSet
     * @return String
     */
    public static String bit2String(BitSet bitSet) {
        String encoded = "";
        for (int i = 0; i < bitSet.length(); i++) {
            encoded += bitSet.get(i) ? "1" : "0";
        }
        return encoded;
    }
}
