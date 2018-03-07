
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
public class Carta {
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
            cartas += cont + ". " + c.toString() + "\n";
            
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

    public String ordenarMazo(ArrayList<Carta> personal){
        Collections.sort(personal, (Carta o1, Carta o2) -> o1.getTipo().compareTo(o2.getTipo()));
        String a = "";
        
        Carta[] cartas = new Carta[personal.size()];
        for(int i = 0; i < personal.size(); i++){
            cartas[i] = personal.get(i);
        }
        
        return enlistarArray(cartas);
    }
    
    public String ordenarColeccion(Map<Integer, Carta> carta){
        Carta[] cartas = new Carta[carta.size()];
        ArrayList<Carta> ccc = new ArrayList<>();
        for (Entry<Integer, Carta> c : carta.entrySet()){
            Carta valor = c.getValue();
            
            Carta c1 = new Carta(valor.getNombre(), valor.getTipo());
            
            ccc.add(c1);
        }
        
        Collections.sort(ccc, (Carta o1, Carta o2) -> o1.getTipo().compareTo(o2.getTipo()));
        
        for(int i = 0; i < ccc.size(); i++){
            cartas[i] = ccc.get(i);
        }
        
        return ordenarMazo(ccc);
    }
    
    public String enlistarArray(Carta[] carta){
        String cartas = "";
        int cont = 0;
        int monstruo = 0, hechizo = 0, trampa = 0; 
        for(Carta c: carta){
            cont++;
            cartas += cont + ". " + c.toString() + "\n";
            
            switch (c.getTipo()) {
                case "Monstruo":
                    monstruo++;
                    break;
                case "Hechizo":
                    hechizo++;
                    break;
                case "Trampa":
                    trampa++;
                    break;
                default:
                    break;
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
    
    public String mostrarTipo(String eleccion, Map<Integer, Carta> map){
        String info = "";
        for (Entry<Integer, Carta> carta : map.entrySet()){
            Carta valor = carta.getValue();
            if(valor.getNombre().equals(eleccion)){
                String nom = valor.getNombre();
                String tipo = valor.getTipo();
                info = nom + " es una carta de tipo: " + tipo;
            }
        }
        
        return info;
    }
//    
//    @Override
//    public int compareTo(Carta o) {
//        Carta cartaTemp = (Carta)o;
//        
//        if(this.tipo.equals(o.tipo)){
//            return tipo.compareTo(o.tipo);
//        }else{
//            return 
//        }
//        
//    }

    
    
}
