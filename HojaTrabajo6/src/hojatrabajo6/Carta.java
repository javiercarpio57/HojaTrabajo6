
package hojatrabajo6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author javie
 */
public class Carta implements Comparable<Carta>{
    private String nombre;
    private String tipo;

    public Carta() {
    }
    
    public Carta(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre + " -- " + tipo;
    }
    
    public void mostrarCartas(Map<Integer, Carta> map){
        for (Entry<Integer, Carta> carta : map.entrySet()){
            Integer clave = carta.getKey();
            Carta valor = carta.getValue();
            System.out.println(clave + ". " + valor.toString());
        }
    }
    
    public boolean buscarCarta(Map<Integer, Carta> map, String eleccion){
        for (Entry<Integer, Carta> carta : map.entrySet()){
            Carta valor = carta.getValue();
            if(valor.getNombre().equals(eleccion)){
                
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Carta> agregarCarta(Map<Integer, Carta> map, String eleccion, ArrayList<Carta> cartas){
        for (Entry<Integer, Carta> carta : map.entrySet()){
            Carta valor = carta.getValue();
            if(valor.getNombre().equals(eleccion)){
                cartas.add(new Carta(valor.getNombre(), valor.getTipo()));
                return cartas;
            }
        }
        
        return null;
    }
    
    public String contarCartas(ArrayList<Carta> carta){
        String cartas = "";
        int cont = 0;
        int monstruo = 0, hechizo = 0, trampa = 0; 
        for(Carta c: carta){
            cont++;
            cartas += cont + ". " + c.getNombre() + " --- " + c.getTipo() + "\n";
            
            if(c.getTipo().equals("Monstruo")){
                monstruo++;
            }else if(c.getTipo().equals("Hechizo")){
                hechizo++;
            }else if(c.getTipo().equals("Trampa")){
                trampa++;
            }
        }
        
        if(cartas.isEmpty()){
            return "No tiene cartas en su mazo";
        }else{
            cartas += "\n--Se tienen:"
                + "\nMonstruos: " + monstruo
                + "\nHechizos: " + hechizo
                + "\nTrampas: " + trampa;
        }                
        
        return cartas;
    }

    public void ordenarMazo(ArrayList<Carta> carta){
        Carta[] cartas = new Carta[carta.size()];
        
        for(int i = 0; i < carta.size(); i++){
            cartas[i] = carta.get(i);
        }
        
        Arrays.sort(cartas);
        
        for(Carta c: cartas){
            System.out.println(c.toString());
        }
        
        //return contarCartas(carta);
    }
    
    @Override
    public int compareTo(Carta o) {
        Carta cartaTemp = (Carta)o;
        
        if(tipo.equals(o.tipo)){
            return 0;
        }else{
            return -1;
        }
        
    }

    
    
}
