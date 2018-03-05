
package hojatrabajo6;

import java.io.*;
import static java.lang.Double.NaN;
import static java.lang.Double.isNaN;
import java.util.Scanner;


/**
 * @author Sergio Marchena
 * @author javie
 * @version 05.03.2018
 */
public class HojaTrabajo6 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
         Scanner scan = null;
         int opcion;
                 
        File archivo = new File ("cards_desc.txt");
        
//        System.out.println("Elija una opcion: ");
//        System.out.println("1. Tree.");
//        System.out.println("2. Linked Hash.");
//        System.out.println("3. HashTable.");
//        opcion = scan.nextInt();

        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        
        scan = new Scanner(fr);
        
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] lineArray = line.split("|");
            System.out.println(line);
        }
    }
    
}
