
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Sergio Marchena
 * @author Javier Carpio
 * @version 05.03.2018
 */
public class Carta {
    private String nombre;
    private String tipo;

    /**
     * COnstructor que permite crear los objetos de Carta.
     */
    public Carta() {
    }
    
    /**
     * Constructor para crear los objetos de Carta.
     * @param nombre Nombre de la carta.
     * @param tipo Tipo de la carta.
     */
    public Carta(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    /**
     * Metodo que nos permite conocer el nombre de la Carta.
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que nos permite conocer el tipo de la Carta.
     * @return nombre
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo que permite concatenar el Key con el Value.
     * @return nombre + tipo
     */
    @Override
    public String toString() {
        return nombre + " -- " + tipo;
    }
    
    /**
     * Muestra todas las cartas en el Mapa.
     * @param map Listado de todas las cartas.
     */
    public void mostrarCartas(Map<Integer, Carta> map){
        map.entrySet().forEach((carta) -> {
            Integer clave = carta.getKey();
            Carta valor = carta.getValue();
            System.out.println(clave + ". " + valor.toString());
        });
    }
    
    /**
     * Busca la carta que escribio el usuario.
     * @param map Listado del mapa.
     * @param eleccion Eleccion de la carta del usuario.
     * @return True: Si existe; False: No existe.
     */
    public boolean buscarCarta(Map<Integer, Carta> map, String eleccion){
        for (Entry<Integer, Carta> carta : map.entrySet()){
            Carta valor = carta.getValue();
            if(valor.getNombre().equals(eleccion)){
                
                return true;
            }
        }
        return false;
    }
    
    /**
     * Agrega una carta seleccionada de la coleccion.
     * @param map Coleccion del mapa.
     * @param eleccion Eleccion de la carta del usuario.
     * @param cartas ArrayList de las cartas de la persona.
     * @return ArrayList de las cartas de la persona.
     */
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
    
    /**
     * Metodo que cuenta las cartas de la persona.
     * @param carta ArrayList de las cartas del usuario.
     * @return Toda la informacion del conteo de cartas.
     */
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

    /**
     * 
     * @param personal
     * @return 
     */
    public String ordenarMazo(ArrayList<Carta> personal){
        Collections.sort(personal, (Carta o1, Carta o2) -> o1.getTipo().compareTo(o2.getTipo()));
        String a = "";
        
        Carta[] cartas = new Carta[personal.size()];
        for(int i = 0; i < personal.size(); i++){
            cartas[i] = personal.get(i);
        }
        
        return enlistarArray(cartas);
    }
    
    /**
     * Metodo que permite ordenar toda la coleccion de cartas.
     * @param carta Mapa de cartas en la coleccion.
     * @return Informacion de las cartas ordenadas.
     */
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
    
    /**
     * Metodo que permite enlistar todas las cartas.
     * @param carta Array de cartas.
     * @return Informacion total de las cartasy su conteo.
     */
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
    
    /**
     * Metodo que permite mostrar el tipo de una carta seleccionada.
     * @param eleccion Seleccion del usuario.
     * @param map Coleccion de Mapas.
     * @return Tipo de carta del nombre de la carta.
     */
    public String mostrarTipo(String eleccion, Map<Integer, Carta> map){
        String info = "";
        for (Entry<Integer, Carta> carta : map.entrySet()){
            Carta valor = carta.getValue();
            if(valor.getNombre().equals(eleccion)){
                String nom = valor.getNombre();
                String tipo2 = valor.getTipo();
                info = nom + " es una carta de tipo: " + tipo2;
            }
        }
        return info;
    }
}
