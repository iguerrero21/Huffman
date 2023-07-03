/**************************************************************
 * Asignatura: Taller de Algoritmos y Estructuras de Datos II
 * Año: 2023
 * Nombre: Ignacio Guerrero
 * Legajo: VINF 012729
 *************************************************************/

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class Huffman {

    
    /** 
     * @param filePath
     * @return String
     * @throws IOException
     */
    public static String loadFileAsString(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes);
    }

    
    /** 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // args = new String[]{"-d", "ejemplo.huff"}; // Debugging
        // args = new String[]{"-c", "ejemplo.txt"};  // Debugging


        if (args.length == 0) {
            System.out.println("Usage: java Huffman [-c|-d] <input file>");
            System.exit(1);
        }

        String filePath = args[1];
        String fileContent;

        try {
            fileContent = loadFileAsString(filePath);

            // Codificar
            if (args[0].equals("-c") && args[1].endsWith(".txt")) {
                HuffmanFile output = ArbolHuffman.codificar(fileContent);
                FileOutputStream fos = new FileOutputStream(
                        args[1].replace(".txt", ".huff"));
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(output);
                oos.close();

            // Decodificar
            } else if (args[0].equals("-d") && args[1].endsWith(".huff")) {
                FileInputStream fis = new FileInputStream(args[1]);
                ObjectInputStream ois = new ObjectInputStream(fis);
                HuffmanFile input = (HuffmanFile) ois.readObject();
                ois.close();

                System.out.println("Código Huffman:");
                System.out.println(input.codigo);
                System.out.println();
                System.out.println("Texto codificado:");
                System.out.println(HuffmanFile.bit2String(input.texto));
                
                String textoDecodificado = ArbolHuffman.decodificar(input);
                
                FileWriter fos = new FileWriter(args[1].replace(".huff", ".txt"));
                PrintWriter oos = new PrintWriter(fos);
                oos.println(textoDecodificado);
                oos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Programa finalizado.");
        
        }
    }
}
