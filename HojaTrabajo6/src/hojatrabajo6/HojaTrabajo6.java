
package hojatrabajo6;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Sergio Marchena
 * @author Javier Carpio
 * @version 05.03.2018
 */
public class HojaTrabajo6 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Carta c = new Carta();
        Scanner scanner = null;
        int opcion;
        
        Scanner s = new Scanner(System.in);
        FactoryMap fm = new FactoryMap();
        
        System.out.println("Elija una opcion: ");
        System.out.println("1. HashMap.");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap.");
        opcion = s.nextInt();
        
        while ((opcion < 1) || (opcion > 3)){
            System.out.println("ERROR. Elija una opcion: ");
            System.out.println("1. HashMap.");
            System.out.println("2. TreeMap");
            System.out.println("3. LinkedHashMap.");
            opcion = s.nextInt();
        }
        
        Map<Integer, Carta> hash = fm.FactoryMap(opcion);
        
        File archivo = new File ("cards_desc.txt");

        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        
        scanner = new Scanner(fr);
        int a = 0;
        while (scanner.hasNextLine()) {
            a++;
            String line = scanner.nextLine();
            String nombre = line.substring(0, line.indexOf("|"));
            String tipo = line.substring(line.indexOf("|") + 1, line.length());
            
            hash.put(a, new Carta(nombre, tipo));
        }
        
        int b = 1;
        
        ArrayList<Carta> personal = new ArrayList<>();
        
        while(b != 0){
            System.out.println("---------------------MENU---------------------");
            System.out.println("0. Salir.");
            System.out.println("1. Mostrar todas las cartas.");
            System.out.println("2. Guardar una carta a mi coleccion.");
            System.out.println("3. Contar y mostrar las cartas de mi mazo.");
            System.out.println("4. Ordenar por tipo.");
            System.out.println("");
            b = s.nextInt();
            System.out.println("----------------------------------------------");
            switch (b) {
                case 1:
                    c.mostrarCartas(hash);
                    break;
                case 2:
                    String eleccion = "";
                    System.out.println("Escriba el nombre de la carta a guardar.");
                    eleccion = s.nextLine();
                    eleccion = s.nextLine();
                    if(c.buscarCarta(hash, eleccion) == true){
                        personal  = (c.agregarCarta(hash, eleccion, personal));
                        System.out.println("Carta agregada con exito");
                    }else{
                        System.out.println("No hemos podido encontrar la carta solicitada.");
                    }   
                    break;
                case 3:
                    System.out.println(c.contarCartas(personal));
                    break;
                
                case 4:
                    c.ordenarMazo(personal);
                    break;
                default:
                    break;
            }
        }
    }
}
